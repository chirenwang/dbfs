package com.dbfs.node;


import com.alibaba.fastjson.JSONObject;

public class AbstractNode {

    protected String id;


    protected JSONObject params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }


}
