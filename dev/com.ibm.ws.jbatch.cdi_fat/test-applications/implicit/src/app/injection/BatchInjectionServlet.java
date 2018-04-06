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
package app.injection;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import app.injection.Injectables.NonBatchArtifact;
import componenttest.app.FATServlet;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import fat.util.PollingWaiter;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/BatchInjectionServlet")
public class BatchInjectionServlet extends FATServlet {

    public static Logger logger = Logger.getLogger("test");

    /**
     * Test that, inside the context of a running batch job, (on the same thread as an executing batch job), the batch context
     * gets injected into other CDI managed beans.
     *
     * Lump this all into one test. Test that all injections are handled by executing the job and looking for COMPLETED status.
     *
     * Because app uses injection which will inject all beans satisfying injection condition, it is
     * easier to have one big test which verifies all the correct injections do (or don't) happen,
     * than it is to have a more fine-grained set of test methods saying which injections do or don't work.
     *
     * To find logic validating injection,
     *
     * @see app.injection.Injectables
     */
    @Test
    @Mode(TestMode.LITE)
    public void testInjectionWithinBatchJob() throws Exception {
        logger.fine("Running test = testInjectionWithinBatchJob");
        JobOperator jo = BatchRuntime.getJobOperator();
        long execId = jo.start("cdi", null);
        JobExecution jobExec = new PollingWaiter(execId, jo).awaitTermination();
        assertEquals("Job didn't complete successfully", BatchStatus.COMPLETED, jobExec.getBatchStatus());
    }

    @Inject
    NonBatchArtifact nonArtifact;

    /**
     * Test that, outside the context of a running batch job, the batch context does NOT get injected into
     * CDI managed beans.
     */
    @Test
    @Mode(TestMode.LITE)
    public void testNullInjectionOutsideOfBatchJob() throws Exception {
        logger.fine("Running test = testNullInjectionOutsideOfBatchJob");
        nonArtifact.assertBatchInjectionsNull();
    }

}
