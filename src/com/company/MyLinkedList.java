package com.company;

public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size = 0;

    public MyLinkedList(){

    }

    public void add(T newItem, int index){
        if(index == 0) {
            if(head == null) {
                MyNode<T> newNode = new MyNode<>(newItem);
                head = newNode;
                head.next = null;
                System.out.println(head.data);
                size++;
            }
            else {
                MyNode<T> newNode = new MyNode<>(newItem);
                newNode.next = head;
                head = newNode;
                size++;
//                System.out.println(head.data);
            }
        }
        else if(index >= size){
            MyNode<T> newNode = new MyNode<>(newItem);
            if(tail == null) {
                head = tail = newNode;
                System.out.println(tail.data);
            }
            else {
                tail.next = newNode;
                tail = tail.next;
                System.out.println(tail.data);
            }
            size++;
        }
        else{
            MyNode<T> current = head;
            for (int i = 1; i < index; i++) current = current.next;
            MyNode<T> temp = current.next;
            current.next = new MyNode<>(newItem);
            (current.next).next = temp;
            System.out.println(current.data);
            size++;
        }
    }

    public int find(T keyItem) {
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == keyItem) return i;
            current = current.next;
        }
        return -1;
    }

    public T remove(int index) {
        MyNode<T> temp = head;
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = head.next;
            size--;
            return temp.data;
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            MyNode<T> removedElement = temp.next;
            temp.next = temp.next.next;
            if (index == size - 1) tail = temp;
            size--;
            return removedElement.data;
        }
    }

    public void reverse() {
        MyNode<T> temp1 = head;
        MyNode<T> temp2 = temp1.next;
        MyNode<T> temp3 = temp2.next;

        while (temp3 != tail) {
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp2.next;
        }
        temp2.next = temp1;
        temp3.next = temp2;

        MyNode<T> temp = tail;
        tail = head;
        tail.next = null;
        head = temp;
        head.next = temp2;
    }

    public static class MyNode<T>{
        T data;
        MyNode<T> next;

        MyNode(T data){
            this.data = data;
            this.next = null;
        }
    }
}
