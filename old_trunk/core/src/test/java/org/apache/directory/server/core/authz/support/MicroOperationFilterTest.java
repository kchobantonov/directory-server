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
package org.apache.directory.server.core.authz.support;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.directory.server.core.authz.support.MicroOperationFilter;
import org.apache.directory.server.core.authz.support.OperationScope;
import org.apache.directory.shared.ldap.aci.ACITuple;
import org.apache.directory.shared.ldap.aci.AuthenticationLevel;
import org.apache.directory.shared.ldap.aci.MicroOperation;
import org.apache.directory.shared.ldap.aci.ProtectedItem;
import org.apache.directory.shared.ldap.aci.UserClass;


/**
 * Tests {@link MicroOperationFilter}.
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$, $Date$
 */
public class MicroOperationFilterTest extends TestCase
{
    private static final Collection<ACITuple> EMPTY_ACI_TUPLE_COLLECTION = Collections.unmodifiableCollection( new ArrayList<ACITuple>() );
    private static final Collection<UserClass> EMPTY_USER_CLASS_COLLECTION = Collections.unmodifiableCollection( new ArrayList<UserClass>() );
    private static final Collection<ProtectedItem> EMPTY_PROTECTED_ITEM_COLLECTION = Collections.unmodifiableCollection( new ArrayList<ProtectedItem>() );

    private static final Set<MicroOperation> USER_OPERATIONS_A = new HashSet<MicroOperation>();
    private static final Set<MicroOperation> USER_OPERATIONS_B = new HashSet<MicroOperation>();
    private static final Set<MicroOperation> TUPLE_OPERATIONS = new HashSet<MicroOperation>();

    static
    {
        USER_OPERATIONS_A.add( MicroOperation.ADD );
        USER_OPERATIONS_A.add( MicroOperation.BROWSE );
        USER_OPERATIONS_B.add( MicroOperation.COMPARE );
        USER_OPERATIONS_B.add( MicroOperation.DISCLOSE_ON_ERROR );
        TUPLE_OPERATIONS.add( MicroOperation.ADD );
        TUPLE_OPERATIONS.add( MicroOperation.BROWSE );
        TUPLE_OPERATIONS.add( MicroOperation.EXPORT );
    }


    public void testZeroTuple() throws Exception
    {
        MicroOperationFilter filter = new MicroOperationFilter();

        Assert.assertEquals( 0, filter.filter( EMPTY_ACI_TUPLE_COLLECTION, OperationScope.ATTRIBUTE_TYPE_AND_VALUE, 
            null, null, null, null, null, null, null, null, null, null ).size() );
    }


    public void testOneTuple() throws Exception
    {
        MicroOperationFilter filter = new MicroOperationFilter();
        Collection<ACITuple> tuples = new ArrayList<ACITuple>();
        
        tuples.add( new ACITuple( EMPTY_USER_CLASS_COLLECTION, AuthenticationLevel.NONE, EMPTY_PROTECTED_ITEM_COLLECTION, 
            TUPLE_OPERATIONS, true, 0 ) );

        Assert.assertEquals( 1, filter.filter( tuples, OperationScope.ENTRY, null, null, null, null, null, null, null,
            null, null, USER_OPERATIONS_A ).size() );
        Assert.assertEquals( 0, filter.filter( tuples, OperationScope.ENTRY, null, null, null, null, null, null, null,
            null, null, USER_OPERATIONS_B ).size() );
    }
}
