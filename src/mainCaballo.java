/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandra
 */
public class mainCaballo {
    //x eje vertical
    //y eje horizontal
   public static void main(String[] snitch) {
        ProblemaCaballo caballo = new ProblemaCaballo(1,1);
        caballo.resolverProblema();
        caballo.mostrarTablero();
    }
}
