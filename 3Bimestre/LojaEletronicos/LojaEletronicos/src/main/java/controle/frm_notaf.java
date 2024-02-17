package controle;

import javax.swing.*;
import java.awt.*;
import conexao.conexao;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frm_notaf extends JFrame {

    conexao con_clientes;
    JLabel produto, data, vendedor,cliente, hora,nomecli;
    JLabel total;
    JButton voltar;
    ImageIcon imagem[];
    ArrayList<String> itens = new ArrayList<String>();

    int posicao_Y = 265;
    double totalres = 0;

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

    public frm_notaf(final int cargo, final int cod_nota) {

        con_clientes = new conexao();
        con_clientes.conecta();

        setTitle("Nota fiscal");
        frm_notaf.ImagePanel backgroundPanel = new frm_notaf.ImagePanel("src/imagens/fundo-nota.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

        String sql = "select * from notafiscal where cod_nota like " + cod_nota;
        con_clientes.executaSQL(sql);
        try {
            if (con_clientes.resultset.next()) {

                int codcli = con_clientes.resultset.getInt("cod_cli");
                String codfunc = con_clientes.resultset.getString("cod_func");
                String dtcompra = con_clientes.resultset.getString("dtcompra_nota");
                String hrcompra = con_clientes.resultset.getString("hr_nota");
               
          
                data = new JLabel("Data da Compra: " + dtcompra);
                hora = new JLabel("Horário da emissão: "+hrcompra);
                vendedor = new JLabel("Código do vendedor emissor da nota: " + codfunc);
                data.setBounds(10, 145, 200, 20); 
                hora.setBounds(10, 165, 300, 20);
                vendedor.setBounds(10,225,300,20);
                backgroundPanel.add(data);
                backgroundPanel.add(vendedor);
                if (codcli < 1)
                {
                cliente = new JLabel("Código do cliente: " + codcli + " (não cadastrado)");
                cliente.setBounds(10, 185, 300, 20); 
                backgroundPanel.add(cliente);
                nomecli = new JLabel ("Nome do cliente: Cliente não Cadastrado ");
                nomecli.setBounds(10,205,300,20);
                backgroundPanel.add(nomecli);
                }
                else
                {
                cliente = new JLabel("Código do cliente: " + codcli);
                cliente.setBounds(10, 185, 300, 20); 
                backgroundPanel.add(cliente);      
                
                
                String sql1 = "select * from dadoscliente where cod_cli like " + codcli;
                con_clientes.executaSQL(sql1);
                if(con_clientes.resultset.next()){
                    String nome_cli = con_clientes.resultset.getString("nome_cli");
                    nomecli = new JLabel ("Nome do cliente: "+nome_cli);
                    nomecli.setBounds(10,205,300,20);
                    backgroundPanel.add(nomecli);
                }
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parâmetro!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            }
          
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }

        con_clientes.executaSQL("select * from itensnfiscal where cod_nota like '" + cod_nota + "'");

        try {
            while (con_clientes.resultset.next()) {
                itens.add(con_clientes.resultset.getString("cod_pro"));
            }

            JLabel LabelsNome[] = new JLabel[itens.size()];
            double multiplicacao = 0;

            for (String row : itens) {

                con_clientes.executaSQL("select qtcompra from itensnfiscal where cod_nota like '" + cod_nota + "' and cod_pro like '" + row + "'");
                if (con_clientes.resultset.next()) {
                    int qnt_prod = con_clientes.resultset.getInt("qtcompra");
                    con_clientes.executaSQL("select * from produto where cod_pro like '" + row + "'");

                    if (con_clientes.resultset.next()) {

                        for (JLabel rNome_pro : LabelsNome) {

                            String nome_prod = con_clientes.resultset.getString("nome_pro");
                            Double preco_prod = con_clientes.resultset.getDouble("preco");

                            rNome_pro = new JLabel(nome_prod + "   " + preco_prod + "   x" + qnt_prod);
                            rNome_pro.setBounds(10, posicao_Y, 200, 20);
                            backgroundPanel.add(rNome_pro);
                            
                            multiplicacao = (preco_prod * qnt_prod);
                        }
                        
                        totalres = totalres+multiplicacao;
                            
                        System.out.println(multiplicacao+"Multiplicação");
                        System.out.println(totalres+"Totalres");
                    }

                    posicao_Y += 30;  // Add 30 pixels for each new product
                }
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }

        total = new JLabel(String.format("Total da Compra: R$ %.2f", totalres), JLabel.RIGHT);
        String icones[] = {"src/imagens/back.png"};
        imagem = new ImageIcon[2];
        for(int i = 0;i<1;i++)
        {
        imagem[i] = new ImageIcon(icones[i]);
        }
        voltar = new JButton(imagem[0]);
 
        
        //posicão da backgroundPanel//
        total.setBounds(75,550,300,20);

        
        //icone da janela
        ImageIcon icone = new ImageIcon("src/imagens/iconetriforce.png");
        setIconImage(icone.getImage());                 
        
      
        backgroundPanel.add(total);
        backgroundPanel.add(hora);
        setSize(400,650);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
}
}
