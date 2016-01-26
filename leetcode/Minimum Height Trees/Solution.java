import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<Integer>();
        }
        int[] degrees = new int[n];
        System.out.println("Start: ");
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];            
            System.out.println("node 1: "+a);
            System.out.println("node 2: "+b);
            degrees[a]++;
            degrees[b]++;
            System.out.println("Degree of node "+a+" is: "+ degrees[a]);
            System.out.println("Degree of node "+b+" is: "+ degrees[b]);
            adjList[a].add(b);
            adjList[b].add(a);
        }
        Queue<Integer> buffer = new LinkedList<Integer>();
        System.out.println("The Adj List is now: ");
        for(int i=0;i<n;i++){   
            System.out.print("The node of "+i+" is now: ");         
            System.out.println(adjList[i]);
        }
        System.out.println();
        System.out.println("The degrees are now: ");
        for(int i=0;i<n;i++){
            if(degrees[i]==1){
                buffer.offer(i);
            }
            System.out.print(degrees[i]+" ");
        }
        System.out.println();
        System.out.println("The queue is now: "+buffer);
        while(n>2){
            int sz = buffer.size();
            for (int i = 0; i < sz; ++i) {
                int top = buffer.poll();
                System.out.println("The top is now: "+ top);
                n--;
                for (int j=0; j<adjList[top].size(); j++) {
                    int adjNode = adjList[top].get(j);
                    degrees[adjNode]--;
                    System.out.println("The degrees of node "+ 
                       adjNode +" is now: " +degrees[adjNode]);
                    if (degrees[adjNode] == 1){
                        buffer.offer(adjNode);       
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (!buffer.isEmpty()){
            res.add(buffer.poll()); 
        }
        return res;
        
    }
    public static void main(String [] args){
        Solution sl = new Solution();
        int n1 = 4;
        int [][] arr1 = {{1,0},{1,2},{1,3}};
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(sl.findMinHeightTrees(n1,arr1));
    }
}