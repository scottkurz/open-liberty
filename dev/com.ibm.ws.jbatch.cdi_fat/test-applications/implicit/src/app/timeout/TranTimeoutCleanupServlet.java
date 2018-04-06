/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package app.timeout;

import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import componenttest.app.FATServlet;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import fat.util.JobRunner;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/TranTimeoutCleanupServlet")
public class TranTimeoutCleanupServlet extends FATServlet {

    public static Logger logger = Logger.getLogger("test");

    /*
     * If FULL runs frequently enough we could make LITE even quicker and just do 1 then 1 job.
     * For now I'll run the risk of making the LITE mode take a bit longer than perhaps optimal
     *
     * @Test
     *
     * @Mode(TestMode.LITE)
     * public void testTranTimeoutCleanupBasic() throws Exception {}
     */

    @Test
    @Mode(TestMode.LITE)
    public void testTranTimeoutCleanupJobs() throws Exception {
        int numIterations = 4;

        logger.fine("Running test = testTranTimeoutCleanupJobs");
        for (int i = 0; i < numIterations; i++) {
            logger.info("Job 1, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupBefore", null);
            logger.info("Job 2, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupAfter", null);
        }
    }

    @Test
    @Mode(TestMode.FULL)
    public void testTranTimeoutCleanupPartitions() throws Exception {
        int numIterations = 3;

        logger.fine("Running test = testTranTimeoutCleanupJobs");
        for (int i = 0; i < numIterations; i++) {
            logger.info("Job 1, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupBeforePartition", null);
            logger.info("Job 2, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupAfter", null);
        }

    }

    @Test
    @Mode(TestMode.FULL)
    public void testTranTimeoutCleanupSplitFlows() throws Exception {

        int numIterations = 3;

        logger.fine("Running test = testTranTimeoutCleanupJobs");
        for (int i = 0; i < numIterations; i++) {
            logger.info("Job 1, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupBeforeSplitFlow", null);
            logger.info("Job 2, iteration #" + i);
            JobRunner.runJob("TranTimeoutCleanupAfter", null);
        }
    }

}
