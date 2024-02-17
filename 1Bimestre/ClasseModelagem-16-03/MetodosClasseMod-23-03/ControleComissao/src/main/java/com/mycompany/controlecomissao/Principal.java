package com.mycompany.controlecomissao;

import javax.swing.JOptionPane;

public class Principal {
    
   public static void main(String args[]){
    Vendedor vend1 = new Vendedor();  
    double vv;
    double result;
    vv=Double.parseDouble(JOptionPane.showInputDialog("Informe o total do valor vendido."));
    result=vend1.calculoComissao(vv);
    JOptionPane.showMessageDialog(null,vend1.getNome()+", seu novo salário é de :"+result);
   }    
}
