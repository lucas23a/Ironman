/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;



/**
 *
 * @author Cristian
 */
public class ObjDetectado {
    private double x;
    private double y;
    private double z;
    private boolean hostil;
    private double resistencia;
    private double distancia;

    public ObjDetectado() {
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    
    public void calcularDistancia(){
        double res= Math.pow(x,2)+ Math.pow(y,2)+Math.pow(z,2) ;
        double resultado= Math.sqrt(res);
        distancia= resultado;
        System.out.println("Se encuentra a " +resultado+ " km");
    }

    @Override
    public String toString() {
        return "ObjDetectado{" + "Hostil=" + hostil + ", resistencia=" + resistencia + '}';
    }
    
    
}
