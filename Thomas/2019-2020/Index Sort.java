package weblab;

class Solution {

    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     *
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        if(arr == null)
            return null;

        int[] input = new int[arr.length];
        for(int i = 0; i < input.length; i++)
            input[i] = i;

        for(int i = 1; i < input.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[input[j - 1]].compareTo(arr[input[j]]) <= 0)
                    break;

                swap(input, j, j - 1);
            }
        }

        return input;
    }

    /**
     * Swap values
     *
     * @param arr array to swap values for
     * @param a first index
     * @param b second index
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}