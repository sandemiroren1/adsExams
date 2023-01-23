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
    Stack<Graph.Vertex> stack = new Stack<>();
    stack.add(v);
    List<Graph.Vertex> visited = new ArrayList<>();
    int number=1;
    visited.add(v);
    while(!stack.isEmpty()){
      Graph.Vertex curr= stack.pop();
      for(Graph.Vertex e: g.getNeighbours(curr)){
        if(!visited.contains(e)){
          stack.add(e);
          visited.add(e);
          number++;
        }
      }
    }
    return number;
  }

}