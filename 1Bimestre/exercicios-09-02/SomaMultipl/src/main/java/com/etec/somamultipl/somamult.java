
package com.etec.somamultipl;

import java.util.Scanner;

public class somamult
{
   public static int par = 30;
   public static int imp;
   public static int res;
   public static long res2;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
  System.out.println("Os números pares de 0 a 30 são:");
  for (int cont=0; cont<=par; cont=cont+2)
  {
      System.out.println(cont);
      
      res*=cont;
  }
     System.out.println("e a multiplicacão de todos os números é: "+res); 
     
    System.out.println("Os números ímpares entre 0 e 30 são: ");
   for (int cont2=1; cont2<=30;cont2+=2)
   {
       System.out.println(cont2);   
       
       res2=cont2+res2;
   }
    System.out.println("E a soma desses números é: "+res2);
} 
}
