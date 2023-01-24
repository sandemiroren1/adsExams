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
    if(words == null)
      throw new NullPointerException();
    return sortByChar(words, 0);
  }

  public static List<String> sortByChar(List<String> words, int pos) {
    if(words.size() < 2)
      return words;
    ArrayList<ArrayList<String>> buckets = new  ArrayList<>();
    for(int i=0;i<26;i++)
      buckets.add(new ArrayList<>());
    List<String> res = new ArrayList<>();
    for(String word : words) {
      if(pos < word.length()) {
        int bucketIdx = word.charAt(pos) -'a';
        buckets.get(bucketIdx).add(word);
      }
      else
      res.add(word);
      
    }
    
    for(int i=0;i<26;i++) {
      res.addAll(sortByChar(buckets.get(i), pos+1));
    }

    return res;

  }


}
