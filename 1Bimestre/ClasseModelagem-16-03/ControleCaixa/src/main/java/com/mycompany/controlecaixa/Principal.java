package com.mycompany.controlecaixa;

import javax.swing.JOptionPane;

public class Principal{

public static void main(String args [])
{
Caixa cx1 = new Caixa(); //instanciação do obj cx1
int op; //declaração da variável de opções
do { //inicio do looping dowhile, apresent~çãom e leitura do menun de opções
    op = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n1 - Entrada " + "\n2 - Retirada \n3 - Consultar saldo \n0 - Sair" ));
    
    switch (op){//aberttura da estrutura switch-case
      case 1:
        cx1.entrar(); //chamada ao método entrar do objeto cx1
        break;
      case 2:
        cx1.retirar(); //retirar do objeto cx1
        break;
      case 3: //apresentação do conteudo do atributo saldo
        JOptionPane.showMessageDialog(null, "Saldo atual: " + cx1.getSaldo());
        break;
      case 0:
        JOptionPane.showMessageDialog(null, "Finalizando o programa");
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opção inválida!");
    }
}while(op != 0); //repetirá as operações enquanto a opção for diferente de zero.
      
}
    
}
