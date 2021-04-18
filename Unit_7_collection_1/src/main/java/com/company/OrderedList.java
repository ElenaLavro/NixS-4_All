package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public interface OrderedList<E> {
    boolean add(E e);

    boolean addAll(OrderedList<E> e);

    public void clear();

    public boolean contains(Object o);

    public Object get(int index);

    public int indexOf(Object o);

    public int lastIndexOf(Object o);

    Iterator<E> iterator();

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    boolean remove(Object o);

    boolean removeAll(OrderedList<E> l);

    boolean retainAll(OrderedList<E> l);

    public Object[] toArray();

    public int size();

    public boolean isEmpty();

    public String toString();
}
