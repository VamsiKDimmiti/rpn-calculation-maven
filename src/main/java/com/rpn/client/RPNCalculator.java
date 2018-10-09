package com.rpn.client;

import com.rpn.command.Operator;
import com.rpn.command.impl.*;
import com.rpn.controller.Operation;
import com.rpn.model.RPNParam;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

/*
 * This is the main class for the RPN Calculator that will accept the input from command line.
 * The allowable operators are undo, clear, sqrt, +, - , *, /
 */
public class RPNCalculator {

    private static final Logger log = Logger.getLogger(RPNCalculator.class.getName());

    public static void main(String args[]) throws Exception {

        log.info("RPN Calculator Main Starts");
        final Scanner scr = new Scanner(System.in);
        String input;
        Stack<String> resultStack = new Stack();
        while (true) {
            //Reading the input from command line
            input = scr.nextLine();
            //to format the value to have 15 allowable decimal which includes precision of 10 decimals
            DecimalFormat decimalFormat = new DecimalFormat("#####.##########");
            List<String> inputList = Arrays.asList(input.split(" "));
            Double res;
            String element;
            //To convert parameters of an Operation to Object - Model
            RPNParam rpnOp = new RPNParam();
            //Controller (Invoker) of the calculator operations
            Operation operation = new Operation();

            for (int id = 0; id < inputList.size(); id++) {
                element = inputList.get(id);
                try {
                    if (element.equals("undo")) {
                        resultStack.pop();
                    } else if (element.equals("clear")) {
                        resultStack.clear();
                    } else {
                        rpnOp.setOperator(element);
                        if ("+,*,-,/".contains(element)){
                            if(element.equals("/") && 0.0 == Double.parseDouble(resultStack.peek()))
                                throw new Exception("Dividing by Zero is not allowed");
                            if (resultStack.size() > 1) {
                                rpnOp.setFirstOperand(Double.parseDouble(resultStack.pop()));
                                rpnOp.setSecondOperand(Double.parseDouble(resultStack.pop()));
                                Operator op;
                                switch(element.charAt(0)){
                                    case '+':
                                        op = new AddOperator(rpnOp);//Command implementing Addition
                                        break;
                                    case '-':
                                        op = new SubOperator(rpnOp); //Command implementing Subtraction
                                        break;
                                    case '*':
                                        op = new MultiplicateOperator(rpnOp); //Command implementing Multiplication
                                        break;
                                    case '/':
                                        op = new DivisionOperator(rpnOp); // Command implementing Division
                                        break;
                                    default:
                                        throw new Exception("invalid char");
                                }
                                operation.setOperator(op);
                                res = operation.getOperationResult();
                            }else{
                                throw new Exception("Invalid no of operands");
                            }
                        }else if(element.equals("sqrt")) {
                            rpnOp.setFirstOperand(Double.parseDouble(resultStack.pop()));//Command implementing Square root
                            Operator op = new SqrtOperator(rpnOp);
                            operation.setOperator(op);
                            res = operation.getOperationResult();
                        }else {
                            //pushing to stack if there is no operation to be performed
                            res = Double.parseDouble(element);
                        }
                        //pushing the result to stack
                        resultStack.push(decimalFormat.format(res));
                    }
                } catch (Exception e) {
                    System.out.println("operator "+element+" (position: "+ (2 * id + 1)+"): insufficient parameters" );
                    break;
                }
            }
            //Converting the Result Stack to String Array
            final String s = Arrays.toString(resultStack.toArray());
            //Removing the square brackets of the stack string
            final String result = s.substring(1, (s.length() - 1));
            //Printing the result removing the , of the stack string
            System.out.println("stack:" + result.replace(",",""));
        }
    }
}

