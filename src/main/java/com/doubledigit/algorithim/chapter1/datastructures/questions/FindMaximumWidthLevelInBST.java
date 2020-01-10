package com.doubledigit.algorithim.chapter1.datastructures.questions;

import com.doubledigit.algorithim.chapter1.datastructures.CircularQueue;
import com.doubledigit.algorithim.chapter1.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FindMaximumWidthLevelInBST {

    private static TreeNode<Integer> head = null;

    public static void main(String[] args) {
        Stream.iterate(0, e -> e + 1).limit(5).forEach(value -> {
            int data = new Random().nextInt(16);
            head = insert(head, new TreeNode<>(data));
            System.out.println("data = " + data);
        });
        System.out.println("head = " + head.getData());

        try {
            int levelWithHighestWidth = findLevelWithHighestWidth(head);
            System.out.println("levelWithHighestWidth = " + levelWithHighestWidth);

        } catch (CircularQueue.QueueOverFlowException e) {
            e.printStackTrace();
        }
    }

    private static int findLevelWithHighestWidth(TreeNode<Integer> head) throws CircularQueue.QueueOverFlowException {
        if (head == null) {
            return 0;
        }

        int maxWidth = 1;
        CircularQueue<TreeNode> treeNodesQueue = new CircularQueue<>(TreeNode.class);
        treeNodesQueue.enqueue(head);

        while (!treeNodesQueue.isEmpty()) {
            List<TreeNode> treeNodes = dequeueAllNodes(treeNodesQueue);

            maxWidth = Math.max(maxWidth, treeNodes.size());
            System.out.println("maxWidth = " + maxWidth);

            addAllChildNodesToQueue(treeNodes, treeNodesQueue);
        }
        return maxWidth;
    }

    private static void addAllChildNodesToQueue(List<TreeNode> treeNodes, CircularQueue<TreeNode> treeNodesQueue) {
        treeNodes.forEach(dequeueNode -> {
            if (dequeueNode.getLeftNode() != null) {
                try {
                    treeNodesQueue.enqueue(dequeueNode.getLeftNode());
                } catch (CircularQueue.QueueOverFlowException e) {
                    e.printStackTrace();
                }
            }
            if (dequeueNode.getRightNode() != null) {
                try {
                    treeNodesQueue.enqueue(dequeueNode.getRightNode());
                } catch (CircularQueue.QueueOverFlowException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static List<TreeNode> dequeueAllNodes(CircularQueue<TreeNode> treeNodesQueue) {
        List<TreeNode> listOfNodes = new ArrayList<>();
        while (!treeNodesQueue.isEmpty()) {
            try {
                listOfNodes.add(treeNodesQueue.dequeue());
            } catch (CircularQueue.QueueUnderFlowException e) {
                e.printStackTrace();
            }
        }
        return listOfNodes;
    }

    private static int getWidth(CircularQueue<TreeNode> treeNodesQueue) {
        return treeNodesQueue.numberOfElements();
    }

    private static TreeNode<Integer> insert(TreeNode<Integer> head, TreeNode<Integer> newNode) {
        if (head == null) {
            head = newNode;
            return head;
        }

        if (newNode.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), newNode));
        } else {
            head.setRightNode(insert(head.getRightNode(), newNode));
        }
        return head;
    }


}
