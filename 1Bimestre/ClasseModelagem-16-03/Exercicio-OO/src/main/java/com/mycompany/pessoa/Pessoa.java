
package com.mycompany.pessoa;

import javax.swing.JOptionPane;

public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
  
    //inicio dos construtores 
    
    public Pessoa(){
     this("","","");
  } 
  
   //passagem de parametros
    public Pessoa (String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //fim dos construtores; inicio dos set gets. lembrar do comando alt+insert.
    public String getNome() {
        return nome;  
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void inserirDadosPessoa(){ //inserçao dos dados atraves do input dialog.pegando os dados do set. obs: em atividades do ano passado, foi feito algo parecido, mas era criado um metodo para coletar cada set. Aqui apenas juntei todos.                                  
        this.setNome(JOptionPane.showInputDialog("Digite o seu nome"));
        this.setEndereco(JOptionPane.showInputDialog("Digite o endereço"));
        this.setTelefone(JOptionPane.showInputDialog("Digite o seu telefone"));
    }
    
    public void apresentarPessoa(){ //apresentação dos dados com showMessage atraves dos gets.
        JOptionPane.showMessageDialog(null, "De acordo com os dados apresentados, seu nome é "+this.getNome() + ", você mora no endereço "+this.getEndereco() +" e seu telefone é "+this.getTelefone());
    }
}
