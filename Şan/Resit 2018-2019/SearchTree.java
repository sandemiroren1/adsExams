import java.util.*;
class Solution {
  /**
   * Given a Binary Search Tree and an Integer, returns the Entry in this tree
   * with the smallest key that is strictly larger than k.
   *
   * @param tree
   *     Binary search tree to search in.
   * @param k
   *     The key of the resulting entry should be strictly larger than this k.
   * @return The entry with smallest key, strictly larger than k.
   */
  static Entry higherEntry(BinarySearchTree tree, int k) {
    if(tree==null){
      return null;
    }
    List<BinarySearchTree> list = inorder(tree,new ArrayList<>());
    for(BinarySearchTree e:list){
      if(e.getKey()>k){
        return e.getEntry();
      }
    }
    return null;
  }
  static List<BinarySearchTree> inorder(BinarySearchTree tree,List<BinarySearchTree> list){
    if(tree==null){
      return list;
    }
    list=inorder(tree.getLeft(),list);
    list.add(tree);
    list=inorder(tree.getRight(),list);
    return list;
  }
}
