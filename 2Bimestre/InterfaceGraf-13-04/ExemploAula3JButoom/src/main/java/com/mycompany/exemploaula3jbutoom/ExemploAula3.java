//projeto referente aos tópicos 8 á 8.2.    Preferi separar assim para ficar mais lógico,sendo este com botão sair e o de exibir senha, e o outro com botão somar e os demais, ja que na tarefa não dizia que tinha que ser tudo em um só.
package com.mycompany.exemploaula3jbutoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploAula3 extends JFrame
{
  JButton botaosair;
  JPasswordField caixa;
  JLabel rotulo, exibir;
  JButton mostrar;
  public ExemploAula3()
  {
   super("Exemplo com JButton");
   Container tela = getContentPane();
   setLayout(null);
   botaosair = new JButton("Sair");
   rotulo = new JLabel("Senha");
   caixa = new JPasswordField(10);
   exibir = new JLabel("A senha digitada é: ");
   mostrar = new JButton("Mostrar");
   exibir.setVisible(false);
   rotulo.setBounds(50,20,100,20);
   caixa.setBounds(50,60,200,20);
   exibir.setBounds(50,120,200,20);
   mostrar.setBounds(50,100,100,20);
   
   mostrar.addActionListener //acionando o evento do botão da senha 
   (
     new ActionListener()
     {
         public void actionPerformed(ActionEvent e) //método do botão da senha 
         {
           String senha = new String(caixa.getPassword());
           exibir.setVisible(true);
           exibir.setText(senha);
         } 
     }
    );
   
   botaosair.setBounds(150,100,80,20);
   
   botaosair.addActionListener //acionando o evento do botão sair 
   (
     new ActionListener()
    {
        public void actionPerformed(ActionEvent e)//método do botão sair
        {
            System.exit(0);
        } 
    }     
   );
   tela.add(rotulo);
   tela.add(caixa);
   tela.add(exibir);
   tela.add(mostrar);
   tela.add(botaosair);
   setSize(400,250);
   setVisible(true);
   setLocationRelativeTo(null);
  }
  public static void main (String args[])
  {
    ExemploAula3 app = new ExemploAula3();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
