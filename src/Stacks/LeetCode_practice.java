package Stacks;

import java.util.*;

public class LeetCode_practice {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int length = s.length();
        int val = 0;
        for(int i=0;i<length;i++){
            if(s.charAt(i) == 'I' && (i+1 < length && s.charAt(i+1) == 'V')) {
                val += 4;
                i++;
            }else if(s.charAt(i) == 'I' && (i+1 < length && s.charAt(i+1) == 'X')) {
                val += 9;
                i++;
            } if(s.charAt(i) == 'I') val += 1;
            else if(s.charAt(i) == 'V') val += 5;
            else if(s.charAt(i)== 'X' && (i+1 < length && s.charAt(i+1) == 'L')) {val += 40;i++;}
            else if(s.charAt(i)== 'X' && (i+1 < length && s.charAt(i+1) == 'C')) {val += 90;i++;}
            else if(s.charAt(i)== 'X') val += 10;
            else if(s.charAt(i) == 'L') val += 50;
            else if(s.charAt(i)== 'C' && (i+1 < length && s.charAt(i+1) == 'D')) {val += 400;i++;}
            else if(s.charAt(i)== 'C' && (i+1 < length && s.charAt(i+1) == 'M')) {val += 900;i++;}
            else if(s.charAt(i)== 'C') val += 100;
            else if(s.charAt(i) == 'D') val += 500;
            else if(s.charAt(i) == 'M') val += 1000;
        }

        return val;

    }
}
