package com.blackjack.leetcode;

import java.util.Scanner;

/**
 * 回文数
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        //一次循环
        //  i++  ==  length-1--
        String s = String.valueOf(x);
        for(int i = 0,j=s.length()-1;i<j;i++,j--){
            if (s.charAt(i) == s.charAt(j)){
                continue;
             }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            boolean palindrome = new PalindromeNumber().isPalindrome(i);
            System.out.println(palindrome);
        }
    }
}
