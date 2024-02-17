package com.mycompany.exercicio_quatro;
import javax.swing.JOptionPane;

public class exercicio_quatro {
    public static void main(String[] args)
    {
       int selec;
       
       selec=Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção do menu, digitando o número correspondente a operação:\n1-Soma\n2-Subtração\n3-Divisão\n4-Multiplicação\n5-Resto da divisão\n6-Dobro\n7-Quadrado\n8-Cubo\n9-Raiz Quadrada\n0-Sair"));
       calculo(selec);
    }
       
    static void calculo(int selecao) //void, pois não retornará nada para a classe principal, pois como diz o enunciado, essa classe deve realizar o cálculo e também apresentar o resultado,sem necessidade de retornar para a classe principal.
    {
     if(selecao==1)   
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite um número para soma"));
      double num2=Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para soma"));
      double result = num1+num2;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);
     }
     else if (selecao==2)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite um número para subtração"));
      double num2=Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para subtração"));
      double result = num1-num2;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);
     }
     else if (selecao==3)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite um número para o dividendo"));
      double num2=Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para o divisor"));
      double result = num1/num2;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result); 
     }
     else if (selecao==4)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro numero para o fator da multiplicação"));
      double num2=Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para o fator da multiplicação"));
      double result = num1*num2;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);
     }
     else if (selecao==5)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o número dividendo para realizar a divisão e exibir o resto."));
      double num2=Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para o divisor"));
      double result = num1%num2;
      JOptionPane.showMessageDialog(null,"Resto da divisão: "+result);    
     }
     else if (selecao==6)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o número para realizar o cálculo do dobro"));
      double result = num1*2;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);  
     }
     else if (selecao==7)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o número para realizar o cálculo do quadrado"));
      double result = num1*num1;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result); 
     }
     else if (selecao==8)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o número para realizar o cálculo do cubo"));
      double result = num1*num1*num1;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);
     }
     else if (selecao==9)
     {
      double num1=Double.parseDouble(JOptionPane.showInputDialog("Digite o número para realizar o cálculo da raíz quadrada"));
      double result = Math.sqrt(num1);;
      JOptionPane.showMessageDialog(null,"Resultado da operação: "+result);
     }    
     else if (selecao==0)
     {
      System.exit(0);
     }
     else
     {
     JOptionPane.showMessageDialog(null,"Digite uma opção válida do menu!");
     System.exit(0);
     }       
    }
}
