/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaAgenteViajero;

/**
 *
 * @author Alejandra
 */
public class mainTSP {
    public static void main(String[] args) {
       TSP g = new TSP("abcdef");
        g.introducirRuta('a','b', 5);
        g.introducirRuta('a','e', 78);
        g.introducirRuta('a','f',15);
        g.introducirRuta('b','c', 89);
        g.introducirRuta('b','e', 3);
        g.introducirRuta('c','d', 6);
        g.introducirRuta('c','e', 67);
        g.introducirRuta('c','f', 58);
        g.introducirRuta('d','f', 30);
        g.introducirRuta('e','f', 22);
       
        String respuesta = g.buscarRuta('a', 'e');
        System.out.println(respuesta);
        
        TSP p = new TSP("zxywtr");
        p.introducirRuta('z','x', 5);
        p.introducirRuta('z','y', 78);
        p.introducirRuta('z','w',15);
        p.introducirRuta('z','t', 89);
        p.introducirRuta('z','r', 3);
        p.introducirRuta('x','y', 6);
        p.introducirRuta('x','w', 67);
        p.introducirRuta('x','t', 58);
        p.introducirRuta('x','r', 30);
        p.introducirRuta('y','w', 2);
        p.introducirRuta('y','t', 9);
        p.introducirRuta('y','r', 8);
        p.introducirRuta('w','t', 56);
        p.introducirRuta('w','r', 97);
        p.introducirRuta('t','r', 1);
        
        String r = p.buscarRuta('x', 'y');
        System.out.println(r);
    }
}
