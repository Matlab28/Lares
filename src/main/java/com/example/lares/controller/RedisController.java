package com.example.lares.controller;

import com.example.lares.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    // Basic Commands
    @PostMapping("/set")
    public String setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return "Value set";
    }

    @GetMapping("/get")
    public String getValue(@RequestParam String key) {
        return redisService.getValue(key);
    }

    @DeleteMapping("/delete")
    public String deleteValue(@RequestParam String key) {
        redisService.deleteValue(key);
        return "Value deleted";
    }

    @PostMapping("/expire")
    public String setExpiry(@RequestParam String key, @RequestParam Long seconds) {
        redisService.setExpiry(key, seconds);
        return "Expiry set";
    }

    // List Commands
    @PostMapping("/list/push")
    public String pushToList(@RequestParam String key, @RequestParam String value) {
        redisService.pushToList(key, value);
        return "Value pushed to list";
    }

    @GetMapping("/list/range")
    public List<String> getListRange(@RequestParam String key,
                                     @RequestParam Long start,
                                     @RequestParam Long end) {
        return redisService.getListRange(key, start, end);
    }

    // Set Commands
    @PostMapping("/set/add")
    public String addToSet(@RequestParam String key, @RequestParam String value) {
        redisService.addToSet(key, value);
        return "Value added to set";
    }

    @GetMapping("/set/members")
    public Set<String> getSetMembers(@RequestParam String key) {
        return redisService.getSetMembers(key);
    }
}
