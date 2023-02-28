package Test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author HP1
 */
public class CipherTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cipher.CipherFrame cft = new Cipher.CipherFrame();
        cft.setVisible(true);
        cft.setBounds(460, 270, 600, 250);
        cft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon img = new ImageIcon("Imagenes/HACK.jpg");
        cft.setIconImage(img.getImage());
    }
    
}
