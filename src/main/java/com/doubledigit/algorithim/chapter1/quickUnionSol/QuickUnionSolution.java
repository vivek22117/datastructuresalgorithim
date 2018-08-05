package com.doubledigit.algorithim.chapter1.quickUnionSol;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class QuickUnionSolution {

    private static int[] dataPoint;
    private static int[] size;

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(new Student("Vivek", "Army"), new Student("Vikash", "KV"), new Student("Harsha", "Convent"),
                new Student("Varsha", "Convent"), new Student("Raj", "Gov School"), new Student("Sunil", "Guj school"),
                new Student("Suyash", "Mah school"), new Student("Amit", "Rewa school"));

        Map<String, Student> studentMap = studentList.parallelStream().collect(toMap(Student::getName, Function.identity()));

        int N = studentList.size();
        dataPoint = new int[N];
        size = new int[N];

        IntStream.range(0, N).forEach(e -> {
            dataPoint[e] = studentList.get(e).getIndex();
            size[e] = 1;
        });

        unionStudent(studentMap.get("Vivek"), studentMap.get("Suyash"));
        System.out.println("First Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Harsha"), studentMap.get("Varsha"));
        System.out.println("Second Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Vikash"), studentMap.get("Sunil"));
        System.out.println("Third Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Raj"), studentMap.get("Amit"));
        System.out.println("Fourth Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Sunil"), studentMap.get("Amit"));
        System.out.println("Fifth Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Varsha"), studentMap.get("Suyash"));
        System.out.println("Sixth Union Result..");
        printDatapoints(dataPoint);
        unionStudent(studentMap.get("Vivek"), studentMap.get("Varsha"));
        System.out.println("Seventh Union Result..");
        printDatapoints(dataPoint);


        boolean connected = isConnected(studentMap.get("Vivek"), studentMap.get("Vikash"));
        System.out.println();
        System.out.println("Vivek and Vikash are connected ? - " + connected);
    }

    private static boolean isConnected(Student s1, Student s2) {
        return getRoot(s1.getIndex()) == getRoot(s2.getIndex());
    }

    private static void unionStudent(Student s1, Student s2) {
        int i = getRoot(s1.getIndex());
        int j = getRoot(s2.getIndex());
        if(size[i] < size[j]){
            dataPoint[i] = j;
            size[j] += size[i];
        } else {
            dataPoint[j] = i;
            size[i] += size[j];
        }
    }



    private static int getRoot(int index) {
        if(index != dataPoint[index]){
            dataPoint[index] = dataPoint[dataPoint[index]];
            index = dataPoint[index];
        }
        return index;
    }

    private static void printDatapoints(int[] dataPoint) {
        for(int i =0; i< 51; i++) System.out.print("-");
        System.out.println();

        for(int i =0; i<dataPoint.length; i++){
            System.out.print("| " + i + " ");
        }
        System.out.println("|");

        for (int i =0; i< 51; i++) System.out.print("-");
        System.out.println();

        for(int i=0; i<dataPoint.length; i++){
            System.out.print("| " + dataPoint[i] + " ");
        }
        System.out.println("|");
        for(int i = 0; i< 51; i++) System.out.print("-");
        System.out.println();

        for(int i=0; i<size.length; i++){
            System.out.print("| " + size[i] + " ");
        }
        System.out.println("|");
    }
}

class Student{
    private String name;
    private String school;
    private int index;

    static int count;

    public Student(String name, String school) {
        this.index = count++;
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public int getIndex() {
        return index;
    }
}
