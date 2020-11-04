/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.mp.jwt12.fat.systemPropertiesTests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.ws.security.fat.common.jwt.utils.JwtKeyTools;
import com.ibm.ws.security.jwt.fat.mpjwt.MpJwt12FatConstants;
import com.ibm.ws.security.mp.jwt12.fat.sharedTests.GenericEnvVarsAndSystemPropertiesTests;
import com.ibm.ws.security.mp.jwt12.fat.utils.MP12ConfigSettings;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.topology.impl.LibertyServer;

/**
 * This is the test class that will verify that we get the correct behavior when we
 * have mp-config defined as system properties
 * We'll test with a server.xml that will NOT have a mpJwt config, the app will NOT have mp-config specified
 * Therefore, we'll be able to show that the config is coming from the system properties
 * We also test with a conflicting config in server.xml - we'll show that this value overrides the system properties
 *
 **/

@Mode(TestMode.FULL)
@RunWith(FATRunner.class)
public class MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS384RelativeFile extends GenericEnvVarsAndSystemPropertiesTests {

    public static Class<?> thisClass = MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS384RelativeFile.class;

    @Server("com.ibm.ws.security.mp.jwt.1.2.fat.jvmOptions")
    public static LibertyServer sysPropResourceServer;

    @BeforeClass
    public static void setUp() throws Exception {

        commonMpJwt12Setup(sysPropResourceServer, "rs_server_AltConfigNotInApp_good12ServerXmlConfigNoAudiences.xml", MpJwt12FatConstants.AUTHORIZATION,
                           MpJwt12FatConstants.TOKEN_TYPE_BEARER, MP12ConfigSettings.AudiencesNotSet, MpJwt12FatConstants.SIGALG_RS256,
                           JwtKeyTools.getPrivateKeyFileNameForAlg(MpJwt12FatConstants.SIGALG_RS384),
                           MPConfigLocation.SYSTEM_PROP);

    }

    @Test
    public void MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS384RelativeFile_test() throws Exception {
        genericGoodTest("sign_RS256_enc_RS384");
    }

    @Test
    public void MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS384RelativeFile_overriddenByServerXml_test() throws Exception {
        genericBadTest("sign_RS256_enc_RS384", "rs_server_AltConfigNotInApp_Bad_DecryptKeyLoc.xml", setEncryptMismatchKeyTypeExpectations(resourceServer, false));
    }
}
