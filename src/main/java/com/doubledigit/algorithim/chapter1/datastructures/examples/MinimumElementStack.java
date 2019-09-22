package com.doubledigit.algorithim.chapter1.datastructures.examples;

import com.doubledigit.algorithim.chapter1.datastructures.StackDataStructure;

public class MinimumElementStack {

    private StackDataStructure<Integer> inputData = new StackDataStructure<>();
    private StackDataStructure<Integer> minimumStack = new StackDataStructure<>();

    public void pushData(int data) throws StackDataStructure.StackOverFlowException, StackDataStructure.StackUnderFlowException {
        int min = data;

        if (!minimumStack.isEmpty()) {
            if (min > minimumStack.peek()) {
                min = minimumStack.peek();
            }
        }
        inputData.push(data);
        minimumStack.push(min);
    }

    public void popData() throws StackDataStructure.StackUnderFlowException {
        minimumStack.pop();
        inputData.pop();
    }

    public int getMinimum() throws StackDataStructure.StackUnderFlowException {
        return minimumStack.peek();
    }
}
