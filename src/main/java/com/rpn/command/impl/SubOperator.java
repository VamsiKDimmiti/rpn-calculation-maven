package com.rpn.command.impl;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Command Interface Implementation for Subtraction
 */

public class SubOperator implements Operator {

    RPNParam rpnParam;
    public SubOperator(RPNParam rpnParam){
        this.rpnParam = rpnParam;
    }
    public Double compute(){
        return rpnParam.getSecondOperand()- rpnParam.getFirstOperand();
    }
}
