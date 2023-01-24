package weblab;

import java.util.*;

class MultiMap {

  private Map<Integer, List<Integer>> map;
  private int size;
  /**
   * Creates a new MultiMap.
   */
  public MultiMap() {
      this.map = new HashMap<>();
      this.size = 0;
  }

  /**
   * @return The number of (key, value) pairs in the MultiMap.
   */
  public int size() {
    return size;
  }

  /**
   * @return True if the MultiMap is empty, false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  // TODO
  }

  /**
   * Adds the given (key, value) pair to the MultiMap.
   *
   * @param key Key for the new item.
   * @param value New item to add to the MultiMap.
   */
  public void put(int key, int value) {
    if (map.get(key) == null){
      map.put(key, new ArrayList<Integer>());
    }
      map.get(key).add(value);
      size++;
  }

  /**
   * Returns all values in the MultiMap for the given key.
   *
   * @param key Key to return all entries for.
   * @return A list of all entries for the given key.
   *         If the key is not in the map, return an empty list.
   */
  public List<Integer> get(int key) {
    if (map.get(key)==null) return new ArrayList<Integer>();
    return map.get(key);
  }

  /**
   * Removes the given (key, value) pair from the MultiMap.
   *
   * @param key Key for the value that should be removed.
   * @param value Value to remove.
   * @return True if removal was successful, false otherwise.
   */
  public boolean remove(int key, int value) {
   if (map.get(key)==null) return false;
   if (!map.get(key).contains(value)) return false;
   for (int i = 0; i< map.get(key).size(); i++){
     if (map.get(key).get(i)==value){
       map.get(key).remove(i);
       break;
     }
   }
   
   
   size--;
   if (map.get(key).size()==0){
     map.remove(key);
   }
   return true;
  }
}
