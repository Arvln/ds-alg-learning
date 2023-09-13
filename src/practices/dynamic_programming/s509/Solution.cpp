class Solution {
public:
    int fib(int n) {
        int x=0, y=1;
        for (int i=1; i<=n; i++)
        {
            int tmp=x+y;
            x=y;
            y=tmp;
        }

        return x;
    }
};