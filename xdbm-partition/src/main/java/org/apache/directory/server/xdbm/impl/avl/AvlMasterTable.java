/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 *
 */
package org.apache.directory.server.xdbm.impl.avl;


import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.directory.server.core.api.partition.index.MasterTable;
import org.apache.directory.shared.ldap.model.constants.SchemaConstants;
import org.apache.directory.shared.ldap.model.entry.Entry;


/**
 * TODO Make it so the master table does not extend table interface - not needed
 * with this single use of delete so we should just use containment.
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public class AvlMasterTable extends AvlTable<UUID, Entry> implements MasterTable
{
    private AtomicLong counter = new AtomicLong( 0 );
    
    
    public AvlMasterTable( String name, Comparator<UUID> keyComparator, Comparator<Entry> valComparator, 
        boolean dupsEnabled )
    {
        super( name, keyComparator, valComparator, dupsEnabled );
    }


    /**
     * {@inheritDoc}
     */
    public UUID getNextId( Entry entry ) throws Exception
    {
        String name = entry.get( SchemaConstants.ENTRY_UUID_AT ).getString();
        UUID uuid = UUID.fromString( name );
        return uuid; 
    }
    
    
    /**
     * {@inheritDoc}
     */
    public void resetCounter() throws Exception
    {
        
    }
}