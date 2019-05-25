package com.rpn.controller;

import com.rpn.command.Operator;

/*
 * Controller or Invoker of the Operation with help of Operator Interface
 */

public class Operation {

    private Operator operator;

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Double getOperationResult(){
        return operator.compute();
    }

}
