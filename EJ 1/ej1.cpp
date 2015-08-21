#include "telegrafo.h"

using namespace std;

int main(){
	//Aca guardo cada linea del archivo de test
	string valoresDelTest;
	//Aca van a ir los valores de los kilometros de cable y las distancias a la capital
	int kilometrosDeCable;
	int distancia;
	//Aca van a ir todas las distancias de 1 Ramal
	vector<int> distanciaDeLasEstaciones;

	//Leo el archivo hasta que termine
	while(!cin.eof()){
		//Tomo una linea del archivo(kilometros de cable) y la guardo en kilometrosDeCable
		if(getline(cin,valoresDelTest)){
			stringstream cable(valoresDelTest);
			cable>>kilometrosDeCable;
		}
		//Tomo la siguiente linea del archivo(las distancias a la capital) y la guardo en el vector de distanciaDeLasEstaciones
		if(getline(cin,valoresDelTest)){
			//Meto en el stream estaciones los valores de la linea del archivo
			stringstream estaciones(valoresDelTest);

			//Guardo en distancia el primer valor de estaciones
			while(estaciones>>distancia){
				
				distanciaDeLasEstaciones.push_back(distancia);
			}

			//Calculo el resultado
			calcularMaximaCantidadDeEstaciones(kilometrosDeCable,distanciaDeLasEstaciones);
		
			/*
			cout<<kilometrosDeCable<<endl;
			for(int i=0;i<distanciaDeLasEstaciones.size();i++){
				cout<<distanciaDeLasEstaciones[i]<<" ";
			}
			cout<<endl;
			*/
		}

		
		//Limpio el vector para que no queden valores anteriores
		distanciaDeLasEstaciones.clear();

	}

	return 0;
}
