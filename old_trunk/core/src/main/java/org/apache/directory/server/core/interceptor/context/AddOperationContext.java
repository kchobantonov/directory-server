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
package org.apache.directory.server.core.interceptor.context;

import javax.naming.directory.Attributes;

import org.apache.directory.shared.ldap.name.LdapDN;
import org.apache.directory.shared.ldap.util.AttributeUtils;

/**
 * A Add context used for Interceptors. It contains all the informations
 * needed for the add operation, and used by all the interceptors
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$, $Date$
 */
public class AddOperationContext extends AbstractOperationContext
{
    /** The added Attribute  */
    private Attributes entry;
    
    /**
     * 
     * Creates a new instance of AddOperationContext.
     *
     */
    public AddOperationContext()
    {
    	super();
    }

    /**
     * 
     * Creates a new instance of AddOperationContext.
     *
     */
    public AddOperationContext( LdapDN dn )
    {
        super( dn );
    }

    /**
     * 
     * Creates a new instance of ModifyOperationContext.
     *
     */
    public AddOperationContext( LdapDN dn, Attributes entry )
    {
    	super( dn );
        this.entry = entry;
    }

	/**
	 * @return The added attributes
	 */
	public Attributes getEntry() 
	{
		return entry;
	}

	/**
	 * Set the added attributes
	 * @param entry The added attributes
	 */
	public void setEntry( Attributes entry ) 
	{
		this.entry = entry;
	}

	/**
     * @see Object#toString()
     */
    public String toString()
    {
        return "AddContext for DN '" + getDn().getUpName() + "'" +
        ", added entry: " + AttributeUtils.toString( entry ); 
    }
}
