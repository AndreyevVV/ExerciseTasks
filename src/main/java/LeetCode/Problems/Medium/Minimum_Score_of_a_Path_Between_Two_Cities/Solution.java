package LeetCode.Problems.Medium.Minimum_Score_of_a_Path_Between_Two_Cities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {

    public int minScore(int n, int[][] roads) {

        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n+1;i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(1, Integer.MAX_VALUE));

        boolean[] vis =new boolean[n+1];

        int ans=Integer.MAX_VALUE;

        while(!qu.isEmpty()){
            Pair p=qu.poll();
            vis[p.node]=true;
            ans=Math.min(ans,p.dist);

            for(Pair adjcomp:adj.get(p.node)){
                if(!vis[adjcomp.node]){
                    qu.add(adjcomp);
                }
            }
        }
        return ans;
    }

    static class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
}
