import java.util.*;

class Node{
    char value;
    ArrayList<Node> children = new ArrayList<>();
    boolean visited = false;

    Node(char value){
        this.value = value;
    }

    void addChildren(Node[] children){
        this.children.addAll(Arrays.asList(children));
    }
}

public class practical17 {
    public static void main(String[] args) {
        Node A = new Node('1');
        Node B = new Node('2');
        Node C = new Node('3');
        Node D = new Node('4');
        Node E = new Node('5');
        Node F = new Node('6');
        Node G = new Node('7');
        Node H = new Node('8');

        A.addChildren(new Node[] {B,C,D});
        B.addChildren(new Node[] {C,E,F});
        C.addChildren(new Node[] {F});
        D.addChildren(new Node[] {G,H});

        Traverse traverse = new Traverse();
        traverse.DFS(A);
        System.out.println();
//        traverse.BFS(A);
    }
}

class Traverse{
    void DFS(Node root){
        System.out.print(root.value + " ");
        root.visited = true;
        for(Node child: root.children){
            if(!child.visited){
                DFS(child);
            }
        }
    }

    void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.println(root.value);

        while(!q.isEmpty()){
            Node first = q.remove();

            for(Node child: first.children){
                if(!child.visited){
                    child.visited = true;
                    q.add(child);
                    System.out.print(child.value + " ");
                }
            }
            System.out.println();
        }
    }
}