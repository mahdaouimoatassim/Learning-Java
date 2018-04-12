/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;
import java.util.*;
import Classes_Interfaces.ForwardingSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author El Mouatassim Billah
 */
public class ObservableSet <E> extends ForwardingSet<E>{
    
  public  ObservableSet(Set<E> set)
  {
  super(set);
  }
    
    private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
     /*   synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }*/
        
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<SetObserver<E>>(observers);
        }
        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
    }
    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result = add(element); // calls notifyElementAdded
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        ObservableSet<Integer> set
                = new ObservableSet<Integer>(new HashSet<Integer>());
        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) s.removeObserver(this);
            /*    if (e == 23) {
                ExecutorService executor
                        = Executors.newSingleThreadExecutor();
                final SetObserver<Integer> observer = this;
                try {
                    executor.submit(new Runnable() {
                        public void run() {
                            s.removeObserver(observer);
                        }
                    }).get();
                } catch (ExecutionException ex) {
                    throw new AssertionError(ex.getCause());
                } catch (InterruptedException ex) {
                    throw new AssertionError(ex.getCause());
                } finally {
                    executor.shutdown();
                }
                }*/
            }
        });
        for (int i = 0; i < 100; i++) {
            set.addAll(Arrays.asList(i,i+100,i+200));
        }
    }
    
    
}
