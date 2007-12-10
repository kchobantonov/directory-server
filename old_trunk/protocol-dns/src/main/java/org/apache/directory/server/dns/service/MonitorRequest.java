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
package org.apache.directory.server.dns.service;


import org.apache.directory.server.dns.messages.DnsMessage;
import org.apache.mina.common.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$, $Date$
 */
public class MonitorRequest extends MonitorMessage
{
    /** the log for this class */
    private static final Logger log = LoggerFactory.getLogger( MonitorRequest.class );

    public void execute( NextCommand next, IoSession session, Object message ) throws Exception
    {
        if ( log.isDebugEnabled() )
        {
            try
            {
                DnsMessage request = (DnsMessage) message;

                log.debug( monitorMessage( request, "request" ) );
            }
            catch ( Exception e )
            {
                // This is a monitor.  No exceptions should bubble up.
                log.error( "Error in request monitor", e );
            }
        }

        next.execute( session, message );
    }
}
