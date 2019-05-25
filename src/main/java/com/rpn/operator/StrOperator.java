package com.rpn.operator;

import com.rpn.command.Operator;
import com.rpn.model.RPNParam;

/*
 * Input Operator Interface which will be implemented by different input operators
 */
public interface StrOperator {
    public Operator getResult(RPNParam rpnOp );
}
