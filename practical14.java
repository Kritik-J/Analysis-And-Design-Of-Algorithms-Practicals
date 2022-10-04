// Assembly line scheduling problem using Dynamic programming

public class practical14 {

    public static int assemblySchedule(int a1[], int a2[], int t1[], int t2[], int e1, int e2, int x1, int x2) {
        int[] f1 = new int[a1.length + 1];
        int[] f2 = new int[a2.length + 1];

        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];

        for (int i = 1; i < a1.length; i++) {
            f1[i] = Math.min(f1[i - 1] + a1[i], f2[i - 1] + t2[i - 1] + a1[i]);
            f2[i] = Math.min(f2[i - 1] + a2[i], f1[i - 1] + t1[i - 1] + a2[i]);
        }

        f1[a1.length] = f1[a1.length - 1] + x1;
        f2[a2.length] = f2[a2.length - 1] + x2;

        return Math.min(f1[a1.length], f2[a2.length]);
    }

    public static void main(String[] args) {
        int[] a1 = { 7, 9, 3, 4, 8 };
        int[] a2 = { 8, 5, 6, 4, 5 };

        int[] t1 = { 2, 3, 1, 3 };
        int[] t2 = { 2, 1, 2, 2 };

        int e1 = 2, e2 = 4, x1 = 3, x2 = 6;

        int min = assemblySchedule(a1, a2, t1, t2, e1, e2, x1, x2);

        System.out.println("Minimum time required to complete the assembly line is: " + min);
    }
}