/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandra
 */
public class ProblemaMochila {
    
    //simbologia utilizada
    private int pesoA[];      // peso de los articulos
    private int articulos;    // cantidad de articulos dados
    private int cp;           // columnas de pesos
    private int filas;        // filas de articulos
    private int c;            // capacidad de la mochila
    private int beneficio[];  // beneficio de los articulos
   
    public void Mochila(int c, int articulos, int pesoA[],int beneficio[]){
         
        int MatrizM[][] = new int[articulos+1][c+1];
  
        for(int filas=0;filas<=articulos;filas++){ //se recorren las filas          
            for(int cp=0;cp<=c;cp++){ //se recorren las columnas
                if(filas==0 || cp==0){ //se agrgan ceros a la matriz
                    MatrizM[filas][cp] = 0;
                }
                else if(pesoA[filas-1]<=cp){ //se agregan los valores de los beneficios a la matriz, para la mochila
                     MatrizM[filas][cp] = sacarMayorValor(beneficio[filas-1]+MatrizM[filas-1][cp-pesoA[filas-1]],MatrizM[filas-1][cp]);
                }
                else{//se agregara a la matriz en la posicion que se encuentra actualmente, el valor que tanga la posicion anterior
                    MatrizM[filas][cp] = MatrizM[filas-1][cp];
                }
                //se imprime la matriz
               System.out.print(MatrizM[filas][cp]);
               if(cp!=MatrizM[filas].length-1){
                   System.out.print("\t");
               }
            }
            System.out.println();
        }
    System.out.println();
    //se imprime el beneficio total
    System.out.println("BENEFICIO TOTAL: " +MatrizM[articulos][c]);
    //se obtienen los articulos utilizados
    while(articulos!=0){
        if(MatrizM[articulos][c]!=MatrizM[articulos-1][c]){
            //se imprimen los articulos utilizados, su peso y su valor
            System.out.println("ARTICULOS: "+articulos+", PESO = "+pesoA[articulos-1]+", VALOR = "+beneficio[articulos-1]);
            c=c-pesoA[articulos-1];
        }
        articulos--;
        }
    }
     private int sacarMayorValor(int a, int b){
  
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
    
}
