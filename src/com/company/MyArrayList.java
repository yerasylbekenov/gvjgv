package com.company;

public class MyArrayList<T> {
    private Object[] array;
    private int size = 0;
    private int capacity = 5;

    public MyArrayList(){
        array = new Object[capacity];
    }

    public void add(T newItem, int index){
        if(size==capacity){
            capacity = (int) (2.5*capacity);
            Object[] array2 = new Object[capacity];
            for(int i = 0; i<size; i++){
                array2[i] = array[i];
            }
            array = array2;
            size++;
            array[index]=newItem;
        } else{
            size++;
            array[index] = newItem;
        }
    }

    public int find(T searchingItem){
        for(int i = 0; i< size; i++){
            if(array[i] == searchingItem){
                return i;
            }
        }
        return -1;
    }

    public Object remove(int index){
        Object removedElement = array[index];
        for(int i=index; i<size;i++){
            array[i]=array[i+1];
        }
        array[size] = null;
        size--;
        return removedElement;
    }

    public void reverse(){
        int j = size-1;
        Object[] array2 = new Object[capacity];
        for(int i =0; i<size; i++){
            array2[i]=array[j];
            j--;
        }
        array = array2;
    }

    public void printList(){
        for(int i = 0; i< size; i++){
            System.out.println(array[i]);
        }
    }
}
