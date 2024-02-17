
package com.etec.maiornumero;

import java.util.Scanner;

public class maiornumero 
{
   public static int n1;
   public static int n2;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
  
    System.out.println("Digite o primeiro número: ");
    n1 = teclado.nextInt();
    
    System.out.println("Digite o segundo número ");
    n2 = teclado.nextInt();
    
    if (n1>n2)
    {
        System.out.println("O maior número entre os dois informados é "+n1);
        System.exit(0);
    }
    else
    {
        System.out.println("O maior número entre os dois informados é "+n2);
    }
    
}
}
