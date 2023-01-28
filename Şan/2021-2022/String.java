package weblab;

import java.util.*;

public class Solution {

    /**
     * Counts the number of occurrences of substring of length k in string s.
     *
     * @param s
     *     The String in which to look for substrings.
     * @param k
     *     The length of the substrings to look for.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note: There should be no entries in the map for substrings that do not occur in string s.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s, int k) {
        if(s==null||k<=0||k>s.length()){
            return new HashMap<>();
        }
        Map<String,Integer> map = new HashMap<>();
        int i=0;
        while(i+k<=s.length()){
            String temp= s.substring(i,i+k);
            if(map.containsKey(temp)){
                int l= map.get(temp);
                map.remove(temp);
                map.put(temp,l+1);
            }else{
                map.put(temp,1);
            }
            i++;
        }
        return map;
    }


    /**
     * Counts the occurrences of substrings (of **all lengths**) in a given string s.
     * Should make use of the method countSubstringOccurrences(String s, int k).
     *
     * @param s
     *     The String in which to look for substrings.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note 1: There should be no entries in the map for substrings that do not occur in string s.
     * Note 2: When iterating through the returned map, the substrings should be found in increasing order of their length.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s) {
    
        Map<String,Integer> map = new LinkedHashMap<>();
        for(int i=1;i!=s.length()+1;i++){
            Map<String,Integer> temp = countSubstringOccurrences(s,i);
            for(String e: temp.keySet()){
                map.put(e,temp.get(e));
            }
        }
        
        return map;
    }

    /**
     * Simplifies a given map of substrings and their occurrences by removing substrings that do not repeat.
     * Must be implemented in-place.
     *
     * @param substringsMap
     *     The map from which substrings that do not repeat (occur only once) are to be removed.
     */
    public static void repeatedSubstrings(Map<String, Integer> substringsMap) {
        Iterator it= substringsMap.keySet().iterator();
        while(it.hasNext()){
            String temp= (String)it.next();
            if(substringsMap.get(temp)==1){
                it.remove();
            }
        }
        
    }
}
