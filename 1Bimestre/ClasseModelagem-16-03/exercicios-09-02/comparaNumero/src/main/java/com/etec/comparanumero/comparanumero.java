
package com.etec.comparanumero;

import java.util.Scanner;

public class comparanumero 
{
   public static int num1;
   public static int num2;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
 
    System.out.println("Digite o primeiro valor");
    num1 = teclado.nextInt();
    
     System.out.println("Digite o segundo valor");
    num2 = teclado.nextInt();
    
    
    if(num1==num2)
    {
        System.out.println("Os números são iguais.");
    }
    else
    {
        if(num1>num2)
        {
        System.out.println("Os números são diferentes,sendo o maior "+num1+" e o menor "+num2);
        }
        else
        {
        System.out.println("Os números são diferentes,sendo o maior "+num2+" e o menor "+num1); 
        }
    }
}
}