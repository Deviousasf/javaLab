package com.example.demo.validators;


import com.example.demo.entity.ValidatorError;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Component
public class NumberValidator {
    private static final Logger logger = LoggerFactory.getLogger(NumberValidator.class);

    public ValidatorError validateParameters(double inp) {
        ValidatorError resp = new ValidatorError();
        if(inp == 0) {
            logger.error("Parameter cannot be 0");
            resp.addErrorMess("Parameter cannot be 0");
        }
        return resp;
    }
}
