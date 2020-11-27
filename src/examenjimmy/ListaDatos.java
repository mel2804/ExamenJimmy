package examenjimmy;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Melyz
 */
public class ListaDatos implements Serializable{
    
    private ArrayList<Datitos> Datos;
    private Archivo objArchivo = new Archivo();
    
    public ListaDatos(){
        Datos= new ArrayList<Datitos>();
    }
    
    public void addRSA(int tamPrimo, BigInteger n, BigInteger q, BigInteger p, BigInteger totient, BigInteger e, BigInteger d, String emisor){
        Datos = objArchivo.leer();
        Datitos obj = new Datitos(tamPrimo, n, q, p, totient, e,  d, emisor);
        Datos.add(obj);
    }
    
    public void addCifrado(int tamPrimo, BigInteger n, BigInteger q, BigInteger p, BigInteger totient, BigInteger e, BigInteger d, String emisor, int mensaje, BigInteger[] msjCifrado){
        Datos = objArchivo.leerCif();   
        Datitos obj = new Datitos(tamPrimo, n, q, p, totient, e,  d, emisor);
        obj.setMensaje(mensaje);
        obj.setMsjCifrado(msjCifrado);
        Datos.set(0,obj);
    }
    
    public void getDatosArch(){
    Datos = objArchivo.leer();
    if (Datos.isEmpty()){
        System.out.println("No hay nada unu");
    } else {
        System.out.println("Emisor: "+Datos.get(0).getEmisor());
        System.out.println("tamaño del primo: "+Datos.get(0).getTamPrimo());
        System.out.println("p: "+String.valueOf(Datos.get(0).getP()));
        System.out.println("q: "+Datos.get(0).getQ());
        System.out.println("n: "+Datos.get(0).getN());
        System.out.println("e: "+Datos.get(0).getE());
        System.out.println("d: "+Datos.get(0).getD());
        System.out.println("Totient: "+Datos.get(0).getTotient());
    }
    }
    
    public void getDescifrado(){
        Datos = objArchivo.leerCif(); 
        System.out.println("Mensajto: "+Datos.get(0).getMensaje());
        System.out.println("Cifrado: "+ String.valueOf(Datos.get(0).getMsjCifrado()));
    }
    
    public ArrayList<Datitos> getListaDatos() {
        return Datos;
    }

    public void setListaDatos(ArrayList<Datitos> ListaDatos) {
        this.Datos = Datos;
    }

    public Archivo getObjArchivo() {
        return objArchivo;
    }

    public void setObjArchivo(Archivo objArchivo) {
        this.objArchivo = objArchivo;
    }
    public void grabarRSA(){
        getObjArchivo().serializar(Datos);
    }
    
    public void grabarCifrado(){
        getObjArchivo().serializarCif(Datos);
    }
        
}
