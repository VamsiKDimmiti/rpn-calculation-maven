package com.uks.client;


import com.uks.service.UknapsackService;

import java.util.*;
import java.util.logging.Logger;

/*
 * This is the main class for the Unbounded Knapsack solver that will accept the input from command line.
 *
 */
public class Uknapsack {

    private static final Logger log = Logger.getLogger(Uknapsack.class.getName());

    public static void main(String args[]) throws Exception {

        log.info("Unbounded Knapsack Main Starts");
        final Scanner scr = new Scanner(System.in);
        UknapsackService uksService = new UknapsackService();
        while (true) {
            //Reading the input from command line
            final String nTestCases = scr.nextLine();
            final int totalTestCases = Integer.parseInt(nTestCases);
            if (totalTestCases < 1 || totalTestCases > 10) {
                System.out.println("Number of test case should be between 1 and 10");
            } else {
                int lineNumber = 1;
                HashMap<Integer, String> lineMap = new HashMap<Integer, String>();
                while (lineNumber <= 2 * totalTestCases) {
                    final String nLine = scr.nextLine();
                    if (nLine.trim().isEmpty()) {
                        continue;
                    }
                    lineMap.put(lineNumber, nLine);
                    lineNumber++;
                }
                HashMap<Integer, Integer> sumMap = uksService.getMaxSumList(lineMap);
                for (Map.Entry<Integer, Integer> sum : sumMap.entrySet()) {
                    System.out.println(sum.getValue());
                }
            }
        }


    }
}