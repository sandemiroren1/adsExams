package weblab;

import java.util.*;

class Solution {

  /**
   * See the description of the exercise.
   */
  public static MWSTNode getCousin(MultiWaySearchTree tree, MWSTNode node) {
  // TODO
    if(tree==null||node==null){
      return null;
    }
    MWSTNode parent= node.getParent();
    if(parent==null){
      return null;
    }
    MWSTNode grandpa= parent.getParent();
    if(grandpa==null){
      return null;
    }
  
    LinkedList<MWSTNode> list = grandpa.getChildren();
    MWSTNode curr=null;
    MWSTNode returned=null;
    for(MWSTNode e: list){
      if(e==parent){
        break;
      }
      if(e!=null){
        for(MWSTNode b: e.getChildren()){
          if(b!=null){
            curr=e;
            returned=b;
          }
        }
      }
    }
    if(curr==null){
      return null;
    }
    
  
    return returned;
  }

  /**
   * See the description of the exercise.
   */
  public static MWSTNode getUncle(MultiWaySearchTree tree, MWSTNode node) {
    if(tree==null||node==null){
      return null;
    }
    MWSTNode parent= node.getParent();
    if(parent==null){
      return null;
    }
    MWSTNode grandpa= parent.getParent();
    if(grandpa==null){
      return null;
    }
  
    LinkedList<MWSTNode> list = grandpa.getChildren();
    MWSTNode curr=null;
    for(MWSTNode e: list){
      if(e!=null){
        curr=e;
      }
    }
    if(curr==parent){
      return null;
    }
     return curr;

  }

  /**
   * See the description of the exercise.
   */
  public static boolean restrictedSearch(MultiWaySearchTree tree, int key) {
  // TODO
    if(tree==null){
      return false;
    }
    int i=0;
    MWSTNode root= tree.getRoot();
    while(i<root.getKeys().size()&&key>=root.getKeys().get(i)){
        if(key==root.getKeys().get(i)){
          return true;
        }
        i++;
    }
    MWSTNode second = root.getChildren().get(i);
    if(second==null) {
      return false;
    }
    int o=0;
    while(o<second.getKeys().size()&&key>=second.getKeys().get(o)){
      if(key==second.getKeys().get(o)){
          return true;
        }
        o++;
    }
    MWSTNode third = second.getChildren().get(o);
    if(third==null) {
      return false;
    }
    o=0;
    while(o<third.getKeys().size()&&key>=third.getKeys().get(o)){
      if(key==third.getKeys().get(o)){
          return true;
        }
        o++;
    }
    


    return false;
  }
  
}
