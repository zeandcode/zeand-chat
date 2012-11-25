/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zeand.chat;

import javax.swing.SwingUtilities;
import zeand.chat.forms.MainForm;

/**
 *
 * @author divusi
 */
public class ZeandChat {
    
    public static void main(String args[]){
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainForm m = new MainForm();
                m.setVisible(true);
            }
        });
        
    }
    
}
