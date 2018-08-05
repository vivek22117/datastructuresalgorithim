package com.doubledigit.algorithim.chapter1.graph;

/**
 * Created by Vivek Kumar Mishra on 05/08/2018.
 */
public class VertexInfo {
    private Integer vertexId;
    private Integer distance;

    public VertexInfo(Integer vertexId, Integer distance) {
        this.vertexId = vertexId;
        this.distance = distance;
    }

    public Integer getVertexId() {
        return vertexId;
    }

    public void setVertexId(Integer vertexId) {
        this.vertexId = vertexId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
