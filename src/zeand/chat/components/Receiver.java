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
import zeand.chat.objects.Message;

/**
 * Extending from thread, so server can be running it self after jform is running
 * 
 * @author Aditya Kresna Permana
 */
public class Receiver extends Thread{

    private static int SRV_PORT = 1806;
    public boolean listening = true;
    private List<ReceiverThreads> threadLists = new ArrayList<ReceiverThreads>();

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
                ReceiverThreads st = new ReceiverThreads(socketServer.accept());
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
}
