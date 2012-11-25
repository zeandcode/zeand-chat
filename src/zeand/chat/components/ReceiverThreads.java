package zeand.chat.components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import zeand.chat.objects.Message;
import zeand.chat.objects.User;

/**
 *
 * @author Aditya Kresna Permana
 */
public class ReceiverThreads extends Thread {
    private Receiver parent = null;
    private boolean is_interupted = false;
    private Socket socketClient = null;
    private static ObjectInputStream OIS = null;
    private Message msg = null;
    private User usr = null;

    public ReceiverThreads(Receiver parent, Socket socketClient) {
        super("Server Thread");
        this.parent = parent;
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
            usr = (User) OIS.readObject();
            
            DefaultListModel listModel = (DefaultListModel) parent.listFriends.getModel();
            listModel.addElement(usr.getOwner());

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