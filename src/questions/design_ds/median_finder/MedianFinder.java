package questions.design_ds.median_finder;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> fe, be;
    public MedianFinder() {
        fe=new PriorityQueue<>((a, b)->b-a);
        be=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (fe.size() == be.size()) {
            be.offer(num);
            fe.offer(be.poll());
        } else {
            fe.offer(num);
            be.offer(fe.poll());
        }
    }

    public double findMedian() {
        if (fe.size() == be.size()) return (fe.peek()+be.peek())/2.0;

        return fe.peek();
    }
}
