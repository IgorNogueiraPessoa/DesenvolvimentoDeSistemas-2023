package com.mycompany.custosviagem;

import javax.swing.JOptionPane;


public class Principal {
    public static void main(String args[]){
    Percurso percurso1 = new Percurso();
    Custos custos1 = new Custos();
   int op;  
do { //repetição para o menu
    op = Integer.parseInt(JOptionPane.showInputDialog("Custos da viagem \n1 - Cadastrar dados da viagem " + "\n2 - Apresentar dados \n3 - Apresentar custos totais \n4 - Sair" )); 
    switch (op){
    case 1:
    percurso1.cadastrarPercurso(); 
    break;
    
    case 2:
    percurso1.listarPercurso();
    break;
    
    case 3:
    custos1.calcularViagem(percurso1); //passando uma classe como parametro.
    break;
    
    case 4:
    JOptionPane.showMessageDialog(null, "Finalizando....");
    break;
        
    default:
    JOptionPane.showMessageDialog(null, "Opção inválida!"); 
    }
}
while(op != 4);
    
   }    
}
