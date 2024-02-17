
package com.mycompany.exercicio_um;

import javax.swing.JOptionPane;

public class exercicio_um {
    public static void main(String[] args)
    {
      float n1, n2,med; 
    
      String nome;
      nome = JOptionPane.showInputDialog("Digite o nome do aluno ");
      n1=lerNota("Digite a sua primeira nota");
      n2=lerNota("Digite a sua segunda nota ");
      med=calcularMedia(n1,n2);
         
      if (n1>10 && n2>10)
      {
         JOptionPane.showMessageDialog(null,"Valor de nota não aceitavel");
         System.exit(0);
      }
      
      if(med>7)
      {
        JOptionPane.showMessageDialog(null,nome+", você está aprovado, média de: "+med);
      }
      else
      {
           JOptionPane.showMessageDialog(null,nome+", você está reprovado, média de: "+med);
      } 
    }
    
    
    static float lerNota(String mensagemnota)//copia da variavel, sendo uma string
    {
     float nota=Float.parseFloat(JOptionPane.showInputDialog(mensagemnota));//leitura e conversão de string para float
     return nota;//retornando o valor transformado em float para as variaveis n1 e n2
    }
    
    static float calcularMedia(float nota1, float nota2)//copia das variaveis da nota
    {
       float res = (nota1+nota2)/2;
       return res;//retornando o resultado do cálculo
    }
}
