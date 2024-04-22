package com.minima.rosetta.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.minima.rosetta.endpoints.networkList;
import com.minima.rosetta.endpoints.networkStatus;

public class JettyServer {
	
	private Server server;

    public void start() throws Exception {
    	
    	int maxThreads = 100;
        int minThreads = 10;
        int idleTimeout = 120;

        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.addConnector(connector);

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        //Add all the handlers
        servletHandler.addServletWithMapping(BlockingServlet.class, "/status");
        servletHandler.addServletWithMapping(networkList.class, "/network/list");
        servletHandler.addServletWithMapping(networkStatus.class, "/network/status");
        
        server.start();
    }
    
    public void stop() throws Exception {
        server.stop();
    }
}
