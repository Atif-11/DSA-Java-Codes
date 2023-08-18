package com.practice;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Single_Link_List {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void creation() {
        int data, n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please enter data");
            data = sc.nextInt();
            Node new_node = new Node(data);
            if (head == null) {
                head = new_node;
            } else {
                new_node.next = head;
                head = new_node;
            }
            System.out.println("Do you want to add more data. If Yes, press 1 Else press any key to stop");
            n = sc.nextInt();
        } while (n == 1);
    }

    public Node rotate(Node list, int d){
        int count = 0;
        Node temp = this.head;
        Node ptr = temp.next;
        while(temp != null){
            count++;
            if(count == (d-1)){
                this.head = ptr;
                temp.next = null;
            }
            if(ptr == null){
                temp.next = list;
            }
            temp = temp.next;
        }
        return head;
    }

    public void traversal() {
        if (head == null)
            System.out.println("LinkList does not exist");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
    }
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

        public static void main (String[]args){
            Single_Link_List s1 = new Single_Link_List();
            s1.creation();
            s1.traversal();
            //printList(s);

        }
}