package weblab;

import java.util.*;

class QuickSelect {

    /**
     * Creates a random partition in a subarray of the input array in-place
     * and returns the index of the pivot.
     * You may assume all items in arr are distinct.
     *
     * @param arr Array to partition.
     * @param left Lower bound of the subarray to partition (inclusive).
     * @param right Upper bound of the subarray to partition (inclusive).
     * @return The index of the pivot after partitioning the array.
     */
    public int partition(int[] arr, int left, int right) {
        
        Random random= new Random();
        int a=left;
        int b=right-1;
        int pivotindex= random.nextInt(left,right);
        int temp=arr[right];
        arr[right]=arr[pivotindex];
        
        arr[pivotindex]=temp;
        int pivot= arr[right];
        while(a<=b){
            while(a<=b&&arr[a]<=pivot){
                a++;
            }
            while(a<=b&&arr[b]>pivot){
                b--;
            }
            if(a<=b){
                temp= arr[a];
                arr[a]=arr[b];
                arr[b]=temp;
                a++;
                b--;
            }
        }

        temp=arr[right];
        arr[right]=arr[a];
        arr[a]=temp;
        
        return a;

    }

    /**
     * Performs in-place quick select to return the k'th smallest number in arr.
     *
     * @param arr Array to find number in.
     * @param k K'th smallest number must be returned.
     * @return The k'th smallest number in arr.
     */
    public int quickSelect(int[] arr, int k) {
        return quack(arr,0,arr.length-1,k-1);
    }
    public int quack(int[] arr,int start,int end,int k){
        if(start==end){
            return arr[start];
        }
        int pivotindex=partition(arr,start,end);
        if(k<pivotindex){
            return quack(arr,start,pivotindex,k);
        }else if(k==pivotindex){
            return arr[pivotindex];
        }else{
            return quack(arr,pivotindex,end,k);
        }
    }
}
