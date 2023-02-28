package Cipher;

import Codificar_descodificar.Codificar;
import Codificar_descodificar.Descodificar;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Imagenpanel extends JPanel {

    private final JTextArea area1;
    private final JButton BotonEncriptar;
    private final JButton BotonDesencriptar;
    private final JButton BotonLeerarchtxt;
    private final JButton BotonLeerarchvge;
    private final JTextArea area2;

    public Imagenpanel() {
        setLayout(new FlowLayout());
        area1 = new JTextArea(10, 15);
        add(area1);

        BotonEncriptar = new JButton("Encriptar");
        add(BotonEncriptar);

        BotonDesencriptar = new JButton("Desencriptar");
        add(BotonDesencriptar);

        area2 = new JTextArea(10, 15);
        add(area2);

        BotonLeerarchtxt = new JButton("Leer archivo desencriptado");
        add(BotonLeerarchtxt);

        BotonLeerarchvge = new JButton("Leer archivo encriptado");
        add(BotonLeerarchvge);

        BotonEncriptar.addActionListener(new Imagenpanel.HandlerEncriptar());
        BotonDesencriptar.addActionListener(new Imagenpanel.HandlerDesencriptar());
        BotonLeerarchtxt.addActionListener(new Imagenpanel.HandlerLeerTxt());
        BotonLeerarchvge.addActionListener(new Imagenpanel.HandlerLeerVge());
    }

    @Override
    public void paint(Graphics g) {
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/Binhack.jpg"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }

    private class HandlerEncriptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String str = "", temp = "", temp2 = "";
            str = area1.getText();
            String[] parts = str.split("\n");
            for (int i = 0; i < parts.length; i++) {
                temp2 = Codificar.paso1(parts[i]);
                temp = temp + "\n" + temp2;
            }
            temp = String.format("La palabra con codificacion es: %s", temp);
            area2.setText(temp);

            try {
                String contenido = temp;
                File file = new File("C:/Users/jonat/Desktop/Semestre 4/Topicos avanzados de programación/Tarea1.1/src/archivos/Texto_cifrado.vge");
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class HandlerDesencriptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String str = "", temp = "", temp2 = "";
            str = area1.getText();
            String[] parts = str.split("\n");
            for (int i = 0; i < parts.length; i++) {
                temp2 = Descodificar.paso2(parts[i]);
                temp = temp + "\n" + temp2;
            }
            temp = String.format("La palabra sin codificacion es: %s", temp);
            area2.setText(temp);

            try {
                String contenido = temp;
                File file = new File("C:/Users/jonat/Desktop/Semestre 4/Topicos avanzados de programación/Tarea1.1/src/archivos/Texto_decifrado.txt");
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class HandlerLeerTxt implements ActionListener {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File("C:/Users/jonat/Desktop/Semestre 4/Topicos avanzados de programación/Tarea1.1/src/archivos/Texto_decifrado.txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String guardar = "";
                String linea;
                while ((linea = br.readLine()) != null) {
                    guardar += " " + linea;
                }
                JOptionPane.showMessageDialog(null, guardar);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta 
                // una excepcion.
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private class HandlerLeerVge implements ActionListener {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File("C:/Users/jonat/Desktop/Semestre 4/Topicos avanzados de programación/Tarea1.1/src/archivos/Texto_cifrado.vge");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                String guardar = "";
                String linea;
                while ((linea = br.readLine()) != null) {
                    guardar += " " + linea;
                }
                JOptionPane.showMessageDialog(null, guardar);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // En el finally cerramos el fichero, para asegurarnos
                // que se cierra tanto si todo va bien como si salta 
                // una excepcion.
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
