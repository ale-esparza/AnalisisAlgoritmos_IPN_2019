#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define d 256

void buscarPatron(char patron[], char cadena[], int q)
{
    int M = strlen(patron);
    int N = strlen(cadena);
    int i, j;
    int p = 0,c=0,h=1,contador=0;

    for (i = 0; i < M - 1; i++){
        h = (h * d) % q;
    }
    for (i = 0; i < M; i++) {
        p = (d * p + patron[i]) % q;
        c = (d * c + cadena[i]) % q;
    }
    for (i = 0; i <= N - M; i++) {
        if (p == c) {
            for (j = 0; j < M; j++) {
                if (cadena[i + j] != patron[j])
                    break;
            }
            if (j == M)
                printf("\n El patron a buscar se ha encontrado en la posicion: %d ", i);
                contador++;
        }
        if (i < N - M) {
            c = (d * (c - cadena[i] * h) + cadena[i + M]) % q;

            if (c < 0)
                c = (c + q);
        }
    }
     printf("\n \nSe ha encontrado:  %d  veces. \n", contador);

}

int main()
{
	
	printf("\n ---------- EMPATE DE CADENAS POR RABIN KARP----------\n");
//	empieza a contar desde la posicion cero
    char cadena[] = "ostrfstfgustjyjystjystlogs";//se introduce la cadena
    printf("\n ----- La cadena es:");
    printf(cadena);
    char patron[] = "rd";//patron a buscar
    printf("\n ----- El patron a buscar es:");
	printf(patron);
	 printf("\n");
    int q = 101;
    buscarPatron(patron, cadena, q);
    return 0;
}



