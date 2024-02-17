package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel; //reconhecer a jtable
import conexao.Conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;

 
public class FrmTelaCad extends JFrame
{
    Conexao con_cliente;
    
    JLabel rCodigo, rNome, rEmail, rTel, rData, rPesquisa,rNavegacao;
    JTextField tcodigo, tnome, temail, tpesquisa;
    JFormattedTextField tel, data;
    MaskFormatter mTel,mData;
    JButton prim,anterior,prox,ultimo, novoreg,gravar,alterar,excluir,pesquisar, sair, retornar;
    ImageIcon imagem[];
    
    JTable tblClientes; //datagrid
    JScrollPane scp_tabela; //container para o datagrid

    public FrmTelaCad()
    {
        con_cliente = new Conexao(); //inicializacao do objeto
        con_cliente.conecta(); //chama o metodo que conecta
        
        setTitle("Conexão Java com MySql");
        setResizable(false);
        Container tela = getContentPane();
        tela.setLayout(null);
        
        rCodigo = new JLabel("Código: ");
        rNome = new JLabel("Nome: ");
        rEmail = new JLabel("Email: ");
        rTel = new JLabel ("Telefone: ");
        rData = new JLabel ("Data: ");
        rPesquisa = new JLabel ("Pesquisar pelo nome do cliente: ");
        rNavegacao = new JLabel ("Botões de navegação:");
        tcodigo = new JTextField(5);
        tnome = new JTextField(5);
        temail = new JTextField(5);
        tpesquisa = new JTextField(5);
        prim = new JButton("Primeiro");
        ultimo = new JButton("Último");
        
       
        
        //mascara dos campos telefone e data
        try
        {
        mTel = new MaskFormatter("(##)####-####");
        mData = new MaskFormatter("##/##/####");
        }
        catch(ParseException excp){}
        
        tel = new JFormattedTextField(mTel);
        data = new JFormattedTextField(mData);
        
        //icones dos botões
        String icones[]={"src/search.png","src/write.png","src/delete.png","src/alter.png","src/new.png","src/next.png","src/previous.png","src/exit.png","src/return.png"};
        imagem = new ImageIcon[10];
        for(int i = 0;i<9;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        pesquisar = new JButton(imagem[0]);
        gravar = new JButton(imagem[1]);
        excluir = new JButton(imagem[2]);
        alterar = new JButton(imagem[3]);
        novoreg = new JButton(imagem[4]);
        prox = new JButton(imagem[5]);
        anterior = new JButton(imagem[6]);
        sair = new JButton(imagem[7]); 
        retornar = new JButton(imagem[8]);
        
        alterar.setToolTipText("Alterar registro já realizado");
        gravar.setToolTipText("Gravar dados digitados");
        excluir.setToolTipText("Excluir registro");
        novoreg.setToolTipText("Limpar textos para realizar novo registro");
        prox.setToolTipText("Próximo registro");
        anterior.setToolTipText("Registro anterior");
        prim.setToolTipText("Primeiro registro");
        ultimo.setToolTipText("Ultimo registro");
        sair.setToolTipText("Sair do programa");
        retornar.setToolTipText("Retornar para tela de cadastro");
        
        //posicoes dos rotulos
        rCodigo.setBounds(50,40,100,20);
        rNome.setBounds(50,80,100,20);
        rEmail.setBounds(50,120,100,20);
        rTel.setBounds(50,160,100,20);
        rData.setBounds(50,200,100,20);
        rPesquisa.setBounds(50,380,550,200);
        rNavegacao.setBounds(485,-5,550,100);
        
        //posicao das caixas de texto e botoes
        tcodigo.setBounds(150,40,30,20);
        tnome.setBounds(150,80,180,20);
        temail.setBounds(150,120,200,20);
        tel.setBounds(150,160,90,20);
        data.setBounds(150,200,70,20);
        prox.setBounds(568,140,30,30);
        anterior.setBounds(513,140,30,30);
        prim.setBounds(513,180,85,20);
        ultimo.setBounds(513,210,85,20);
        novoreg.setBounds(513,60,30,30);
        gravar.setBounds(568,60,30,30);
        alterar.setBounds(513,100,30,30);
        excluir.setBounds(568,100,30,30);
        tpesquisa.setBounds(250,470,250,21);
        pesquisar.setBounds(505,470,30,20);
        sair.setBounds(90,510,30,30);
        retornar.setBounds(50,510,30,30);
       
        
        //estilizando fundo,fonte
        tela.setBackground(new Color(176,196,222));
        rCodigo.setFont(new Font("Calibri",Font.BOLD,16));
        rNome.setFont(new Font("Calibri",Font.BOLD,16));
        rEmail.setFont(new Font("Calibri",Font.BOLD,16));
        rTel.setFont(new Font("Calibri",Font.BOLD,16));
        rData.setFont(new Font("Calibri",Font.BOLD,16));
        rPesquisa.setFont(new Font("Calibri",Font.BOLD,14));
        rNavegacao.setFont(new Font("Calibri",Font.BOLD,16));
        
        //funcionalidades dos butoes
        //sair
        sair.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[]botoes={"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair do programa?","Sair",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,botoes,botoes[0]);
        if(opcao==JOptionPane.YES_OPTION)System.exit(0);
        }});
          
        //proximo
        prox.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
          if(con_cliente.resultset.isLast())
          {
              JOptionPane.showMessageDialog(null, "Não existem registros depois do último! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          }
          else{
         con_cliente.resultset.next();
         mostrar_Dados();
        }}catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //anterior
        anterior.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
          if(con_cliente.resultset.isFirst())
          {
               JOptionPane.showMessageDialog(null, "Não existem registros antes do primeiro registro! "," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
          }
          else{
         con_cliente.resultset.previous();
         mostrar_Dados();
          }}catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //primeiro
        prim.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
         con_cliente.resultset.first();
         mostrar_Dados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //ultimo
        ultimo.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        try
        {
         con_cliente.resultset.last();
         mostrar_Dados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o registro: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
        }
        }});
        
        //novo registro
        novoreg.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          tcodigo.setText("");
          tnome.setText("");
          temail.setText("");
          tel.setText("");
          data.setText("");
          tnome.requestFocus();
         }});
    
        //gravar
        gravar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String nome = tnome.getText();
          String email = temail.getText();
          String telefone = tel.getText();
          String data_nasc = data.getText();
          
          try
          {
           String insert_sql="insert into tbclientes (nome,telefone,email,dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";   
           con_cliente.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
           
           con_cliente.executaSQL("select * from tbclientes order by cod");
           preencherTabela();
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //alterar
        alterar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String nome = tnome.getText();
          String email = temail.getText();
          String telefone = tel.getText();
          String data_nasc = data.getText();
          String sql;
          String msg="";
          try
          {
            if(tcodigo.getText().equals("")){
               sql="insert into tbclientes (nome,telefone,email,dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
               msg="Gravação de um novo registro";
            }else{
                sql="update tbclientes set nome='" + nome + "',telefone='" + telefone + "',email='" + email + "',dt_nasc='" + data_nasc + "'where cod =" + tcodigo.getText();  
                msg="Alteração de registro";
            }
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select *from tbclientes order by cod");
            preencherTabela();
              
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //excluir
        excluir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String sql="";
          try
          {
           int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
           if (resposta==0){
            sql = "delete from tbclientes where cod = " + tcodigo.getText();
            int excluir = con_cliente.statement.executeUpdate(sql);
            if (excluir==1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.executaSQL("select * from tbclientes order by cod");
                con_cliente.resultset.first();
                preencherTabela();
                posicionarRegistro();
            }
            else{
                 JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            }
               
           }}catch (SQLException excecao){
               JOptionPane.showMessageDialog(null, "Erro na exclusão: "+excecao,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);    
           }
          }});
        
        //pesquisar 
        pesquisar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          try{
             String pesquisa = "select * from tbclientes where nome like '" + tpesquisa.getText() + "%'";
             con_cliente.executaSQL(pesquisa);
             
             if(con_cliente.resultset.first()){
                 preencherTabela();
             }
             else{
               JOptionPane.showMessageDialog(null,"\n Não existe dados com este parâmetro!","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
             }
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }  
           
          }});
        
        //sair
        retornar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        frm_login mostra = new frm_login();
        mostra.setVisible(true);
        dispose();
        }});
        
        /////////////////////////configuração da jtable/////////////////////////
        tblClientes = new javax.swing.JTable(){
         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) { //alterar cor das linhas
         Component c = super.prepareRenderer(renderer, row, column);
         if (!isRowSelected(row)){
            c.setBackground(row % 2 == 0 ? Color.WHITE : (new Color(220,220,220)));
        }
        return c;
         }}; //fim da alteração da cor das linhas

        scp_tabela = new javax.swing.JScrollPane();
        
        tblClientes.setBounds(50,260,650,200);
        scp_tabela.setBounds(50,260,550,200);
        
        tela.add(tblClientes);
        tela.add(scp_tabela);
        
        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        tblClientes.setFont(new java.awt.Font("Arial",1,12));
        
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][]{
         {null, null, null, null, null},
         {null, null, null, null, null},
         {null, null, null, null, null},
         {null, null, null, null, null}},
         
         new String[] {"Código", "Nome", "Nascimento", "Telefone", "Email"})
        {
         boolean[] canEdit = new boolean []{false, false, false, false, false};
         
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];}
        
        });
        
        
        scp_tabela.setViewportView(tblClientes);
        tblClientes.setAutoCreateRowSorter(true);//ativa classificacao ordenada da tabela 
        
        
        /////////////////////////fim da config da jtable/////////////////////////
        
        tela.add(rNavegacao);
        tela.add(rCodigo);
        tela.add(rNome);
        tela.add(rEmail);
        tela.add(rTel);
        tela.add(rData);
        tela.add(tcodigo);
        tela.add(tnome);
        tela.add(temail);
        tela.add(tel);
        tela.add(data);
        tela.add(prim);
        tela.add(prox);
        tela.add(ultimo);
        tela.add(anterior);
        tela.add(novoreg);
        tela.add(gravar);
        tela.add(excluir);
        tela.add(alterar);
        tela.add(rPesquisa);
        tela.add(tpesquisa);
        tela.add(pesquisar);
        tela.add(sair);
        tela.add(retornar);
        
        setSize(700,600);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from tbclientes order by cod");
        preencherTabela();   
        posicionarRegistro();
    } 
    
    public void preencherTabela() //metodo para popular as caixas da tabela
    {
       tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
       tblClientes.getColumnModel().getColumn(1).setPreferredWidth(170);
       tblClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
       tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
       tblClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
       
       DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
       modelo.setNumRows(0);
       
       try
       {
         con_cliente.resultset.beforeFirst();
         while(con_cliente.resultset.next())
         {
           modelo.addRow(new Object[]{
               con_cliente.resultset.getString("cod"),con_cliente.resultset.getString("nome"),con_cliente.resultset.getString("dt_nasc"),con_cliente.resultset.getString("telefone"),con_cliente.resultset.getString("email")
           });
         }
       }catch(SQLException erro)
       {
         JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!: \n"+erro,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
    public void posicionarRegistro()
    {
      try
      {
       con_cliente.resultset.first(); //posiciona no 1 registro da tabela
       mostrar_Dados(); //chama o metodo que ira buscar o dado da tabela
      }catch(SQLException erro){
       JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
      }
    }
    
    public void mostrar_Dados()
    {
       try
       {
        tcodigo.setText(con_cliente.resultset.getString("cod")); //associar a caixa de texto ao campo cod
        tnome.setText(con_cliente.resultset.getString("nome")); //associar a caixa de texto ao campo nome
        data.setText(con_cliente.resultset.getString("dt_nasc"));
        tel.setText(con_cliente.resultset.getString("telefone"));
        temail.setText(con_cliente.resultset.getString("email"));
       }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
} 


