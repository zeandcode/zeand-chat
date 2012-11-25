/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zeand.chat.objects;

/**
 *
 * @author divusi
 */
public class User {
    private String owner;
    private String ip_address;
    private String mac_address;

    public User(String owner, String ip_address, String mac_address) {
        this.owner = owner;
        this.ip_address = ip_address;
        this.mac_address = mac_address;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
}
