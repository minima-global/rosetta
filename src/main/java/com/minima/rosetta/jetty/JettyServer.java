package com.minima.rosetta.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.minima.rosetta.endpoints.accountBalance;
import com.minima.rosetta.endpoints.block;
import com.minima.rosetta.endpoints.blockTransaction;
import com.minima.rosetta.endpoints.constructionPreprocess;
import com.minima.rosetta.endpoints.networkList;
import com.minima.rosetta.endpoints.networkOptions;
import com.minima.rosetta.endpoints.networkStatus;

public class JettyServer {
	
	private Server server;

    public void start() throws Exception {
    	
    	int maxThreads = 20;
        int minThreads = 10;
        int idleTimeout = 120;

        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.addConnector(connector);

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        //Add all the handlers
        servletHandler.addServletWithMapping(networkList.class, "/network/list");
        servletHandler.addServletWithMapping(networkStatus.class, "/network/status");
        servletHandler.addServletWithMapping(networkOptions.class, "/network/options");
        
        servletHandler.addServletWithMapping(block.class, "/block");
        servletHandler.addServletWithMapping(blockTransaction.class, "/block/transaction");
        
        servletHandler.addServletWithMapping(accountBalance.class, "/account/balance");
        
        servletHandler.addServletWithMapping(constructionPreprocess.class, "/construction/preprocess");
        
        server.start();
    }
    
    public void stop() throws Exception {
        server.stop();
    }
}
