package com.practice;
import java.util.Scanner;

class Stack{
    int n = 10, top = -1;
    int[] arr = new int[n];
    Scanner sc = new Scanner(System.in);

    void push(){
        if(top==(n-1)){
            System.out.println("Overflow");
        }
        else
        {
            System.out.println("Enter data");
            int i = sc.nextInt();
            top = top+1;
            arr[top] = i;
            System.out.println("Item Inserted");
        }
    }

    void pop(){
        if(top == -1)
            System.out.println("Underflow");
        else
        {
            top = top-1;
            System.out.println("Item Deleted");
        }
    }

    void display(){
        System.out.println("Items are: ");
        for(int i = top; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }
}
public class Stack_Array {
    public static void main(String[] args) {
        int choice, iterator;
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Press 1 for Push Operation.\nPress 2 for Pop operation.\nPress 3 for display\nPress any other button to exit");
        choice = sc.nextInt();
        switch(choice){
        case 1->
                stack.push();

        case 2->
                stack.pop();

        case 3->
                stack.display();

        }
            System.out.println("Enter 0 to return to the main menu");
            System.out.println("Press any key to exit");
            iterator = sc.nextInt();
        }while(iterator == 0);
    }
}
