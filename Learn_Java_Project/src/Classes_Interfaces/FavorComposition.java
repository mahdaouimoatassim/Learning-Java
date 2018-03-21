/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

import java.util.HashSet;
import java.util.*;
/**
 *
 * @author El Mouatassim Billah
 */
public class FavorComposition<E> extends ForwardingSet<E>{
    
    private int addCounttrue = 0;

    public FavorComposition(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCounttrue++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCounttrue += c.size();
        return super.addAll(c);       
    }

    public int getAddCount() {
        return addCounttrue;
    }
    
}
