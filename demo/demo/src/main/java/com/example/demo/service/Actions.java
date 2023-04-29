package com.example.demo.service;

import com.example.demo.entity.Params;
import com.example.demo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Actions {

    public Result act(Params params){
        return new Result(params.getParam1() + params.getParam2(), params.getParam1() -params.getParam2(), params.getParam1() * params.getParam2(), params.getParam1() / params.getParam2(), params);
    }
}
