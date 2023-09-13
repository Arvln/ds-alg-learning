package practices.backtrack.o38;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<String> ret;
    StringBuilder sb;
    boolean[] used;
    char[] str;
    int N;
    public String[] permutation(String s) {
        N=s.length();
        ret=new ArrayList<>();
        sb=new StringBuilder();
        used=new boolean[N];
        str=s.toCharArray();
        Arrays.sort(str);
        dfs(0);
        String[] ans=new String[ret.size()];
        for (int i=0; i<ret.size(); i++)
            ans[i]=ret.get(i);
        return ans;
    }
    void dfs(int j)
    {
        if (j==N)
        {
            ret.add(sb.toString());
            return;
        }

        for (int i=0; i<N; i++) {
            if (i>0&&str[i]==str[i-1]&&!used[i-1]) continue;
            if (used[i]) continue;

            used[i]=true;
            sb.append(str[i]);
            dfs(j+1);
            used[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
