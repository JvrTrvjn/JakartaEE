package org.jti.apiservlet.webapp.session;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        StringBuilder sb11 = new StringBuilder("Hola");
        sb11.insert(2, 'c');
        System.out.println(sb11);

        Predicate<String> predicate = s -> s.length() == 3;
        System.out.println(predicate.test("Hola"));



    }

    static class Solution {
        public String gcdOfStrings(String str1, String str2) {

            if (str1.length() > str2.length()) {
                str1 = str1.substring(0, str2.length());
            }
            char[] charArray = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            StringBuilder sbTotal = new StringBuilder();

            int count = 0;

            for (int i = 0;i < charArray2.length; i++) {
                for( int j = 0; j < charArray.length; j++ ){
                    if (charArray2[i]==charArray[j]){
                                sbTotal.append(charArray2[i]); }
                    else{
                        sbTotal.append("");
                    }
                }
            }
            return sbTotal.toString();
        }
    }


}




