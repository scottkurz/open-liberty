/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.mp.jwt12.fat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.security.jwt.fat.mpjwt.MpJwt12FatConstants;

@RunWith(Suite.class)
@SuiteClasses({
//                // 1.1 tests running with 1.2 feature
//
//                AlwaysRunAndPassTest.class,
//                // Basic Functional tests
//                // -- These tests will run 3 times - tests that pass the token in the Authorization header
//                // -- will run using "Bearer <token>", "Token <token>", and "misc <token>" - the use of
//                // -- the config attribute authorizationHeaderPrefix will tell runtime what prefix to look for
//                MPJwtBasicTests.class,
//                // More targeted tests
//                MPJwtConfigUsingBuilderTests.class,
//                MPJwtApplicationAndSessionScopedClaimInjectionTests.class,
//                MPJwtLoginConfig_ignoreApplicationAuthMethodTrueTests.class,
//                MPJwtLoginConfig_ignoreApplicationAuthMethodFalseTests.class,
//                MPJwtNoMpJwtConfig.class,
//                // propagation tests
//                MPJwtPropagationTests_usingWebTarget.class,
//                MPJwtPropagationTests_notUsingWebTarget.class,
//                // mp-config specified in the applications
//                MPJwtMPConfigInApp_NoMPJwtConfigInServerXml_Tests.class,
//                MPJwtMPOtherSigAlgConfigInApp_SigAlgOnlyMPJwtConfigInServerXml_Tests.class,
//                MPJwtMPConfigInApp_BadIssuerMPJwtConfigInServerXml_Tests.class,
//                MPJwtMPConfigInApp_BadJwksUriMPJwtConfigInServerXml_Tests.class,
//                MPJwtMPConfigInApp_BadKeyNameMPJwtConfigInServerXml_Tests.class,
//                MPJwtMPConfigInApp_GoodMPJwtConfigInServerXml_Tests.class,
//                // mp-config specified as system properties
//                MPJwtGoodMPConfigAsSystemProperties_UsePublicKey_NoKeyLoc.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseKeyLoc.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseJwksUri_X509.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseJwksUri_JWK.class,
//                MPJwtBadMPConfigAsSystemProperties.class,
//                MPJwtGoodMPConfigAsSystemProperties_UseRS384PublicKey_NoKeyLoc.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseKeyLocES2564Url.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseKeyLocES384File.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseKeyLocES512RelativeFile.class,
//                MPJwtGoodMPConfigAsSystemProperties_NoPublicKey_UseKeyLocRS512JwksUri.class,
//                // mp-config specified as env vars
//                MPJwtGoodMPConfigAsEnvVars_UsePublicKey_NoKeyLoc.class,
//                MPJwtGoodMPConfigAsEnvVars_UseES384PublicKey_NoKeyLoc.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseKeyLocRS384Url.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseKeyLocRS512File.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseKeyLocES256RelativeFile.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseKeyLocES512JwksUri.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseKeyLoc.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseJwksUri_X509.class,
//                MPJwtGoodMPConfigAsEnvVars_NoPublicKey_UseJwksUri_JWK.class,
//                MPJwtBadMPConfigAsEnvVars.class,

//                // 1.2 tests
                MPJwt12ConfigUsingBuilderTests.class,
//                // mp-config specified in applications
//                MPJwt12MPConfigInApp_Tests.class,
//                // mp-config specified as system properties
//                MPJwtGoodMP12ConfigAsSystemProperties_HeaderAuthorization.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_HeaderCookie.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_HeaderCookie_withCookieName.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_Audiences.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_Algorithm.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS384RelativeFile.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_RS256Jwk.class,
//                MPJwtGoodMP12ConfigAsSystemProperties_decryptKeyLoc_AlternateDecryptSettings.class,
//                // mp-config specified as env vars
//                MPJwtGoodMP12ConfigAsEnvVars_HeaderAuthorization.class,
//                MPJwtGoodMP12ConfigAsEnvVars_HeaderCookie.class,
//                MPJwtGoodMP12ConfigAsEnvVars_HeaderCookie_withCookieName.class,
//                MPJwtGoodMP12ConfigAsEnvVars_Audiences.class,
//                MPJwtGoodMP12ConfigAsEnvVars_Algorithm.class,
//                MPJwtGoodMP12ConfigAsEnvVars_decryptKeyLoc_RS256File.class,
//                MPJwtGoodMP12ConfigAsEnvVars_decryptKeyLoc_RS512Url.class,
//                MPJwtGoodMP12ConfigAsEnvVars_decryptKeyLoc_RS256PlainText.class,
//                MPJwtGoodMP12ConfigAsEnvVars_decryptKeyLoc_AlternateDecryptSettings.class,
//
//                // Ensure 1.2 function not available with only 1.1 Feature enabled
//                Feature11Enabled_ConfigInAppTests.class,
//                Feature11Enabled_ConfigInServerXmlTests.class,
//                Feature11Enabled_MpConfigAsEnvVars.class,
//                Feature11Enabled_MpConfigAsSystemProperties.class
})

public class FATSuite {

    public static String authHeaderPrefix = MpJwt12FatConstants.TOKEN_TYPE_BEARER;

}
