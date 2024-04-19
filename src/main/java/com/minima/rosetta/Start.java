package com.minima.rosetta;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

/**
 * Hello world!
 *
 */
public class Start 
{	
	private static JettyServer mMainServer;
	
    public static void main( String[] args ) throws Exception
    {
    	
    	/*HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://127.0.0.1:10005/block");
        
        System.out.println(res.getContentAsString());
        
        client.stop();
    	*/
    	
        //Create and start server 
        /*mMainServer = new JettyServer();
        mMainServer.start();
		
        //Add a shutdown hook..
        Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				//Shutdown hook called..
				System.out.println("[!] Shutdown Hook..");
				
				//Shut down the whole system
				try {
					mMainServer.stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
    }
}
