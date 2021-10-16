package com.google.algo.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupStringAnagrams {

    public static void main(String[] args) {
        String[] inputData = {"ate", "pig", "owl", "eat", "tea", "gip", "low", "lie", "wol"};

        GroupStringAnagrams group = new GroupStringAnagrams();
        List<List<String>> result = group.groupAnagrams(inputData);
        System.out.println(result.toString());
    }


    public List<List<String>> groupAnagrams(String[] input) {
        List<List<String>> groupedAnagram = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String value : input) {
            char[] characters = value.toCharArray();
            Arrays.sort(characters);

            String sortedValue = new String(characters);

            if(!map.containsKey(sortedValue)){
                map.put(sortedValue, new ArrayList<>());
            }

            map.get(sortedValue).add(value);
        }

        groupedAnagram.addAll(map.values());
        return groupedAnagram;

    }
}
