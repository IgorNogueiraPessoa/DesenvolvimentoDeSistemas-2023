package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel; //reconhecer a jtable
import conexao.conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.table.TableCellRenderer;
import javax.swing.JFrame;


public class adm_func extends JFrame {
        
    conexao con_cliente;
    
    JLabel rCodigo, rNome, rEmail, rTel, rData, rcfunc, rccargo, rdataadms, rlogin, rsenha, rPesquisa,rNavegacao;
    JTextField tnome, temail, tpesquisa, tcfunc, tccargo, tdataadms, tlogin, tsenha;
    JFormattedTextField tel, data, dataadms;
    MaskFormatter mTel,mData,mdataadms;
    JButton prim,anterior,prox,ultimo, novoreg,gravar,alterar,excluir,pesquisar, sair, retornar, voltar;
    ImageIcon imagem[];
    
    JTable tblClientes; //datagrid
    JScrollPane scp_tabela; //container para o datagrid

    //imagem de fundo
         class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            try {
                backgroundImage = javax.imageio.ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
    
    public adm_func(final int cargo)
    {
        con_cliente = new conexao(); //inicializacao do objeto
        con_cliente.conecta(); //chama o metodo que conecta
        
         setTitle("Tela Cadastro de Funcionário");
         ImagePanel backgroundPanel = new ImagePanel("src/imagens/fundo6.png");
         setContentPane(backgroundPanel);
         backgroundPanel.setLayout(null);
         setResizable(false);
         
        rCodigo = new JLabel("Código: ");
        rcfunc = new JLabel("Código do funcionário: ");
        rccargo = new JLabel("Cod cargo: ");
        rNome = new JLabel("Nome: ");
        rEmail = new JLabel("Email: ");
        rTel = new JLabel ("Telefone: ");
        rData = new JLabel ("Dt Nascimento: ");
        rdataadms = new JLabel ("Dt Admissão: ");
        rlogin = new JLabel ("Login: ");
        rsenha = new JLabel ("Senha: ");
        rPesquisa = new JLabel ("Pesquisar pelo nome do funcionário: ");
        rNavegacao = new JLabel ("Botões de navegação: ");
        tcfunc = new JTextField(5);
        tnome = new JTextField(5);
        temail = new JTextField(5);
        tpesquisa = new JTextField(5);
        tccargo = new JTextField(5);
        tdataadms = new JTextField(5);
        tlogin = new JTextField(5);
        tsenha = new JTextField(5);
        prim = new JButton("Primeiro");
        ultimo = new JButton("Último");
         //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());   
       
        //mascara dos campos telefone e data
        try
        {
        mTel = new MaskFormatter("(##)#####-####");
        mData = new MaskFormatter("##/##/####");
        mdataadms = new MaskFormatter("##/##/####");
        }
        catch(ParseException excp){}
        
        tel = new JFormattedTextField(mTel);
        data = new JFormattedTextField(mData);
        dataadms = new JFormattedTextField(mdataadms);
        
        //icones dos botões
        String icones[]={"src/imagens/search.png","src/imagens/write.png","src/imagens/delete.png","src/imagens/alter.png","src/imagens/new.png","src/imagens/next.png","src/imagens/previous.png","src/imagens/exit.png","src/imagens/return.png","src/imagens/back.png"};
        imagem = new ImageIcon[10];
        for(int i = 0;i<10;i++)
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
        voltar = new JButton(imagem[9]);
        
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
        voltar.setToolTipText("Retornar para tela principal");
        
        //posicoes dos rotulos
        rccargo.setBounds(360,40,100,25);
        rNome.setBounds(50,40,100,20);
        rEmail.setBounds(50,80,100,20);
        rTel.setBounds(50,120,100,20);
        rData.setBounds(50,160,150,20);
        rdataadms.setBounds(50,200,150,20);
        rlogin.setBounds(50,240,150,20);
        rsenha.setBounds(50,280,150,20);
        rPesquisa.setBounds(50,525,300,25);
        rNavegacao.setBounds(860,65,550,100);
        
        //posicao das caixas de texto e botoes
        tccargo.setBounds(440,40,30,20);
        tnome.setBounds(160,40,180,20);
        temail.setBounds(160,80,200,20);
        tel.setBounds(160,120,100,20);
        data.setBounds(160,160,70,20);
        dataadms.setBounds(160,200,70,20);
        tlogin.setBounds(160, 240, 100, 20);
        tsenha.setBounds(160, 280, 100, 20);
        prox.setBounds(965,210,30,30);
        anterior.setBounds(910,210,30,30);
        prim.setBounds(910,250,85,20);
        ultimo.setBounds(910,280,85,20);
        novoreg.setBounds(910,130,30,30);
        gravar.setBounds(965,130,30,30);
        alterar.setBounds(910,170,30,30);
        excluir.setBounds(965,170,30,30);
        tpesquisa.setBounds(350,525,250,21);
        pesquisar.setBounds(605,525,30,20);
        sair.setBounds(130,560,30,30);
        retornar.setBounds(50,560,30,30);
        voltar.setBounds(90,560,30,30);
       
        
        //estilizando fundo,fonte
        backgroundPanel.setBackground(new Color(176,196,222));
        rccargo.setFont(new Font("Calibri",Font.BOLD,16));
        rNome.setFont(new Font("Calibri",Font.BOLD,16));
        rEmail.setFont(new Font("Calibri",Font.BOLD,16));
        rTel.setFont(new Font("Calibri",Font.BOLD,16));
        rData.setFont(new Font("Calibri",Font.BOLD,16));
        rdataadms.setFont(new Font("Calibri",Font.BOLD,16));
        rlogin.setFont(new Font("Calibri",Font.BOLD,16));
        rsenha.setFont(new Font("Calibri",Font.BOLD,16));
        rPesquisa.setFont(new Font("Calibri",Font.BOLD,16));
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
          tcfunc.setText("");
          tccargo.setText("");
          tnome.setText("");
          temail.setText("");
          tel.setText("");
          data.setText("");
          dataadms.setText("");
          tlogin.setText("");
          tsenha.setText("");
          tnome.requestFocus();
         }});
    
        //gravar
        gravar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String codfunc = tcfunc.getText(); 
          String codcargo = tccargo.getText(); 
          String nome = tnome.getText();
          String email = temail.getText();
          String telefone = tel.getText();
          String data_adms = dataadms.getText();
          String data_nasc = data.getText();
          String loginf = tlogin.getText();
          String senhaf = tsenha.getText();
          
          try
          {
           String insert_sql="insert into funcionario (cod_cargo,nome_func,email_func,tel_func,data_adms,dtnasc_func,login_func,senha_func) values ('" + codcargo + "','" + nome + "','" + email + "','" + telefone + "','" + data_adms + "','" + data_nasc + "','" + loginf + "','" + senhaf + "')";   
           con_cliente.statement.executeUpdate(insert_sql);
           JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
           
           con_cliente.executaSQL("select * from funcionario order by cod_func");
           preencherTabela();
          }catch(SQLException errosql){
               JOptionPane.showMessageDialog(null, "erro fudido: "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
          }
         }});
        
        //alterar
        alterar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)  
         {
          String codfunc = tcfunc.getText(); 
          String codcargo = tccargo.getText(); 
          String nome = tnome.getText();
          String email = temail.getText();
          String telefone = tel.getText();
          String data_adms = dataadms.getText();
          String data_nasc = data.getText();
          String loginf = tlogin.getText();
          String senhaf = tsenha.getText();
          String sql;
          String msg="";
          try
          {
            if(tcfunc.getText().equals("")){
               sql="insert into funcionario (cod_cargo,nome_func,email_func,tel_func,data_adms,dtnasc_func,login_func,senha_func) values ('" + codcargo + "','" + nome + "','" + email + "','" + telefone + "','" + data_adms + "','" + data_nasc + "','" + loginf + "','" + senhaf + "')";
               msg="Gravação de um novo registro";
            }else{
                sql="update funcionario set nome_func='" + nome + "',email_func='" + email + "',tel_func='" + telefone + "',data_adms='" + data_adms + "',dtnasc_func='" + data_nasc + "',login_func='" + loginf + "',senha_func='" + senhaf + "'where cod_func =" + tcfunc.getText();  
                msg="Alteração de registro";
            }
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            
            con_cliente.executaSQL("select *from funcionario order by cod_func");
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
            sql = "delete from funcionario where cod_func = " + tcfunc.getText();
            int excluir = con_cliente.statement.executeUpdate(sql);
            if (excluir==1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                con_cliente.executaSQL("select * from funcionario order by cod_func");
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
             String pesquisa = "select * from funcionario where nome_func like '" + tpesquisa.getText() + "%'";
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
        
        //Voltar
        voltar.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
        menu mostra = new menu(cargo);
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
        
        tblClientes.setBounds(50,320,950,200);
        scp_tabela.setBounds(50,320,950,200);
        
        backgroundPanel.add(tblClientes);
        backgroundPanel.add(scp_tabela);
        
        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        tblClientes.setFont(new java.awt.Font("Arial",1,12));
        
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][]{
         {null, null, null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null, null, null},
         {null, null, null, null, null, null, null, null, null}},
         
         new String[] {"cod_func","cod_cargo", "nome", "email", "telefone", "admissão", "nascimento", "login", "senha"})
        {
         boolean[] canEdit = new boolean []{false, false, false, false, false, false, false, false, false};
         
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];}
        
        });
        
        
        scp_tabela.setViewportView(tblClientes);
        tblClientes.setAutoCreateRowSorter(true);//ativa classificacao ordenada da tabela 
        
        
        /////////////////////////fim da config da jtable/////////////////////////
        
        backgroundPanel.add(rNavegacao);
        backgroundPanel.add(rccargo);
        //backgroundPanel.add(rCodigo);
        backgroundPanel.add(rNome);
        backgroundPanel.add(rEmail);
        backgroundPanel.add(rTel);
        backgroundPanel.add(rData);
        backgroundPanel.add(rdataadms);
        backgroundPanel.add(rlogin);
        backgroundPanel.add(rsenha);
        //backgroundPanel.add(tcfunc);
        backgroundPanel.add(tccargo);
        backgroundPanel.add(tnome);
        backgroundPanel.add(temail);
        backgroundPanel.add(tel);
        backgroundPanel.add(data);
        backgroundPanel.add(dataadms);
        backgroundPanel.add(tlogin);
        backgroundPanel.add(tsenha);
        backgroundPanel.add(prim);
        backgroundPanel.add(prox);
        backgroundPanel.add(ultimo);
        backgroundPanel.add(anterior);
        backgroundPanel.add(novoreg);
        backgroundPanel.add(gravar);
        backgroundPanel.add(excluir);
        backgroundPanel.add(alterar);
        backgroundPanel.add(rPesquisa);
        backgroundPanel.add(tpesquisa);
        backgroundPanel.add(pesquisar);
        backgroundPanel.add(sair);
        backgroundPanel.add(retornar);
        backgroundPanel.add(voltar);
        
        setSize(1050,650);
        setVisible(true);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from funcionario order by cod_func");
        preencherTabela();   
        posicionarRegistro();
    } 
    
    public void preencherTabela() //metodo para popular as caixas da tabela
    {
       tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
       tblClientes.getColumnModel().getColumn(1).setPreferredWidth(80);
       tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
       tblClientes.getColumnModel().getColumn(3).setPreferredWidth(250);
       tblClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
       tblClientes.getColumnModel().getColumn(5).setPreferredWidth(120);
       tblClientes.getColumnModel().getColumn(6).setPreferredWidth(80);
       tblClientes.getColumnModel().getColumn(7).setPreferredWidth(100);
       tblClientes.getColumnModel().getColumn(8).setPreferredWidth(150);
       
       DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
       modelo.setNumRows(0);
       
       try
       {
         con_cliente.resultset.beforeFirst();
         while(con_cliente.resultset.next())
         {
           modelo.addRow(new Object[]{
               con_cliente.resultset.getString("cod_func"),con_cliente.resultset.getString("cod_cargo"),con_cliente.resultset.getString("nome_func"),con_cliente.resultset.getString("email_func"),con_cliente.resultset.getString("tel_func"),con_cliente.resultset.getString("data_adms"),con_cliente.resultset.getString("dtnasc_func"),con_cliente.resultset.getString("login_func"),con_cliente.resultset.getString("senha_func")
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
        tcfunc.setText(con_cliente.resultset.getString("cod_func")); //associar a caixa de texto ao campo cod
        tccargo.setText(con_cliente.resultset.getString("cod_cargo")); //associar a caixa de texto ao campo cod
        tnome.setText(con_cliente.resultset.getString("nome_func")); //associar a caixa de texto ao campo nome
        data.setText(con_cliente.resultset.getString("dtnasc_func"));
        dataadms.setText(con_cliente.resultset.getString("data_adms"));
        tlogin.setText(con_cliente.resultset.getString("login_func"));
        tsenha.setText(con_cliente.resultset.getString("senha_func"));
        tel.setText(con_cliente.resultset.getString("tel_func"));
        temail.setText(con_cliente.resultset.getString("email_func"));
       }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro," Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
       }
    }
}


