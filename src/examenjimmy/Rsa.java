package examenjimmy;
/**
 *
 * @author porfi
 */
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Rsa extends Thread{
    
    //variables
    int tamanoPrimo;
    BigInteger n,q,p;
    BigInteger totient;
    BigInteger e,d;
    public JTextField JTFp,JTFq,JTFn,JTFphi,JTFd,JTFe;
    public JTextArea JTAmensaje;

    public Rsa(){}
    
    public Rsa(int tamanoPrimo, JTextField JTFp, JTextField JTFq, JTextField JTFn, JTextField JTFphi, JTextField JTFd, JTextField JTFe, JTextArea JTAmensaje) {
        this.tamanoPrimo = tamanoPrimo;
        this.JTFp = JTFp;
        this.JTFq = JTFq;
        this.JTFn = JTFn;
        this.JTFphi = JTFphi;
        this.JTFd = JTFd;
        this.JTFe = JTFe;
        this.JTAmensaje = JTAmensaje;
    }
    
    @Override
    public void run(){
        p = new BigInteger(tamanoPrimo, 10, new Random());
        do q = new BigInteger(tamanoPrimo, 10, new Random());
        while(q.compareTo(p)==0);
        System.out.println(p+"\n"+q);
        
        this.JTFp.setText(p.toString());
        this.JTFq.setText(q.toString());
    
        //n = pq
        n = p.multiply(q);
        //p(phi) = (p-1)(q-1)
        totient = p.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(q.subtract(BigInteger.valueOf(1)));
        //elegir el primo relativo menor a n 
        do e = new BigInteger(2*tamanoPrimo, new Random());
        while(e.compareTo(totient) != -1 || e.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0);
        //operacion modulo
        //d = e^1 mod totient
        d = e.modInverse(totient);
        
        System.out.println("holi");
        this.JTFd.setText(d.toString());
        this.JTFe.setText(e.toString());
        this.JTFn.setText(n.toString());
        this.JTFphi.setText(totient.toString());
    
    }
    
    /*public void generarPrimos(){
    
        p = new BigInteger(tamanoPrimo, 10, new Random());
        do q = new BigInteger(tamanoPrimo, 10, new Random());
        while(q.compareTo(p)==0);
        System.out.println(p+"\n"+q);
        
        this.JTFp.setText(p.toString());
        this.JTFq.setText(q.toString());
    
    }
    
    public void generarClaves(){
    
        //n = pq
        n = p.multiply(q);
        //p(phi) = (p-1)(q-1)
        totient = p.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(q.subtract(BigInteger.valueOf(1)));
        //elegir el primo relativo menor a n 
        do e = new BigInteger(2*tamanoPrimo, new Random());
        while(e.compareTo(totient) != -1 || e.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0);
        //operacion modulo
        //d = e^1 mod totient
        d = e.modInverse(totient);
        
        System.out.println("holi");
        this.JTFd.setText(d.toString());
        this.JTFe.setText(e.toString());
        this.JTFphi.setText(totient.toString());
        
    
    }*/
    
    public BigInteger[] encriptar(String mensaje, BigInteger e, BigInteger n){
        
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        //recorrerlo para asignarlo al temporal
        for (i = 0; i < bigdigitos.length; i++) {
            
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
            
        }
        //a cifrar
        BigInteger[] encriptado = new BigInteger[bigdigitos.length];
        
        for (i = 0; i < bigdigitos.length; i++) {
            
            encriptado[i] = bigdigitos[i].modPow(e, n);
            
        }
    
        return encriptado;
    
    }
    
    // decifrar el arrary del biginteger 
        
    public String desencriptado(BigInteger[] encriptado){
    
        BigInteger[] desencriptar = new BigInteger[encriptado.length];
        
        for (int i = 0; i < desencriptar.length; i++) {
            
            desencriptar[i] = encriptado[i].modPow(d, n);
            
        }
        
        char[] charArray = new char[desencriptar.length];
        
        for (int i = 0; i < charArray.length; i++) {
            
            charArray[i] = (char)(desencriptar[i].intValue());
            
        }
        
        return (new String(charArray));
    
    }

    public int getTamanoPrimo() {
        return tamanoPrimo;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getTotient() {
        return totient;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public void setTamanoPrimo(int tamanoPrimo) {
        this.tamanoPrimo = tamanoPrimo;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public void setTotient(BigInteger totient) {
        this.totient = totient;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }
    
    
}
