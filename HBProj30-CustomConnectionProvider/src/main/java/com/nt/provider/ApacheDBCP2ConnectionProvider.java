package com.nt.provider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

public class ApacheDBCP2ConnectionProvider  extends  UserSuppliedConnectionProviderImpl {
        private BasicDataSource bds;
        
        public ApacheDBCP2ConnectionProvider() {
        	System.out.println("ApacheDBCP2ConnectionProvider:: 0-param constructor");
		     bds=new BasicDataSource();
		     bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		     bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		     bds.setUsername("system");
		     bds.setPassword("manager");
		     bds.setMinIdle(10);
		     bds.setMaxIdle(100);
		}
        
        @Override
        public Connection getConnection() throws SQLException {
        	System.out.println("ApacheDBCP2ConnectionProvider.getConnection()");
                return  bds.getConnection();
        }
        
        @Override
        public void closeConnection(Connection conn) throws SQLException {
        	System.out.println("ApacheDBCP2ConnectionProvider.closeConnection()");
           conn.close();
        }
	   
	  
}
