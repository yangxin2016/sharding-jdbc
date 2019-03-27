package com.example.shardingjdbc.algorithm;

import com.google.gson.Gson;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;


/**
 * Created by yangxin on 2019/3/18.
 */
@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        log.info("collection:" + new Gson().toJson(collection) + ",preciseShardingValue:" + new Gson().toJson(preciseShardingValue));
        Long value = preciseShardingValue.getValue();
        for (String name : collection) {
            if (name.endsWith(value % (long)collection.size()+"")) {
                log.info("return name:"+name);
                return name;
            }
        }
        return null;
    }

}
