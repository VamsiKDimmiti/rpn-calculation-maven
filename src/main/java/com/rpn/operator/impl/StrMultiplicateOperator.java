package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.MultiplicateOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;

/*
 * Multiplication Operator implementation
 */
public class StrMultiplicateOperator implements StrOperator {
    public Operator getResult(RPNParam rpnOp){
        return new MultiplicateOperator(rpnOp);
    }
}
