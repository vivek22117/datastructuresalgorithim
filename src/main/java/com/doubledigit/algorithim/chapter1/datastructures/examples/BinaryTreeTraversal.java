package com.doubledigit.algorithim.chapter1.datastructures.examples;

import com.doubledigit.algorithim.chapter1.datastructures.CircularQueue;
import com.doubledigit.algorithim.chapter1.datastructures.TreeNode;

import java.util.stream.Stream;

public class BinaryTreeTraversal {

    private static final CircularQueue<TreeNode> inputData = new CircularQueue<>(TreeNode.class);

    public void breadthFirstTraversal(TreeNode root) throws CircularQueue.QueueOverFlowException,
            CircularQueue.QueueUnderFlowException {
        if (root == null) {
            return;
        }

        CircularQueue<TreeNode> queue = new CircularQueue<>(TreeNode.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            processNode(node);

            if (node.getLeftNode() != null) {
                queue.enqueue(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.enqueue(node.getRightNode());
            }
        }
    }

    public void preOrderDepthFirstTraversal(TreeNode root) throws CircularQueue.QueueOverFlowException {
        if (root == null) {
            return;
        }

        processNode(root);
        preOrderDepthFirstTraversal(root.getLeftNode());
        preOrderDepthFirstTraversal(root.getRightNode());
    }

    public void inOrderDepthFirstTraversal(TreeNode root) throws CircularQueue.QueueOverFlowException {
        if (root == null) {
            return;
        }

        inOrderDepthFirstTraversal(root.getLeftNode());
        processNode(root);
        inOrderDepthFirstTraversal(root.getRightNode());
    }

    public void postOrderDepthFirstTraversal(TreeNode root) throws CircularQueue.QueueOverFlowException {
        if (root == null) {
            return;
        }

        postOrderDepthFirstTraversal(root.getLeftNode());
        postOrderDepthFirstTraversal(root.getRightNode());
        processNode(root);
    }

    private void processNode(TreeNode node) throws CircularQueue.QueueOverFlowException {
        System.out.println("node = [" + node.getData() + "]");
        inputData.enqueue(node);
    }


    public void printQueue(CircularQueue inputData) {
        Stream.iterate(0, e -> e + 1).limit(inputData.numberOfElements())
                .forEach(data -> {
                    try {
                        System.out.println("Node-data " + inputData.dequeue());
                    } catch (CircularQueue.QueueUnderFlowException e) {
                        System.out.println("e = " + e.getMessage());
                    }
                });
    }

}
