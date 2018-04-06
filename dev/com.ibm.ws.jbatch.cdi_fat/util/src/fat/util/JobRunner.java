/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package fat.util;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;

/**
 * Utility to start a job with a static reference to a
 * {@link javax.batch.operations.JobOperator}
 * and wait for termination (a final state like <code>BatchStatus.COMPLETED</code> or
 * <code>BatchStatus.FAILED</code>.
 */
public class JobRunner {

    protected static JobOperator jobOp = BatchRuntime.getJobOperator();

    /**
     * Start a job, wait for terminating status like {@code BatchStatus.COMPLETED} or
     * {@code BatchStatus.FAILED}.
     *
     * See {@link PollingWaiter}, which this uses and wraps.
     *
     * @param jobXMLName
     * @param jobParameters
     * @return
     * @throws Exception
     */
    public static JobExecution runJob(String jobXMLName, Properties jobParameters) throws Exception {
        long executionId = jobOp.start(jobXMLName, jobParameters);
        PollingWaiter waiter = new PollingWaiter(executionId, jobOp);
        return waiter.awaitTermination();
    }

    /**
     * Start a job, wait for terminating status like {@code BatchStatus.COMPLETED} or
     * {@code BatchStatus.FAILED}.
     *
     * See {@link PollingWaiter}, which this uses and wraps.
     *
     * @param jobXMLName
     * @param jobParameters
     * @param timeout to use with {@code PollingWaiter}
     * @return
     * @throws Exception
     */
    public static JobExecution runJob(String jobXMLName, Properties jobParameters, long timeout) throws Exception {
        long executionId = jobOp.start(jobXMLName, jobParameters);
        PollingWaiter waiter = new PollingWaiter(executionId, jobOp, timeout);
        return waiter.awaitTermination();
    }

}
