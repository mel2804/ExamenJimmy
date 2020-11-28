package examenjimmy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Melyz
 */
public class Archivo{

    ArrayList<Datitos> DatosRecuperados = new ArrayList<Datitos>();
    
    public ArrayList<Datitos> leer() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("RSA.txt"));
            DatosRecuperados = (ArrayList<Datitos>) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Inicio...");
        }
        return DatosRecuperados;
    }
    
    public ArrayList leerCif() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("TextoCifrado.txt"));
            DatosRecuperados = (ArrayList) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("Inicio...");
        }
        return DatosRecuperados;
    }
    
    void serializar(ArrayList<Datitos> listaSeriar) {
        try {
            FileOutputStream out = new FileOutputStream("RSA.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(listaSeriar);
            objOut.close();
            System.out.println("Si salio uwu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    void serializarCif(ArrayList<Datitos> listaSeriar) {
        try {
            FileOutputStream out = new FileOutputStream("TextoCifrado.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(listaSeriar);
            objOut.close();
            System.out.println("Si salio uwu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
