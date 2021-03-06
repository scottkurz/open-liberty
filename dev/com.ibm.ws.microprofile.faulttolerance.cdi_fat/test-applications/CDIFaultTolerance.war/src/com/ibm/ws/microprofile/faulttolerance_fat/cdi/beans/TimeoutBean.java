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
package com.ibm.ws.microprofile.faulttolerance_fat.cdi.beans;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import com.ibm.ws.microprofile.faulttolerance_fat.util.ConnectException;
import com.ibm.ws.microprofile.faulttolerance_fat.util.Connection;

@RequestScoped
public class TimeoutBean {

    private int connectCCalls = 0;
    private int connectDCalls = 0;

    @Timeout
    public Connection connectA() throws ConnectException {
        try {
            Thread.sleep(20000);
            throw new ConnectException("Timeout did not interrupt");
        } catch (InterruptedException e) {
            //expected
            System.out.println("TimeoutBean Interrupted");
        }
        return null;

    }

    @Timeout
    public Connection connectB() throws ConnectException {
        throw new ConnectException("A simple exception");
    }

    @Timeout(500)
    @Retry(maxRetries = 7, maxDuration = 10, durationUnit = ChronoUnit.SECONDS)
    public Connection connectC() throws InterruptedException, ConnectException {
        connectCCalls++;
        Thread.sleep(2000);
        Connection result = new Connection() {
            @Override
            public String getData() {
                return "connectC";
            }
        };
        return result; // Should not be seen because timeout happens first
    }

    @Asynchronous
    @Timeout(500)
    @Retry(maxRetries = 7, maxDuration = 10, durationUnit = ChronoUnit.SECONDS)
    public Future<Connection> connectD() throws InterruptedException, ConnectException {
        connectDCalls++;
        Thread.sleep(2000);
        Connection result = new Connection() {
            @Override
            public String getData() {
                return "connectC";
            }
        };
        return CompletableFuture.completedFuture(result); // Should not be seen because timeout happens first
    }

    public int getConnectCCalls() {
        return connectCCalls;
    }

    public int getConnectDCalls() {
        return connectDCalls;
    }

    /**
     * Just sleeps for longer than the default 1000ms. Should not time out because Timeout.value = 0 -> no timeout.
     */
    @Timeout(0)
    public void connectE() throws InterruptedException {
        Thread.sleep(2000);
    }
}
