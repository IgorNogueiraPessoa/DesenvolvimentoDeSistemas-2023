package com.mycompany.calculadorabasica;

import javax.swing.JOptionPane;

public class Calculadora {
    private double n1, n2, r;
  
    public Calculadora(){
     this(0,0,0);
    }
    
   public Calculadora(double n1, double n2, double r ){
    this.n1 = n1;
    this.n2 = n2;
    this.r = r;
  }
    //set e get 
    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
   
   //metodos específicos do projeto
    public void somar(){
    this.setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite um número para a soma")));
    this.setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para a soma")));
    this.setR(this.n1+this.n2);
    JOptionPane.showMessageDialog(null,this.getN1()+"+"+this.getN2()+"="+this.getR());
    } 
    
    public void subtrair(double a, double b){
    a = Double.parseDouble(JOptionPane.showInputDialog("Digite um número para a subtração"));
    b = Double.parseDouble(JOptionPane.showInputDialog("Digite outro número para a subtração"));
    this.setR(a-b);
    JOptionPane.showMessageDialog(null,a+"-"+b+"="+this.getR());
    }
    
    public double multiplicar(){
    this.setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite o número do primeiro fator")));
    this.setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo fator ")));  
    this.setR(this.n1*this.n2);
    return this.getR();
    }
    
    public double dividir (double a, double b){
    this.setR(a/b);
    return this.getR();
    }
}
