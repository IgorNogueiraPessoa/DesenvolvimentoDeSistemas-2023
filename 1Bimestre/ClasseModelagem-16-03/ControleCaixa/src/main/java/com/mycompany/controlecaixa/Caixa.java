
package com.mycompany.controlecaixa;
import javax.swing.JOptionPane;
public class Caixa {
    
    //Atributo
    private double saldo;
    
    //Construtores
    //inicializando o atributo zerado
    public Caixa(){
        this(0);
    }
  //inicializando o atributo com parâmetro 
  public Caixa(double saldo){
      this.saldo = saldo;
  }
  //getters e setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
  

//metódos específicos da classe
public void entrar(){
//Lê um valor, converte de String para double e atribui a variável valor
double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da entrada: "));
//Soma o conteúdo do atributo saldo com o da variávelvalor e passa o resultado por parametro para o metodo setSaldo
this.setSaldo(this.saldo + valor);
}

public void retirar(){
//Lê um valor, converte para String para double e atribui a variável valor
double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da retirada: "));
//Subtrai o conteúdo do atributo saldo com o da variável valor e passa o resultado por parametro para o método setSaldo
this.setSaldo(this.saldo - valor);
}
}