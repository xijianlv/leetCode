package com.xijianlv.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xijianlv
 */
public class No2325 {

    public static void main(String[] args) {
        decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb");
    }

    public static String decodeMessage(String key, String message) {
        Map<Character, Character> mapping = new HashMap<>();
        key = key.replaceAll(" ","");
        for (int i = 0; i < key.length(); i++) {
            if (mapping.containsKey(key.charAt(i))) {
                continue;
            }
            mapping.put(key.charAt(i), (char) ('a' + mapping.size()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(mapping.get(message.charAt(i)));
            }
        }
        return stringBuilder.toString();
    }
}
