package com.dbfs.scheduler;

import com.dbfs.edge.BeamEdge;
import com.dbfs.node.BeamNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class BeamDagScheduler extends com.dbfs.scheduler.AbstractScheduler {
    private static final Logger logger = LoggerFactory.getLogger(com.dbfs.scheduler.BeamDagScheduler.class);

    public static void schedule(com.dbfs.dag.BeamDag beamDag){
        Set<String> hasRun = new HashSet<String>(30);
        Map<String, BeamNode> beamNodeMap = beamDag.getNodeMap();
        while (beamNodeMap.size() != 0){
            BeamNode executeBeamNode = new BeamNode();
            String beamNodeId = "";
            for (Map.Entry<String, BeamNode> entry : beamNodeMap.entrySet()){
                BeamNode beamNode = entry.getValue();
                beamNodeId = entry.getKey();
                List<BeamEdge> input = beamNode.getInput();
                if (input.size() != 0){
                    boolean canRun = true;
                    for (com.dbfs.edge.BeamEdge beamEdge : input){
                        if (!hasRun.contains(beamEdge.getId())){
                            canRun = false;
                            break;
                        }
                    }
                    if (canRun){
                        executeBeamNode = beamNode;
                        hasRun.add(beamNodeId);
                        List<BeamEdge> output = beamNode.getOutput();
                        for (com.dbfs.edge.BeamEdge beamEdge : output){
                            hasRun.add(beamEdge.getId());
                        }
                        break;
                    }
                }else {
                    executeBeamNode = beamNode;
                    hasRun.add(beamNodeId);
                    List<BeamEdge> output = beamNode.getOutput();
                    for (com.dbfs.edge.BeamEdge beamEdge : output){
                        hasRun.add(beamEdge.getId());
                    }
                    break;
                }
            }
            try {
                executeBeamNode.execute();
                beamNodeMap.remove(beamNodeId);
            }catch (Exception e){
                logger.error("execute node failed: {}", e.getMessage(), e);
                break;
            }


        }

    }
}
