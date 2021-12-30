package com.java.base.tree;


/**
 * Comparable表示E必须是一个可比较的类型
 *
 * @param <E>
 */
public class BTS<E extends Comparable<E>> {


    private Node root;
    private int size;
    public BTS() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索输中添加元素
     */
    public void add(E e) {
        //递归算法一
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }

        //递归算法二
        root = add(root, e);
    }

    /**
     * 向node为根的二分搜索树中插入元素，递归算法二 对一的优化
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    /**
     * 向node为根的二分搜索树中插入元素，递归算法一
     */
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else if (e.compareTo(node.e) > 0) {
//            add(node.right, e);
//        }
//
//    }

    /**
     * 查看二分搜索树中是否包含了某个元素
     */
    public boolean contain(E e) {
        return contain(root, e);
    }

    private boolean contain(Node node, E e) {
        if (node == null)
            return false;
        else if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contain(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return contain(node.right, e);
        return false;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}
