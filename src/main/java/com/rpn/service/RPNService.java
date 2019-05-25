package com.rpn.service;

import com.rpn.command.Operator;
import com.rpn.controller.Operation;
import com.rpn.factory.OperatorFactory;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;

import java.util.Stack;

/*
 * Service class to support business logic if any
 */
public class RPNService {

    //To convert parameters of an Operation to Object - Model
    private static RPNParam rpnOp = new RPNParam();
    //Controller (Invoker) of the calculator operations
    private static Operation operation = new Operation();

    public Double getOperator(String input, Stack<String> resStack) throws Exception {
        try {
            Double res;
            rpnOp.setOperator(input);
            if ("+,*,-,/".contains(input)) {
                if (input.equals("/") && 0.0 == Double.parseDouble(resStack.peek()))
                    throw new Exception("Dividing by Zero is not allowed");
                if (resStack.size() > 1) {
                    rpnOp.setFirstOperand(Double.parseDouble(resStack.pop()));
                    rpnOp.setSecondOperand(Double.parseDouble(resStack.pop()));
                    StrOperator strOp = OperatorFactory.getOperator(input);
                    Operator op = strOp.getResult(rpnOp);
                    if(null != op)
                        operation.setOperator(op);
                    else
                        throw new Exception("Invalid Operator");
                    res = operation.getOperationResult();
                } else {
                    throw new Exception("Invalid no of operands");
                }
            } else if (input.equals("sqrt")) {
                rpnOp.setFirstOperand(Double.parseDouble(resStack.pop()));//Command implementing Square root
                StrOperator strOp = OperatorFactory.getOperator(input);
                Operator op = strOp.getResult(rpnOp);
                if(null != op)
                operation.setOperator(op);
                else
                    throw new Exception("Invalid Operator");
                res = operation.getOperationResult();
            } else {
                //pushing to stack if there is no operation to be performed
                res = Double.parseDouble(input);
            }
            return res;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
