package com.doubledigit.algorithim.chapter1.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Vivek Kumar Mishra on 05/08/2018.
 */
public class AdjacencyMatrixGraphImpl implements Graph {

    private GraphType graphType;
    private int numberOfVertices;
    private int[][] adjacentMatrix;

    public AdjacencyMatrixGraphImpl(GraphType graphType, int numberOfVertices) {
        this.graphType = graphType;
        this.numberOfVertices = numberOfVertices;

        adjacentMatrix = new int[numberOfVertices][numberOfVertices];
        IntStream.range(0, numberOfVertices).forEach(e -> {
            IntStream.range(0, numberOfVertices).forEach(i -> {
                adjacentMatrix[e][i] = 0;
            });
        });
    }

    @Override
    public Integer getWeightedEdge(int v1, int v2) {
        return adjacentMatrix[v1][v2];
    }

    @Override
    public void addEdge(int v1, int v2) {
        if(v1 >= numberOfVertices || v1 < 0 && v2 >= numberOfVertices || v2 < 0){
            throw new IllegalArgumentException("Please provide correct vertex ID..");
        }

        adjacentMatrix[v1][v2] = 1;
        if(graphType == GraphType.UNDIRECTED){
            adjacentMatrix[v2][v1] = 1;
        }
    }

    @Override
    public void addWeightedEdge(int v1, int v2, int weight) {
        if(v1 >= numberOfVertices || v1 < 0 && v2 >= numberOfVertices || v2 < 0){
            throw new IllegalArgumentException("Please provide correct vertex Id..");
        }

        adjacentMatrix[v1][v2] = weight;
        if(graphType == GraphType.UNDIRECTED){
            adjacentMatrix[v2][v1] = weight;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v >= numberOfVertices || v < 0){
            throw new IllegalArgumentException("Please provide correct vertex Id..");
        }
        List<Integer> adjacentVertices = new ArrayList<>();
        IntStream.range(0, numberOfVertices).forEach(e -> {
            if(adjacentMatrix[v][e] == 1){
                adjacentVertices.add(e);
            }
        });
        return adjacentVertices;
    }

    @Override
    public List<Integer> getAdjacentVerticesOfWeightedGraph(int v) {
        if(v >= numberOfVertices || v < 0){
            throw new IllegalArgumentException("Please provide correct Vertex Id...");
        }

        List<Integer> adjacentVertices = new ArrayList<>();
        IntStream.range(0, numberOfVertices).forEach(e -> {
            if(adjacentMatrix[v][e] != 0){
                adjacentVertices.add(e);
            }
        });
        return adjacentVertices;
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }
}
