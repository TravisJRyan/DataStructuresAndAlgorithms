/*
    8.4 Power Set - Write a method to return all subsets of a set
*/

import java.util.ArrayList;

public class PowerSet{
    public static void main(String[] args){
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(3);
        set.add(12);
        set.add(9);
        set.add(49);
        set.add(43);
        set.add(32);
        set.add(25);
        set.add(8);
        ArrayList<ArrayList<Integer>> superSet = getSuperSet(set);
        for(ArrayList<Integer> subset : superSet)
            System.out.println(subset.toString()); // prints the enter superset
    }

    // To build the super set, take all sets currently in the array, clone them, and add new element
    // Repeat until super set is complete
    // O(N^2) time, can't be improved upon
    public static ArrayList<ArrayList<Integer>> getSuperSet(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> superSet = new ArrayList<ArrayList<Integer>>();
        superSet.add(new ArrayList<Integer>()); // add null set
        for(int newElement : set){ // for each element provided
            ArrayList<ArrayList<Integer>> copies = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> existingSet: superSet){ // for each existing set already added to the superset
                ArrayList<Integer> copy = new ArrayList<Integer>();
                for(int existingElement : existingSet)
                    copy.add(existingElement);
                copy.add(newElement);
                copies.add(copy);
            }
            for(ArrayList<Integer> copy : copies)
                superSet.add(copy);
        }
        
        return superSet;
    }

    


}