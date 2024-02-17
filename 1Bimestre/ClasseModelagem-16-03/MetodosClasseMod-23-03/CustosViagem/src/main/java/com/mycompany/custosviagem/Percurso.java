
package com.mycompany.custosviagem;

import javax.swing.JOptionPane;

public class Percurso {
    private double kmPercorrido;
    private double valorCombustivel;
    private double valorPedagio;
            
     public Percurso(){
     this(0,0,0);
    }
     
    public Percurso (double kmPercorrido, double valorCombustivel, double valorPedagio ){
    this.kmPercorrido = kmPercorrido;
    this.valorCombustivel = valorCombustivel;
    this.valorPedagio = valorPedagio;
  }
   //get e set

    public double getKmPercorrido() {
        return kmPercorrido;
    }

    public void setKmPercorrido(double kmPercorrido) {
        this.kmPercorrido = kmPercorrido;
    }

    public double getValorCombustivel() {
        return valorCombustivel;
    }

    public void setValorCombustivel(double valorCombustivel) {
        this.valorCombustivel = valorCombustivel;
    }

    public double getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }
    
    //métodos especificos 
    public void cadastrarPercurso(){
    this.setKmPercorrido(Double.parseDouble(JOptionPane.showInputDialog("Digite os km percorridos na viagem.")));  
    this.setValorCombustivel(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do litro do combustível."))); 
    this.setValorPedagio(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor dos gastos com pedágio."))); 
    }  
    
    public void listarPercurso(){
    JOptionPane.showMessageDialog(null, "Os dados de sua viagem digitados por você:\nKM percorrido: "+this.getKmPercorrido()+"\nValor do combustivel: "+this.getValorCombustivel()+"\nValor do pedágio: "+this.getValorPedagio());
        
    }   
}