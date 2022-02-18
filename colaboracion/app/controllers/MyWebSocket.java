package controllers;

import play.Logger;
import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Http.WebSocketFrame;
import play.mvc.WebSocketController;
import play.libs.WS;
import play.libs.F;

public class MyWebSocket extends WebSocketController{
	
	public static void hello(String name) {
        outbound.send("Hello %s!", name);
    }
	
//	public static void chat(String message) {
//        outbound.send("-", message);
//    }
	
	/*public static void echo2() {
	    while(inbound.isOpen()) {
	       WebSocketEvent e = await(inbound.nextEvent());
	         
	       for(String quit: TextFrame.and(
	    		   Equals("quit")).match(e)) {
	           outbound.send("Bye!");
	           disconnect();
	       }
	 
	       for(String message: TextFrame.match(e)) {
	           outbound.send("Echo: %s", message);
	       }
	         
	       for(WebSocketClose closed: SocketClosed.match(e)) {
	           Logger.info("Socket closed!");
	       }
	    }
	}*/
	
	public static void echo(){
        while(inbound.isOpen()){
        	WebSocketEvent e = await(inbound.nextEvent());
             
            if(e instanceof WebSocketFrame){
            	WebSocketFrame frame = (WebSocketFrame)e;
                  
                if(e != null) {//!e.isBinary
                	if(frame.textData.equals("quit")){
                    	outbound.send("Bye!");
                        disconnect();
                          
                    }else{
                        outbound.send("Echo: %s", frame.textData); 
                    }
                }
           }
           if(e instanceof WebSocketClose){
               Logger.info("Socket closed!");
           }
        }
    }
	
}
