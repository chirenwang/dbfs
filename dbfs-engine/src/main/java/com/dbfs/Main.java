package com.dbfs;

import com.dbfs.dag.BeamDag;
import com.dbfs.data.TestData;
import com.dbfs.parser.BeamDagParser;
import com.dbfs.scheduler.BeamDagScheduler;

public class Main {

    public static void main(String[] args) {
        BeamDag beamDag = BeamDagParser.parse(TestData.TEST_JSON);
        BeamDagScheduler.schedule(beamDag);
    }
}
