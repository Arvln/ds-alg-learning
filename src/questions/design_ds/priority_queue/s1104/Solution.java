package questions.design_ds.priority_queue.s1104;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int targetIndex;
    private int[] buildTree(int label) {
        int capacity=1;
        while (capacity<=label) capacity*=2;
        int[] res=new int[capacity];

        int start=1, end=1, deep=1;
        for (int i=1; i<capacity;) {
            if (deep%2==1) {
                for (int j=start; j<=end; j++, i++) {
                    if (i==label) targetIndex=j;
                    res[j]=i;
                }
                int s=start;
                start=2*end+1;
                end=2*s;
            } else {
                for (int j=start; j>=end; j--, i++) {
                    if (i==label) targetIndex=j;
                    res[j]=i;
                }
                int s=start;
                start=2*end;
                end=2*s+1;
            }
            deep++;
        }
        return res;
    }

    public List<Integer> pathInZigZagTree(int label) {
        int[] tree=buildTree(label);
        LinkedList<Integer> res=new LinkedList<>();
        while (targetIndex>0) {
            res.addFirst(tree[targetIndex]);
            targetIndex/=2;
        }
        return res;
    }
}
