package practices.backtrack.s638;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int N;
    private int[] memo;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        N=price.size();
        memo=new int[1<<24];
        List<List<Integer>> special2=new ArrayList<>();
        for (int i=0; i<special.size(); i++)
        {
            int sum=0;
            for (int j=0; j<N; j++)
                sum+=special.get(i).get(j) * price.get(j);

            if (sum>special.get(i).get(N))
                special2.add(special.get(i));
        }

        int state=0;
        for (int i=0; i<N; i++)
            state+=needs.get(i)<<(i*4);
        return dfs(state, special2, price);
    }
    private int dfs(int state, List<List<Integer>> special2, List<Integer> price)
    {
        if (state==0) return 0;
        if (memo[state]!=0) return memo[state];

        int ret=0;
        for (int i=0; i<N; i++)
            ret += ((state>>(i*4))&15) * price.get(i);

        for (List<Integer> comb : special2)
        {
            int flag=1;
            for (int i=0; i<N; i++)
            {
                if (((state>>(i*4))&15) < comb.get(i))
                {
                    flag=0;
                    break;
                }
            }
            if (flag==0) continue;

            int state2=state;
            for (int i=0; i<N; i++)
                state2-=comb.get(i)<<(i*4);

            ret=Math.min(ret, comb.get(N)+dfs(state2, special2, price));
        }

        memo[state]=ret;
        return ret;
    }
}
