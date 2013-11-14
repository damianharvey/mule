/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.api.config;

public interface DomainAwareConfigurationBuilder extends ConfigurationBuilder
{

    /**
     * TODO check how to avoid depending on Object
     * @param domainContext
     */
    public void setDomainContext(Object domainContext);

}
