package com.doubledigit.algorithim.chapter1.datastructures.examples;

import com.doubledigit.algorithim.chapter1.datastructures.StackDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMatchingParanthesis {
    private static final Map<Character, Character> matchinParenthesisMap = new HashMap<>();
    private static final Set<Character> openingParenthesisSet = new HashSet<>();

    static {
        matchinParenthesisMap.put(')', '(');
        matchinParenthesisMap.put('}', '{');
        matchinParenthesisMap.put(']', '[');
        openingParenthesisSet.addAll(matchinParenthesisMap.values());
    }

    // {(([]))}{}
    public static boolean hasMatchingParenthesis(String inputData) {
        try {
            StackDataStructure<Character> parentStack = new StackDataStructure<>();

            for (int i = 0; i < inputData.length(); i++) {
                char ch = inputData.charAt(i);

                if (openingParenthesisSet.contains(ch)) {
                    parentStack.push(ch);
                }

                if (matchinParenthesisMap.containsKey(ch)) {
                    Character lastParenthesis = parentStack.pop();
                    if (lastParenthesis != matchinParenthesisMap.get(ch)) {
                        return false;
                    }
                }
            }
            return parentStack.isEmpty();
        } catch (StackDataStructure.StackOverFlowException ex) {
            System.out.println("Stack overflow");

        } catch (StackDataStructure.StackUnderFlowException ex) {
            System.out.println("Stack underflow");
        }
        return false;
    }
}
