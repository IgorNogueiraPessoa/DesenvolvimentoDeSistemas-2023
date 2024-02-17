
package com.mycompany.controlecomissao;
import javax.swing.JOptionPane;

public class Vendedor {
    private double salarioBase;
    private String nome;
            
     public Vendedor(){
     this(0,"");
    }
     
    public Vendedor (double salarioBase, String nome ){
    this.salarioBase = salarioBase;
    this.nome = nome;
  }
    //set e get

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //métodos específicos do método
    public double calculoComissao(double valorVendido){
    double novosal;
    this.setNome(JOptionPane.showInputDialog("Digite o seu nome "));  
    this.setSalarioBase(Double.parseDouble(JOptionPane.showInputDialog("Digite o salário base.")));
    novosal = (valorVendido*0.1) + this.salarioBase;
    return (novosal);
    }  
   
    
}
