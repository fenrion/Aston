package org.example;

/**
 * My personal ArrayList by Maksim Kopylov for Aston
 * @param <T>
 */
public class MKArrayList<T> {
    private int capacity = 1;
    private T[] array = (T[])new Object[capacity];
    private int size=0;

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * add in ArrayList element
     * @param elem
     */
    public void add(T elem){
        enoughSize();
        array[size]=elem;
        size++;
    }

    /**
     * add in ArrayList element by index
     * @param elem
     * @param index
     */
    public void add(T elem, int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("index: " + index + " size: "+size);
        }
        enoughSize();
        for (int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        //System.arraycopy(array, index,array, index + 1,size - index);
        array[index]=elem;
        size++;
    }

    /**
     * add in ArrayList another array
     * @param elem
     */
    public void add(T[] elem){

        while(size+elem.length>=array.length){
            growArray();
        }
        int j=0;
        for(int i= size;i<size+ elem.length;i++){
            array[i]=elem[j];
            j++;
        }
        //System.arraycopy(elem,0,array,size,elem.length);
        size=size+elem.length;
    }

    /**
     * set element by index
     * @param elem
     * @param index
     */
    public void set(T elem, int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("index: " + index + " size: "+size);
        }
        array[index]=elem;
    }

    /**
     * remove element from array by index
     * @param index
     */
    public void remove(int index){
        T[] copyArray = (T[])new Object[capacity];
        for(int i=0;i<size;i++){
            copyArray[i]=array[i];
        }
        for(int i=index;i<size;i++){
            if(i+1!=size){
                array[i]=copyArray[i+1];
            }
        }
        //System.arraycopy(array,index+1,array,index,size-index-1);
        array[--size]=null;
    };

    /**
     * clear array from elements
     */
    public void clear(){
        capacity=1;
        array=(T[])new Object[capacity];
        size=0;
    }

    /**
     * getting element from array by index
     * @param index
     * @return
     */
    public T get(int index){
        return (T) array[index];
    }

    /**
     * the array is growing twice in size with copied elements
     */
    private void growArray(){
        capacity *= 2;
        T[] copyArray = (T[])new Object[capacity];
        for(int i=0;i<array.length;i++){
            copyArray[i]=array[i];
        }
        //System.arraycopy(array,0,copyArray,0,size);
        array=copyArray;
    }

    /**
     * checking enough size for add element in array
     */
    private void enoughSize(){
        if(size==array.length-1){
            growArray();
        }
    }

}