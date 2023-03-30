/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arm;

/**
 *
 * @author Cristian
 */
public class Armadura implements Bateria {

    private String colorPrimario = "Rojo";
    private String colorSecundario = "Dorado";
    private int resistencia = 1000;
    private float Reactor = 998399908;
    private Bota izq = new Bota();
    Bota der = new Bota();
    // private Bota[] botas = new Bota[2];
    // private Guante[] guantes = new Guante[2];
    private Guante d = new Guante();
    private Guante i = new Guante();
    private Casco head;
    private boolean nivelBat= true;

    public Armadura() {
    }

    public Bota getIzq() {
        return izq;
    }

    public void setIzq(Bota izq) {
        this.izq = izq;
    }

    public Bota getDer() {
        return der;
    }

    public void setDer(Bota der) {
        this.der = der;
    }

    public Guante getD() {
        return d;
    }

    public void setD(Guante d) {
        this.d = d;
    }

    public Guante getI() {
        return i;
    }

    public void setI(Guante i) {
        this.i = i;
    }

    public Casco getHead() {
        return head;
    }

    public void setHead(Casco head) {
        this.head = head;
    }        

    public boolean isNivelBat() {
        return nivelBat;
    }

    public void setNivelBat(boolean nivelBat) {
        this.nivelBat = nivelBat;
    }

    
    public void caminar(int tiempo) {
        Reactor = Reactor - (izq.consumo * tiempo);
        Reactor = Reactor - (der.consumo * tiempo);
    }

    public void correr(int tiempo) {
        Reactor = Reactor - (izq.consumo * tiempo * 2);
        Reactor = Reactor - (der.consumo * tiempo * 2);
    }

    public void propulsarse(int tiempo) {
        Reactor = Reactor - (izq.consumo * tiempo * 3);
        Reactor = Reactor - (der.consumo * tiempo * 3);
        sufriendoDañosBotas();
    }

    public void volar(int tiempo) {
        Reactor = Reactor - (izq.consumo * tiempo * 3);       
        Reactor = Reactor - (der.consumo * tiempo * 3);
        Reactor = Reactor - (d.consumo * tiempo * 2);
        Reactor = Reactor - (i.consumo * tiempo * 2);
       ;
        sufriendoDañosGuantes();
        sufriendoDañosBotas();
    }

    public void disparar(int tiempo) {
        if(d.estado== true){
            Reactor = Reactor - (d.consumo * tiempo * 3);
        } 
        if(i.estado==true){
        Reactor = Reactor - (i.consumo * tiempo * 3);
        }
        sufriendoDañosGuantes();
    }

    public void enviarMsj() {
        System.out.println("1-Mensaje por consola");
        System.out.println("2-Mensaje por sintetizador");
        switch (head.leer.nextInt()) {
            case 1:
                head.consola();
                Reactor = Reactor - 10;
                break;
            case 2:
                head.sintetizador();
                Reactor = Reactor - 10;
                break;
            default:
                System.out.println("No valido");
                break;

        }
    }

    public void nivelDeBateria() {
        int max= Integer.MAX_VALUE;
       float porcentaje= Reactor/max *100;              
        System.out.println("El nivel de bateria es:" + porcentaje + "%");
        if(porcentaje<10){
            nivelBat=false;
        }
     //   if (Reactor < 10) {
       //     cargarBateria();
        //}
    }

    private void sufriendoDañosBotas() {
        int a1 = (int) (Math.random() * 100);
        int a2 = (int) (Math.random() * 100);
        if (a1 <= 30) {
            izq.estado = false;
        } else if (a2 <= 30) {
            der.estado = false;
        }
    }

    private void sufriendoDañosGuantes() {
        int a1 = (int) (Math.random() * 100);
        int a2 = (int) (Math.random() * 100);
        if (a1 <= 30) {
            i.estado = false;
        } else if (a2 <= 30) {
            d.estado = false;
        }
    }
    
    private boolean reparandoDaños(){
       // System.out.println("Dispositivo dañado, reparar");
        boolean x= false;
        int a1 = (int) (Math.random() * 100);
        if(a1<=40){
            x=true;
        }
        return x;
    }      
    
    public void Reparar(){
        if(izq.estado== false){
            izq.estado= reparandoDaños();
        }
        if(der.estado== false){
            der.estado=reparandoDaños();
        }
        if(i.estado== false){
            i.estado= reparandoDaños();
        }
        if(d.estado== false){
            d.estado= reparandoDaños();
        }
    }

    @Override
    public void cargarBateria() {
        Reactor = Integer.MAX_VALUE;
    }

}
