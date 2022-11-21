import java.util.Arrays;

public class practical19 {
    static int[] w = { 2, 5, 10, 5 };
    static int[] v = { 40, 30, 50, 10 };
    static int[] Y = new int[v.length];
    static int W = 15;
    static int finalProfit = 0;
    static int finalWeight = 0;

    public static void main(String[] args) {
        KnapSack(0,0,0);
        System.out.println("Value: "+finalProfit);
        System.out.println("Weight:" +finalWeight + "\n");
        System.out.println(Arrays.toString(w));
        System.out.println(Arrays.toString(Y));
    }

    static void KnapSack(int profit, int weight, int index){
        int n = v.length;

        if(weight + w[index] <= W){
            Y[index] = 1;
            if(index < n-1){
                KnapSack(profit+v[index], weight+w[index], index+1);
            }
            if(profit + v[index] > finalProfit && index == n-1){
                finalProfit = profit + v[index];
                finalWeight = weight + w[index];
//                X = Y;
            }
        }

        if(Bound(profit, weight, index) >= finalProfit){
            Y[index] = 0;
            if(index < n-1){
                KnapSack(profit, weight, index+1);
            }
            if(profit > finalProfit && index==n-1){
                finalProfit = profit;
                finalWeight = weight;
            }
        }
    }

    static int Bound(int profit, int weight, int index){
        int boundProfit = profit;
        int currWeight = weight;
        int n = v.length;

        for(int i=index+1;i<n;i++){
            if(currWeight + w[i] <= W){
                currWeight += w[i];
                boundProfit -= v[i];
            }
        }

        return boundProfit;
    }
}
