/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JarcvisAdd;

import Arm.Armadura;
import Objeto.ObjDetectado;
import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class Jarvis {

    Armadura iron = new Armadura();
    private ArrayList<ObjDetectado> lista = new ArrayList();
    private double nivelDeBat;
 

    public void estadoBateria() {
        iron.nivelDeBateria();
        iron.volar(58);
        iron.nivelDeBateria();
      //  iron.cargarBateria();
        //iron.nivelDeBateria();
    }

    public void revisandoDispositivos() {
        System.out.println("---Revisando Dispositivos---");
        System.out.println("Guante derecho: " + iron.getD().toString());
        System.out.println("Guante izquierdo: " + iron.getI().toString());
        System.out.println("Bota derecha: " + iron.getDer().toString());
        System.out.println("Bota izquierda: " + iron.getIzq().toString());
        // iron.Reparar();
    }

    public void repararByJarvis() {
        int aleatorio = 1;
        do {
            aleatorio = (int) (Math.random() * 100);
          //  System.out.println("");
           // System.out.println("Dispositivo roto, reparar");
            iron.Reparar();
        } while (aleatorio > 30);
    }

    private ObjDetectado obj() {
        ObjDetectado ob1 = new ObjDetectado();
        ob1.setX((int) (Math.random() * 6));
        ob1.setY((int) (Math.random() * 6));
        ob1.setZ((int) (Math.random() * 6));
        ob1.setResistencia((int) (Math.random() * 1000));
        int a = (int) (Math.random() * 100);
        if (a < 49) {
            ob1.setHostil(true);
        }
        return ob1;
    }

    private void usarRadar() {
        int a1 = (int) (Math.random() * 9) + 1;
        int cont = 0;
        do {
            lista.add(obj());
            cont++;
        } while (cont != a1);

    }

    public void verObjetos() {
        usarRadar();
        for (ObjDetectado aux : lista) {
            System.out.println("Objeto " + lista.indexOf(aux));
            System.out.println(aux);
            aux.calcularDistancia();
            System.out.println("");
        }
    }

    public void destruirEnemigo() {
        ArrayList<ObjDetectado> enemigos = new ArrayList();
        if(iron.isNivelBat()){
        for (ObjDetectado aux : lista) {
            if (aux.isHostil()) {
                enemigos.add(aux);
                          }
        }
        System.out.println("---Destruir enemigos---");
        
        for (ObjDetectado ene : enemigos) {
            if (ene.getDistancia() < 5) {
                do {
                    iron.disparar(10);
                    if ((iron.getD().toString() == "Estado=true") && (iron.getI().toString() == "Estado=true")) {
                         
                        ene.setResistencia(ene.getResistencia() - ene.getDistancia() * 2);
                    } else {
                        ene.setResistencia(ene.getResistencia() - ene.getDistancia());
                    }
                } while (ene.getResistencia() > 0);
                System.out.println("Enemigo " + enemigos.indexOf(ene) + " destruido");
            }

        }
        }else{
            accionEvasiva();
        }
    }
    
    public void accionEvasiva(){
        System.out.println("Accion evasiva, volar a 10km");
        iron.volar(2);
    }

}
