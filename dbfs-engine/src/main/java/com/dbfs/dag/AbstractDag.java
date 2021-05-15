package com.dbfs.dag;


import java.util.Properties;

public abstract class AbstractDag {

    protected String id;

    protected Properties properties;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
