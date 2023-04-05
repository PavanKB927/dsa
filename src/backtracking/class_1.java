package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class class_1 {
    public static void main(String[] args) {
        /*
            int n= 3;
            int[] out = new int[n];
            ArrayList<int[]> arrList = new ArrayList<>();
            generateBoolenaStrings(n,0,out,arrList);
        */
//        int[] input = {1,2,3};
//        ArrayList<Integer> currentOutput = new ArrayList<>();
//        generateSubsetOfArray(0,input,currentOutput);
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12,13));
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        getSubsets(A,0,answer,new ArrayList<>());
        System.out.println("answer :"+Arrays.toString(answer.toArray()));

    }

    // print all possible boolean(0 and 1) strings of length n
    public static void generateBoolenaStrings(int n, int i, int[] out, ArrayList<int[]> arrayList){
        if(i == n){
            //System.out.println(Arrays.toString(out));
            arrayList.add(out.clone());
            return;
        }
        out[i] = 0;
        generateBoolenaStrings(n,i+1,out,arrayList);
        out[i] = 1;
        generateBoolenaStrings(n,i+1,out,arrayList);
    }

    // given an array of size N, generate all possible subsets
    public static void generateSubsetOfArray(int i,int[] intput, ArrayList<Integer> currentOutput){
        if(i == intput.length){
            System.out.println(Arrays.toString(currentOutput.toArray()));
            return;
        }

        currentOutput.add(intput[i]);
        generateSubsetOfArray(i+1,intput,currentOutput);
        Integer x = intput[i];
        currentOutput.remove(x);
        generateSubsetOfArray(i+1,intput,currentOutput);

    }

    /*
    * Given a set of distinct integers A, return all possible subsets.
    * NOTE:
    * Elements in a subset must be in non-descending order.
    * The solution set must not contain duplicate subsets.
    * Also, the subsets should be sorted in ascending ( lexicographic ) order.
    * The list is not necessarily sorted
    * */
    public static void getSubsets(ArrayList<Integer> A,int i,ArrayList<ArrayList<Integer>> answer,ArrayList<Integer> currentOutput){
        if(i == A.size()){
            return;
        }

        ArrayList<Integer> temp = new ArrayList<>(currentOutput);
        temp.add(A.get(i));
        answer.add(temp);
        getSubsets(A,i+1,answer,temp); // recursive call with element
        getSubsets(A,i+1,answer,currentOutput); // recursive call without element
    }


}
