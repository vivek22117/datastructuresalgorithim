package com.doubledigit.algorithim.chapter1.datastructures.questions;

import com.doubledigit.algorithim.chapter1.datastructures.TreeNode;

import java.util.Random;
import java.util.stream.Stream;

public class FindClosestValueInBST {

    private static TreeNode<Integer> head = null;
    private static final Integer TARGET_VALUE = 8;

    public static void main(String[] args) {
        Stream.iterate(0, e -> e + 1).limit(14).forEach(i -> {
            int value = new Random().nextInt(20);
            head = insert(head, new TreeNode<>(value));
            System.out.println("value = " + value);
        });
        System.out.println("head = " + head.getData());

        int closestValueToTargetInBST = findClosestValueToTargetInBST(head, TARGET_VALUE, Integer.MAX_VALUE);
        System.out.println("closestValueToTargetInBST = " + closestValueToTargetInBST);
        int closesValueIterative = findClosestValueToTargetInBSTIterative(head, TARGET_VALUE, Integer.MAX_VALUE);
        System.out.println("closesValueIterative = " + closesValueIterative);
    }

    //recursive method  -> time: O(n) | space: O(n)
    private static int findClosestValueToTargetInBST(TreeNode<Integer> head, Integer target, Integer closest) {
        if (head == null) {
            return closest;
        }

        if (Math.abs(target - closest) > Math.abs(target - head.getData())) {
            closest = head.getData();
        }

        if (target < head.getData()) {
            return findClosestValueToTargetInBST(head.getLeftNode(), target, closest);
        } else if (target > head.getData()) {
            return findClosestValueToTargetInBST(head.getRightNode(), target, closest);
        } else {
            return closest;
        }
    }

    //iterative method  -> time: O(n) | space: O(1)
    private static int findClosestValueToTargetInBSTIterative(TreeNode<Integer> head, Integer target, Integer closest) {
        TreeNode<Integer> currentNode = head;

        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.getData())) {
                closest = currentNode.getData();
            }
            if (target < currentNode.getData()) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return closest;
    }

    private static TreeNode<Integer> insert(TreeNode<Integer> head, TreeNode<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }

    private static TreeNode<Integer> lookup(TreeNode<Integer> head, TreeNode<Integer> search) {
        if (head == null) {
            return null;
        }

        if (head.getData() == search.getData()) {
            return head;
        }

        if (search.getData() < head.getData()) {
            return lookup(head.getLeftNode(), search);
        } else {
            return lookup(head.getRightNode(), search);
        }
    }

}
