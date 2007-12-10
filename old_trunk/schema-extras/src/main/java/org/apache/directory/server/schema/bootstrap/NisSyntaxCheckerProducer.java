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
package org.apache.directory.server.schema.bootstrap;


import javax.naming.NamingException;

import org.apache.directory.server.schema.bootstrap.AbstractBootstrapProducer;
import org.apache.directory.server.schema.bootstrap.ProducerCallback;
import org.apache.directory.server.schema.bootstrap.ProducerTypeEnum;
import org.apache.directory.server.schema.registries.Registries;
import org.apache.directory.shared.ldap.schema.syntax.AcceptAllSyntaxChecker;
import org.apache.directory.shared.ldap.schema.syntax.SyntaxChecker;


/**
 * A producer of SyntaxChecker objects for the nis schema.
 * Modified by hand from generated code
 *
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 * @version $Rev$
 */
public class NisSyntaxCheckerProducer extends AbstractBootstrapProducer
{
    public NisSyntaxCheckerProducer()
    {
        super( ProducerTypeEnum.SYNTAX_CHECKER_PRODUCER );
    }


    // ------------------------------------------------------------------------
    // BootstrapProducer Methods
    // ------------------------------------------------------------------------

    /**
     * @see org.apache.directory.server.schema.bootstrap.BootstrapProducer#produce(Registries, org.apache.directory.server.schema.bootstrap.ProducerCallback)
     */
    public void produce( Registries registries, ProducerCallback cb ) throws NamingException
    {
        SyntaxChecker syntaxChecker;

        /*
         * We are going to need a syntax checker for each and every one of
         * these syntaxes.  However right now we're probably not going to be
         * turning on syntax checking or are not as interested in it.  So we
         * can put in place simple do nothing syntax checkers - which is really
         * the binary syntax checker.
         */

        // 1.3.6.1.1.1.0.0 - RFC2307 NIS Netgroup Triple
        syntaxChecker = new AcceptAllSyntaxChecker( "1.3.6.1.1.1.0.0" );
        cb.schemaObjectProduced( this, syntaxChecker.getSyntaxOid(), syntaxChecker );

        // 1.3.6.1.1.1.0.1 - RFC2307 Boot Parameter Syntax
        syntaxChecker = new AcceptAllSyntaxChecker( "1.3.6.1.1.1.0.1" );
        cb.schemaObjectProduced( this, syntaxChecker.getSyntaxOid(), syntaxChecker );
    }
}
