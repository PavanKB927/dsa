package Graph;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class class_1 {
    public static void main(String[] args) {
        // buildGraph(5,new int[][]{{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}});
         solveIsPathExists(5,new int[][]{{1,2},{4,1},{2,4},{3,4},{5,2},{1,5}},1);

    }

    // building graph using arrayList
    public static void buildGraph(int A, int[][] B){
        //generate  the outer size of graph
        ArrayList<Integer>[] graph = new ArrayList[A+1];

        //pass the values  from 2D array to graph
        int size = B.length;
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<size;i++){
            graph[B[i][0]].add(B[i][1]);
        }
        // print the graph
        for(ArrayList<Integer> node: graph){
            System.out.println(node);
        }
    }

    /* Path in Directed Graph
     * Check if there is a path between given nodes
     */
    public static int solveIsPathExists(int nodes, int[][] A, int source) {
        // creating the Graph
        ArrayList<Integer>[] graph = new ArrayList[nodes+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }
        int size = A.length;
        for(int i=0;i<size;i++){
            graph[A[i][0]].add(A[i][1]);
        }
        // check if all nodes are traversed from 1 using breadth first search(BFS)
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        // track node visited
        boolean[] visited = new boolean[nodes+1];
        visited[source] = true;
        while(!q.isEmpty()){
            int currentNode = q.peek();
            q.remove();
            for(int i=0;i< graph[currentNode].size();i++){
                int node = graph[currentNode].get(i);
                if(!visited[node]){
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
        System.out.println("is visited :"+visited[nodes]);
        return visited[nodes] ? 1:0;
    }

    /* Depth First Search
    *
    * */


}
