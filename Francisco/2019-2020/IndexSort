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
    if(arr == null) return null;
    String[] help = new String[arr.length];
    for (int i = 0; i <arr.length;i++){
      String s = arr[i]; 
      help[i] = s;
    }
    for (int i  = 0; i < help.length;i++){
      for (int y = i; y > 0;y--){
        if(help[y].compareTo(help[y-1])<0)
            swap(help,y,y-1);
        else{
          break;
        }
      }
    }
    int[] result = new int[arr.length];
    for (int i = 0; i < help.length;i++){
      int index = 0;
      for (int y = 0; y<help.length;y++){
        if (help[i].equals(arr[y])){
          index = y;
          break;
        }
      }
      result[i] = index;}
      return result;
  }

  private static void swap(String[] arr, int a, int b){
    String temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
