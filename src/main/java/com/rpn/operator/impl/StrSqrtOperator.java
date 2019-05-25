package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.SqrtOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;

/*
 * Square Root Operator implementation
 */
public class StrSqrtOperator implements StrOperator {
    public Operator getResult(RPNParam rpnOp){
        return new SqrtOperator(rpnOp);
    }
}
