//Here I get 16/100 spec but pass all tests

import java.util.*;

class Solution {

  /**
   * Sorts a list of words using MSD radix sort.
   *
   * @param words
   *     The list of words to sort.
   * @return The sorted list of words.
   * @throws NullPointerException
   *     If `words` equals `null`.
   */
  static List<String> radixSortMSD(List<String> words) {
    if (words == null) throw new NullPointerException();
    return MSD(words,0);
  }

  private static int index(String s, int index){
    return s.charAt(index)-'a';
  }

  private static List<String> MSD(List<String> words,int index){
    if (words.size()<2) return words;
    List<List<String>> buckets = new ArrayList<>();
    int i = 0;
    while (i<26){
      buckets.add(new ArrayList<String>());
      i++;
    }
    for(String w : words){
      if(index>w.length()){
        // Should be added to the result instead of a bucket(bucket 0 might also be fine, but not keep sorting it on the last index)
        // Current if you have ["catb", "cat", "cata"] the output will become ["cata", "catb", "cat"]
        buckets.get(index(w,w.length())).add(w);
      }
      else{
        buckets.get(index(w,index)).add(w);
      }
    }
    for(List<String> l : buckets){
      MSD(l,index+1);
    }

    List<String> result = new ArrayList<>();
    for(List<String> l : buckets){
      // Instead of this you can also use result.addAll which will do exactly this, but looks cleaner
      for (String w : l){
        result.add(w);
      }
    }
    return result;
  }

}