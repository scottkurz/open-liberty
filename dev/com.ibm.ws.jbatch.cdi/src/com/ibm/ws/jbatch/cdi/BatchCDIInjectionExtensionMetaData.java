/**
 * Copyright 2022 International Business Machines Corp.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.ws.jbatch.cdi;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.Extension;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import io.openliberty.cdi.spi.CDIExtensionMetadata;

/**
 * Use the marker interface to register via DS within Open Liberty, but we 
 * provide our logic through the application Extension interface methods.
 */
@Component(service = CDIExtensionMetadata.class, configurationPolicy = ConfigurationPolicy.IGNORE, immediate = true, property = { "api.classes=" +
                                                                                                                 "javax.batch.api.BatchProperty;" +
                                                                                                                 "javax.batch.operations.JobOperator;" +
                                                                                                                 "javax.batch.runtime.context.JobContext;" +
                                                                                                                 "javax.batch.runtime.context.StepContext",
                                                                                                                 "service.vendor=IBM" })
public class BatchCDIInjectionExtensionMetaData implements CDIExtensionMetadata {

    public Set<Class<? extends Extension>> getExtensions() {
        
        final Set<Class<? extends Extension>> t = new HashSet<Class<? extends Extension>>();
        t.add(BatchCDIInjectionExtension.class);
        return Collections.unmodifiableSet(t);
    }

}
