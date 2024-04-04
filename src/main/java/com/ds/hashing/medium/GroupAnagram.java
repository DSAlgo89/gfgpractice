package com.ds.hashing.medium;

import java.util.*;

public class GroupAnagram {
    public static String[][] groupAnagrams(String[] s) {
        // Code here
        Arrays.sort(s);
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        for(String str: s) {
            String key = new String(str);
            key = generateKey(key);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        String[][] result = new String[map.size()][];

        int i = 0;
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            List<String> value = entry.getValue();
            Collections.sort(value);
            String[] current = new String[value.size()];
            int j = 0;
            for(String curr: value) {
                current[j++] = curr;
            }
            result[i] = current;
            i++;
        }
        return result;
    }

    private static String generateKey(String key) {
        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        key = new String(chars);
        return key;
    }

    public static void main(String[] args) {
        String[] s = {"eat" ,"tea" ,"tan" ,"ate" ,
                "nat" ,"bat"};

        String[][] result = groupAnagrams(s);


    }
}
