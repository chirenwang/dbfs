package com.dbfs.data;

public class TestData {
    public static final String TEST_JSON = "{\t\n" +
            "\t\"id\":\"dag-1234\",\n" +
            "\t\"globalParams\": [],\n" +
            "\t\"nodes\": [{\n" +
            "\t\t\"type\": \"MYSQL\",\n" +
            "\t\t\"output\":[\"edge-1\"],\n" +
            "\t\t\"id\": \"node-1\",\n" +
            "\t\t\"name\": \"mysql导入\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"type\": \"MYSQL\",\n" +
            "\t\t\t\"datasource\": 1,\n" +
            "\t\t\t\"sql\": \"SELECT * from t_datasource_test\"\n" +
            "\t\t}\n" +
            "\t}, {\n" +
            "\t\t\"type\": \"HDFS\",\n" +
            "\t\t\"output\":[\"edge-2\"],\n" +
            "\t\t\"id\": \"node-2\",\n" +
            "\t\t\"name\": \"hdfs\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"path\": \"hdfs://xxx\"\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"type\": \"PARSE\",\n" +
            "\t\t\"input\":[\"edge-2\"],\n" +
            "\t\t\"output\":[\"edge-4\"],\n" +
            "\t\t\"id\": \"node-3\",\n" +
            "\t\t\"name\": \"解析\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"delimiter\": \";\"\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"type\": \"PARSE\",\n" +
            "\t\t\"input\":[\"edge-1\"],\n" +
            "\t\t\"output\":[\"edge-3\"],\n" +
            "\t\t\"id\": \"node-4\",\n" +
            "\t\t\"name\": \"解析\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"delimiter\": \",\"\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"type\": \"JOIN\",\n" +
            "\t\t\"input\":[\"edge-3\",\"edge-4\"],\n" +
            "\t\t\"output\":[\"edge-5\", \"edge-6\"],\n" +
            "\t\t\"id\": \"node-5\",\n" +
            "\t\t\"name\": \"join\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"field\": \"a,b\"\n" +
            "\t\t}\n" +
            "\t},{\n" +
            "\t\t\"type\": \"HDFS\",\n" +
            "\t\t\"input\":[\"edge-5\"],\n" +
            "\t\t\"id\": \"node-6\",\n" +
            "\t\t\"name\": \"导出到hdfs\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"path\":\"hdfs://xxx\"\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\t,{\n" +
            "\t\t\"type\": \"HBASE\",\n" +
            "\t\t\"input\":[\"edge-6\"],\n" +
            "\t\t\"id\": \"node-7\",\n" +
            "\t\t\"name\": \"导出到hbase\",\n" +
            "\t\t\"params\": {\n" +
            "\t\t\t\"path\":\"hdfs://xxx\"\n" +
            "\t\t}\n" +
            "\t}],\n" +
            "\t\"edges\":\n" +
            "\t[\n" +
            "\t\t\"edge-1\",\n" +
            "\t\t\"edge-2\",\n" +
            "\t\t\"edge-3\",\n" +
            "\t\t\"edge-4\",\n" +
            "\t\t\"edge-5\",\n" +
            "\t\t\"edge-6\"\n" +
            "\t]\n" +
            "}\n" +
            "\n";

}
