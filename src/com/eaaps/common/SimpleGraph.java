package com.eaaps.common;

import java.util.ArrayList;

public class SimpleGraph {
    public ArrayList<ArrayList<Integer>> edges;

    public SimpleGraph() {
        edges = new ArrayList<ArrayList<Integer>>();
    }

    public ArrayList<Integer> neighbors(Integer id) {
        return edges.get(id);
    }

    public int verticesNum() {
        return edges.size();
    }
}
