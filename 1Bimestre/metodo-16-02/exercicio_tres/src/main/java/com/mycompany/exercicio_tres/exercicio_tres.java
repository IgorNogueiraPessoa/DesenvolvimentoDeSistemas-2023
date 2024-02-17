package com.mycompany.exercicio_tres;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class exercicio_tres {
    public static void main(String[] args)
    {
      String sexo;
      double alt;
      
      sexo=JOptionPane.showInputDialog("Digite seu sexo: f para feminino, m para masculino ");
      alt=Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura"));
      
      double pesoid = calcularPesoIdeal(sexo, alt);
      DecimalFormat df = new DecimalFormat("#.#");
      JOptionPane.showMessageDialog(null,"Seu peso ideal, de acordo com seu gênero e altura, seria de: "+df.format(pesoid));
    }
    
    static double calcularPesoIdeal(String sexo2, double alt2)
    {
    if ("m".equals(sexo2))
    {
    double res=(72.7*alt2)-58;
    return res;
    }
    else if("f".equals(sexo2))
    {
    double res=(62.1*alt2)-44.7;
    return res;
    }
    else
    {
    JOptionPane.showMessageDialog(null, "Digite apenas f ou m!");
    System.exit(0);
    }
    return 0;    
    }            
}