/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 *
 * @author pedro
 */
public class listener implements ServletContextListener,HttpSessionListener{

    ServletContext servletContext;
    private static int count = 0;
   
    @Override
    public void contextInitialized(ServletContextEvent sce){
        //nada ainda
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        //nada ainda
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this){
            count++;
        }
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this){
            if(count > 0 ){
                count--;
            }
        }
    }

    public static int getNumeroUsuarios() {
        return count;
    }
}
