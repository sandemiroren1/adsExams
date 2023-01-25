package weblab;

class CoatiList {

  private CoatiNode head;

  private CoatiNode tail;

  int size=0;
  public CoatiNode getHead() {
    return head;
  }

  public CoatiNode getTail() {
    return tail;
  }

  /**
   * Adds value v in a new node to the head of the list.
   *
   * @param v Value to add.
   */
  public void addFirst(int v) {
    size++;
    if(head==null){
      head= new CoatiNode(v);
      tail=head;
      return;
    }
    CoatiNode node= new CoatiNode(v,null,head);
    head.setPrevious(node);
    head=node;
    CoatiNode curr= node;
    int i=0;
    System.out.println("");
    while(curr!=null&&i<3){
        System.out.println(curr.getValue());
        curr=curr.getNext();
        i++;
    }
    if(curr==null){
      return;
    }
  
    node.setSkipAhead(curr);
    curr.setSkipBack(node);

  }

  /**
   * Remove the first node in the list and return its value.
   *
   * @return The value of the head node.
   * @throws EmptyListException If the list is empty.
   */
  public int removeFirst() {
    if(head==null){
      throw new EmptyListException();
    }
    size--;
    int res=head.getValue();
    if(head==tail){
      head=null;
      tail=null;
      return res;
    }
    CoatiNode curr= head;
    head=head.getNext();
    head.setPrevious(null);
    int i=0;
    while(curr!=null&&i<3){
        curr=curr.getNext();
        i++;
    }
    if(curr==null){
      return res;
    }
    
    
    curr.setSkipBack(null);
    return res;
  }

  /**
   * Returns the value of node at the given position.
   * @param pos Position to look for.
   * @return The value of the node at the given position.
   * @throws IllegalIndexException If there is no node at this index.
   */
  public int getValueAtPosition(int pos) {
    if(pos<0){
      throw new IllegalIndexException();
    }
    
    CoatiNode curr= head;
    int i=0;
    while(curr!=null&&i+3<=pos){
      curr=curr.getSkipAhead();
      i=i+3;
    }
    int o=i;
    while(curr!=null&&o<pos){
      curr=curr.getNext();
      o++;
    }
    if(curr==null){
      throw new IllegalIndexException();
    }
    return curr.getValue();
  }
}
