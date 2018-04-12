/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurency;
import java.util.*;
import Classes_Interfaces.ForwardingSet;
import java.util.concurrent.CopyOnWriteArrayList;
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
    
    private final List<SetObserver<E>> observers2 = new CopyOnWriteArrayList<SetObserver<E>>();

/**
 * 
 *   Implementation des méthodes à la base de la synchronization implémenté au niveau de chaque classe.
 * 
    */
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
    
    /**
 * 
 *   Implementation des méthodes à la base de l'utilisation de la liste synchronisé qui appartient
 *   au package Concurent.
 * 
    */
    
    public void addObserver2(SetObserver<E> observer) {
        observers2.add(observer);
    }

    public boolean removeObserver2(SetObserver<E> observer) {
        return observers2.remove(observer);
    }

    private void notifyElementAdded2(E element) {
        for (SetObserver<E> observer : observers2) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded2(element);
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
        set.addObserver2(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) s.removeObserver2(this);
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
