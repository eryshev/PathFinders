package com.eaaps;

import com.eaaps.common.SimpleGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSSolver {
    public static void solve(SimpleGraph graph, int start) {
        Queue<Integer> frontier = new LinkedList<Integer>();
        frontier.add(start);
        boolean[] visited = new boolean[graph.verticesNum()];
        visited[start] = true;

        int current;
        while(!frontier.isEmpty()) {
            current = frontier.remove();
            System.out.println("Visited " + current);
            for (int neighbor: graph.neighbors(current)) {
                if (!visited[neighbor]) {
                    frontier.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
