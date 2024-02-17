
package com.etec.trocanumero;

import java.util.Scanner;

public class trocanumnero 
{
   public static int numA;
   public static int numB;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
    System.out.println("Digite o valor de numA");
    numA = teclado.nextInt();
    
    System.out.println("Digite o valor de numB");
    numB = teclado.nextInt();       
     
    System.out.println("Invertidamente, o valor de numA é: "+numB+" e o de numB é: "+numA);
}
}