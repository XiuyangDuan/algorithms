package com.xiuyang.algorithms.lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution627LongestPalindrome {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            if(!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        int max = 0;
        boolean single = false;
        for(String ch: map.keySet()) {
            int origin = map.get(ch);
            int count = origin - origin % 2;
            if(count < origin) {
                single = true;
            }
            max = max + count;
        }
        if(single) {
            max++;
        }
        return max;
    }

//    public int longestPalindrome2(String s) {
//        Set<Character> set = new HashSet<>();
//        char[] charArray = s.toCharArray();
//        for(char ch: charArray) {
//            if(set.contains(ch)) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution627LongestPalindrome sol = new Solution627LongestPalindrome();
        System.out.println(sol.longestPalindrome("abccccdd"));
    }
}
