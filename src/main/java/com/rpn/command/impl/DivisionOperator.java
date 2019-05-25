package com.rpn.command.impl;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Command Interface Implementation for Division
 */

public class DivisionOperator implements Operator {

    RPNParam rpnParam;
    public DivisionOperator(RPNParam rpnParam){
        this.rpnParam = rpnParam;
    }
    public Double compute(){
        return rpnParam.getSecondOperand()/ rpnParam.getFirstOperand();
    }

}
