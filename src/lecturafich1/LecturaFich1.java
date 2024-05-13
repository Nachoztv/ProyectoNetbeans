/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecturafich1;

import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class LecturaFich1 {
//Cuando detecta una letra igual que la pasada como paramametro la cambia por la letra introducida.
    public void copyFile(String sourceFilePath, String destFilePath)
            throws IOException {
        // Declaramos o reader e o writer
        Console c = System.console();
        FileReader in = null;
        FileWriter out = null;
        try {
            // Abrimos o reader e o writer
            in = new FileReader(sourceFilePath);
            out = new FileWriter(destFilePath);
            // Usamos os métodos read e write para ler e escribir caracter a caracter
            Scanner scan = new Scanner(c.reader());
            System.out.println("Introduce el caracter para reemplazar!!!");
            char thirdChar = scan.next().charAt(0);
            int oneChar;
            while ((oneChar = in.read()) != -1) {
                if (oneChar == 'a') {
                    oneChar = thirdChar;
                }
                out.write(oneChar);
            }
        } finally {
            // En calquera caso, producirase ou non unha excepción, pechamos o
            // reader e o writer se están abertos
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * @param args the command line arguments
     *  llama al metodo copyfile pasandole como parametro origen el archivo y como destino el archivo mas .copia
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LecturaFich1 fich1 = new LecturaFich1();

        try {
            fich1.copyFile(args[0], args[0] + ".copia");
        } catch (IOException ex) {
            Logger.getLogger(LecturaFich1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
