/*
@Author:Shakhzod Ali-zade
@Problem: Given numbers 1≤n≤10^18 and 2≤m≤10^5, find the residual that remains after the division of n-th Fibonacci number by m
*/

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long n = kb.nextLong();
        long m = kb.nextLong();
        long res = get_fibonacci_huge(n,m);
        System.out.print(res);
    }

    private static long get_pisano_period(long m) {
        long a = 0, b = 1, c = a + b;
        long res = 0;
        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    private static long get_fibonacci_huge(long n, long m) {
        long remainder = n % get_pisano_period(m);

        long first = 0;
        long second = 1;

        long res = remainder;

        for (int i = 1; i < remainder; i++) {
            res = (first + second) % m;
            first = second;
            second = res;
        }

        return res % m;
    }
}
