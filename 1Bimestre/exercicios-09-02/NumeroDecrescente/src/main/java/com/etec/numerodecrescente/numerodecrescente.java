
package com.etec.numerodecrescente;

import java.util.Scanner;

public class numerodecrescente 
{
   public static int n;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
  
    System.out.println("Digite um numero: ");
    n = teclado.nextInt();
    
    for(int cont=n; cont>=0;cont--)
    {
        System.out.println(cont);
    }
}
}
