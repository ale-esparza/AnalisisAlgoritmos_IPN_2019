/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaAgenteViajero;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

 

/**
 *
 * @author Alejandra
 */
public class TSP {
    
    String  caminoCorto;  
    char[]  ciudades;  
    int[][] matriz; 
    int longC = Integer.MAX_VALUE;   
    List<ClaseNodos>  camino=null;                        
 
    TSP(String serieNodos) {
        ciudades = serieNodos.toCharArray();
        matriz = new int[ciudades.length][ciudades.length];
    }
    
   //se introducira el nodo de inicio y el del final para poder hacer la ruta
    public void introducirRuta(char n, char f, int distancia) {
        int n1 = posicion(n);
        int n2 = posicion(f);
        matriz[n1][n2]=distancia;
        matriz[n2][n1]=distancia;
    }
 
    private int posicion(char nodo) {
        for(int i=0; i<matriz.length; i++) {
            if(ciudades[i]==nodo) return i;
        }
        return -1;
    }
     
    
    public String buscarRuta(char n, char f) {
        
        buscarRutaMinima(n);
       
        ClaseNodos tmp = new ClaseNodos(f);
        if(!camino.contains(tmp)) {
            System.out.println("La ciudad es inalcanzable");
            return "";
        }
        tmp = camino.get(camino.indexOf(tmp));
        int distancia = tmp.dis;  
        Stack<ClaseNodos> pila = new Stack<ClaseNodos>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.CiudadProcedencia;
        }
        String ruta = "";
        while(!pila.isEmpty()) ruta+=(pila.pop().z + " ");
        return distancia + ": " + ruta;
    }
 
   public boolean terminacion(int p) {
        ClaseNodos tmp = new ClaseNodos(ciudades[p]);
        return camino.contains(tmp);
    }
   
   //de las rutas que ya se encontraron, se debera uscar la mas corta
    public void buscarRutaMinima(char inicio) {
        Queue<ClaseNodos>   cola = new PriorityQueue<ClaseNodos>(); 
        ClaseNodos            ni = new ClaseNodos(inicio);          
         
        camino = new LinkedList<ClaseNodos>();
        cola.add(ni);                   
        while(!cola.isEmpty()) {        
            ClaseNodos tmp = cola.poll();     
            camino.add(tmp);           
            int p = posicion(tmp.z);   
            for(int j=0; j<matriz[p].length; j++) {  
                if(matriz[p][j]==0) continue;        
                if(terminacion(j)) continue;      
                ClaseNodos nod = new ClaseNodos(ciudades[j],tmp.dis+matriz[p][j],tmp);
                
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
           
                for(ClaseNodos x: cola) {
                    
                    if(x.z==nod.z && x.dis > nod.dis) {
                        cola.remove(x); 
                        cola.add(nod);  
                        break;          
                    }
                }
            }
        }
    }
    
    public void MinimaDistancia(char n, char f) {
        int p1 = posicion(n);
        int p2 = posicion(f);
        
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
    
 //se recorreran todas las ciudades y asi sacar las rutas posibles del lugar de inicio al final
    private void recorrerRutas(int noI, int noF, Stack<Integer> resul) {
      
        if(noI==noF) {
            int respuesta = calcular(resul);
            if(respuesta < longC) {
                longC = respuesta;
                caminoCorto     = "";
                for(int x: resul) caminoCorto+=(ciudades[x]+" ");
            }
            return;
        }
        
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<matriz.length;i++) {
            if(matriz[noI][i]!=0 && !resul.contains(i))lista.add(i);
        }
      
        for(int nodo: lista) {
            resul.push(nodo);
            recorrerRutas(nodo, noF, resul);
            resul.pop();
        }
    }
    
    //se calculara el resultado del camino mas corto
    public int calcular(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=matriz[r[i]][r[i-1]];
        return resp;
    }
 
}

