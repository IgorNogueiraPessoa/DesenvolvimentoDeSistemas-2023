
package com.mycompany.exemplo_um;

import javax.swing.JOptionPane;

public class exemplo_um {
    
    public static void main(String[] args)
    {
       int a;
       digite();
       a=Integer.parseInt(JOptionPane.showInputDialog("Digite um número: "));
       dobro(a);//chamada para o cálculo do valor armazenado na variável a
    }    
    
    static void digite() 
    {
       JOptionPane.showMessageDialog(null,"Digite um número:: ");
    }
    
    static void dobro(int n)//atribuição "cópia" da variavel a
    {
       int d = n*2;
       JOptionPane.showMessageDialog(null,"Dobro de "+n+" é "+d);
    }
    
}
