class DynamicArray {
    int capacity;
    int size;
    int[] array;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.array = new int[capacity];
            this.size = 0;
        }
        else throw new IllegalArgumentException("capacity must be > 0");
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        int popped = array[size - 1];
        size--;
        return popped;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
