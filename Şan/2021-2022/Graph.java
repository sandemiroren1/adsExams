package weblab;

import java.util.*;

class GraphChecker {

    /**
     * Traverses the given graph depth first and returns the IDs of visited vertices in order, starting from the given vertex.
     * In case multiple choices are possible for a next vertex, they are visited in increasing order of ID.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to traverse.
     * @param v Vertex to start the traversal from.
     * @return List of IDs of vertices found using DFS traversal.
     */
    public List<Integer> traverseDepthFirst(Graph g, Vertex v) {
        if(g==null||v==null){
            return new ArrayList<>();
        }
        Stack<Vertex> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        HashSet<Vertex> colored = new HashSet<>();
        stack.add(v);
        while(!stack.isEmpty()){
            Vertex temp = stack.pop();
            if(colored.contains(temp)){
                continue;
            }
            
            colored.add(temp);
            res.add(temp.getId());
            for(int i=temp.getNeighbours().size()-1;i!=-1;i--){
                stack.add(temp.getNeighbours().get(i));
            }
        }
        return res;
    }

    /**
     * Returns the transpose of the given graph, i.e. a graph with all edges reversed.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to create the transpose of.
     * @return Transpose of the given graph.
     */
    public Graph transpose(Graph g) {
        if(g==null){
            return new Graph();
        }
        Graph res = new Graph();

        for(Vertex e: g.getAllVertices()){
            Vertex temp = new Vertex(e.getId());
            res.addVertex(temp);   
        }
        for(Vertex e: g.getAllVertices()){
            for(Vertex neigh: e.getNeighbours()){
                res.addEdge(res.getVertex(neigh.getId()),res.getVertex(e.getId()));
            }
        }
        return res;
        
        
    }

    /**
     * Returns true if the given graph is strongly connected, false otherwise.
     * Runs in O(V+E) time. Does not modify the input graph.
     * @param g Graph to check for strong connectedness.
     * @return True if the graph is strongly connected, false otherwise.
     */
    public boolean isStronglyConnected(Graph g) {
        if(g==null){
            return false;
        }
        Graph trans= transpose(g);
        List<Integer> org= traverseDepthFirst(g,g.getAllVertices().get(0));
        List<Integer> transDepth= traverseDepthFirst(trans,trans.getVertex(g.getAllVertices().get(0).getId()));
        return org.size()==transDepth.size()&&org.size()==g.getAllVertices().size();
    }
}
