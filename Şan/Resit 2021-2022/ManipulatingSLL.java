package weblab;

class ADSLinkedList<T> {

    Node<T> head;

    /**
     * Removes every other element from the list.
     */
    public void remove() {
       if(head==null){
           return;
       }
       int i=0;
       Node<T> curr=head;
       Node<T> pre= null;
       while(curr!=null){
           if(i%2!=0){
               pre.setNext(curr.getNext());
           }
           i++;
           pre=curr;
           curr=curr.getNext();
       }
    }

    /**
     * Reverses the list.
     */
    public void reverse() {
        if(head==null){
            return;
        }
    
        Node<T> next=head.getNext();
        Node<T> prev= head;
        while(next!=null){
            prev.setNext(next.getNext());
            next.setNext(head);
            head=next;
            next=prev.getNext();
        }
    }

    /**
     * Rearranges the nodes such that all nodes with even indices end
     * up packed together at the front, and all nodes with odd indices
     * end up packed together at the back.
     *
     * Note: the first node in the list corresponds to index 0,
     * which is considered even.
     */
    public void pack() {
        if(head==null){
            return;
        }
        if(head.getNext()==null){
            return;
        }
        Node<T> even= head;
        Node<T> odd= head.getNext();
        Node<T> curr= odd.getNext();
        Node<T> oddHead= odd;
        int i=2;
        while(curr!=null){
            if(i%2==0){
                even.setNext(curr);
                even=curr;
            }else{
                odd.setNext(curr);
                odd=curr;
            }
            curr=curr.getNext();
            i++;
            
        
        }
        even.setNext(oddHead);
        odd.setNext(null);
        
        
     
    }
}
