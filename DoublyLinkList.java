package com.practice;
import java.util.Scanner;

public class DoublyLinkList {
    static class Node2{
        int data;
        Node2 prev;
        Node2 next;

        Node2(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node2 head = null;
    Node2 tail = null;

    public void creation(){
        int data,n,m,p;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter data");
            data = sc.nextInt();
            Node2 new_node = new Node2(data);
            if(head == null){
                head = new_node;
                tail = new_node;
            }
            else{
                System.out.println("Press 1 to insert at the start. 2 for at the end. 3 for at specific location.");
                m = sc.nextInt();
                switch (m) {
                    case 1 -> {
                        head.prev = new_node;
                        new_node.next = head;
                        head = new_node;
                    }
                    case 2 -> {
                        tail.next = new_node;
                        new_node.prev = tail;
                        tail = new_node;
                    }
                    case 3 -> {
                        System.out.println("Enter the position where you want to add the data");
                        p = sc.nextInt();
                        Node2 temp = head;
                        Node2 ptr = temp.next;
                        for (int i = 1; i < (p - 1); i++) {
                            temp = ptr;
                            ptr = ptr.next;
                        }
                        temp.next = new_node;
                        new_node.next = ptr;
                        new_node.prev = temp;
                        ptr.prev = new_node;
                    }
                }
            }
            System.out.println("Do you want to enter more data? Press 1 to enter more date");
            n = sc.nextInt();
        }while(n==1);
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
                        Node2 temp = head;
                        temp = temp.next;
                        head = temp;
                        temp.prev = null;
                    }
                    case 2 -> {
                        Node2 temp1 = tail;
                        temp1 = temp1.prev;
                        tail = temp1;
                        tail.next = null;
                    }
                    case 3 -> {
                        Node2 temp2 = head;
                        Node2 ptr1 = temp2.next;
                        System.out.println("Enter the position where you want to perform deletion");
                        p = sc.nextInt();
                        for (int i = 1; i < (p - 1); i++) {
                            temp2 = ptr1;
                            ptr1 = ptr1.next;
                        }
                        temp2.next = ptr1.next;
                        ptr1.next.prev = temp2;
                    }
                }
            }
            System.out.println("Do you want to delete more nodes?. Press 1 to delete");
            n = sc.nextInt();
        }while(n == 1);
    }

    public void traversal() {
        Node2 temp = head;
        if (head == null)
            System.out.println("LinkList does not exist");
        else {

            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while (temp != null);
        }
    }

    public static void main(String[] args) {
        String c;
        DoublyLinkList d1 = new DoublyLinkList();
        d1.creation();
        System.out.println("Do you want to perform deletion operation? Type 'Yes' OR 'No'.");
        Scanner sc = new Scanner(System.in);
        c = sc.nextLine();
        if(c.equals("YES") || c.equals("Yes"))
            d1.deletion();
        d1.traversal();
    }
}
