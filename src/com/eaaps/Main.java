package com.eaaps;

import com.eaaps.common.GraphWithWeights;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        SimpleGraph graph = new SimpleGraph();
//
//        graph.edges.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
//        graph.edges.add(new ArrayList<Integer>(Arrays.asList(0, 3)));
//        graph.edges.add(new ArrayList<Integer>(Arrays.asList(3)));
//        graph.edges.add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
//
//        BFSSolver.solve(graph, 1);

        GraphWithWeights graphWW = new GraphWithWeights();
        graphWW.edges.add(new HashMap<Integer, Integer>(){
            {
                put(1, 1);
                put(3, 10);
            }
        });
        graphWW.edges.add(new HashMap<Integer, Integer>(){
            {
                put(0, 1);
                put(3, 3);
            }
        });
        graphWW.edges.add(new HashMap<Integer, Integer>(){
            {
                put(3, 5);
            }
        });
        graphWW.edges.add(new HashMap<Integer, Integer>(){
            {
                put(0, 10);
                put(1, 3);
                put(2, 5);
            }
        });

        DijkstraSolver.solve(graphWW, 2, 0);

        new AStarSolver() {
            @Override
            public float heuristic(GraphWithWeights graph, int node, int goal) {
                return 0;
            }
        }.solve(graphWW, 2, 0);
    }
}
