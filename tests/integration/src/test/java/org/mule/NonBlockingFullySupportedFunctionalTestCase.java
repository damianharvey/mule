/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.construct.Flow;
import org.mule.tck.functional.EventCallback;
import org.mule.tck.functional.FlowAssert;
import org.mule.tck.functional.FunctionalTestComponent;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.util.concurrent.Latch;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class NonBlockingFullySupportedFunctionalTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigFile()
    {
        return "non-blocking-fully-supported-test-config.xml";
    }

    @Test
    public void defaultFlow() throws Exception
    {
        testFlowNonBlocking("defaultFlow");
    }

    @Test
    public void nonBlockingFlow() throws Exception
    {
        testFlowNonBlocking("nonBlockingFlow");
    }

    @Test
    public void subFlow() throws Exception
    {
        testFlowNonBlocking("subFlow");
    }

    @Test
    public void childFlow() throws Exception
    {
        testFlowNonBlocking("childFlow");
    }

    @Test
    public void processorChain() throws Exception
    {
        testFlowNonBlocking("processorChain");
    }

    @Test
    public void filter() throws Exception
    {
        testFlowNonBlocking("filter");
    }

    @Test
    public void securityFilter() throws Exception
    {
        testFlowNonBlocking("security-filter");
    }

    @Test
    public void transformer() throws Exception
    {
        testFlowNonBlocking("transformer");
    }

    @Test
    public void choice() throws Exception
    {
        testFlowNonBlocking("choice");
    }

    @Test
    public void enricher() throws Exception
    {
        testFlowNonBlocking("enricher");
    }

}

