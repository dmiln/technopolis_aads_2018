package ru.mail.polis.collections.set.sorted.todo;

import ru.mail.polis.collections.set.sorted.ISelfBalancingSortedTreeSet;
import ru.mail.polis.collections.set.sorted.UnbalancedTreeException;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A Red-Black tree based {@link ISelfBalancingSortedTreeSet} implementation.
 * <p>
 * ! An implementation of red-black trees must be based on the description in
 * Introduction to Algorithms (Cormen, Leiserson, Rivest)
 *
 * <a href="http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap13.htm">CHAPTER 13: BINARY SEARCH TREES</a>
 *
 * <a href="http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap14.htm">CHAPTER 14: RED-BLACK TREES</a>
 *
 * @param <E> the type of elements maintained by this set
 */
public class RedBlackTree<E extends Comparable<E>> implements ISelfBalancingSortedTreeSet<E> {


    //todo: update it if required
    enum RBColor {
        RED, BLACK;
    }

    //todo: update it if required
    static final class RBNode<E> {

        E value; //key
        RBNode<E> left;
        RBNode<E> right;
        RBNode<E> parent;
        RBColor color = RBColor.BLACK;

        @Override
        public String toString() {
            return "RBNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", color=" + color +
                    '}';
        }

    }

    /**
     * The comparator used to maintain order in this tree sett.
     */
    protected final Comparator<E> comparator;

    protected RBNode root;
    private int N = 0;
    private RBNode<E> TNILL;

    public RedBlackTree() {
        this(Comparator.naturalOrder());
    }

    /**
     * Creates a {@code ISelfBalancingSortedTreeSet} that orders its elements according to the specified comparator.
     *
     * @param comparator comparator the comparator that will be used to order this priority queue.
     * @throws NullPointerException if the specified comparator is null
     */
    public RedBlackTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param value element to be added to this set
     * @return {@code true} if this set did not already contain the specified
     * element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        RBNode<E> z = new RBNode<>();
        z.value = value;
        RBNode<E> y = TNILL;
        RBNode<E> x = root;

        while (x != TNILL) {
            y = x;
            if (comparator.compare(z.value, x.value) < 0) {
                x = x.left;
            } else if (comparator.compare(z.value, x.value) > 0) {
                x = x.right;
            } else {
                return false;
            }
        }
        z.parent = y;
        if (y == TNILL) {
            root = z;
        } else if (comparator.compare(z.value, y.value) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = TNILL;
        z.right = TNILL;
        z.color = RBColor.RED;
        insertFixup(z);
        N++;
        return true;
    }

    private void insertFixup(RBNode z) {
        RBNode<E> y;
        while (z != root && z.parent.color == RBColor.RED) {
            if (z.parent == z.parent.parent.left) { //родитель слева
                y = z.parent.parent.left;
                if (RBColor.RED == y.color) {
                    z.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    z = z.parent;
                    leftRotate(z);
                } else {
                    z.parent.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                y = z.parent.parent.right;
                if (RBColor.RED == y.color) {
                    z.parent.color = RBColor.BLACK;
                    y.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    z = z.parent;
                } else if (z == z.parent.left) {
                    z = z.parent;
                    rightRotate(z);
                } else {
                    z.parent.color = RBColor.BLACK;
                    z.parent.parent.color = RBColor.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = RBColor.BLACK;
    }

    private void rightRotate(RBNode<E> x) {
        RBNode<E> y = x.left;
        x.left = y.right;

        if (y.right != TNILL) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == TNILL) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void leftRotate(RBNode<E> x) {
        RBNode<E> y = x.right;
        x.right = y.left;

        if (y.left != TNILL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == TNILL) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param value object to be removed from this set, if present
     * @return {@code true} if this set contained the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean remove(E value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return true;
    }

    /**
     * Returns {@code true} if this collection contains the specified element.
     * aka collection contains element el such that {@code Objects.equals(el, value) == true}
     *
     * @param value element whose presence in this collection is to be tested
     * @return {@code true} if this collection contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E value) {
        if (value == null) {
            throw new NullPointerException();
        }

        return searchValue(root, value);
    }

    private boolean searchValue(RBNode<E> x, E value) {
        if (x == TNILL) {
            return false;
        }

        if (comparator.compare(x.value, value) < 0) {
            return searchValue(x.left, value);
        } else if (comparator.compare(x.value, value) > 0) {
            return searchValue(x.right, value);
        } else {
            return true;
        }
    }

    /**
     * Returns the first (lowest) element currently in this set.
     *
     * @return the first (lowest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        RBNode<E> x = root;
        while (x.left != TNILL) {
            x = x.left;
        }
        return x.value;
    }

    /**
     * Returns the last (highest) element currently in this set.
     *
     * @return the last (highest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        RBNode<E> x = root;
        while (x.right != TNILL) {
            x = x.right;
        }
        return x.value;
    }

    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return N;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Removes all of the elements from this collection.
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        N = 0;
    }

    /**
     * Обходит дерево и проверяет выполнение свойств сбалансированного красно-чёрного дерева
     * <p>
     * 1) Корень всегда чёрный.
     * 2) Если узел красный, то его потомки должны быть чёрными (обратное не всегда верно)
     * 3) Все пути от узла до листьев содержат одинаковое количество чёрных узлов (чёрная высота)
     *
     * @throws UnbalancedTreeException если какое-либо свойство невыполнено
     */
    @Override
    public void checkBalance() throws UnbalancedTreeException {
        if (root != null) {
            if (root.color != RBColor.BLACK) {
                throw new UnbalancedTreeException("Root must be black");
            }
            traverseTreeAndCheckBalanced(root);
        }
    }

    private int traverseTreeAndCheckBalanced(RBNode RBNode) throws UnbalancedTreeException {
        if (RBNode == null) {
            return 1;
        }
        int leftBlackHeight = traverseTreeAndCheckBalanced(RBNode.left);
        int rightBlackHeight = traverseTreeAndCheckBalanced(RBNode.right);
        if (leftBlackHeight != rightBlackHeight) {
            throw UnbalancedTreeException.create("Black height must be equal.", leftBlackHeight, rightBlackHeight, RBNode.toString());
        }
        if (RBNode.color == RBColor.RED) {
            checkRedNodeRule(RBNode);
            return leftBlackHeight;
        }
        return leftBlackHeight + 1;
    }

    private void checkRedNodeRule(RBNode RBNode) throws UnbalancedTreeException {
        if (RBNode.left != null && RBNode.left.color != RBColor.BLACK) {
            throw new UnbalancedTreeException("If a RBNode is red, then left child must be black.\n" + RBNode.toString());
        }
        if (RBNode.right != null && RBNode.right.color != RBColor.BLACK) {
            throw new UnbalancedTreeException("If a RBNode is red, then right child must be black.\n" + RBNode.toString());
        }
    }

}
