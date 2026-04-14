import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercicio2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Sistema de Vendas");
        frame.setSize(320, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(20, 20, 20));

        JLabel labelvalor = new JLabel("Valor da compra");
        labelvalor.setBounds(10, 10, 120, 20);
        labelvalor.setForeground(Color.WHITE);
        frame.add(labelvalor);

        JTextField txtvalor = new JTextField();
        txtvalor.setBounds(150, 10, 120, 20);
        txtvalor.setBackground(new Color(50, 50, 50));
        txtvalor.setForeground(Color.WHITE);
        frame.add(txtvalor);

        JLabel labelcupom = new JLabel("Cupom");
        labelcupom.setBounds(10, 40, 120, 20);
        labelcupom.setForeground(Color.WHITE);
        frame.add(labelcupom);

        JTextField txtcupom = new JTextField();
        txtcupom.setBounds(150, 40, 120, 20);
        txtcupom.setBackground(new Color(50, 50, 50));
        txtcupom.setForeground(Color.WHITE);
        frame.add(txtcupom);

        JButton btn = new JButton("Calcular");
        btn.setBounds(90, 130, 120, 30);
        btn.setBackground(new Color(0, 150, 136));
        btn.setForeground(Color.WHITE);
        frame.add(btn);

        // Troquei JLabel por JTextArea
        JTextArea resultado = new JTextArea();
        resultado.setBounds(20, 170, 260, 60);
        resultado.setEditable(false);
        resultado.setBackground(new Color(20, 20, 20));
        resultado.setForeground(Color.WHITE);
        frame.add(resultado);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorCompra = Double.parseDouble(txtvalor.getText());
                    String cupom = txtcupom.getText();
                    double desconto = 0;

                    if (valorCompra >= 500) {
                        desconto = valorCompra * 0.1;
                    }
                    if (cupom.equals("AMIGAO10")) {
                        desconto += 10;
                    }

                    double resultadoFinal = valorCompra - desconto;

                    resultado.setText(
                            "Valor original: R$ " + valorCompra + "\n" +
                            "Desconto: R$ " + desconto + "\n" +
                            "Final: R$ " + resultadoFinal
                    );

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Digite valores válidos!");
                }
            }
        });

        frame.setVisible(true);
    }
}