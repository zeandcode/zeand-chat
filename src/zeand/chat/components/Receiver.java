/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zeand.chat.components;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import zeand.chat.objects.Message;

/**
 * Extending from thread, so server can be running it self after jform is running
 * 
 * @author Aditya Kresna Permana
 */
public class Receiver extends Thread{

    protected JList listFriends = null;
    private static int SRV_PORT = 1806;
    public boolean listening = true;
    private List<ReceiverThreads> threadLists = new ArrayList<ReceiverThreads>();

    public Receiver(JList listFriends) {
        this.listFriends = listFriends;
        
        
    }
    
    

    /*
     * Running server and starting accept clients with thread
     */
    @Override
    public void run() {

        try {
            /*
             * Creating socket server and client, to waiting an connection
             */
            ServerSocket socketServer = new ServerSocket(SRV_PORT);

            /*
             * listening clients with creating a new thread
             */
            while (this.listening) {
                ReceiverThreads st = new ReceiverThreads(this, socketServer.accept());
                st.start();
                threadLists.add(st);
            }

        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * Stopping server and interupt all threads
     */
    public void interupt() throws InterruptedException{
        for (ReceiverThreads serverThreads : threadLists) {
            serverThreads.setInterupt(true);
        }
    }
    
    public Message getMessage(int clientNumber){
        return this.threadLists.get(clientNumber - 1).getMessage();
    }

    public static int getSRV_PORT() {
        return SRV_PORT;
    }

    public static void setSRV_PORT(int SRV_PORT) {
        Receiver.SRV_PORT = SRV_PORT;
    }
}