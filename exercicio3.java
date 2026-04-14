import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercicio3 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculador de XP");
        frame.setSize(350, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(25, 25, 25));

        JLabel lblNivel = new JLabel("Nível atual:");
        lblNivel.setBounds(10, 10, 120, 20);
        lblNivel.setForeground(Color.WHITE);
        frame.add(lblNivel);

        JTextField txtNivel = new JTextField();
        txtNivel.setBounds(150, 10, 120, 20);
        txtNivel.setBackground(new Color(50, 50, 50));
        txtNivel.setForeground(Color.WHITE);
        frame.add(txtNivel);

        JLabel lblXP = new JLabel("XP atual:");
        lblXP.setBounds(10, 40, 120, 20);
        lblXP.setForeground(Color.WHITE);
        frame.add(lblXP);

        JTextField txtXP = new JTextField();
        txtXP.setBounds(150, 40, 120, 20);
        txtXP.setBackground(new Color(50, 50, 50));
        txtXP.setForeground(Color.WHITE);
        frame.add(txtXP);

        JLabel lblDif = new JLabel("Dificuldade:");
        lblDif.setBounds(10, 70, 120, 20);
        lblDif.setForeground(Color.WHITE);
        frame.add(lblDif);

        JRadioButton facil = new JRadioButton("Fácil");
        facil.setBounds(150, 70, 100, 20);
        facil.setBackground(new Color(25, 25, 25));
        facil.setForeground(Color.GREEN);
        frame.add(facil);

        JRadioButton media = new JRadioButton("Média");
        media.setBounds(150, 95, 100, 20);
        media.setBackground(new Color(25, 25, 25));
        media.setForeground(Color.ORANGE);
        frame.add(media);

        JRadioButton dificil = new JRadioButton("Difícil");
        dificil.setBounds(150, 120, 100, 20);
        dificil.setBackground(new Color(25, 25, 25));
        dificil.setForeground(Color.RED);
        frame.add(dificil);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(facil);
        grupo.add(media);
        grupo.add(dificil);

        JButton btn = new JButton("Calcular XP");
        btn.setBounds(100, 150, 130, 30);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        frame.add(btn);

        // Troca aqui
        JTextArea resultado = new JTextArea();
        resultado.setBounds(20, 190, 300, 60);
        resultado.setEditable(false);
        resultado.setBackground(new Color(25, 25, 25));
        resultado.setForeground(Color.WHITE);
        frame.add(resultado);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int nivel = Integer.parseInt(txtNivel.getText());
                    double xp = Double.parseDouble(txtXP.getText());

                    double ganhoXP = 100;

                    if (media.isSelected()) {
                        ganhoXP *= 1.5;
                    } else if (dificil.isSelected()) {
                        ganhoXP *= 2.0;
                    }

                    double totalXP = xp + ganhoXP;

                    if (totalXP >= 1000) {
                        resultado.setText(
                                "XP Total: " + totalXP + "\n" +
                                "PARABÉNS! Subiu para nível " + (nivel + 1)
                        );
                    } else {
                        resultado.setText("XP Total: " + totalXP);
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Preencha corretamente!");
                }
            }
        });

        frame.setVisible(true);
    }
}