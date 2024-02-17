
package com.mycompany.pessoa;

public class Principal { //classe principal
    
    public static void main(String[] args)
    {
     
      Pessoa pessoa1 = new Pessoa();//chamada para a classe pessoa: orientação a objeto funcionando!
      //chamada para insercção e apresentação de dados
      pessoa1.inserirDadosPessoa();
      pessoa1.apresentarPessoa();
    }
    
}