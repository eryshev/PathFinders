package com.eaaps;

import com.eaaps.common.GraphWithWeights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DijkstraSolver {
    public static class Pair {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void solve(GraphWithWeights graph, int start, int goal) {
        if (start == goal) {
            System.out.println("Cost from " + start + " to goal " + goal + " = " + 0);
            System.out.println("Path " + start);
            return;
        }
        PriorityQueue<Pair> frontier = new PriorityQueue<Pair>(graph.verticesNum() * 2,
                (Pair p1, Pair p2) -> {
                    if (p1.cost < p2.cost) return -1;
                    else if (p1.cost > p2.cost) return 1;
                    else return 0;
                });
        frontier.add(new Pair(start, 0));
        int[] cameFrom = new int[graph.verticesNum()];
        int[] costSoFar = new int[graph.verticesNum()];
        cameFrom[start] = -1;
        costSoFar[start] = -1;

        Pair current;
        int new_cost;
        while(!frontier.isEmpty()) {
            current = frontier.remove();

            if (current.node == goal) break;

            for (int neighbor: graph.neighbors(current.node)) {
                new_cost = current.cost + graph.cost(current.node, neighbor);
                if (costSoFar[neighbor] == 0 || new_cost < costSoFar[neighbor]) {
                    costSoFar[neighbor] = new_cost;
                    frontier.add(new Pair(neighbor, new_cost));
                    cameFrom[neighbor] = current.node;
                }
            }
        }

        if (costSoFar[goal] != 0) {
            System.out.println("Cost from " + start + " to goal " + goal + " = " + costSoFar[goal]);
            ArrayList<Integer> reversePath = new ArrayList<Integer>();
            int node = goal;
            while(cameFrom[node] != -1) {
                reversePath.add(node);
                node = cameFrom[node];
            }
            reversePath.add(start);
            Collections.reverse(reversePath);
            System.out.println("Path " + reversePath);
        }
        else
            System.out.println("Goal is not reached!");
    }
}
