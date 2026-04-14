import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercicio4 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Filtro de Streamer");
        frame.setSize(350, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(30, 30, 30));

        JLabel lblDonates = new JLabel("Total de Donates:");
        lblDonates.setBounds(10, 10, 150, 20);
        lblDonates.setForeground(Color.WHITE);
        frame.add(lblDonates);

        JTextField txtDonates = new JTextField();
        txtDonates.setBounds(180, 10, 120, 20);
        txtDonates.setBackground(new Color(50, 50, 50));
        txtDonates.setForeground(Color.WHITE);
        frame.add(txtDonates);

        JLabel lblSubs = new JLabel("Número de Subs:");
        lblSubs.setBounds(10, 40, 150, 20);
        lblSubs.setForeground(Color.WHITE);
        frame.add(lblSubs);

        JTextField txtSubs = new JTextField();
        txtSubs.setBounds(180, 40, 120, 20);
        txtSubs.setBackground(new Color(50, 50, 50));
        txtSubs.setForeground(Color.WHITE);
        frame.add(txtSubs);

        JLabel lblPlataforma = new JLabel("Plataforma:");
        lblPlataforma.setBounds(10, 70, 150, 20);
        lblPlataforma.setForeground(Color.WHITE);
        frame.add(lblPlataforma);

        JRadioButton twitch = new JRadioButton("Twitch");
        twitch.setBounds(180, 70, 100, 20);
        twitch.setBackground(new Color(30, 30, 30));
        twitch.setForeground(new Color(145, 70, 255)); // roxo
        frame.add(twitch);

        JRadioButton youtube = new JRadioButton("YouTube");
        youtube.setBounds(180, 95, 100, 20);
        youtube.setBackground(new Color(30, 30, 30));
        youtube.setForeground(Color.RED);
        frame.add(youtube);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(twitch);
        grupo.add(youtube);

        JButton btn = new JButton("Calcular");
        btn.setBounds(100, 130, 120, 30);
        btn.setBackground(new Color(70, 130, 180)); // azul
        btn.setForeground(Color.WHITE);
        frame.add(btn);

        JLabel resultado = new JLabel();
        resultado.setBounds(20, 170, 300, 60);
        resultado.setForeground(Color.WHITE);
        frame.add(resultado);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double donates = Double.parseDouble(txtDonates.getText());
                    int subs = Integer.parseInt(txtSubs.getText());

                    double valorSubs = subs * 5;
                    double total = donates + valorSubs;

                    if (twitch.isSelected()) {
                        total -= valorSubs * 0.5;
                    } else if (youtube.isSelected()) {
                        total *= 0.7;
                    }

                    if (total < 100) {
                        resultado.setText("<html>Final: R$ " + total +
                                "<br>Saldo insuficiente para saque mínimo</html>");
                    } else {
                        resultado.setText("<html>Final: R$ " + total + "</html>");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Preencha tudo corretamente!");
                }
            }
        });

        frame.setVisible(true);
    }
}