import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercicio1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simulador de Frete");
        frame.setSize(320, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(25, 25, 25));

        JLabel lblDist = new JLabel("Distância (km):");
        lblDist.setBounds(10, 10, 120, 20);
        lblDist.setForeground(Color.WHITE);
        frame.add(lblDist);

        JTextField txtDist = new JTextField();
        txtDist.setBounds(150, 10, 120, 20);
        txtDist.setBackground(new Color(50, 50, 50));
        txtDist.setForeground(Color.WHITE);
        frame.add(txtDist);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(10, 40, 120, 20);
        lblPeso.setForeground(Color.WHITE);
        frame.add(lblPeso);

        JTextField txtPeso = new JTextField();
        txtPeso.setBounds(150, 40, 120, 20);
        txtPeso.setBackground(new Color(50, 50, 50));
        txtPeso.setForeground(Color.WHITE);
        frame.add(txtPeso);

        JLabel lblTipo = new JLabel("Tipo de envio:");
        lblTipo.setBounds(10, 70, 120, 20);
        lblTipo.setForeground(Color.WHITE);
        frame.add(lblTipo);

        JRadioButton normal = new JRadioButton("Normal");
        normal.setBounds(150, 70, 100, 20);
        normal.setBackground(new Color(25, 25, 25));
        normal.setForeground(Color.GREEN);
        frame.add(normal);

        JRadioButton expresso = new JRadioButton("Expresso");
        expresso.setBounds(150, 95, 100, 20);
        expresso.setBackground(new Color(25, 25, 25));
        expresso.setForeground(Color.RED);
        frame.add(expresso);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(normal);
        grupo.add(expresso);

        JButton btn = new JButton("Calcular");
        btn.setBounds(90, 130, 120, 30);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        frame.add(btn);

        // Resultado com JTextArea (padrão dos outros)
        JTextArea resultado = new JTextArea();
        resultado.setBounds(70, 170, 180, 50);
        resultado.setEditable(false);
        resultado.setBackground(new Color(25, 25, 25));
        resultado.setForeground(Color.WHITE);
        frame.add(resultado);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double distancia = Double.parseDouble(txtDist.getText());
                    double peso = Double.parseDouble(txtPeso.getText());

                    double valor = 10;
                    valor += distancia * 0.5;

                    if (peso > 20) {
                        valor += 30;
                    }

                    if (expresso.isSelected()) {
                        valor *= 1.2;
                    }

                    resultado.setText(String.format("Valor do frete:\nR$ %.2f", valor));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Digite valores válidos!");
                }
            }
        });

        frame.setVisible(true);
    }
}