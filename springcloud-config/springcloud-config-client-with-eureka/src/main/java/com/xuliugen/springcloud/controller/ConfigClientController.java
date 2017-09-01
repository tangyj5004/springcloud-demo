package com.xuliugen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuliugen on 2017/8/31.
 */

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @GetMapping(value = "profile")
    public String getProfile() {
        return profile;
    }
}
