package practices.design_ds.priority_queue.s1845;

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
        while(n>1&&greater(parent(n), n)) {
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
            if (greater(min, n)) break;

            swap(min, n);
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


public class SeatManager {
    private MinPQ<Integer> pq;

    public SeatManager(int n) {
        pq=new MinPQ<>(n);
        for (int i=1; i<=n; i++) pq.offer(i);
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
