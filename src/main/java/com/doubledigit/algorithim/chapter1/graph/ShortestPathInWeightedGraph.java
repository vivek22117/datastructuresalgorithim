package com.doubledigit.algorithim.chapter1.graph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Vivek Kumar Mishra on 05/08/2018.
 */
public class ShortestPathInWeightedGraph {

    public static void main(String[] args) {
        AdjacencyMatrixGraphImpl graphImpl = new AdjacencyMatrixGraphImpl(Graph.GraphType.DIRECTED, 20);

        IntStream.range(0, 250).forEach(e -> {
            int i = new Random().nextInt(20 - 0) + 0;
            graphImpl.addWeightedEdge(i, new Random().nextInt(20 - 0) + 0, new Random().nextInt(25 - 0) + 0);
        });

        printAdjacentMatrix(graphImpl.getAdjacentMatrix());

        List<Integer> adjacentVertices = graphImpl.getAdjacentVerticesOfWeightedGraph(5);
        System.out.println("Number of connections that vertex 5 has: " + adjacentVertices.size());

//        createDistanceTable(graphImpl, 0);
        shortestPathInDirectedGraph(graphImpl, 5, 12);
    }

    private static void shortestPathInDirectedGraph(AdjacencyMatrixGraphImpl graphImpl, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = createDistanceTable(graphImpl, source);
        Stack<Integer> vertexIds = new Stack<>();
        vertexIds.push(destination);

        Integer lastVertex = distanceTable.get(destination).getLastVertex();
        while (lastVertex != -1 && lastVertex != source){
            vertexIds.push(lastVertex);
            lastVertex = distanceTable.get(lastVertex).getLastVertex();
        }

        if(lastVertex == -1){
            System.out.println("No path for destination from source: " + source + " == " + destination);
        } else {
            System.out.print("Smallest path is.. " + source);
            while (!vertexIds.isEmpty()){
                System.out.print("->" + vertexIds.pop());
            }
            System.out.println(" Job done!");

        }

    }

    private static Map<Integer, DistanceInfo> createDistanceTable(AdjacencyMatrixGraphImpl graphImpl, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo o1, VertexInfo o2) {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        });

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        IntStream.range(0, graphImpl.getNumberOfVertices()).forEach(e -> {
            distanceTable.put(e, new DistanceInfo());
        });

        distanceTable.get(source).setDistanceInfo(0, source);
        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        vertexInfoMap.put(source, sourceVertexInfo);
        queue.add(sourceVertexInfo);

        while (!queue.isEmpty()) {
            VertexInfo currentVertexInfo = queue.poll();
            Integer vertexId = currentVertexInfo.getVertexId();

            for (Integer id : graphImpl.getAdjacentVerticesOfWeightedGraph(vertexId)) {

                int distance = distanceTable.get(vertexId).getDistance() + graphImpl.getWeightedEdge(vertexId, id);

                if (distanceTable.get(id).getDistance() > distance) {
                    distanceTable.get(id).setDistanceInfo(distance, vertexId);

                    VertexInfo vertexInfo = vertexInfoMap.get(id);
                    if (vertexInfo != null) {
                        queue.remove(vertexInfo);
                    }

                    vertexInfo = new VertexInfo(id, distance);
                    vertexInfoMap.put(id, vertexInfo);
                    queue.add(vertexInfo);
                }
            }
        }
        System.out.println("Below is the distance table how it looks like...");
        distanceTable.entrySet().stream().limit(10).forEach(entry -> {
            System.out.println("VertexId = " + entry.getKey() + " == " + entry.getValue().getDistance() + " == " + entry.getValue().getLastVertex());
        });

        return distanceTable;
    }

    private static void printAdjacentMatrix(int[][] adjacentMatrix) {
        for (int i = 0; i < adjacentMatrix.length; i++) {
            for (int j = 0; j < adjacentMatrix[i].length; j++) {

                System.out.print(adjacentMatrix[i][j] + "|");
            }
            System.out.println();
        }
    }
}
