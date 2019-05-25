package com.rpn.client;

import com.rpn.service.RPNService;

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
        final Stack<String> resultStack = new Stack<String>();
        RPNService rpnService = new RPNService();
        while (true) {
            //Reading the input from command line
            input = scr.nextLine();
            //to format the value to have 15 allowable decimal which includes precision of 10 decimals
            DecimalFormat decimalFormat = new DecimalFormat("#####.##########");
            List<String> inputList = Arrays.asList(input.split(" "));
            String element;
            for (int id = 0; id < inputList.size(); id++) {
                element = inputList.get(id);
                try {
                    if (element.equals("undo")) {
                        resultStack.pop();
                    } else if (element.equals("clear")) {
                        resultStack.clear();
                    } else {
                    resultStack.push(decimalFormat.format(rpnService.getOperator(element,resultStack)));
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

