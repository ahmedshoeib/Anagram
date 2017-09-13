package com.test.anagram.utils;

/**
 * Created by shoeib on 9/13/17.
 */

public class TextUtils {


    /**
     * @param firstText  the first text you need to check
     * @param secondText the second text you need to check
     * @return true if the two strings are anagrams else return false
     */
    public static boolean isAnagram(String firstText, String secondText) {

        if (firstText == null || secondText == null || firstText.length() != secondText.length())
            return false;

        boolean isAnagram = true;
        
        for (int i = 0; i < firstText.length(); i++) {
            char char1 = firstText.charAt(i);
            boolean isFirstCharExistInSecndString = false;
            for (int j = 0; j < secondText.length(); j++) {
                char char2 = secondText.charAt(j);
                if (char1 == char2) {
                    isFirstCharExistInSecndString = true;
                    break;
                }
            }
            secondText = secondText.replaceFirst(String.valueOf(char1), "");

            if (!isFirstCharExistInSecndString) {
                isAnagram = false;
                break;
            }
        }


        return isAnagram;
    }

}
