package ru.mail.polis.collections.list.todo;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDequeFull<E> extends ArrayDequeSimple<E> implements Deque<E> {

    /**
     * Inserts the specified element at the end of this deque unless it would
     * violate capacity restrictions.  When using a capacity-restricted deque,
     * this method is generally preferable to the {@link #addLast} method,
     * which can fail to insert an element only by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }


    /**
     * Inserts the specified element at the end of this deque unless it would
     * violate capacity restrictions.  When using a capacity-restricted deque,
     * this method is generally preferable to the {@link #addLast} method,
     * which can fail to insert an element only by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * Retrieves and removes the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollFirst() {
        if (!isEmpty()){
            return removeFirst();
        } else {
            return null;
        }
    }

    /**
     * Retrieves and removes the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E pollLast() {
        if (!isEmpty()){
            return removeLast();
        } else {
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekFirst() {
        if (!isEmpty()){
            return getFirst();
        } else {
            return null;
        }
    }

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque, or {@code null} if this deque is empty
     */
    @Override
    public E peekLast() {
        if (!isEmpty()){
            return getLast();
        } else {
            return null;
        }
    }

    /**
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * {@code Objects.equals(o, e)} (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (o == null){
            throw new NullPointerException();
        }
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()){
            if (o.equals(iterator.next())){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the last occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the last element {@code e} such that
     * {@code Objects.equals(o, e)} (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null){
            throw new NullPointerException();
        }
        Iterator<E> descendingIterator = descendingIterator();
        while (descendingIterator.hasNext()){
            if (o.equals(descendingIterator.next())){
                descendingIterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Inserts the specified element into the queue represented by this deque
     * (in other words, at the tail of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * Inserts the specified element into the queue represented by this deque
     * (in other words, at the tail of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and {@code false} if no space is currently
     * available.  When using a capacity-restricted deque, this method is
     * generally preferable to the {@link #add} method, which can fail to
     * insert an element only by throwing an exception.
     *
     * <p>This method is equivalent to {@link #offerLast}.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this deque, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque).
     * This method differs from {@link #poll() poll()} only in that it
     * throws an exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E remove() {
        return removeFirst();
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns
     * {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #pollFirst()}.
     *
     * @return the first element of this deque, or {@code null} if
     *         this deque is empty
     */
    @Override
    public E poll() {
        return pollFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque).
     * This method differs from {@link #peek peek} only in that it throws an
     * exception if this deque is empty.
     *
     * <p>This method is equivalent to {@link #getFirst()}.
     *
     * @return the head of the queue represented by this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E element() {
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this deque (in other words, the first element of this deque), or
     * returns {@code null} if this deque is empty.
     *
     * <p>This method is equivalent to {@link #peekFirst()}.
     *
     * @return the head of the queue represented by this deque, or
     *         {@code null} if this deque is empty
     */
    @Override
    public E peek() {
        return peekFirst();
    }

    /**
     * Adds all of the elements in the specified collection at the end
     * of this deque, as if by calling {@link #addLast} on each one,
     * in the order that they are returned by the collection's iterator.
     *
     * @param c the elements to be inserted into this deque
     * @return {@code true} if this deque changed as a result of the call
     * @throws NullPointerException if the specified collection contains a
     *         null element and this deque does not permit null elements,
     *         or if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator<E> iterator = (Iterator<E>) c.iterator();
        while (iterator.hasNext()){
            this.addLast(iterator.next());
        }
        return true;
    }

    /**
     * Pushes an element onto the stack represented by this deque (in other
     * words, at the head of this deque) if it is possible to do so
     * immediately without violating capacity restrictions, throwing an
     * {@code IllegalStateException} if no space is currently available.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public void push(E e) {
        addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this deque.  In other
     * words, removes and returns the first element of this deque.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this deque (which is the top
     *         of the stack represented by this deque)
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E pop() {
        return removeFirst();
    }

    /**
     * Removes the first occurrence of the specified element from this deque.
     * If the deque does not contain the element, it is unchanged.
     * More formally, removes the first element {@code e} such that
     * {@code Objects.equals(o, e)} (if such an element exists).
     * Returns {@code true} if this deque contained the specified element
     * (or equivalently, if this deque changed as a result of the call).
     *
     * <p>This method is equivalent to {@link #removeFirstOccurrence(Object)}.
     *
     * @param o element to be removed from this deque, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    /**
     * Returns {@code true} if this deque contains the specified element.
     * More formally, returns {@code true} if and only if this deque contains
     * at least one element {@code e} such that {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     * @throws NullPointerException if the specified element is null and this
     *         deque does not permit null elements
     */
    @Override
    public boolean contains(Object o) {
        return super.contains((E)o);
    }

    /**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
    @Override
    public Iterator<E> descendingIterator() {
        return new ArrayDequeDescendingIterator();
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order. The returned array's {@linkplain Class#getComponentType
     * runtime component type} is {@code Object}.
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        Iterator<E> iterator = iterator();
        for (int i = 0; i < result.length; i++) {
            if (iterator.hasNext()){
                result[i] = iterator.next();
            }
        }
        return result;
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * If the collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     *
     * @param <T> the component type of the array to contain the collection
     * @param a the array into which the elements of this collection are to be
     *        stored, if it is big enough; otherwise, a new array of the same
     *        runtime type is allocated for this purpose.
     * @return an array containing all of the elements in this collection
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size()){
            a = (T[])new Object[size()];
        }
        Iterator<E> iterator = iterator();
        for (int i = 0; i < size(); i++) {
            if (iterator.hasNext()){
                a[i] = (T) iterator.next();
            }
        }
        for (int i = size(); i < a.length; i++){
            a[i] = null;
        }
        return a;
    }

    /**
     * Returns {@code true} if this collection contains all of the elements
     * in the specified collection.
     *
     * @param  c collection to be checked for containment in this collection
     * @return {@code true} if this collection contains all of the elements
     *         in the specified collection
     * @throws NullPointerException if the specified collection contains one
     *         or more null elements and this collection does not permit null
     *         element or if the specified collection is null.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty() || c.contains(null)){
            throw new NullPointerException();
        }
        Iterator<E> iterator = (Iterator<E>) c.iterator();
        while (iterator.hasNext()){
            if (!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return {@code true} if this collection changed as a result of the
     *         call
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not support
     *         null elements or if the specified collection is null
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isModified = false;
        if (c.isEmpty() || c.contains(null)){
            throw new NullPointerException();
        }
        Iterator<E> iterator = (Iterator<E>) c.iterator();
        while (iterator.hasNext()){
            E forRemove = iterator.next();
            while (contains(forRemove)){
                remove(forRemove);
                isModified = true;
            }
        }
        return isModified;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return {@code true} if this collection changed as a result of the call
     *         is not supported by this collection
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not permit null
     *         elements or if the specified collection is null
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isModified = false;
        if (c.isEmpty() || c.contains(null)){
            throw new NullPointerException();
        }

        for (E forRemove : this) {
            if (!c.contains(forRemove)) {
                while (contains(forRemove)) {
                    remove(forRemove);
                    isModified = true;
                }
            }
        }
        return isModified;
    }

    private class ArrayDequeDescendingIterator implements Iterator<E> {

        private int i = N;
        private int target = tail;
        private int previousTarget;
        private boolean canRemove = false;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (hasNext()) {
                previousTarget = target;
                Object value = deque[target--];

                i--;

                if (target == -1) {
                    target = deque.length - 1;
                }

                canRemove = true;

                return (E) value;
            } else {
                throw new NoSuchElementException("Deque is empty");
            }
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         *
         * @throws IllegalStateException if the iteration has no more elements
         */
        @Override
        public void remove() {

            if (N == 0 || target == tail || !canRemove) {
                throw new IllegalStateException();
            }

            int targetInd = previousTarget;

            if (targetInd > tail){
                int j;
                for (j = targetInd; j > head; j--){
                    deque[j] = deque[j - 1];
                }
                head = head == deque.length - 1 ? 0 : head + 1;
                target++;
            } else {
                int j;
                for (j = targetInd; j < tail; j++) {
                    deque[j] = deque[j + 1];
                }
                tail = tail == 0 ? deque.length - 1 : tail - 1;
            }

            canRemove = false;
            N--;

        }
    }
}
