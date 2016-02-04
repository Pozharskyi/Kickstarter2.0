package com.ivanpozharskyi.kickstarter2.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;






public class DataSourse {
	private static volatile DataSourse instance;
    private DataSource dSrc;
//    private static Logger log = Logger.getLogger(MySQLConnectionsFactory.class.getName()); 

    private DataSourse(){
//        log.log(Level.INFO,"MySQLConnectionsFactory: instance created.");
        Context initialCtx = null;
        Context envCtx = null;
        
        try {
//        	InitialContext ic = new InitialContext();
//        	String dsName = "java:comp/env/jdbc/kickstarter";
//        	DataSource ds = (javax.sql.DataSource)ic.lookup(dsName);
        	
            initialCtx =  new InitialContext();
            envCtx =(Context) initialCtx.lookup("java:comp/env");
            dSrc = (DataSource) envCtx.lookup("jdbc/kickstarter");
//            log.log(Level.INFO,"MySQLConnectionsFactory: DataSource acquired.");
        } catch (NamingException ex) {
//            log.log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static DataSourse getInstance(){
        DataSourse localInst = instance;
        if (localInst == null){
            synchronized (DataSourse.class){
                localInst = instance;
                if (localInst == null){
                    instance = localInst = new DataSourse();
                }
            }
        }
        return localInst;
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = dSrc.getConnection();
        } catch (SQLException ex) {
//            log.log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
