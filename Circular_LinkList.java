package com.practice;

import java.util.Scanner;
public class Circular_LinkList {
    static class Node1 {
        int data;
        Node1 next;

        Node1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node1 head = null;
    Node1 tail = null;

    public void creation() {
        int data, n, p ,choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please enter data");
            data = sc.nextInt();
            Node1 new_node = new Node1(data);
            if (head == null) {
                head = new_node;
                tail = new_node;
                new_node.next = head;
            } else {
                System.out.println("Press  1 to insert in the beginning. Press 2 to insert at specified location. Press 3 to insert at the end");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        new_node.next = head;
                        head = new_node;
                        tail.next = head;
                    }
                    case 2 -> {
                        System.out.println("Enter the location where you want to insert the node");
                        p = sc.nextInt();
                        Node1 temp = head;
                        for (int i = 0; i < (p - 2); i++) {
                            temp = temp.next;
                        }
                        new_node.next = temp.next;
                        temp.next = new_node;
                    }
                    case 3 -> {
                        tail.next = new_node;
                        tail = new_node;
                        new_node.next = head;
                    }
                }
            }
            System.out.println("Do you want to add more data. If Yes, press 1 Else press any key to stop");
            n = sc.nextInt();
        } while (n == 1);
    }

    public void deletion(){
        int n,m,p;
        Scanner sc = new Scanner(System.in);
        do{
            if(head == null)
                System.out.println("LinkList is Empty");
            else{
                System.out.println("Press 1 to delete from the beginning. Press 2 to delete at the end. Press 3 to delete at a specified location ");
                m = sc.nextInt();
                switch (m) {
                    case 1 -> {
                        Node1 temp = head;
                        temp = temp.next;
                        head = temp;
                        tail.next = head;
                    }
                    case 2 -> {
                        Node1 temp1 = head;
                        Node1 ptr = temp1.next;
                        while (ptr.next != head) {
                            temp1 = temp1.next;
                            ptr = ptr.next;
                        }
                        temp1.next = head;
                        tail = temp1;
                    }
                    case 3 -> {
                        Node1 temp2 = head;
                        Node1 ptr1 = temp2.next;
                        System.out.println("Enter the position where you want to perform deletion");
                        p = sc.nextInt();
                        for (int i = 1; i < (p - 1); i++) {
                            temp2 = ptr1;
                            ptr1 = ptr1.next;
                        }
                        temp2.next = ptr1.next;
                    }
                }
            }
            System.out.println("Do you want to delete more nodes?. Press 1 to delete");
            n = sc.nextInt();
        }while(n == 1);
    }

    public void traversal() {
        Node1 temp = head;
        if (head == null)
            System.out.println("LinkList does not exist");
        else {

            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while (temp != head);
        }
    }
    public void size() {
        Node1 temp = head;
        int size = 0;
        if (head == null)
            System.out.println("LinkList does not exist");
        else {
            do{
                size++;
                temp = temp.next;
            }while (temp != head);
            System.out.printf("The size of Circular linked list is %d",size);
        }
    }
    public static void main (String[]args){
        String c;
        Circular_LinkList c1 = new Circular_LinkList();
        c1.creation();
        System.out.println("Do you want to perform deletion operation? Type 'Yes' OR 'No'.");
        Scanner sc = new Scanner(System.in);
        c = sc.nextLine();
        if(c.equals("YES") || c.equals("Yes"))
            c1.deletion();
        c1.traversal();
        c1.size();
    }
}
