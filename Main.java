/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] cables) {
        // Initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] cable : cables) {
            int a = cable[0] - 1;
            int b = cable[1] - 1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        // Calculate network rank for each pair of labs
        int maxNetworkRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Set<Integer> adjSet = new HashSet<>(adjList.get(i));
                adjSet.addAll(adjList.get(j));
                int commonAdj = adjList.get(i).size() + adjList.get(j).size() - adjSet.size();
                int networkRank = adjList.get(i).size() + adjList.get(j).size() - commonAdj;
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }
        }
        
        return maxNetworkRank;
    }
}
