/* esta classe será responsavel pela conexao com o mysql e tera 3 metodo:
 *metodo 1: abertura da conexao 
 * metodo 2: fechamento da conexao
 * metodo 3: execucao de comandos sql
 */
package conexao;

import javax.swing.JOptionPane;
import java.sql.*; //para execucao de comandos sql para ambiente java

public class Conexao 
{
    final private String driver = "com.mysql.cj.jdbc.Driver"; //definicao do driver mysql para acesso aos dados
    final private String url = "jdbc:mysql://localhost/clientes"; //acesso ao bd 'clientes' no servidor (myadm)
    final private String usuario = "root";  //usuario do mysql
    final private String senha = ""; //senha mysql
    private Connection conexao; //variavel que armazenará a conexao aberta
    public Statement statement; //variavel que executa comandos sql dentro do ambiente java
    public ResultSet resultset; //variavel que armazenara o resultado da execucao de um comando sq1
    
     
    public boolean conecta()
    {
       boolean result = true;
       try
       {
         Class.forName(driver);
         conexao = DriverManager.getConnection(url,usuario,senha);
        
       }catch (ClassNotFoundException Driver)
       {
         JOptionPane.showMessageDialog(null, "Driver não localizado"+Driver,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
         result = false; 
       }catch (SQLException Fonte)
       {
         JOptionPane.showMessageDialog(null, "Fonte de dados não localizado"+Fonte,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
         result = false;
       }
       return result;
    }
    
    public void desconecta()
    {
       try
       {
         conexao.close();
         JOptionPane.showMessageDialog(null, "Conexão com o banco fechada","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
       }catch(SQLException fecha)
       {
         JOptionPane.showMessageDialog(null, "Erro ao fechar o banco","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
    public void executaSQL(String sql)
    {
       try
       {
         statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
         resultset = statement.executeQuery(sql);
       }catch(SQLException excecao)
       {
         JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro "+excecao,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
       }
    }
}
