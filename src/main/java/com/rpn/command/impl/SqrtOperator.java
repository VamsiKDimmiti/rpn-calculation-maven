package com.rpn.command.impl;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Command Interface Implementation for square root
 */
public class SqrtOperator implements Operator {

    RPNParam rpnParam;
    public SqrtOperator(RPNParam rpnParam){
        this.rpnParam = rpnParam;
    }

    public Double compute(){
        return Math.sqrt(rpnParam.getFirstOperand());
    }

}
