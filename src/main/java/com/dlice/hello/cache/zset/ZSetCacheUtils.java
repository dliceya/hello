package com.dlice.hello.cache.zset;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mubai
 * @apiNote:
 * @date 2021/5/20 18:08
 **/
@Service
public class ZSetCacheUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 批量设置拥有不同过期时间zSet元素
     */
    public boolean add(String cacheKey, Map<Object, Long> valueMap) {

        Set<ZSetOperations.TypedTuple<Object>> dataSet = new HashSet<>();
        valueMap.forEach((key, value) -> dataSet.add(new DefaultTypedTuple<>(JSON.toJSONString(key), Double.valueOf(value))));

        redisTemplate.opsForZSet().add(cacheKey, dataSet);
        return true;
    }

    /**
     * 批量设置拥有相同过期时间的zSet元素
     */
    public boolean add(String cacheKey, Collection<Object> values, Duration timeout) {

        long expireTime =  System.currentTimeMillis() / 1000L + timeout.getSeconds();

        Set<ZSetOperations.TypedTuple<Object>> dataSet = new HashSet<>();
        values.forEach((value) -> dataSet.add(new DefaultTypedTuple<>(JSON.toJSONString(value), (double) (expireTime))));

        redisTemplate.opsForZSet().add(cacheKey, dataSet);
        return true;
    }


    /**
     * 清理入参key中过期的元素
     */
    public boolean clearExpiredCache(String key) {

        if (StringUtils.isEmpty(key)) {
            return true;
        }

        long current = System.currentTimeMillis();

        redisTemplate.opsForZSet().removeRangeByScore(key, Integer.MIN_VALUE, (double) (System.currentTimeMillis() / 1000L));

        return true;
    }



    private Integer currentTimeParse() {

        long current = System.currentTimeMillis() / 1000000L;
        return (int) current;
    }


}
