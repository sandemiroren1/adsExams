package weblab;

import java.util.*;

class MultiMap {

    private Map<Integer, List<Integer>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        this.map = new HashMap<>();
    }

    /**
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        int amount = 0;
        for(List<Integer> list : map.values())
            amount += list.size();

        return amount;
    }

    /**
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        return Optional.ofNullable(map.get(key)).orElse(new ArrayList<>());
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        if(!map.containsKey(key))
            return false;

        List<Integer> list = map.get(key);
        boolean b = list.remove((Object) value);
        if(list.isEmpty())
            map.remove(key);

        return b;
    }

}