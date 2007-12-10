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

package org.apache.directory.server.dhcp.options.misc;


import org.apache.directory.server.dhcp.options.AddressListOption;


/**
 * The IRC server option specifies a list of IRC available to the
 * client.  Servers SHOULD be listed in order of preference.
 * 
 * The code for the IRC server option is 74.  The minimum length for
 * this option is 4 octets, and the length MUST always be a multiple of
 * 4.
 * 
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$, $Date$
 */
public class DefaultIrcServers extends AddressListOption
{
    /**
     * Creates a new instance of DefaultIrcServers.
     *
     * @param defaultIrcServer
     */
    public DefaultIrcServers( byte[] defaultIrcServer )
    {
        super( 74, defaultIrcServer );
    }
}
