package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.DivisionOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;

/*
 * Division Operator implementation
 */

public class StrDivisionOperator implements StrOperator {
    public Operator getResult(RPNParam rpnOp){
        return new DivisionOperator(rpnOp);
    }
}
