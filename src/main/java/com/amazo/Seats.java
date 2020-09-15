package com.amazo;

import java.util.*;
import java.util.stream.IntStream;

public class Seats {
    public static int numberOfRows = 2;
    public static String seatsReserved = "1A 2D 1K";
    public static Map<Character, Character> dataType = new HashMap<>();


    public static void main(String[] args) {
        dataType.put('A', '0');
        dataType.put('B', '1');
        dataType.put('C', '2');
        dataType.put('D', '3');
        dataType.put('E', '4');
        dataType.put('F', '5');
        dataType.put('G', '6');
        dataType.put('H', '7');
        dataType.put('J', '8');
        dataType.put('K', '9');
        Set<Character> dataTypes = new HashSet<>(dataType.values());
//        processReservedSeats(seatsReserved, dataType, dataTypes);

        findNumberOfFamilies(numberOfRows, seatsReserved);
    }

    private static void findNumberOfFamilies(int numberOfRows, String seatsReserved) {
        Character[] points = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};

        List<Character[]> seatMatrix = createSeatMatrix(numberOfRows, points);
        int finalCount = seatMatrix.stream().mapToInt(value -> findFamilyCount(seatsReserved, value)).sum();

        System.out.println(finalCount);
    }


    private static int findFamilyCount(String seatsReserved, Character[] value) {
        int count = 0;
        int indx = 1;
        if (!seatsReserved.contains(value[indx].toString())) {
            boolean allowed = true;
            for (int i = indx; i < 5; i++) {
                if (seatsReserved.contains(value[i].toString())) {
                    allowed = false;
                    indx = i;
                    break;
                }
                indx = i;
            }
            if (allowed) {
                count += 1;
            }
        }

        if (indx < 2) {
            indx += 3;
        } else {
            return count;
        }
        if (!seatsReserved.contains(value[indx].toString())) {
            boolean allowed = true;
            for (int i = indx; i < 7; i++) {
                if (seatsReserved.contains(value[i].toString())) {
                    allowed = false;
                    indx = i;
                    break;
                }
                indx = i;
            }
            if (allowed) {
                count += 1;
            }
        }

        if (indx < 5) {
            indx += 5;
        } else {
            return count;
        }
        if (!seatsReserved.contains(value[indx].toString())) {
            boolean allowed = true;
            for (int i = indx; i < 9; i++) {
                if (seatsReserved.contains(value[i].toString())) {
                    allowed = false;
                    indx = i;
                    break;
                }
                indx = i;
            }
            if (allowed) {
                count += 1;
            }
        }

        return count;
    }

    private static List<Character[]> createSeatMatrix(int numberOfRows, Character[] points) {
        List<Character[]> seatsMatrix = new ArrayList<>();
        IntStream.range(0, numberOfRows).forEach(e -> {
            seatsMatrix.add(points);
        });

        seatsMatrix.stream().forEach(value -> {
            System.out.println(Arrays.toString(value));
        });

        return seatsMatrix;
    }
}
