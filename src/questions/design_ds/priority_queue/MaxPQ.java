package questions.design_ds.priority_queue;

class MinPQ<T extends Comparable<T>> {
    private T[] pq;
    private int size;

    public MinPQ(int len) {
        pq=(T[]) new Comparable[len+1];
        size=0;
    }

    private void swap(int i, int j) {
        T tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }
    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j])>0;
    }
    private int parent(int root) {
        return root/2;
    }
    private int left(int root) {
        return root*2;
    }
    private int right(int root) {
        return root*2+1;
    }

    private void swim(int n) {
        while(n>0&&greater(parent(n), n)) {
            swap(parent(n), n);
            n=parent(n);
        }
    }

    public void offer(T val) {
        size++;
        pq[size]=val;
        swim(size);
    }

    private void sink(int n) {
        while(left(n)<=size) {
            int min=left(n);

            if (right(n)<=size&&greater(min, right(n))) min=right(n);
            if (greater(min, parent(n))) break;

            swap(min, parent(n));
            n=min;
        }
    }

    public T peek() {
        return pq[1];
    }

    public T poll() {
        T min=pq[1];

        swap(1, size);
        pq[size]=null;
        size--;
        sink(1);
        return min;
    }
}

public class MaxPQ<T extends Comparable<T>> {
    private T[] pq;
    private int size;

    public MaxPQ(int capacity) {
        pq=(T[]) new Comparable[capacity+1];
        size=0;
    }

    public void offer(T val) {
        size++;
        pq[size]=val;
        swim(size);
    }

    public T poll() {
        T max=pq[1];

        swap(1, size);
        pq[size]=null;
        size--;
        sink(1);
        return max;
    }

    public T peek() { return pq[1]; }

    private int parent(int root) { return root/2; }
    private int left(int root) { return 2*root; }
    private int right(int root) { return 2*root+1; }
    private void swap(int i, int j) {
        T tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j])<0;
    }
    private void swim(int root) {
        while (root>1&&less(parent(root), root)) {
            swap(root, parent(root));
            root=parent(root);
        }
    }
    private void sink(int root) {
        while (left(root)<=size) {
            int max=left(root);

            if (right(root)<=size&&less(max, right(root))) max=right(root);
            if (less(max, root)) break;

            swap(root, max);
            root=max;
        }
    }
}
