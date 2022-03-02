package controllers;

import java.util.ArrayList;

import play.Logger;
import play.mvc.Http.Inbound;
import play.mvc.Http.Outbound;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Http.WebSocketFrame;
import play.mvc.WebSocketController;

public class MyWebSocket extends WebSocketController{
	
	public static void hello(String name) {
        outbound.send("Hello %s!", name);
    }
	
	static ArrayList<Inbound> inbounds = new ArrayList<Inbound>();
	static ArrayList<Outbound> outbounds = new ArrayList<Outbound>();
	
	public static void echo(){
		outbound.send("Chat abierto.");
		
		inbounds.add(inbound);
		outbounds.add(outbound);
		
        while(inbound.isOpen()){
        	WebSocketEvent e = await(inbound.nextEvent());
             
            if(e instanceof WebSocketFrame){
            	WebSocketFrame frame = (WebSocketFrame)e;
                  
                if(e != null) {//!e.isBinary
                	if(frame.textData.equals("quit")){
                    	outbound.send("Chat cerrado.");
                        disconnect();
                          
                    }else{
                    	for(int i = 0; i < inbounds.size(); i++) {
                    		outbounds.get(i).send("Tu: %s", frame.textData); 
                    	}
                    	 
                    }
                }
            }
            if(e instanceof WebSocketClose){
               Logger.info("Socket closed!");
           }
        }
    }
	
}
