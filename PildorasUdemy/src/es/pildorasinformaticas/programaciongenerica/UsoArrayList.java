package es.pildorasinformaticas.programaciongenerica;

import java.io.*;

public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MiArrayList archivos = new MiArrayList(6);
		
		archivos.agregaElemento("Maria");
		
		archivos.agregaElemento("Antonio");
		
		archivos.agregaElemento("Ana");
		
		archivos.agregaElemento("Juan");
		
		archivos.agregaElemento("Pedro");
		
		//String nombrePersona = (String)archivos.getObjeto(2);
		
		archivos.agregaElemento(new File("ejemplo.xlsx"));
		
		File nombrePersona = (File) archivos.getObjeto(1);
		
		System.out.println(nombrePersona);
	}

}
