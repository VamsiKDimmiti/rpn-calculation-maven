package com.rpn.command.impl;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Command Interface Implementation for Multiplication
 */

public class MultiplicateOperator implements Operator {


    RPNParam rpnParam;
    public MultiplicateOperator(RPNParam rpnParam){
        this.rpnParam = rpnParam;
    }
    public Double compute(){
        return rpnParam.getSecondOperand()* rpnParam.getFirstOperand();
    }


}
