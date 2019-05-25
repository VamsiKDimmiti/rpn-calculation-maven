package com.uks.service;

import com.uks.model.TestCase;

import java.util.*;

public class UknapsackService {


    public HashMap<Integer,Integer> getMaxSumList(HashMap<Integer, String> lineMap){

        HashMap<Integer,TestCase> tcListMap = new HashMap<Integer, TestCase>();
        int ind = 0;
        for(Map.Entry<Integer, String> line : lineMap.entrySet()){
           if(line.getKey()%2 == 0){
                tcListMap.get(ind).setArr(Arrays.asList(line.getValue().split(" ")).stream().mapToInt(Integer::parseInt).toArray());
                ind++;
            }else{
                TestCase tc = new TestCase();

                tc.setLength(Integer.parseInt(line.getValue().split(" ")[0]));
                tc.setTotal(Integer.parseInt(line.getValue().split(" ")[1]));
                tcListMap.put(ind,tc);
            }
        }
        return getMaxSum(tcListMap);


    }

    public HashMap<Integer, Integer> getMaxSum(HashMap<Integer, TestCase> tcListMap){

        HashMap<Integer,Integer> maxSumMap = new HashMap<Integer,Integer>();
        for(Map.Entry<Integer, TestCase> itestCase : tcListMap.entrySet()){
            //Case1:
            maxSumMap.put(itestCase.getKey(), getMax(itestCase.getValue()));
            //Case2:
            //maxSumMap.put(itestCase.getKey(), getHighSum(itestCase.getValue().getTotal(),itestCase.getValue().getLength(),itestCase.getValue().getArr()));
            //Case3:
            //maxSumMap.put(itestCase.getKey(), getSumRes(itestCase.getValue().getTotal(),itestCase.getValue().getLength(),itestCase.getValue().getArr()));
        }
        return maxSumMap;
    }

    public int getMax(TestCase tc){
        int maxItm[] = new int[tc.getTotal()+1];
        int temp = -1;
        maxItm[0] = 0;
        for (int arrindex=1;arrindex<=tc.getTotal();arrindex++){
            maxItm[arrindex] = maxItm[arrindex-1];
            for(int itrArrIndex =0; itrArrIndex< tc.getLength();itrArrIndex++){
                if(arrindex>=tc.getArr()[itrArrIndex]){
                    temp = maxItm[arrindex-tc.getArr()[itrArrIndex]]+tc.getArr()[itrArrIndex];
                }
                if(temp>maxItm[arrindex]){
                    maxItm[arrindex] = temp;
                }
            }
        }
        return maxItm[tc.getTotal()];
    }

public int getHighSum(int sum, int size, int[] arr) {

    int maxItm[][] = new int[size + 1][sum + 1];
    for (int i = 0; i <= size; i++) {
        for (int s = 0; s <=sum; s++) {
            if (i == 0 || s == 0)
                maxItm[i][s] = 0;
            else if (arr[i - 1] <= s)
                maxItm[i][s] = Math.max(maxItm[i][s - arr[i - 1]]+arr[i-1], maxItm[i - 1][s]);
            else
                maxItm[i][s] = maxItm[i - 1][s];
        }
    }
    return maxItm[size][sum];
}


 public int getSumRes(int sum, int size, int[] arr) {
     if (sum == 0 || size == 0) return 0;
     if (arr[size - 1] > sum) return getSumRes(sum, size - 1, arr);
     return Math.max(arr[size - 1] + getSumRes(sum - arr[size - 1], size, arr), getSumRes(sum, size - 1, arr));
 }


}