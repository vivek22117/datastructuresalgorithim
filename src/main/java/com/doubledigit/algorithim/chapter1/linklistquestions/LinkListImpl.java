package com.doubledigit.algorithim.chapter1.linklistquestions;

/**
 * Created by Vivek Kumar Mishra on 17/10/2018.
 */
public class LinkListImpl {

    private Node head = null;

    class Node{
        String data;
        Node next;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(String data){
        Node oldFirst = head;
        head = new Node();
        head.data = data;
        head.next = oldFirst;
    }

    public String pop(){
        String data = head.data;
        head = head.next;
        return data;
    }

    public void printLinklist(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("Printing Done..!");
    }

    public Node getHead() {
        return head;
    }
}
