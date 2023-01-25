package weblab;


import java.util.*;

class Solution {

  /**
   * Sorts the list of student IDs as defined in the description.
   * @param studentIds - list of student IDs
   * @return sorted list of student IDs
   */
  static List<String> sortStudentId(List<String> studentIds) {   
    if(studentIds==null){
      return null;
    }           
    for(int i=5;i!=-1;i--){
      studentIds= bucketSort(studentIds,i);
    }
    return studentIds;
  }
  static List<String> bucketSort(List<String> studentIds,int index){
    List<List<String>> buckets = new ArrayList<>();
    if(index==1||index==3){
      
      for(int i=0;i!=10;i++){
        buckets.add(new ArrayList<>());
      }
      for(String e: studentIds){
        System.out.println((int)e.charAt(index)-(int)'0');
        buckets.get(-(int)e.charAt(index)+(int)'9').add(e);
      }
    }else{
      for(int i=0;i!=26;i++){
        buckets.add(new ArrayList<>());
      }
      for(String e: studentIds){
        
        buckets.get(-(int)e.charAt(index)+(int)'Z').add(e);
      }
    }
    List<String> res= new ArrayList<>();
    for(List<String> e:buckets){
      res.addAll(e);
    }
    return res;
  }
}
