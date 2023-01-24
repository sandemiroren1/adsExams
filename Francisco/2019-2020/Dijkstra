package weblab;

import java.util.*;

class Solution {

  /**
   * Returns the length of the shortest path between vertex a and b in graph g.
   * @param g Graph to consider.
   * @param a Vertex to start from.
   * @param b Vertex to go to.
   * @return The length of the shortest path between a and b, or -1 if no such path exists.
   */
  public static int shortestPath(Graph g, Vertex a, Vertex b) {
          AdaptablePQ pq = new AdaptablePQ();
          Map<Vertex,Vertex> daddy = new HashMap<>();
          Map<Vertex,Integer> tokens= new HashMap<>();
          for (Vertex v : g.getAllVertices()){
            if (v == a){
              daddy.put(v,null);
              tokens.put(v,0);
              pq.insertOrReplace(v,0);
            }
            else{
              daddy.put(a,null);
              tokens.put(v,Integer.MAX_VALUE);
              pq.insertOrReplace(v,Integer.MAX_VALUE);
            }
          }
          while (!pq.isEmpty()){
            VertexNumPair v = pq.removeMin();
            int distance = v.getNum();
            List<VertexNumPair> neighbours = (List) v.getVertex().getNeighbours();
            for (VertexNumPair n : neighbours){
              if (n.getNum()+distance < tokens.get(n.getVertex())){
                tokens.replace(n.getVertex(),n.getNum()+distance);
                daddy.replace(n.getVertex(),v.getVertex());
                pq.insertOrReplace(n.getVertex(),n.getNum()+distance);
              }
            }
          }

          if (tokens.get(b)==Integer.MAX_VALUE) return -1;
          return tokens.get(b);

  }
}
