package Exames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Login.InterfacePrincipal;

public class InterfaceTriagem extends JFrame {
    private JRadioButton[] radioSim;
    private JRadioButton[] radioNao;
    private JButton botaoVoltar;

    public InterfaceTriagem() {
        super("Triagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;

        
        radioSim = new JRadioButton[15];
        radioNao = new JRadioButton[15];

        for (int i = 0; i < 15; i++) {
            constraints.gridx = 0;
            constraints.gridy = i;

            
            JLabel labelPergunta = new JLabel((i + 1) + ": ");
            switch (i) {
                case 0:
                    labelPergunta.setText("1. Você teve gripe, febre ou infecção recentemente?");
                    break;
                case 1:
                    labelPergunta.setText("2. Você fez tatuagem, piercing ou colocou brinco nos últimos 6 meses?");
                    break;
                case 2:
                    labelPergunta.setText("3. Você fez alguma cirurgia nos últimos 12 meses?");
                    break;

                case 3:
                    labelPergunta.setText(
                            "4. Você teve contato com pessoas que apresentaram sintomas de hepatite ou HIV nos últimos 6 meses?");
                    break;

                case 4:
                    labelPergunta.setText("5. Você está grávida ou amamentando?");
                    break;
                case 5:
                    labelPergunta.setText("6. Você tem ou já teve doenças cardíacas ou respiratórias?");
                    break;
                case 6:
                    labelPergunta.setText("7. Você tem histórico de anemia?");
                    break;
                case 7:
                    labelPergunta.setText("8. Você já teve malária ou doenças transmitidas pelo mosquito Aedes\n" + //
                            "aegypti??");
                    break;
                case 8:
                    labelPergunta.setText("9. Você tomou algum medicamento nos últimos 7 dias?");
                    break;
                case 9:
                    labelPergunta.setText("10. Você ingeriu bebida alcoólica nas últimas 24 horas?");
                    break;
                case 10:
                    labelPergunta.setText("11. Você é usuário de drogas ilícitas?");
                    break;
                case 11:
                    labelPergunta.setText("12. Você viajou para áreas consideradas de risco para doenças\n" + //
                            "infecciosas nos últimos 30 dias?");
                    break;
                case 12:
                    labelPergunta.setText("13. Você possui algum tipo de doença autoimune?");
                    break;
                case 13:
                    labelPergunta.setText("14. Você tem algum tipo de alergia alimentar ou medicamentosa?");
                    break;
                case 14:
                    labelPergunta.setText("15. Você tem diabetes ou pressão alta?");
                    break;
            }

            painel.add(labelPergunta, constraints);
            radioSim[i] = new JRadioButton("Sim");
            constraints.gridx = 1;
            painel.add(radioSim[i], constraints);

            radioNao[i] = new JRadioButton("Não");
            constraints.gridx = 2;
            painel.add(radioNao[i], constraints);

            ButtonGroup grupo = new ButtonGroup();
            grupo.add(radioSim[i]);
            grupo.add(radioNao[i]);
        }

        JButton botaoVerificar = new JButton("Verificar");
        constraints.gridx = 0;
        constraints.gridy = 15;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        painel.add(botaoVerificar, constraints);

        add(painel);
        setVisible(true);

        botaoVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean elegivel = true;

                for (int i = 0; i < 15; i++) {
                    if (radioSim[i].isSelected()) {
                        elegivel = false;
                        break;
                    }
                }

                if (elegivel) {
                    JOptionPane.showMessageDialog(null,
                            "Você é elegível para doar sangue. Por favor, prossiga para a próxima etapa.");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Você não é elegível para doar sangue. Por favor, consulte um profissional de saúde para obter mais informações e orientações.");
                }
            }
        });

        botaoVoltar = new JButton("Voltar ");
        constraints.gridx = 0;
        constraints.gridy = 16; 
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        painel.add(botaoVoltar, constraints);

        add(painel);
        setVisible(true);
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfacePrincipal(null);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceTriagem();
            }
        });
    }
}