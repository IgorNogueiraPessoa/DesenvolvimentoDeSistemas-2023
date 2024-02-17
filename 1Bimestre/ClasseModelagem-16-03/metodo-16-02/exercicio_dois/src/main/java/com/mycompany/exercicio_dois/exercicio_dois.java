package com.mycompany.exercicio_dois;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class exercicio_dois {
    public static void main (String[] args)
    {
      double num1, num2;
      num1=Double.parseDouble(JOptionPane.showInputDialog("Entre com um número"));
      num2=Double.parseDouble(JOptionPane.showInputDialog("Entre com outro número"));
      diferenca(num1,num2);     
    }
     static void diferenca(double numeroum, double numerodois)//realizar o calculo e exibir o resultado, nao retornando para a classe principal
    {
      if(numeroum>numerodois)
      {
        double resultado=numeroum-numerodois;
        DecimalFormat df = new DecimalFormat("#.##"); // formata o resultado com duas casas decimais. fiz isso pois estava exibindo muitos números após a virgula, quando o calculo envolvia decimais.
        JOptionPane.showMessageDialog(null,"A diferença entre os valores é de "+df.format(resultado));
      }
       else
      {
          double resultado=numerodois-numeroum;
          DecimalFormat df = new DecimalFormat("#.##"); 
          JOptionPane.showMessageDialog(null,"A diferença entre os valores é de "+df.format(resultado));
      }
    }   
}
