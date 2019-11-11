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
public class ClaseNodos implements Comparable<ClaseNodos>  {
    char z;
    int  dis = Integer.MAX_VALUE;
    
    ClaseNodos CiudadProcedencia = null;
    ClaseNodos(char x, int d, ClaseNodos p) { z=x; dis=d; CiudadProcedencia=p; }
    ClaseNodos(char x) { this(x, 0, null); }
    
    public int compareTo(ClaseNodos temp) { 
        return this.dis-temp.dis;
    }
    
    public boolean equals(Object o) {
        ClaseNodos temp = (ClaseNodos) o;
        if(temp.z==this.z) 
          return true;
        else
        return false;
    }
     
}
