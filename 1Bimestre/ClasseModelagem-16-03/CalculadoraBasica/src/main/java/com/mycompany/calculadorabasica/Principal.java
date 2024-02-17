package com.mycompany.calculadorabasica;

import javax.swing.JOptionPane;

public class Principal {
    
   public static void main(String args[]){
       
   Calculadora calc1 = new Calculadora();  
   int op; 
   
do { //reaproveitando código do menu de opções do exemplo. uma das vantagens de orientação a objetos
    op = Integer.parseInt(JOptionPane.showInputDialog("Calculadora básica: \n1 - Soma " + "\n2 - Subtração \n3 - Multiplicação \n4 - Divisão \n0 - Sair" )); 
    switch (op){
    case 1:
    calc1.somar(); 
    break;
    
    case 2:
    calc1.subtrair(calc1.getN1(), calc1.getN2());
    break;
    
    case 3:
    calc1.multiplicar();
    JOptionPane.showMessageDialog(null,calc1.getN1()+"X"+calc1.getN2()+"="+calc1.getR());
    break;
    
    case 4:
    double n1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o número do dividendo"));
    double n2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o número do divisor")); 
    calc1.dividir(n1,n2);
    JOptionPane.showMessageDialog(null,n1+" dividido por "+n2+"="+calc1.getR());
    break;
      
    case 0:
    JOptionPane.showMessageDialog(null, "Finalizando a calculadora....");
    break;
        
    default:
    JOptionPane.showMessageDialog(null, "Opção inválida!"); 
    }
}while(op != 0);
   }    
}