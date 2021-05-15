package com.dbfs.node;

import com.dbfs.edge.BeamEdge;

import java.util.List;


public class BeamNode extends AbstractNode {

    protected String type;

    protected List<BeamEdge> input;

    protected List<BeamEdge> output;

    public List<BeamEdge> getInput() {
        return input;
    }

    public void setInput(List<BeamEdge> input) {
        this.input = input;
    }

    public List<BeamEdge> getOutput() {
        return output;
    }

    public void setOutput(List<BeamEdge> output) {
        this.output = output;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void execute(){
        System.out.println(id + " execute " + type);
    }
}
