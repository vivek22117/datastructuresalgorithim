package com.doubledigit.algorithim.chapter1.graph;

/**
 * Created by Vivek Kumar Mishra on 05/08/2018.
 */
public class DistanceInfo {

    private Integer lastVertex;
    private Integer distance;

    public DistanceInfo() {
        this.lastVertex = -1;
        this.distance = Integer.MAX_VALUE;
    }

    public void setDistanceInfo(Integer distance, Integer lastVertex) {
        this.distance = distance;
        this.lastVertex = lastVertex;
    }

    public Integer getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(Integer lastVertex) {
        this.lastVertex = lastVertex;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
