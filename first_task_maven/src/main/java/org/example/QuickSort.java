package org.example;

import java.util.Comparator;

/**
 * My personal QuickSort for MKArrayList by Maksim Kopylov
 * @param <T>
 */
public class QuickSort<T>{
    /**
     * quicksort using comparator
     * @param comparator
     * @param array
     */
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

    /**
     * quicksort using comparable
     * @param array
     * @param <T>
     */
    public <T extends Comparable<T>> void sort(MKArrayList<T>array) {
        doSort(array, 0, array.getSize() - 1);
    }

    private <T extends Comparable<T>> void doSort(MKArrayList<T> array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            doSort(array, low, pivot - 1);
            doSort(array, pivot, high);
        }
    }

    private <T extends Comparable<T>> int partition(MKArrayList<T> array, int low, int high) {
        int mid = (low + high) / 2;
        T pivot = array.get(mid);
        while (high >= low) {
            while (array.get(low).compareTo(pivot) < 0) {
                low++;
            }
            while (pivot.compareTo(array.get(high)) < 0) {
                high--;
            }
            if (high >= low) {
                T swap = array.get(low);
                array.set(array.get(high),low);
                array.set(swap,high);
                ++low;
                --high;
            }
        }
        return low;
    }
}
