package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Everything about MyArrayList
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i, i);
        }
        System.out.println(list.find(5));
        System.out.println(list.remove(4));
        list.printList();
        list.reverse();
        list.printList();
        System.out.println("------------------------------------------");
        //Everything about MyLinkedList
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        for(int i = 0; i<10; i++){
            list1.add(i,i);
        }
        System.out.println("----------------");
        System.out.println(list1.find(1));
        System.out.println(list1.remove(5));
        list1.reverse();

    }
}
