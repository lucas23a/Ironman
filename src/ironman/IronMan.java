
package ironman;

import Arm.Armadura;
import JarcvisAdd.Jarvis;


public class IronMan {

    public static void main(String[] args) {
        Jarvis sistema = new Jarvis();
        sistema.estadoBateria();
        System.out.println("");
        sistema.revisandoDispositivos();
        System.out.println("");
        sistema.repararByJarvis();
        System.out.println("");
        sistema.revisandoDispositivos();
        System.out.println(" ");
        sistema.verObjetos();
        sistema.destruirEnemigo();
        

    }

}
