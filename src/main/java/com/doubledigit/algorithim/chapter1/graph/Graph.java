package com.doubledigit.algorithim.chapter1.graph;

import java.util.List;

/**
 * Created by Vivek Kumar Mishra on 05/08/2018.
 */
public interface Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    Integer getWeightedEdge(int v1, int v2);
    void addEdge(int v1, int v2);
    void addWeightedEdge(int v1, int v2, int weight);
    List<Integer> getAdjacentVertices(int v);
    List<Integer> getAdjacentVerticesOfWeightedGraph(int v);
    int getNumberOfVertices();
}
