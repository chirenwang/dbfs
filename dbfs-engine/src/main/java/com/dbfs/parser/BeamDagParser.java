package com.dbfs.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dbfs.edge.BeamEdge;
import com.dbfs.node.BeamNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dbfs.constant.Constant.*;

public class BeamDagParser {


    public static com.dbfs.dag.BeamDag parse(String dagJson){
        com.dbfs.dag.BeamDag beamDag = new com.dbfs.dag.BeamDag();
        JSONObject dagJsonObject = JSON.parseObject(dagJson);
        String dagId = dagJsonObject.getString(ID);
        beamDag.setId(dagId);
        JSONArray edges = dagJsonObject.getJSONArray(EDGES);
        Map<String, BeamEdge> beamEdgeMap = new HashMap<String, BeamEdge>(20);
        for (Object o : edges){
            String beamEdgeId = (String) o;
            beamEdgeMap.put(beamEdgeId, makeBeamEdge(beamEdgeId));
        }
        beamDag.setEdgeMap(beamEdgeMap);
        JSONArray nodes = dagJsonObject.getJSONArray(NODES);
        Map<String, BeamNode> beamNodeMap = new HashMap<String, BeamNode>(30);
        for (Object o : nodes){
            JSONObject beamNodeObject = (JSONObject) o;
            String beamNodeId = beamNodeObject.getString(ID);
            beamNodeMap.put(beamNodeId, makeBeamNode(beamNodeObject));
        }
        beamDag.setNodeMap(beamNodeMap);
        return beamDag;
    }

    private static com.dbfs.edge.BeamEdge makeBeamEdge(String beamEdgeId) {
        com.dbfs.edge.BeamEdge beamEdge = new com.dbfs.edge.BeamEdge();
        beamEdge.setId(beamEdgeId);
        return beamEdge;
    }

    private static BeamNode makeBeamNode(JSONObject beamNodeObject){
        BeamNode beamNode = new BeamNode();
        beamNode.setId(beamNodeObject.getString(ID));
        beamNode.setType(beamNodeObject.getString(TYPE));
        JSONArray outputArr = beamNodeObject.getJSONArray(OUTPUT);
        List<BeamEdge> output = new ArrayList<BeamEdge>(10);
        if (outputArr != null){
            for (Object o : outputArr){
                String beamEdgeId = (String) o;
                output.add(makeBeamEdge(beamEdgeId));
            }
        }
        beamNode.setOutput(output);
        JSONArray inputArr = beamNodeObject.getJSONArray(INPUT);
        List<BeamEdge> input = new ArrayList<BeamEdge>(10);
        if (inputArr != null){
            for (Object o : inputArr){
                String beamEdgeId = (String) o;
                input.add(makeBeamEdge(beamEdgeId));
            }
        }
        beamNode.setInput(input);
        JSONObject params = beamNodeObject.getJSONObject(PARAMS);
        beamNode.setParams(params);
        return beamNode;
    }





}
