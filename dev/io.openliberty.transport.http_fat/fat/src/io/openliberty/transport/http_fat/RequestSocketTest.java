/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.transport.http_fat;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;

import app1.web.RequestSocket;
import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;
import io.openliberty.transport.http_fat.accesslists.Utils;

/**
 * This class is a common superclass of all Http FAT tests and can be used to
 * hold instance/test centric common methods and state.
 */
@RunWith(FATRunner.class)
public class RequestSocketTest extends FATServletClient {

    public static final String APP_NAME = "app1";

    /* This server is used to get the hostname, address and port that is the test client */
    @Server("RequestSocket")
    @TestServlet(servlet = RequestSocket.class, contextRoot = APP_NAME)
    public static LibertyServer server;

    /**
     * Setup test app, find out address/host/port of this test client
     * for substituting into the server.xml used in tests and prestart
     * the test server once
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUp() throws Exception {
        ShrinkHelper.defaultApp(server, APP_NAME, "app1.web");
        server.startServer();
        server.resetLogMarks();
        assertNotNull("defaultHttpEndpoint-ssl was not started",
                      //server.waitForStringInLog("CWWKO0219I: TCP Channel defaultHttpEndpoint-ssl has been started"));
                      server.waitForStringInLog("CWWKO0219I:(.*)defaultHttpEndpoint-ssl"));

    }

    /**
     * Stop the server, the FAT scaffolding will check the logs when wrapping up
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer();
    }

    /* Useful for getting hold of the current test */
    @Rule
    public TestName test = new TestName();

    /**
     * E.g. AccessListsTests_testA11
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "_" + test.getMethodName();
    }

    @Test
    public void testRequestSocket() throws Exception {
        String expected = "socket LocalPort: " + server.getHttpDefaultPort();
        String info = Utils.get(server, "/" + APP_NAME + "/RequestSocket", "", expected, "");
    }

    @Test
    public void testRequestSocketSecure() throws Exception {
        String expected = "socket LocalPort: " + server.getHttpDefaultSecurePort();
        String info = Utils.getSecure(server, "/" + APP_NAME + "/RequestSocket", "", expected, "");
    }

    /**
     * Customize the servers server.xml file for this particular test
     *
     * @param server
     */
    public void setUpServer(LibertyServer server) {
        //Utils.setUpServer(server, this);
    }

    /**
     * Simple logging primarily for unit testing etc.
     *
     * @param string
     */
    protected void debug(String string) {
        Utils.debug(string);
    }
}
