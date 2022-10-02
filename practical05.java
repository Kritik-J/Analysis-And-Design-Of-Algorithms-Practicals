import java.util.Arrays;
import java.util.HashSet;

//        4
// [1]---------[2]
//   \         /
//  4 \       / 2
//     \     /
//       [3]
//      / | \
//   1 / 6|  \ 3
//    /   |   \
//  [4]--[5]--[6]
//      3    2

public class practical05 {

    static double inf = Double.POSITIVE_INFINITY;

    public static void main(String[] args){
        double[][] graph = {
                {0,4,4,inf,inf,inf},
                {4,0,2,inf,inf,inf},
                {4,2,0,1,6,3},
                {inf,inf,1,0,3,inf},
                {inf,inf,6,3,0,2},
                {inf,inf,3,inf,2,0},
        };

        double[] shortest_distance = {inf,inf,inf,inf,inf,inf};
        double max_min = 0.0;
        int source = 0;
        HashSet<Integer> sources = new HashSet<Integer>();

        shortest_distance[source] = 0;

        for(int i=0; i<graph.length;i++){
            for(int j =0; j< graph.length; j++){
                if(j==source){
                    continue;
                }
                if((shortest_distance[source] + graph[source][j]) < shortest_distance[j]){
                    shortest_distance[j] = shortest_distance[source] + graph[source][j];
                }
            }
            double minimum=inf;
            for(int k =0; k< shortest_distance.length;k++){
                if(k==source) {
                    continue;
                }
                if(shortest_distance[k] >= max_min && shortest_distance[k] < minimum && !(sources.contains(k))){
                    minimum = shortest_distance[k];
                    source = k;
                    sources.add(k);
                }
            }
            max_min = minimum;
        }

        System.out.println(Arrays.toString(shortest_distance));
    }
}