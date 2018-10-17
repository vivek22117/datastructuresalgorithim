package com.doubledigit.algorithim.chapter1.linklistquestions;

/**
 * Created by Vivek Kumar Mishra on 17/10/2018.
 *
 * kth Element from last in a link list using Recursive...approach.....
 */
public class FindKthElementFromLast {

    private LinkListImpl linkList;

    public static void main(String[] args) {
        FindKthElementFromLast kthElement = new FindKthElementFromLast();
        LinkListImpl initializedLinkList = kthElement.initLinklist();
        initializedLinkList.printLinklist();

        LinkListImpl.Node node = kthElement.kthElementFromLast(initializedLinkList.getHead(), 4);

        System.out.println("Kth Element from last is..." + node.data);

    }

    public LinkListImpl initLinklist() {
        linkList = new LinkListImpl();
        linkList.push("Vivek");
        linkList.push("Arti");
        linkList.push("Varun");
        linkList.push("Harsha");
        linkList.push("Varsha");
        linkList.push("Viash");
        linkList.push("Neeraj");
        linkList.push("Yahs");
        linkList.push("Nidhi");
        linkList.push("Deepak");

        return linkList;
    }

    public LinkListImpl.Node kthElementFromLast(LinkListImpl.Node head, int k) {
        Index index = new Index();
        System.out.println("The Value of index is.." + index.value);
        return kthToLast(head, k, index);
    }

    private LinkListImpl.Node kthToLast(LinkListImpl.Node head, int k, Index id) {
        if (head == null) {
            return null;
        }

        LinkListImpl.Node node = kthToLast(head.next, k, id);
        id.value = id.value + 1;
        if (id.value == k) {
            return head;
        }
        return node;
    }

    class Index {
        public int value = 0;
    }
}
