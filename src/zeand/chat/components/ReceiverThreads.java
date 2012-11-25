package zeand.chat.components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import zeand.chat.objects.Message;

/**
 *
 * @author Aditya Kresna Permana
 */
public class ReceiverThreads extends Thread {

    private boolean is_interupted = false;
    private Socket socketClient = null;
    private static ObjectInputStream OIS = null;
    private static int SLEEPTIME = 2000;
    private Message msg = null;

    public ReceiverThreads(Socket socketClient) {
        super("Server Thread");
        this.socketClient = socketClient;
    }

    @Override
    public void run() {

        try {
            /*
             * Creating new stream to read an stream
             */
            OIS = new ObjectInputStream(socketClient.getInputStream());

            /*
             * Casting and Reading object
             */
            msg = (Message) OIS.readObject();


        } catch (IOException ex) {
            Logger.getLogger(ReceiverThreads.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceiverThreads.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Set interupted status
     *
     * @param boolean status
     * @return void
     */
    public void setInterupt(boolean status) {
        this.is_interupted = status;
    }

    /**
     * Get a message from client
     *
     * @return Message
     */
    public Message getMessage() {
        return msg;
    }
}
