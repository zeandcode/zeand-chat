/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zeand.chat.components;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import zeand.chat.objects.Message;
import zeand.chat.objects.User;

/**
 *
 * @author Aditya Kresna Permana
 */
public class Sender {

    private User u = null;
    private ObjectOutputStream OOS = null;
    private String SRV_IP = "127.0.0.1";
    private int SRV_PORT = 1806;

    public Sender(User u) {
        this.u = u;
    }

    public String getSRV_IP() {
        return SRV_IP;
    }

    public void setSRV_IP(String SRV_IP) {
        this.SRV_IP = SRV_IP;
    }

    public int getSRV_PORT() {
        return SRV_PORT;
    }

    public void setSRV_PORT(int SRV_PORT) {
        this.SRV_PORT = SRV_PORT;
    }

    public void run() {
        try {
            /*
             * Creating socket Client
             */
            Socket socketClient = new Socket(SRV_IP, SRV_PORT);
            
            /*
             * Creating a Stream for sending an object
             */
            OOS = new ObjectOutputStream(socketClient.getOutputStream());
            
            /*
             * Sending user first
             */
            OOS.writeObject(u);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send(Message m) throws IOException {
        /*
         * Creating an object and sending over stream
         */
        OOS.writeObject(m);
    }
    
    public static void main(String args[]){
        new Sender(new User("Aditya", "localhost", "mac")).run();
    }
}