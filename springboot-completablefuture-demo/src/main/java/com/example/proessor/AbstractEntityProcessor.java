package com.example.proessor;

import com.example.bean.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author jameszhou
 */
public abstract class AbstractEntityProcessor {

    @Autowired
    protected RestTemplate restTemplate;

    /**
     * 获取信息
     */
    public abstract Entity requestEntity();
}
