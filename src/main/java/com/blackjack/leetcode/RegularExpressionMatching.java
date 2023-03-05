package com.blackjack.leetcode;

import java.util.Scanner;

/**
 *
 * 正则表达式匹配
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        //给p一个游标 记录当前p字符的位置
          int pCount = 0;
        //如果匹配到*  记录当前p的*指代的字符
         char chatacter = '0';
        //给s一个游标 记录当前s字符的位置
         int sCount = 0;

         // 将**挨着的去掉
        String replace = "";
        while (true){
            if (replace.length()==p.length()){
                break;
            }
            replace = p.replace("**", "*");
        }

        if (p.contains(".*")&&!p.startsWith(".*"))
            return true;
        while (true){
            if (sCount==s.length()||pCount==p.length()){//s走完了||p也走完了  跳出循环
               break;
            }
            char cPoint = s.charAt(sCount);
            char pPoint = p.charAt(pCount);
            if (pPoint=='.'){ // .字符
                 //cPoint是什么都无所谓   修改当前的chatacter
                sCount++;
                pCount++;
            }else if (pPoint=='*'){ //* 字符   chatacter为空||直到s没数||没重复再移除
              if (!Character.isDefined(chatacter)){
                  pCount++;
              }else if (sCount==s.length()-1&&cPoint==chatacter){
                  sCount++;
                  pCount++;
              }else {
                  //判断相同不
                  if (cPoint==chatacter) {
                      sCount++;
                  }else {
                      pCount++;
                  }
              }
            }else if (pPoint == cPoint) {  //普通字符
                   sCount++;
                   pCount++;
                chatacter = pPoint;
            }else{//不匹配  p继续走
                pCount++;
                chatacter = pPoint;
            }
        }
        // 再判断  s走完了&&p也走完了 置为true
        if (sCount==s.length()){//s走完了  p没走完没事  跳出循环
            return true;
        }else
            return false;

    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String p = scanner.nextLine();
            boolean palindrome = new RegularExpressionMatching().isMatch(s,p);
            System.out.println(palindrome);
        }
    }
}
