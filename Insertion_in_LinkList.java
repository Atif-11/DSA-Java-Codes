package com.practice;

import java.util.Scanner;
import com.practice.Single_Link_List.Node;
public class Insertion_in_LinkList{
        Node head = null;
        public void creationAndInsertion() {
            int data, n, choice, location;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Please enter data");
                data = sc.nextInt();
                Node new_node = new Node(data);
                if (head == null) {
                    head = new_node;
                } else {
                    System.out.println("Press  1 to insert in the beginning. Press 2 to insert at specified location. Press 3 to insert at the end");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> {
                            new_node.next = head;
                            head = new_node;
                        }
                        case 2 -> {
                            System.out.println("Enter the location where you want to insert the node");
                            location = sc.nextInt();
                            Node temp = head;
                            for (int i = 0; i < (location - 2); i++) {
                                temp = temp.next;
                            }
                            new_node.next = temp.next;
                            temp.next = new_node;
                        }
                        case 3 -> {
                            Node temp1 = head;
                            while (temp1.next != null) {
                                temp1 = temp1.next;
                            }
                            temp1.next = new_node;
                        }
                    }
                }
                System.out.println("Do you want to add more data. If Yes, press 1 Else press any key to stop");
                n = sc.nextInt();
            } while (n == 1);
        }

    public void deletionInLinkList(){
            int n,m,p;
            Scanner sc = new Scanner(System.in);
            do{
                if(head == null)
                    System.out.println("LinkList is Empty");
                else{
                    System.out.println("Press 1 to delete from the beginning. Press 2 to delete at the end. Press 3 to delete at a specified location ");
                    m = sc.nextInt();
                    switch (m){
                        case 1:
                            Node temp = head;
                            temp = temp.next;
                            head = temp;
                            break;
                        case 2:
                            Node temp1 = head;
                            Node ptr = temp1.next;
                            while(ptr.next != null)
                            {
                                temp1 = temp1.next;
                                ptr = ptr.next;
                            }
                            temp1.next = null;
                            break;
                        case 3:
                            Node temp2 = head;
                            Node ptr1 = temp2.next;
                            System.out.println("Enter the position where you want to perform deletion");
                            p = sc.nextInt();
                            for(int i =0; i < (p-2);i++){
                                temp2 = ptr1;
                                ptr1 = ptr1.next;
                            }
                            temp2.next = ptr1.next;
                            break;
                    }}
                System.out.println("Do you want to delete more nodes?. Press 1 to delete");
                n = sc.nextInt();
            }while(n == 1);
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

    public static void main(String[] args) {
        Insertion_in_LinkList l1 = new Insertion_in_LinkList();
        l1.creationAndInsertion();
        System.out.println("LinkList's data after creating");
        l1.traversal();
        l1.deletionInLinkList();
        System.out.println("LinkList's data after deletion");
        l1.traversal();


    }
}
