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

/**
 *
 * @author Aditya Kresna Permana
 */
public class Sender {

    private static String SRV_IP = "127.0.0.1";
    private static int SRV_PORT = 1806;
    private static ObjectOutputStream OOS = null;

    public static void main(String args[]) {
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
             * Creating an object and sending over stream
             */
            Message m = new Message("Test Message one");
            OOS.writeObject(m);
            
            /*
             * Output message
             */
//            System.out.println("Sending objects...");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
