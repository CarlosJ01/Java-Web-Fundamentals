package servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestLisener
 *
 */
@WebListener // => Crear un Lisener, monitoriar los eventos que se den en el contenedor 
public class RequestLisener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestLisener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)  { 
         System.out.println("Request destroy");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
    	System.out.println("Request created");
    }
	
}
