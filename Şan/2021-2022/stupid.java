package weblab;

import java.util.*;

public class Solution {

    /**
     * Sorts and merges `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]` into `out`.
     *
     * @param in The input array, sorted in their intervals `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`.
     * @param out The output array that should be updated to have `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`
     *            in sorted fashion at `out[start, start + 2*inc - 1]`.
     * @param start The index of the first element to be merged into out.
     * @param inc The size of each of the intervals to be merged into out.
     */
    public static void merge(int[] in, int[] out, int start, int inc) {
        int i=start;
        int j=start+inc;
        int iLim=Math.min(start+inc,in.length);
        int jLim=Math.min(start+2*inc,in.length);
        int total=start;
        while(total<jLim){
            if(j>=jLim||(i<iLim &&in[i]<in[j])){
                out[total]=in[i];
                i++;
                total++;
            }else{
                out[total]=in[j];
                j++;
                total++;
            }
        }
    }

    /**
     * Sorts the input array using bottom-up merge sort.
     *
     * @param array The array to be sorted.
     * @return The resulting sorted array.
     */
    public static int[] mergeSortBottomUp(int[] array) {
        int[] res= new int[array.length];
        for(int i=1;i<array.length;i=i*2){
            for(int j=0;j<array.length;j=j+2*i){
               merge(array,res,j,i);
            }
            int[] temp = res;
            res=array;
            array=temp;
        }
        
        return array;
    }
}
