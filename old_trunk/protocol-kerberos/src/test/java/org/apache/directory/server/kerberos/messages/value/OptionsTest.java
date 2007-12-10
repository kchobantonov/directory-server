/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.directory.server.kerberos.messages.value;


import java.util.Arrays;

import junit.framework.TestCase;

import org.apache.directory.server.kerberos.shared.messages.value.KdcOptions;
import org.apache.directory.server.kerberos.shared.messages.value.TicketFlags;


/**
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$, $Date$
 */
public class OptionsTest extends TestCase
{
    private byte[] fpriOptions =
        { ( byte ) 0x50, ( byte ) 0x00, ( byte ) 0x00, ( byte ) 0x10 };


    /**
     * Tests converting the ticket flags to a descriptive String.
     */
    public void testToString()
    {
        TicketFlags flags = new TicketFlags();
        flags.set( TicketFlags.FORWARDABLE );
        flags.set( TicketFlags.PROXIABLE );
        flags.set( TicketFlags.RENEWABLE );
        flags.set( TicketFlags.INITIAL );
        assertEquals( flags.toString(), "FORWARDABLE PROXIABLE RENEWABLE INITIAL" );
    }


    /**
     * Tests that setting flags is idempotent.
     */
    public void testDuplicateSetting()
    {
        TicketFlags flags = new TicketFlags();
        flags.set( TicketFlags.MAY_POSTDATE );
        flags.set( TicketFlags.FORWARDABLE );
        flags.set( TicketFlags.PROXIABLE );
        flags.set( TicketFlags.MAY_POSTDATE );
        flags.set( TicketFlags.RENEWABLE );
        assertEquals( flags.toString(), "FORWARDABLE PROXIABLE MAY_POSTDATE RENEWABLE" );
    }


    /**
     * Tests the basic construction of the {@link KdcOptions}.
     */
    public void testConstruction()
    {
        KdcOptions options = new KdcOptions( fpriOptions );
        assertTrue( Arrays.equals( options.getBytes(), fpriOptions ) );
    }
}
