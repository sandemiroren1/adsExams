package weblab;

import java.util.*;

class Solution {

  /**
   * @param village Adjacency map representing the village.
   * @param coatiHouses The IDs of the coati houses that should be connected.
   * @return The roads on which the traps should be dismantled.
   */
  public static Set<Road> regroupTheCoatis(List<Map<Integer, Integer>> village, Set<Integer> coatiHouses) {
    if(village==null){
      return null;
    }
    if(village.size()==0){
      return new HashSet<Road>();
    }
    UnionFind uF= new UnionFind(village.size());
    Set<Road> roads= new HashSet<>();
    int connected=0;
    PriorityQueue<Road> pq= new PriorityQueue<Road>();
    for(int i=0;i!=village.size();i++){
      if(coatiHouses.contains(i)){
        for(int e: village.get(i).keySet()){
          if(coatiHouses.contains(e)){
            pq.add(new Road(i,e,village.get(i).get(e)));
          }
        }
      }
      
    }

    while(!pq.isEmpty()){
      Road temp = pq.poll();
      if(uF.union(temp.getFrom(),temp.getTo())){
        roads.add(temp);
        connected++;
      }
      
    }
  
   if(connected!=coatiHouses.size()-1){
     return null;
   }
    
    return roads;
  }
}
