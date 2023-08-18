package com.practice;
import java.util.Scanner;

class Stack1{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;
    void push(Scanner sc){
        System.out.println("Please enter data");
        int data = sc.nextInt();
        Node new_node = new Node(data);
        if(top == null)
            top = new_node;
        else
        {
            new_node.next = top;
            top = new_node;
        }
    }

    void pop(){
        if(top == null)
            System.out.println("Stack is empty");
        else
        {
            top = top.next;
        }
    }

    void display(){
        Node temp = top;
        System.out.println("The values in stack are: ");
        while(temp !=null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

    }
}
public class Stack_LinkList {
    public static void main(String[] args) {
        int d;
        Scanner sc = new Scanner(System.in);
        Stack1 s1 = new Stack1();
        int l;
        do{
            System.out.println("Press 1 to Push");
            System.out.println("Press 2 to Pop");
            System.out.println("Press 3 to Display");
            d = sc.nextInt();

            switch(d){
                case 1->
                        s1.push(sc);
                case 2->
                        s1.pop();
                case 3->
                        s1.display();
            }
            System.out.println("Press 0 to return to main menu");
            System.out.println("Press any key to exit the program");
            l = sc.nextInt();
        }while(l == 0);
    }
}
