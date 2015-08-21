#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

void calcularMaximaCantidadDeEstaciones(int kilometrosDeCable,vector<int> distanciaDeLasEstaciones){
	//Inicializo variables que voy a utilizar
	int inicio=0;
	int fin=1;
	int cantidadDeEstaciones=0;
	int maximaCantidadDeEstaciones=0;

	//Busco una cota minima de maxima cantidad de estaciones al buscar la estacion mas lejana a la capital que puedo unir con el cable
	int j=0;
	while(distanciaDeLasEstaciones[j]<=kilometrosDeCable)
	{
		maximaCantidadDeEstaciones=j+2;
		j++;
	}

	//Voy moviendo 2 indices que representan las estaciones a lo largo del vector calculando la distancia entre esas estaciones.
	//Si puedo unir las estaciones entre los indices con cable almaceno esa cantidad de estaciones en cantidadDeEstaciones
	//Si es mejor que el maximo que tenia antes reemplazo maximaCantidadDeEstaciones por ese valor.
	//Si no puedo unir las estaciones con cable, aumento el indice inicio, o ambos si es que al aumentar inicio este iguala a fin
	//Como cota superior cada indice recorre una sola vez el vector distanciaDeLasEstaciones, por lo que la complejidad es O(2n)
	//que esta incluida en O(n), siendo n el tamaño del vector distanciaDeLasEstaciones, que es donde estan las estaciones del ramal.
	while(fin<distanciaDeLasEstaciones.size()){
		
		if((distanciaDeLasEstaciones[fin]-distanciaDeLasEstaciones[inicio])<=kilometrosDeCable){
			cantidadDeEstaciones=fin-inicio+1;
			if(cantidadDeEstaciones>maximaCantidadDeEstaciones)
				maximaCantidadDeEstaciones=cantidadDeEstaciones;
			if(fin<distanciaDeLasEstaciones.size())
				fin++;
		}
		else{
			if(fin==inicio+1){
				fin++;
				inicio++;
			}
			else{
				inicio++;
			}

		}

	}
	cout<<maximaCantidadDeEstaciones<<endl;
}


void calcularMaximaCantidadDeEstaciones(int kilometrosDeCable,vector<int> distanciaDeLasEstaciones);