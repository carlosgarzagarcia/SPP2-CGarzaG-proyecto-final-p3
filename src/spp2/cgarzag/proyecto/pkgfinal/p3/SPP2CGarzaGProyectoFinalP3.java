/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp2.cgarzag.proyecto.pkgfinal.p3;

/**
 *
 * @author Carlos Rafael
 */
import javax.swing.JOptionPane;
public class SPP2CGarzaGProyectoFinalP3 {

    /**
     3.	Desarrolla un programa que muestre un Menú con 3 opciones: Opción 1: Calcular Máximo Común Divisor, 
     * Opción 2: Calcular Mínimo Común Múltiplo, Opción 3: Salir.
     * De acuerdo con la opción seleccionada por el usuario el programa deberá solicitar dos número, realizar el cálculo correcto y mostrar el resultado.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         menu();
    }
    
    public static void menu(){
        int opcion = JOptionPane.showOptionDialog(null, "Selecciona tu opción deseada", "Menu:",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Maximo comun divisor", "Minimo comun multiplo", "Salir"}, "Maximo comun divisor");
        int primerNum, segundoNumero;
        switch (opcion){
            case 0:
             primerNum = pedirNumero("1er numero");
             segundoNumero = pedirNumero("2do numero");
             maximoComunDivisor(primerNum, segundoNumero);
             preguntaContinuidad();
             break;
            case 1:
                primerNum= pedirNumero("1er número");
                segundoNumero = pedirNumero("2do número");
                minimoComunMultiplo(primerNum, segundoNumero);
                preguntaContinuidad();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
                System.exit(0);
        }
    }
    
    public static int pedirNumero(String mensaje){
        boolean flag;
        int x=0;
        do{
            try{
             String respuesta = JOptionPane.showInputDialog(null, "Ingrese el "+mensaje); 
             x=Integer.parseInt(respuesta);
             flag=true;
            }catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "ERROR, vuelva a intentarlo");
             flag=false;
            }
            }
        while(flag==false);
        return x;
    }
    
    public static void maximoComunDivisor(int primerNum, int segundoNumero){
        int maximoComunDivisor;
        while(primerNum != segundoNumero)
            if(primerNum > segundoNumero)
                primerNum = primerNum - segundoNumero;
            else
                segundoNumero = segundoNumero - primerNum;
        JOptionPane.showMessageDialog(null, "El Maximo Comun Divisor es: " + primerNum);
    }
    
    public static void minimoComunMultiplo(int primerNum, int segundoNumero){
        int minimoComunMultiplo = 1;
        int i = 2;
        while(i <= primerNum || i <= segundoNumero)
        {
            if(primerNum%i == 0 || segundoNumero%i == 0)
            {
            minimoComunMultiplo = minimoComunMultiplo * i;
            if(primerNum%i == 0) primerNum = primerNum / i;
            if(segundoNumero%i == 0) segundoNumero = segundoNumero / i;
            }
            else
                i = i+1;               
        }                        
        JOptionPane.showMessageDialog(null, "El Minimo Comun Multiplo es: " + minimoComunMultiplo);            
    }
    
    public static void preguntaContinuidad(){
        int respuesta = JOptionPane.showOptionDialog(null, "¿Desea seguir utilizando el programa?", "Pregunta de Continuidad",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Si", "No"}, "Si");
       
        switch (respuesta){
            case 0:
                menu();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "The ");
                System.exit(0);
        }
    }
}