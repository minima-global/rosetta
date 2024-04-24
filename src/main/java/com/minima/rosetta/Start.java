package com.minima.rosetta;

import com.minima.rosetta.jetty.JettyServer;
import com.minima.rosetta.testchain.testminima;

/**
 * Hello world!
 *
 */
public class Start 
{	
	/**
	 * The Main Jetty Server used to accept POST requests
	 */
	private static JettyServer mMainServer;
	
	public static final String mVersion = "0.1.0";
	
    public static void main( String[] args ) throws Exception
    {
    	Log.log("Rosetta Server version : "+mVersion);
    	
    	/*HttpClient client = new HttpClient();
        client.start();
        ContentResponse res = client.GET("http://127.0.0.1:10005/block");
        System.out.println(res.getContentAsString());
        client.stop();*/
    	
        //Create and start server 
        mMainServer = new JettyServer();
        mMainServer.start();
		
        testminima.getTestMinima().start();
        
        //Add a shutdown hook..
        Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run(){
				//Shutdown hook called..
				Log.log("[!] Rosetta Shutdown Hook..");
				
				//Shut down the whole system
				try {
					mMainServer.stop();
					
					testminima.getTestMinima().stop();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
    }
}
