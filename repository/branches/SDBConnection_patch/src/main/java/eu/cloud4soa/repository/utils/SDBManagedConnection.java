/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package eu.cloud4soa.repository.utils;

import com.hp.hpl.jena.sdb.sql.JDBC;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Connection;

/**
 * An managed SDB connection that borrows the connection from the current hibernate session.
 *
 * Semantic repository operations must be wrapped in a transaction.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SDBManagedConnection extends SDBConnection {

    private static final Logger logger = LoggerFactory.getLogger(SDBManagedConnection.class);

    public SDBManagedConnection() {
        super(JDBC.jdbcNone, null, null);
    }

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * This should never be called.
     */
    @Override
    public void close() {
        logger.debug("Closing SDBManagedConnection with no effect.");
    }

    /**
     * Override connection allocation using the hibernate managed connection.
     *
     * @return Connection to be used to access the semantic repository relational backend
     */
    @Override
    public Connection getSqlConnection() {
        // avoid NPE at startup bean initialization
        if (sessionFactory == null)
            // this is in fact null
            return super.getSqlConnection();
        else {
            return sessionFactory.getCurrentSession().connection();
        }
    }
}
