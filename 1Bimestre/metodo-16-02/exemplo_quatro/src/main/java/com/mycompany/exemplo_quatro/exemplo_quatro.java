
package com.mycompany.exemplo_quatro;

import javax.swing.JOptionPane;

public class exemplo_quatro {
    public static void main(String[] args)
    {
      int num;
      num=Integer.parseInt(JOptionPane.showInputDialog("Entre com um numero:: "));
      
      if (RestoPorDois(num) == 0) //chamada para o método acontecendo dentro da condição if
         JOptionPane.showInputDialog(null,"O número é par. \n");
      else
          JOptionPane.showMessageDialog(null, "O número é impar. \n");
    }
    
    static int RestoPorDois(int a)//atribuição da cópia da variável 
    {
       return a % 2; // analise do resto da divisão por dois, retornando para a variável num
    }
    
}
