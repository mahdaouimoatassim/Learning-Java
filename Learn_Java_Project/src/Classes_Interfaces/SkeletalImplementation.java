/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_Interfaces;

import java.util.Map;

/**
 *
 * @author El Mouatassim Billah
 */
public abstract class SkeletalImplementation<K, V> implements Map.Entry<K, V>{

    // Primitive operations
    public abstract K getKey(int i);

    public abstract V getValue(int i);
// Entries in modifiable maps must override this method

    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }
// Implements the general contract of Map.Entry.equals

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> arg = (Map.Entry) o;
        return equals(getKey(), arg.getKey())
                && equals(getValue(), arg.getValue());
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }
// Implements the general contract of Map.Entry.hashCode

    @Override
    public int hashCode() {
        return hashCode(getKey()) ^ hashCode(getValue());
    }

    private static int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }


}
