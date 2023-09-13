package recursion;

import java.util.Arrays;

public class Recursion {
    public static int fib(int n, int[] cache) {
        if (n == 0 || n == 1) {
            cache[n] = n;
        }
        if (cache[n] == -1) {
            cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
        }

        return cache[n];
    }

    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return fib(n, cache);
    }

    public static void reversePrint(String string) {
        if ("".equals(string)) return;

        reversePrint(string.substring(1));
        System.out.println(string.charAt(0));
    }

    public static void main(String[] args) {
        reversePrint("abcd");
    }
}
