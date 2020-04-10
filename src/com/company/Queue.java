package com.company;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    Item arr[];
    int size = 0, front = 0;

    public Queue() {

        arr = (Item[]) new Object[1];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public void enqueue(Item item) {

        arr[size++] = item;

        if (size == arr.length)
            resize(2 * arr.length);
    }

    public Item dequeue() {

        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Item temp = arr[front];
        arr[front] = null;
        front++;
        size--;

        if (size <= arr.length / 4)
            resize(arr.length / 2);

        return temp;
    }

    public Iterator<Item> iterator(){

            return new Itemlist();
    }

    private class Itemlist implements Iterator<Item> {

        private int current = front;

        public boolean hasNext() {
            return front < size;
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }

        public Item next() {
            int current = front;
            if (arr[current] == null)
                throw new java.util.NoSuchElementException();
            else {

                return arr[current++];
            }
        }
    }

        private void resize(int len){

            Item temp[] = (Item[]) new Object[len];
            for(int i =0;i<size;i++)
            {
                if(arr[i]!=null)
                    temp[i]=arr[i];

            }
            front = 0;

    }
}





