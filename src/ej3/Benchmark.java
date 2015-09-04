package ej3;
import java.lang.Math;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

import org.junit.Test;


public class Benchmark {


	public static final int MAX  = 100;



	public void run_Caso(int n, int caso){

	  
	  
	 for(int k = 1;k<=n;k++){
		
		 long start_t = 0, delta_t=0;
		  
		  
		 double[] v = new double[MAX];
		 
		 double count=0;
		 double max=0;
		 
		 
		 double desvio=0,desvio2=0,prom=0,promedio2=0,varianza=0,varianza2=0, total = 0,total2=0;
		 
		 //Warm-up
		 for(int i = 0;i<100;i++){
			if(caso == 0)
				FogonTest.mejorCaso(k);
			if(caso == 1)
				 FogonTest.PeorCaso(k);
			if(caso == 2)
				FogonTest.CasoSinIntencionalidad(k);
			if(caso == 3)
				FogonTest.testSobreConjunto(k);
			
		 }
			
		 
		for(int i=0; i< MAX; i++){
			
			double delta;
			start_t = System.currentTimeMillis();
			//Notar que el calculo va a incluir esta "decision"
			if(caso == 0)
				FogonTest.mejorCaso(k);
			if(caso == 1)
				 FogonTest.PeorCaso(k);
			if(caso == 2)
				FogonTest.CasoSinIntencionalidad(k);
			
			delta = (System.currentTimeMillis()-start_t)/1000F;
			

		//	System.out.println("Elapsed time:" + delta);
			total = total + delta;
			if(delta > max) 
				max = delta;
			v[i] = delta;		
		}
	  

		prom = total/MAX;
		  
		for(int i=0; i< MAX; i++)	
			varianza = varianza +((prom - v[i])*(prom - v[i])); 
		
		varianza = varianza/MAX;
	   
		desvio = Math.sqrt(varianza);
	 
		for(int i=0; i< MAX; i++){
			if((prom-desvio)<= v[i] && v[i] <= ((prom+desvio))){
				count = count+1;
				total2 = total2 + v[i];
		  }  
		}  
	 
		promedio2 = (total2/count);
	
		for(int i =0; i< MAX; i++){	
			if((prom-desvio)<= v[i] && v[i] <= ((prom+desvio)))
				varianza2 = varianza2 + (promedio2 - v[i])*(promedio2 - v[i]);
		}
	  
		varianza2 = varianza2/count;
		desvio2 = Math.sqrt(varianza2);

		System.out.println("---------------------");
	    
	  
		System.out.println("N:"+k+ "Promedio:"+ prom +  "| Max:" + max+ "| Desvio:" + desvio+ "| PromedioRefinado:"+promedio2+ "|Desvio2:" + desvio2);  
	  
		System.out.println("---------------------");

	 	}
	 
		 


	}

	@Test
	public void main(){
		System.out.println("Mejor");
		//run_Caso(11,0);
		System.out.println("Peor");
	//	run_Caso(11,1);
		System.out.println("SinIntencionalidad");
	//	run_Caso(11,2);
		System.out.println("TestSobreConjuntoExploradorasFijas");
		run_Caso(10000,3);
	}

}