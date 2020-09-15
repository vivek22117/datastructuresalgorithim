package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

import java.util.Stack;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 *
 * This algorithm is used to search minimum element from a list of elements in O(1) times.
 * Implemented using STACK
 */
public class ConstantTimeSearch {

    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minimumElement = new Stack<>();

    public static void main(String[] args) {

        pushData(5);
        pushData(11);
        pushData(3);
        pushData(18);
        pushData(22);
        pushData(9);
        pushData(4);
        pushData(13);
        pushData(21);
        pushData(2);


        int minimumElement = getMinimumElement();
        System.out.println("Currently minimum element in the list is: " + minimumElement);


        popData();
        int newMinElement = getMinimumElement();
        System.out.println("Now minimum element in the list is: " + newMinElement);
    }

    private static void popData() {
        minimumElement.pop();
        dataStack.pop();
    }

    private static int getMinimumElement() {
        return minimumElement.peek();
    }

    private static void pushData(int value) {
        int min = value;
        if(!minimumElement.isEmpty()){
            if(min > minimumElement.peek()){
                min = minimumElement.peek();
            }
        }
        dataStack.push(value);
        minimumElement.push(min);
    }
}
