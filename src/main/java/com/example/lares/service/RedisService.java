package com.example.lares.service;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;
    private final ListOperations<String, String> listOps;
    private final SetOperations<String, String> setOps;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.listOps = redisTemplate.opsForList();
        this.setOps = redisTemplate.opsForSet();
    }

    // Basic Operations
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

    public void setExpiry(String key, long timeoutInSeconds) {
        redisTemplate.expire(key, timeoutInSeconds, TimeUnit.SECONDS);
    }

    // List Operations
    public void pushToList(String key, String value) {
        listOps.leftPush(key, value);
    }

    public List<String> getListRange(String key, long start, long end) {
        return listOps.range(key, start, end);
    }

    // Set Operations
    public void addToSet(String key, String value) {
        setOps.add(key, value);
    }

    public Set<String> getSetMembers(String key) {
        return setOps.members(key);
    }
}
