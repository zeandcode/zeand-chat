
package zeand.chat.objects;

import java.io.Serializable;

/**
 *
 * @author Aditya Kresna Permana
 */
public class Message implements Serializable{
    private String computer_ip;
    private String computer_name;
    private String owner_name;
    private String message;

    public Message(String computer_ip, String computer_name, String owner_name, String message) {
        this.computer_ip = computer_ip;
        this.computer_name = computer_name;
        this.owner_name = owner_name;
        this.message = message;
    }

    public Message(String owner_name, String message) {
        this.owner_name = owner_name;
        this.message = message;
    }
    
    public Message(String message){
        this.message = message;
    }

    public String getComputer_ip() {
        return computer_ip;
    }

    public void setComputer_ip(String computer_ip) {
        this.computer_ip = computer_ip;
    }

    public String getComputer_name() {
        return computer_name;
    }

    public void setComputer_name(String computer_name) {
        this.computer_name = computer_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    
    
}
