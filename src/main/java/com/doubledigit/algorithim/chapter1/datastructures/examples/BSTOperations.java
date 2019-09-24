package com.doubledigit.algorithim.chapter1.datastructures.examples;

import com.doubledigit.algorithim.chapter1.datastructures.TreeNode;

public class BSTOperations {

    public class Employee {
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static TreeNode<Employee> insert(TreeNode<Employee> head, TreeNode<Employee> node) {
        if (head == null) {
            return node;
        }

        if (node.getData().id <= head.getData().id) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }

    private static TreeNode<Employee> lookup(TreeNode<Employee> head, TreeNode<Employee> search){
        if(head == null){
            return null;
        }

        if(head.getData().id == search.getData().id){
            return head;
        }

        if(search.getData().id < head.getData().id){
            return lookup(head.getLeftNode(), search);
        } else {
            return lookup(head.getRightNode(), search);
        }
    }
}
