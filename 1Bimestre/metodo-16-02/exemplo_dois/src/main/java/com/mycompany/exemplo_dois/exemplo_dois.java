package com.mycompany.exemplo_dois;

import javax.swing.JOptionPane;

public class exemplo_dois {
    
    public static void main(String[] args)
    {
    int t;
    String p;
    digite();
    p = JOptionPane.showInputDialog("Digite uma palavra qualquer: ");
    t=tamanho(p);//chamada do método que irá analisar a string p
    JOptionPane.showMessageDialog(null,p+" possui "+t+" caracteres");  
    }
    
static void digite()
{
    JOptionPane.showMessageDialog(null, "digite uma palavra");
}
 
static int tamanho(String x)//atribuição de "cópia" da variável p
{
    return x.length();//retornar o comando x length para a classe principal, realizando a contagem de caracteres
}
}
