package com.eaaps.common;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphWithWeights {
    public ArrayList<HashMap<Integer, Integer>> edges;

    public GraphWithWeights() {
        edges = new ArrayList<HashMap<Integer, Integer>>();
    }

    public ArrayList<Integer> neighbors(Integer id) {
        return new ArrayList<Integer>(edges.get(id).keySet());
    }

    public int verticesNum() {
        return edges.size();
    }

    public int cost(int from_node, int to_node) {
        return edges.get(from_node).getOrDefault(to_node, -1);
    }
}
