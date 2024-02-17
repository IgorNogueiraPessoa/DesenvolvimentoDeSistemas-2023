
package com.etec.media;

import java.util.Scanner;

public class media 
{
   public static float n1;
   public static float n2;
   public static float n3;
   public static float n4;
   public static float media;
   public  static String nome;
   public static Scanner teclado = new Scanner(System.in); 
   
   
public static void main (String args[])
{
    
    System.out.println("Informe seu nome");
    nome = teclado.nextLine();
 
    System.out.println("Digite a primeira nota");
    n1 = teclado.nextInt();
    
    System.out.println("Digite a segunda nota");
    n2 = teclado.nextInt();
    
    System.out.println("Digite a terceira nota");
    n3 = teclado.nextInt();
    
    System.out.println("Digite a quarta nota");
    n4 = teclado.nextInt();

    media=(n1+n2+n3+n4)/4;
    System.out.println(nome+",sua média em matemática é: "+media);
   
}
}
