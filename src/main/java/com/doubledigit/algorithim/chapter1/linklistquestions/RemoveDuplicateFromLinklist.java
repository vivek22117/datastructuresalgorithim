package com.doubledigit.algorithim.chapter1.linklistquestions;

import java.util.HashSet;

/**
 * Created by Vivek Kumar Mishra on 17/10/2018.
 */
public class RemoveDuplicateFromLinklist {
    private LinkListImpl linkList = null;


    public static void main(String[] args) {
        RemoveDuplicateFromLinklist removeDuplicateFromLinklist = new RemoveDuplicateFromLinklist();

        LinkListImpl initLinkList = removeDuplicateFromLinklist.initLinkList();
        initLinkList.printLinklist();

        removeDuplicateFromLinklist.removeDuplicates(initLinkList.getHead());
        initLinkList.printLinklist();

        removeDuplicateFromLinklist.removeDuplicatesByHashset(initLinkList.getHead());
        initLinkList.printLinklist();
    }


    public LinkListImpl initLinkList(){
        linkList = new LinkListImpl();
        linkList.push("Vivek");
        linkList.push("Harsha");
        linkList.push("AArti");
        linkList.push("Raj");
        linkList.push("Vikash");
        linkList.push("Varun");
        linkList.push("Harsha");
        linkList.push("Vivek");
        linkList.push("Vijay");

        return linkList;
    }

    //REMOVE DUPLICATES FROM LINKLIST USING WHILE LOOP ...takes O(N-Square)
    public void removeDuplicates(LinkListImpl.Node head){
        LinkListImpl.Node current = head;
        System.out.println("Head node is.." + head.data);
        while (current != null){
            LinkListImpl.Node runner = current;
            while (runner.next != null){
                if(runner.next.data.equals(current.data)){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //REMOVES DUPLICATES FROM LINKLIST USING HASHSET....takes O(N)..times...
    public void removeDuplicatesByHashset(LinkListImpl.Node head){
        HashSet<String> duplicates = new HashSet<>();
        LinkListImpl.Node previous = null;
        while (head != null){
            if(duplicates.contains(head.data)){
                previous.next = head.next;
            } else {
                duplicates.add(head.data);
                previous = head;
            }
            head = head.next;
        }

    }

}
