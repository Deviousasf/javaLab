package com.example.demo.controller;

import com.example.demo.entity.Params;
import com.example.demo.entity.Result;
import com.example.demo.entity.ValidatorError;
import com.example.demo.memory.Storage;
import com.example.demo.service.Actions;
import com.example.demo.service.Counter;
import com.example.demo.validators.NumberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/lab")
public class Controller {

    private final Actions service;

    private NumberValidator val;

    private Storage storage;


    private final Logger logger = LoggerFactory.getLogger(Actions.class);

    public Controller(Actions service) {
        this.service = service;
    }
    @Autowired
    public Controller(Actions service, NumberValidator val, Storage storage) {
        this.service = service;
        this.val = val;
        this.storage = storage;
    }


    @GetMapping("/actions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Object> actions(@RequestParam(name = "param1", required = true, defaultValue = "0") double param1,
                                           @RequestParam(name = "param2", required = true, defaultValue = "0") double param2) {

        Params inp = new Params(param1,param2);
        logger.info("1. Validation starts");

        ValidatorError resp = val.validateParameters(inp.getParam2());
        if(resp.getErrorMess().size()!=0){
            resp.addErrorMess("Input number is not valid");
            resp.setStatus(HttpStatus.BAD_REQUEST.name());

            return new ResponseEntity(resp,HttpStatus.BAD_REQUEST);
        }
        Result result = storage.getResult(inp);
        try {
            logger.info("2. Actions start");
            result = service.act(inp);
        }catch(Exception exp) {
            resp.addErrorMess("Internal Server Error");
            resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
            logger.error("Internal Server Error");
            return new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        storage.saveResult(result);
        return new ResponseEntity(resp,HttpStatus.OK);
    }

    @GetMapping("/getResults")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Result>> getAllResults() {
        return ResponseEntity.ok(storage.getAllResults());
    }
    @GetMapping("/clear")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity clearInMemory() {
        storage.clearMemory();
        return ResponseEntity.ok(storage);
    }
}
