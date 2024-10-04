package com.vladproduction.controllers;

import com.vladproduction.exceptions.ValueNotFoundException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String opsHandler(){

        return "not_implemented";
    }

    public String opsHandlerByException(){

        throw new ValueNotFoundException("Value is not found");
    }
}
