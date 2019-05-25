package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.SubOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;

/*
 * Subtraction Operator implementation
 */

public class StrSubOperator implements StrOperator {
    public Operator getResult(RPNParam rpnOp){
        return new SubOperator(rpnOp);
    }
}
