package Cipher;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 *
 * @author HP1
 */ 
public class CipherFrame extends JFrame {
    
    Imagenpanel panel = new Imagenpanel();
    
    public CipherFrame() {
        super("Cipher Demo");
        this.add(panel,BorderLayout.CENTER);
        this.setLocationRelativeTo(null);    
    }

    
}
