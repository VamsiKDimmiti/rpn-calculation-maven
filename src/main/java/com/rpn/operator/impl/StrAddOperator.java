package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.AddOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;
/*
 * Addition Operator implementation
 */
public class StrAddOperator implements StrOperator {
    public Operator getResult(RPNParam rpnOp){
        Operator op = new AddOperator(rpnOp);
        return op;
    }
}
