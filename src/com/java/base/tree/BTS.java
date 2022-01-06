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


    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    //二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("bts is empty");
        }
        return minimum(root).e;
    }


    //寻找二分搜索树的最小元素所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    //寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("bts is empty");
        }
        return maximum(root).e;
    }


    //寻找二分搜索树的最大元素所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return minimum(node.right);
    }


    //删除二分搜索树最小的元素所在的节点，并返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }


    //删除掉以node为根节点的二分搜索树的最小节点
    //返回删除后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    //删除二分搜索树最大的元素所在的节点，并返回最小值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }


    //删除掉以node为根节点的二分搜索树的最大节点
    //返回删除后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


}
