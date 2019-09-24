package com.doubledigit.algorithim.chapter1.linklistquestions;

/**
 * Created by Vivek Kumar Mishra on 17/10/2018.
 */
public class KthElementFromLastII {
    private LinkListImpl linkList;

    public static void main(String[] args) {
        KthElementFromLastII kthElement = new KthElementFromLastII();
        LinkListImpl initializedLinkList = kthElement.initLinkList();
        initializedLinkList.printLinklist();

        LinkListImpl.Node node = kthElement.kthElementFromLast(initializedLinkList.getHead(), 5);
        System.out.println("Kth element from last is..." + node.data);
    }

    public LinkListImpl initLinkList() {
        linkList = new LinkListImpl();
        linkList.push("Vivek");
        linkList.push("Vijay");
        linkList.push("Harsha");
        linkList.push("Arti");
        linkList.push("Raj");
        linkList.push("Varsha");
        linkList.push("Deepak");
        linkList.push("Yash");
        linkList.push("John");
        linkList.push("Nseit");
        linkList.push("Sai");

        return linkList;
    }

    public LinkListImpl.Node kthElementFromLast(LinkListImpl.Node head, int k) {
        LinkListImpl.Node p1 = head;
        LinkListImpl.Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                return null; //out of bound because number of nodes are less than k...
            }
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
