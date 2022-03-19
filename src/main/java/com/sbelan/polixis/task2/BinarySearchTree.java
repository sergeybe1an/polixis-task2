package com.sbelan.polixis.task2;

public class BinarySearchTree {

    private Node root;

    private static class Node {
        private String ip;
        private Node left, right;
        private int nodesQuantity;

        public Node(String ip, int nodesQuantity) {
            this.ip = ip;
            this.nodesQuantity = nodesQuantity;
        }

        public String getIp() {
            return ip;
        }

        public int getSubNodesQuantity() {
            return nodesQuantity;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setSubNodesQuantity(int nodesQuantity) {
            this.nodesQuantity = nodesQuantity;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getSubNodesQuantity();
    }

    public void put(String ip) {
        this.root = put(this.root, ip);
    }

    private Node put(Node node, String ip) {
        if (node == null) {
            return new Node(ip, 1);
        }

        if (ip.compareTo(node.getIp()) < 0) {
            node.setLeft(put(node.getLeft(), ip));
        } else if (ip.compareTo(node.getIp()) > 0) {
            node.setRight(put(node.getRight(), ip));
        } else {
            node.setIp(ip);
        }

        node.setSubNodesQuantity(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }
}
