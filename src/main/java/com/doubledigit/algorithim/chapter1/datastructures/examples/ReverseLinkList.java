package com.doubledigit.algorithim.chapter1.datastructures.examples;


import com.doubledigit.algorithim.chapter1.datastructures.LinkListDataStructure;

public class ReverseLinkList {

    private static LinkListDataStructure<Integer> empLinkList = new LinkListDataStructure<>();

    public static void main(String[] args) {
        empLinkList.append(11);
        empLinkList.append(12);
        empLinkList.append(44);
        empLinkList.append(66);
        empLinkList.append(33);
        empLinkList.append(88);
        empLinkList.append(55);

        System.out.println("head = " + empLinkList.getHead());

        reverseLinkList(empLinkList);
    }

    public static void reverseLinkList(LinkListDataStructure<Integer> empLinkList) {
        if (ReverseLinkList.empLinkList.isEmpty()) {
            return;
        }
    }


}

