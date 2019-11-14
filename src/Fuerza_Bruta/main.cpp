#include "iostream"
#include<conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define max 5000

using namespace std;

int band=0;
int l,j,i,N,M;
int contador=0;


void buscarPatron(char cadena[max],char patron[max]){
	int contador=0;
	N=strlen(cadena);
    M=strlen(patron); 
     //Recorrido que se hara sobre la cadena para encontrar el patron
     for(i=0;i<=N-M;i++){
       int  l=i; 
		int j=0;
        while(cadena[l]==patron[j] &&  j<=M) {
            l++; j++; }
            if(j>M-1){
            	 //se determinara la pocision en la que se encuentre el patron
			printf("El patron a buscar se ha encontrado en la posicion: %d \n", i+1); 
    		contador++;	
		     band=1;	
			}		
			else	
			band=0;					
	 }	
	 //se determina el numero de veces que ha sido encontrado el patron 
  printf("Se ha encontrado:  %d  veces. \n", contador);
}	 

int main(){
	
char cadena[max],patron[max];
int opcion;

do{
	printf("\n ----------CADENAS MEDIANTE FUERZA BRUTA----------\n");
	//empieza a contar desde 1
	printf("\n Ingresa la cadena: ");
	cin>>cadena;
	printf("\n Ingresa el patron a encontrar: ");
	cin>>patron;
	buscarPatron(cadena,patron);
	printf("\n ----------si no deseas ingresar una nueva cadena ingresa un 2----------");
	printf("\n ----------si deseas ingresar una nueva cadena presiona otro numero----------");
	cin>>opcion;
	system("cls");
}while(opcion!=2);

}
