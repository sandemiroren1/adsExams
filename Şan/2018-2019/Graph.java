import java.util.*;

class Solution {
  /**
   * Counts the number of vertices in the same connected component as v in graph g.
   * This is done using depth first search.
   *
   * Returns 0 if the graph or vertex is null
   *
   * @param g
   *     The graph to count vertices in.
   * @param v
   *     The vertex to start counting at.
   * @return the number of vertices in the same connected component.
   */
  public static int countVertices(Graph g, Graph.Vertex v) {
    if(g==null||v==null){
      return 0;
    }
    
    return helper(g,v,new ArrayList<>());
  }
  public static int helper(Graph g, Graph.Vertex v,List<Graph.Vertex> list){
    if(v==null){
      return 0;
    }
    list.add(v);
    int returned=1;
    for(Graph.Vertex e: g.getNeighbours(v)){
      if(!list.contains(e)){
        returned+=helper(g,e,list);
      }
    }
    return returned;
  }
}
