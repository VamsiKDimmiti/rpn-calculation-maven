package com.rpn.command.impl;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Command Interface Implementation for Addition
 */
public class AddOperator implements Operator {

    RPNParam rpnParam;
    public AddOperator(RPNParam rpnParam){
        this.rpnParam = rpnParam;
    }
    public Double compute(){
        return rpnParam.getFirstOperand()+ rpnParam.getSecondOperand();
    }

}
