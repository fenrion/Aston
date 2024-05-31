package org.example;

import java.util.Comparator;

/**
 * My personal QuickSort for MKArrayList by Maksim Kopylov
 * @param <T>
 */
public class QuickSort<T>{
    public void sort(Comparator<T> comparator, MKArrayList<T> array){
        quickSort(0,array.getSize()-1,comparator,array);
    }

    private void quickSort(int low, int high, Comparator<T> comparator,MKArrayList<T> array){
        if(low<high){
            int pi = partition(low,high,comparator,array);
            quickSort(low,pi-1,comparator,array);
            quickSort(pi+1,high,comparator,array);
        }
    }

    private int partition(int low, int high, Comparator<T> comparator,MKArrayList<T> array){
        T pivot = array.get(high);
        int i = low-1;

        for(int j=low;j<high;j++){
            if(comparator.compare(array.get(j),pivot)<0){
                i++;
                T temp = array.get(i);
                array.set(array.get(j),i);
                array.set(temp,j);
            }
        }
        T temp = array.get(i+1);
        array.set(array.get(high),i+1);
        array.set(temp,high);

        return i+1;

    }
}
