/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjimmy;

import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 *
 * @author porfi
 */
public class Datos {
    
    int tamano;
    public JTextField p,q,n,phi,d,e;
    public JTextArea mensaje;

    public Datos(int tamano, JTextField p, JTextField q, JTextField n, JTextField phi, JTextField d, JTextField e, JTextArea mensaje) {
        this.tamano = tamano;
        this.p = p;
        this.q = q;
        this.n = n;
        this.phi = phi;
        this.d = d;
        this.e = e;
        this.mensaje = mensaje;
    
        Rsa rsa = new Rsa(tamano,p,q,n,phi,d,e,mensaje);
        rsa.start();
        
    }    
}
