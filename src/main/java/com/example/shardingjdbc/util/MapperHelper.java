package com.example.shardingjdbc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author maaowen
 * @date 2017/11/6
 */
public class MapperHelper<T, K> {

    private static final Logger logger = LoggerFactory.getLogger(MapperHelper.class);

    /**
     * 匹配类型
     */
    private enum ParamType {
        EQUAL_TYPE(1, "EqualTo"),
        LIKE_TYPE(2, "Like"),;

        private int type;
        private String name;

        ParamType(int type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    /**
     * 模糊查询: 父类的元素需要递归,这里不知道目标类是哪个，只能在调用的时候传--基础类
     */
    public T fuzzyQuery(T criteria, K obj) {
        if (obj == null)
            return criteria;
        Field[] objFields = obj.getClass().getDeclaredFields();
        Class criteriaClass = criteria.getClass();
        for (Field field : objFields) {
            try {
                field.setAccessible(true);
                Class clazz = field.getType();
                String name = field.getName();
                if (field.get(obj) == null)
                    continue;
                if (clazz.equals(Integer.class) || clazz.equals(Double.class) || clazz.equals(Long.class)) {
                    String methodName = getMethodName(name, ParamType.EQUAL_TYPE);
                    Method method = criteriaClass.getDeclaredMethod(methodName, clazz);
                    method.invoke(criteria, field.get(obj));
                } else {
                    String methodName = getMethodName(name, ParamType.LIKE_TYPE);
                    Method method = criteriaClass.getDeclaredMethod(methodName, clazz);
                    method.invoke(criteria, "%" + field.get(obj) + "%");
                }
            } catch (Exception e) {
                // 有可能会报 NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
                logger.error("MapperHelper fuzzyQuery, e:{}", e);
            }
        }
        return criteria;
    }

    /**
     * 精确查询
     */
    public T exactQuery(T criteria, K obj) {
        if (obj == null)
            return criteria;
        Field[] objFields = obj.getClass().getDeclaredFields();
        Class criteriaClass = criteria.getClass();
        for (Field field : objFields) {
            try {
                field.setAccessible(true);
                Class clazz = field.getType();
                String name = field.getName();
                if (field.get(obj) == null)
                    continue;
                String methodName = getMethodName(name, ParamType.EQUAL_TYPE);
                Method method = criteriaClass.getDeclaredMethod(methodName, clazz);
                method.invoke(criteria, field.get(obj));
            } catch (Exception e) {
                logger.error("MapperHelper exactQuery, e:{}", e);
            }
        }
        return criteria;
    }


    private String getMethodName(String paramName, ParamType paramType) {
        StringBuilder sb = new StringBuilder();
        sb.append("and").append(paramName.substring(0, 1).toUpperCase()).append(paramName.substring(1, paramName.length()))
                .append(paramType.name);
        return sb.toString();
    }
}
