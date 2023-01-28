package weblab;

import java.util.*;

public class Solution {

    /**
     * Returns the indices of the vertices in G in topological order, as far as possible.
     * @param g Graph to form a topological order of.
     * @return List of IDs of vertices in G in topological order.
     */
    public static List<Integer> topoOrder(Graph g) {
        Map<Vertex,Integer> map= new HashMap<>();
        Queue<Vertex> que= new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(Vertex e: g.getAllVertices()){
            map.put(e,e.getIncomingNeighbours().size());
            if(e.getIncomingNeighbours().size()==0){
                que.add(e);
            }
        }
        while(!que.isEmpty()){
            Vertex temp= que.poll();
            list.add(temp.getId());
            for(Vertex e:temp.getOutgoingNeighbours()){
                map.replace(e,map.get(e)-1);
                if(map.get(e)<=0){
                    que.add(e);
                }
            }
        }
        return list;
        
    }
    
}
