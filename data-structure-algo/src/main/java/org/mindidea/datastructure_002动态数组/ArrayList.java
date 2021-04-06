package org.mindidea.datastructure_002动态数组;

public class ArrayList<E> {

    private int size;

    private final Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elementData = new Object[capacity];
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    /**
     * 元素的数量
     *
     * @return int
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public void add(E element) {
        elementData[size++] = element;
    }

    /**
     * 在 index 位置上插入一个新元素
     *
     * @param index   下标
     * @param element 新元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }

        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        return (E) elementData[index];
    }

    /**
     * 设置 index 位置上的元素
     *
     * @param index   index
     * @param element 新元素
     * @return index 位置上原来的元素
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
}
