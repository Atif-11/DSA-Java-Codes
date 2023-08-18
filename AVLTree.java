package com.practice;

import java.util.Scanner;

public class AVLTree {
private int key, height;
private AVLTree left, right;

public static final AVLTree NIL = new AVLTree();

public AVLTree(int[] a) {
        this.key = a[0];
        left = right = NIL;
        for (int i = 1; i < a.length; i++) {
            this.add(a[i]);
        }
}

public AVLTree(int key){
        this.key = key;
        left = right = NIL;
        }

public boolean add(int key){
    int oldSize = size();
    grow(key);
    return size() > oldSize;
}

public AVLTree grow(int key){
        if (this == NIL) return new AVLTree(key);
    // prevent key duplication
        if (key == this.key) return this;
        if (key < this.key) left = left.grow(key);
        else right = right.grow(key);
        rebalance();

        height = 1 + Math.max(left.height, right.height);
        return this;
        }

public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
        }

public String toString() {
    if (this == NIL) return "";
    return left + " " + key + " " + right;
}

private AVLTree(){
    left = right = this;
    height = -1;
}

private AVLTree(int key, AVLTree left, AVLTree right) {
            this.key = key;
            this.left = left;
            this.right = right;
            height = 1+ Math.max(left.height,right.height);
        }



private void rebalance() {
        if (right.height > left.height+1) {
        if (right.left.height > right.right.height) right.rotateRight();
        rotateLeft();
        }
        else if (left.height > right.height+1) {
        if (left.right.height > left.left.height) left.rotateLeft();
        rotateRight();
        }
        }

private void rotateLeft() {
        left = new AVLTree(key,left,right.left);
        key = right.key;
        right = right.right;
        }

private void rotateRight() {
        right = new AVLTree(key,left.right,right);
        key = left.key;
        left = left.left;
        }

    public static void preorderTraversal(AVLTree root) {
        if (root != NIL) {
            System.out.print(root.key + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }


public int getHeight(){
    return this.height;
}
public AVLTree getLeft(){
    return this.left;
}
public AVLTree getRight(){
    return this.right;
}
public int getRoot(){
    return this.key;
}

    public AVLTree delete(AVLTree root, int val){
        if(root.key > val)
            root.left = delete(root.left, val);
        else if(root.key < val)
            root.right = delete(root.right, val);

        else{
            //Case 1 Node is a leaf
            if(root.left == NIL && root.right == NIL){
                return NIL;
            }
            //Case 2 Node has either left or right child
            if(root.left == NIL)
                return root.right;
            else if(root.right == NIL)
                return root.left;

            //Case 3 Node has 2 two Children
            AVLTree IS = inorderSuccessor(root.right);
            root.key = IS.key;
            root.right = delete(root.right,IS.key);
        }
        rebalance();
        return root;
    }

    public boolean contains(int x) {
        if (this == NIL)
            return false;
        if (x == key)
            return true;
        if (x < key)
            return left.contains(x);
        else
            return right.contains(x);
    }

    public boolean isAVLTree() {
        if (this == NIL)
            return true;

        int balanceFactor = Math.abs(left.height - right.height);
        boolean isLeftAVL = left.isAVLTree();
        boolean isRightAVL = right.isAVLTree();

        return (balanceFactor <= 1) && isLeftAVL && isRightAVL;
    }



    public static AVLTree inorderSuccessor(AVLTree root){
        while(root.left != NIL){
            root = root.left;
        }
        return root;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
           System.out.println("Please enter the number of entries you need in your AVL tree.");
            int num = sc.nextInt();
            int input;
            int[] arr = new int[num];
            System.out.println("Populate the array now");
            for(int i = 0; i< num;i++){
                System.out.println("Enter value:");
                input = sc.nextInt();
                arr[i] = input;
            }
         AVLTree tree = new AVLTree(arr);
            System.out.println("Creation successful");
            System.out.println("Here are the values of tree in pre-order traversal: ");
            System.out.println(tree);
//            System.out.println("How many entries you want to make in your AVL Tree?");
//            int entries = sc.nextInt();
//            int input;
//            for(int i=1; i<=entries;i++){
//                System.out.println("Please enter "+i+" value:");
//                input = sc.nextInt();
//                tree.add(input);
//            }
//            int height = tree.getHeight();
//            AVLTree treeLeft = tree.getLeft();
//            AVLTree treeRight = tree.getRight();
//            int root = tree.getRoot();
//            System.out.println("Press 1 to check if the tree is AVL or not.");
//            int avl = sc.nextInt();
//            if(avl == 1){
//            boolean check = tree.isAVLTree();
//            System.out.println("Is tree AVL:" + check);
//            }
//            System.out.println("Here are the values of tree in pre-order traversal: ");
//            System.out.println(tree);
//            System.out.println(tree);
//            tree.delete(tree,10);
//
//
//            System.out.println(tree);
//            System.out.println("Height of the tree is "+height+"\nThe left Subtree is: "+treeLeft+"\nRight Subtree is: "+treeRight+"\nThe root key is: "+root);
//            AVLTree.preorderTraversal(tree);
        }
        }


