/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandra
 */
public class ProblemaCaballo {

    private int[][] tablero = new int[9][9];
    private boolean exito;
    //movimientos posibles que puede hacer el caballo
    private int[][] SALTO = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},{-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private int x0, y0;
    
// constructor
    public ProblemaCaballo(int x, int y)  {
        if ((x < 1) || (x > 8) || (y < 1) || (y > 8)) {
            System.out.println("Coordenadas no validas");
        }
        x0 = x;
        y0 = y;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                tablero[i][j] = 0;
            }
        }
        //posicion 1 donde va a comenzar el caballo
        tablero[x0][y0] = 1;
        exito = false;
    }

    public void resolverProblema() {
        saltoCaballo(x0, y0, 2);
    }

    private void saltoCaballo(int x, int y, int i) {
        //nx eje en el lado de las x
        //ny eje en el lado de las y
        int nx, ny;
        int k;
        k = 0; // inicializa el conjunto de posibles movimientos
        do {
            k++;
            nx = x + SALTO[k - 1][0];
            ny = y + SALTO[k - 1][1];
// determina si las nuevas coordenadas son aceptables
            if ((nx >= 1) && (nx <= 8) && (ny >= 1) && (ny <= 8)
                    && (tablero[nx][ny] == 0)) {
                tablero[nx][ny] = i; // anota movimiento
                if (i < 8 * 8) {
                    saltoCaballo(nx, ny, i + 1);
// se analiza si se ha completado la solución
                    if (!exito) { // no se alcanzó la solución
                        tablero[nx][ny] = 0; // se borra anotación
                    }
                } else {
                    exito = true; // tablero completado
                }
            }
        } while ((k < 8) && !exito);
    }
    
//muestra en la pantalla los pasos o saltos que ha dado el caballo
    void mostrarTablero() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}