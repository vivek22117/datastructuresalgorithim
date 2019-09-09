package Algo;


import static java.util.Arrays.sort;

public class LowestOccurrenceInArrayElement {
    static int[] inputElements = {4, 3, 2, 4, 2, 2, 4, 11, 1, 1, 11, 1, 3, 3, 0, 0, 0, 0, 33, 3, 3, 4, 4, 4};

    public static void main(String[] args) {
        getIndexOfLowestOccurrencesInArrayElements(inputElements);
    }

    private static void getIndexOfLowestOccurrencesInArrayElements(int[] inputElements) {
        sort(inputElements);
        int[][] output = new int[2][3];
        int i = 0;
        while (i < inputElements.length) {
            int j = inputElements[i];
            int valueCount = 1;
            i = i + 1;

            if(i > inputElements.length -1){
                updateLeastCount(inputElements, output, i, valueCount);
                break;
            }

            while (inputElements[i] == j) {
                valueCount = valueCount + 1;
                i = i + 1;
                if (i > inputElements.length - 1) break;
            }
            updateLeastCount(inputElements, output, i, valueCount);
        }
        System.out.println("Element is " + output[0][1] + " and Frequency is " + output[0][2] + "\n"
                + "Element is " + output[1][1] + " and Frequency is " + output[1][2]);

    }

    private static void updateLeastCount(int[] inputElements, int[][] output, int i, int valueCount) {
        if (output[0][2] == 0) {
            output[0][0] = i - 1;
            output[0][1] = inputElements[i - 1];
            output[0][2] = valueCount;
        } else if (output[1][2] == 0) {
            output[1][0] = i - 1;
            output[1][1] = inputElements[i - 1];
            output[1][2] = valueCount;
        } else if (output[0][2] >= valueCount && output[0][2] > output[1][2]) {
            output[0][0] = i - 1;
            output[0][1] = inputElements[i - 1];
            output[0][2] = valueCount;
        } else if (output[1][2] >= valueCount) {
            output[1][0] = i - 1;
            output[1][1] = inputElements[i - 1];
            output[1][2] = valueCount;
        }
    }
}
