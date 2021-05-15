package com.dbfs.dag;


import com.dbfs.edge.BeamEdge;
import com.dbfs.node.BeamNode;

import java.util.Map;

public class BeamDag extends AbstractDag {

    protected Map<String, BeamEdge> edgeMap;

    protected Map<String, BeamNode> nodeMap;

    public Map<String, BeamEdge> getEdgeMap() {
        return edgeMap;
    }

    public void setEdgeMap(Map<String, BeamEdge> edgeMap) {
        this.edgeMap = edgeMap;
    }

    public Map<String, BeamNode> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, BeamNode> nodeMap) {
        this.nodeMap = nodeMap;
    }
}
