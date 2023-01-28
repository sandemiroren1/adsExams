package weblab;

import java.util.*;

class Street {

    // Use the fields below to store the heads and tails of the even and odd side of the street
    // Do NOT change the names of the fields or how they are initialised in the constructor!
    // You may NOT add more fields to the class.
    Node headEven;

    Node tailEven;

    Node headOdd;

    Node tailOdd;

    /**
     * Make an empty street.
     */
    public Street() {
        headEven = new Node();
        tailEven = new Node();
        headEven.setNext(tailEven);
        tailEven.setPrev(headEven);
        headOdd = new Node();
        tailOdd = new Node();
        headOdd.setNext(tailOdd);
        tailOdd.setPrev(headOdd);
    }

    /**
     * Removes a house from the street.
     * If the house does not exist, the street should be unchanged and the method should return null.
     *
     * This method must run in O(n + m) time.
     * Here is n the number of even houses, and m the number of odd houses.
     *
     * @param houseNumber number of the house to be removed from this street, if present
     * @return if present, the removed house, otherwise null
     */
    public House removeHouse(int houseNumber) {
        if(houseNumber<0){
            return null;
        }
        if(houseNumber%2==0){
            Node curr= headEven.getNext();
            while(curr!=tailEven&&curr.getHouse().getHouseNumber()!=houseNumber){
                curr=curr.getNext();
            }
            if(curr==tailEven){
                return null;
            }
            Node odd= headOdd;
            while(odd!=tailOdd){
                if(odd.getOpposingHouses().contains(curr.getHouse())){
                    odd.getOpposingHouses().remove(curr.getHouse());
                    
                }
                odd=odd.getNext();
            }
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
            return curr.getHouse();
        }else{
            Node curr= headOdd.getNext();
            while(curr!=tailOdd&&curr.getHouse().getHouseNumber()!=houseNumber){
                curr=curr.getNext();
            }
            if(curr==tailOdd){
                return null;
            }
            Node even= headEven;
            while(even!=tailEven){
                if(even.getOpposingHouses().contains(curr.getHouse())){
                    even.getOpposingHouses().remove(curr.getHouse());
                    
                }
                even=even.getNext();
            }
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
            return curr.getHouse();
        }
    }

    /**
     * Puts all the houses in the street in a list in increasing order of house number.
     *
     * This method must run in O(n+m) time.
     * Here n is the number of even houses, and m is the number of odd houses.
     *
     * @return a list of all the houses in the street in increasing order of house number
     */
    public List<House> collectAllHouses() {
        Node even=headEven.getNext();
        Node odd= headOdd.getNext();
        List<House> list = new ArrayList<>();
        while(even!=tailEven||odd!=tailOdd){
            if(odd==tailOdd||
            even!=tailEven&&even.getHouse().getHouseNumber()<odd.getHouse().getHouseNumber()){
                list.add(even.getHouse());
                even=even.getNext();
            }else{
                list.add(odd.getHouse());
                odd=odd.getNext();
            }
        }
        return list;
    }

    /**
     * Gets the number of even numbered houses in the street.
     *
     * @return the number of houses with an even house number
     */
    public int getNumEven() {
        Node curr=headEven.getNext();
        int res=0;
        while(curr!=tailEven){
            res++;
            curr=curr.getNext();
        }
        return res;
    }
}
