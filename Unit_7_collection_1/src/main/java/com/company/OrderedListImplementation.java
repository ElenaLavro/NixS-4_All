package com.company;

import java.util.*;

public class OrderedListImplementation<E extends Comparable<E>> implements OrderedList<E> {
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    protected transient int modCount = 0;
    private E[] elementData;

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
    public OrderedListImplementation(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity" + initialCapacity);
        this.elementData = (E[]) new Comparable[initialCapacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public boolean addAll(OrderedList<E> e) {
        Object[] a = e.toArray();
        int newNum = a.length;
        ensureCapacity(size + newNum);
        System.arraycopy(a, 0, elementData, size, newNum);
        size += newNum;
        return newNum != 0;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length && !(minCapacity <= DEFAULT_CAPACITY))
            modCount++;
        grow(minCapacity);
    }

    public static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    private Object[] grow() {
        return grow(size + 1);
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0) {
            int newCapacity = newLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = (E[]) new Comparable[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int newLength = Math.max(minGrowth, prefGrowth) + oldLength;
        if (newLength - MAX_ARRAY_LENGTH <= 0)
            return newLength;
        return hugeLength(oldLength, minGrowth);
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new OutOfMemoryError("Array length too large");
        }
        if (minLength <= MAX_ARRAY_LENGTH) {
            return MAX_ARRAY_LENGTH;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean add(E e) {
        if(modCount == 0) {
            elementData[modCount] = e;
            modCount += 1;
            return true;
        }
        if(modCount >= elementData.length) {
            E[] secondData = (E[]) new Comparable[elementData.length +5];
            System.arraycopy(elementData,0, secondData,0,elementData.length);
            elementData = secondData;
        }
        for (int i = 0; i <modCount; i++) {
            if(elementData[i].compareTo(e) >=0) {
                System.arraycopy(elementData, i, elementData,i+1, modCount-i);
                elementData[i] = e;
                modCount++;
                return true;
            }

        }
        if (size == elementData.length)
            resize(size * 2);
        elementData[size++] = e;
        sortList();
        if(size != 1)
            sortList();
        return true;
//        elementData[modCount] = e;
//        modCount +=1;
//        return true;
    }

    private void resize(int newLength) {
        E[] newList = (E[]) new Comparable[newLength];
        System.arraycopy(elementData, 0, newList, 0, size);
        elementData = newList;
    }

    private void sortList() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (elementData[j].compareTo(elementData[j + 1]) > 0) {
                    E cur = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = cur;
                }
            }
        }
    }

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;

    }


    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i]))
                    return i;

            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int lastRet = -1;
        int expectedModCount = modCount;

        Itr() {
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException(e);
            }
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                OrderedListImplementation.this.remove(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }

        }
    }


    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            int i = cursor - 1;
            if (i < 0) {
                throw new NoSuchElementException();
            }
            Object[] elementData = OrderedListImplementation.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void set(E e) {
            throw new ConcurrentModificationException();
        }

        @Override
        public void add(E e) {
            try {
                int i = cursor;
                OrderedListImplementation.this.add((E) e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return false;
    }

    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public boolean removeAll(OrderedList l) {
        return batchRemove(l, false);
    }

    private boolean batchRemove(OrderedList<?> c, boolean complement) {
        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modifier = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                for (int i = w; i < size; i++) {
                    elementData[i] = null;
                }
                modCount += size - w;
                size = w;
                modifier = true;
            }
        }
        return modifier;
    }

    @Override
    public boolean retainAll(OrderedList l) {
        return batchRemove(l, true);
    }


    @Override
    public Object[] toArray() {
        E[] elementsData = (E[]) new Comparable[modCount];
        if (size() >= 0)
            System.arraycopy(elementData, 0, elementsData, 0, size());
        return elementsData;
    }


}
