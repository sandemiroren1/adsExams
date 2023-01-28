package weblab;

import java.util.*;

class Heap extends LibraryHeap {

    public Heap() {
        super();
    }


    /**
     * Constructor of the heap.
     *
     * @param key
     *     the key value for the root.
     */
    public Heap(int key) {
        super(key);
    }

    /**
     * Performs the downheap operation starting from the specified node in O(log n).
     *
     * @param node
     *     the node where the downheap starts.
     */
    @Override
    public void downHeap(TreeNode node) {
        if(node==null){
            return;
        }
        
        TreeNode min= node;
        if(node.hasLeft()&&node.getLeft().getKey()<min.getKey()){
            min=node.getLeft();
        }
        if(node.hasRight()&&node.getRight().getKey()<min.getKey()){
            min=node.getRight();
        }
        if(min==node){
            return;
        }
        int temp= node.getKey();
        node.setKey(min.getKey());
        min.setKey(temp);
        downHeap(min);
    }

    /**
     * Performs the upheap operation starting from the specified node in O(log n).
     *
     * @param node
     *     the node where the upheap starts.
     */
    @Override
    public void upHeap(TreeNode node) {
        if(node==null||!node.hasParent()){
            return;
        }
        if(node.getKey()<node.getParent().getKey()){
            swap(node,node.getParent());
            upHeap(node.getParent());
        }

    }

    /**
     * Turns a TreeNode into a LibraryHeap in O(n).
     * This is an in-place algorithm, the heap is built on the TreeNode node itself.
     *
     * @param node
     *     to be turned into a Heap.
     * @return Heap containing the elements of node.
     */
    @Override
    public Heap heapify(TreeNode node) {
        if(node==null){
            return null;
        }
        Heap res= new Heap();

        res.root=node;
        heapification(res,node);
        return res;
    }
    public void heapification(Heap res,TreeNode node){
        if(node==null){
            return;
        }
        heapification(res,node.getRight());
        heapification(res,node.getLeft());
        downHeap(node);
        res.size++;
        
    }

    /**
     * Does a breadth-first traversal of the heap and returns a list
     * of all nodes in the order that they are found in O(n).
     *
     * @return List of heap elements in BFS order.
     */
    @Override
    public List<Integer> bfs() {
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            TreeNode temp= que.poll();
            list.add(temp.getKey());
            if(temp.hasLeft()){
                que.add(temp.getLeft());
            }
            if(temp.hasRight()){
                que.add(temp.getRight());
            }
        }
        return list;
    }
}
