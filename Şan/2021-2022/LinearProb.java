package weblab;

class SolutionHashTable extends HashTable {

    /**
     * Constructs a new HashTable.
     * Do NOT change this method.
     */
    public SolutionHashTable(int capacity) {
        super(capacity);
    }

    /**
     * Remove the entry associated with this key from the hash table.
     *
     * Returns false if the key is null.
     *
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     */
    public boolean remove(String key) {
        if(key==null){
            return false;
        }
        int hashed= hash(key);
        int i=0;
        while(table[hashed]!=null&&!key.equals(table[hashed].getKey())){
            hashed=(hashed+1)%capacity;
            i++;
        }
        if(i==capacity||table[hashed]==null){
            return false;
        }
        setDefunct(hashed);
        return true;
    }
}
