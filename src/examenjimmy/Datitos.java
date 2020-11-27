package examenjimmy;

import java.io.Serializable;
import java.math.BigInteger;
/**
 *
 * @author Melyz
 */
public class Datitos implements Serializable{
    
    private int tamPrimo;
    private BigInteger n;
    private BigInteger q;
    private BigInteger p;
    private BigInteger totient;
    private BigInteger e;
    private BigInteger d;
    private String emisor;
    private int mensaje;
    private BigInteger[] msjCifrado;

    public Datitos(){
        
    }
    public Datitos(int tamPrimo, BigInteger n, BigInteger q, BigInteger p, BigInteger totient, BigInteger e, BigInteger d, String emisor) {
        this.tamPrimo = tamPrimo;
        this.n = n;
        this.q = q;
        this.p = p;
        this.totient = totient;
        this.e = e;
        this.d = d;
        this.emisor = emisor;
    }
    
    public int getTamPrimo() {
        return tamPrimo;
    }

    public void setTamPrimo(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public BigInteger getN() {
        return n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getTotient() {
        return totient;
    }

    public void setTotient(BigInteger totient) {
        this.totient = totient;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        return d;
    }

    public void setD(BigInteger d) {
        this.d = d;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public int getMensaje() {
        return mensaje;
    }

    public void setMensaje(int mensaje) {
        this.mensaje = mensaje;
    }

    public BigInteger[] getMsjCifrado() {
        return msjCifrado;
    }

    public void setMsjCifrado(BigInteger[] msjCifrado) {
        this.msjCifrado = msjCifrado;
    }
}
