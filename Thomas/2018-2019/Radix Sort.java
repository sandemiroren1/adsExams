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

    return bucketSort(words, 0);
  }

  static List<String> bucketSort(List<String> words, int index) {
    if(words.isEmpty())
      return words;

    List<String> results = new ArrayList<>();
    List<String>[] buckets = new List[26];
    for(int i = 0; i < 26; i++)
      buckets[i] = new ArrayList<>();

    for(String word : words) {
      if(word.length() <= index) {
        results.add(word);
        continue;
      }

      buckets[word.charAt(index) - 'a'].add(word);
    }

    for(List<String> bucket : buckets)
      results.addAll(bucketSort(bucket, index + 1));

    return results;
  }

}