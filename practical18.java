import java.io.*;
import java.util.*;

class practical18
{

    static int a[] = new int[30], cnt;

    static int place(int pos)
    {
        int i;
        for (i = 1; i < pos; i++) {
            if ((a[i] == a[pos])
                    || ((Math.abs(a[i] - a[pos]) == Math.abs(i - pos))))
                return 0;
        }
        return 1;
    }

    static void print_sol(int N)
    {
        int i, j;
        cnt++;
        System.out.println("Solution #" + cnt + ":");
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                if (a[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println("");
        }
    }

    static void queen(int n)
    {
        cnt = 0;
        int k = 1;
        a[k] = 0;
        while (k != 0) {
            a[k] = a[k] + 1;
            while ((a[k] <= n) && place(k) == 0)
                a[k]++;
            if (a[k] <= n) {
                if (k == n)
                    print_sol(n);
                else {
                    k++;
                    a[k] = 0;
                }
            }
            else
                k--;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 4;
        queen(N);
        System.out.println("Total solutions=" + cnt);
    }
}

