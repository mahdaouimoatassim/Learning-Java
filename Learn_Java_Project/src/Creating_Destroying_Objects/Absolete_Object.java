/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creating_Destroying_Objects;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author El Mouatassim Billah
 */
public class Absolete_Object implements Cloneable {

    public Object[] Humains;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Absolete_Object() {
        Humains = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        Humains[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = Humains[--size];
        Humains[size] = null;
        return result;

    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (Humains.length == size) {
            Humains = Arrays.copyOf(Humains, 2 * size + 1);
        }
    }

    @Override
    public Absolete_Object clone() {
        try {
            Absolete_Object result = (Absolete_Object) super.clone();
            result.Humains = Humains.clone();
            return result;
//        return (Absolete_Object) super.clone(); 

            
         /*  
            
             @Override public HashTable clone() {
             try {
             HashTable result = (HashTable) super.clone();
             result.buckets = new Entry[buckets.length];
             for (int i = 0; i < buckets.length; i++)
             if (buckets[i] != null)
             result.buckets[i] = buckets[i].deepCopy();
             return result;
             } catch (CloneNotSupportedException e) {
             throw new AssertionError();
             }
             }
           */ 
            
        } catch (CloneNotSupportedException cc) {
            throw new AssertionError();
        }

    }
}
