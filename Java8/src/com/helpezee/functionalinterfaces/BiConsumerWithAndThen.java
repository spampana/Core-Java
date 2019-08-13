package com.helpezee.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerWithAndThen {
    public static void main(String args[]) 
    { 
  
        // Create first list 
        List<Integer> lista = new ArrayList<Integer>(); 
        lista.add(2); 
        lista.add(1); 
        lista.add(3); 
  
        // Create second list 
        List<Integer> listb = new ArrayList<Integer>(); 
        listb.add(2); 
        listb.add(1); 
        listb.add(2); 
  
        // BiConsumer to compare 2 lists of integers 
        BiConsumer<List<Integer>, List<Integer> > equals = (list1, list2) -> 
        { 
            if (list1.size() != list2.size()) { 
                System.out.println("False"); 
            } 
            else { 
                for (int i = 0; i < list1.size(); i++) 
                    if (list1.get(i) != list2.get(i)) { 
                        System.out.println("False"); 
                        return; 
                    } 
                System.out.println("True"); 
            } 
        }; 
  
        // BiConsumer to print 2 lists 
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) -> 
        { 
            list1.stream().forEach(a -> System.out.print(a + " ")); 
            System.out.println(); 
            list2.stream().forEach(a -> System.out.print(a + " ")); 
            System.out.println(); 
        }; 
  
        // Using addThen() method 
        equals.andThen(disp).accept(lista, listb);
}
}
