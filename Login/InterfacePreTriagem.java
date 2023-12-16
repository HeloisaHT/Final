package Login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exames.InterfaceTriagem;

import javax.swing.JOptionPane; // Importa a classe JOptionPane

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class InterfacePreTriagem extends JFrame {
    private JTextField nomeDoadorTextField;
    private JTextField cpfDoadorTextField;
    private JTextField idadeDoadorTextField;
    private JTextField pulsoDoadorTextField;
    private JTextField temperaturaDoadorTextField;
    private JTextField pressaoDoadorTextField;
    private JTextField pesoDoadorTextField;
    private JTextField hemoglobinaDoadorTextField;
    private JTextField hematocritoDoadorTextField;
    private JCheckBox habilitadoCheckBox;
            boolean apto = true;

    public InterfacePreTriagem() {
        super("Pré-Triagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);


        final JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        JLabel nomeDoadorLabel = new JLabel("Nome do doador:");
        painel.add(nomeDoadorLabel, constraints);

        nomeDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(nomeDoadorTextField, constraints);

        JLabel cpfDoadorLabel = new JLabel("CPF do doador:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(cpfDoadorLabel, constraints);

        cpfDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(cpfDoadorTextField, constraints);

        JLabel idadeDoadorLabel = new JLabel("Idade do doador:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(idadeDoadorLabel, constraints);

        idadeDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(idadeDoadorTextField, constraints);

        JLabel pulsoDoadorLabel = new JLabel("Pulso do doador:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(pulsoDoadorLabel, constraints);

        pulsoDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(pulsoDoadorTextField, constraints);

        JLabel temperaturaDoadorLabel = new JLabel("Temperatura do doador:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(temperaturaDoadorLabel, constraints);

        temperaturaDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(temperaturaDoadorTextField, constraints);

        JLabel pressaoDoadorLabel = new JLabel("Pressão do doador:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painel.add(pressaoDoadorLabel, constraints);

        pressaoDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(pressaoDoadorTextField, constraints);

        JLabel pesoDoadorLabel = new JLabel("Peso do doador:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painel.add(pesoDoadorLabel, constraints);

        pesoDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(pesoDoadorTextField, constraints);

        JLabel hemoglobinaDoadorLabel = new JLabel("Hemoglobina do doador:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        painel.add(hemoglobinaDoadorLabel, constraints);

        hemoglobinaDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(hemoglobinaDoadorTextField, constraints);

        JLabel hematocritoDoadorLabel = new JLabel("Hematócrito do doador:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        painel.add(hematocritoDoadorLabel, constraints);

        hematocritoDoadorTextField = new JTextField(20);
        constraints.gridx = 1;
        painel.add(hematocritoDoadorTextField, constraints);


        JLabel habilitadoLabel = new JLabel("Habilitado para doação:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        painel.add(habilitadoLabel, constraints);

        habilitadoCheckBox = new JCheckBox();
        constraints.gridx = 1;
        painel.add(habilitadoCheckBox, constraints);


        JButton salvarButton = new JButton("Salvar");
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        painel.add(salvarButton, constraints);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (habilitadoCheckBox.isSelected()) {
            
                    int idade = Integer.parseInt(idadeDoadorTextField.getText());
                    double temperatura = Double.parseDouble(temperaturaDoadorTextField.getText());
                    int pulso = Integer.parseInt(pulsoDoadorTextField.getText());
                    double pressao = Double.parseDouble(pressaoDoadorTextField.getText());
                    double peso = Double.parseDouble(pesoDoadorTextField.getText());
                    double hemoglobina = Double.parseDouble(hemoglobinaDoadorTextField.getText());
                    double hematocrito = Double.parseDouble(hematocritoDoadorTextField.getText());

                    apto = true;
                    if (idade < 18) {
                        apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. Menores de 18 anos não são elegíveis.");
                    }  if (temperatura < 35 || temperatura > 37) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. A temperatura está fora da faixa permitida.");
                    }  if (pulso < 50 || pulso > 90) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. O pulso está fora da faixa permitida.");
                    } if (pressao < 9 || pressao > 13) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. A pressão está fora da faixa permitida.");
                    }  if (peso < 50) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. O peso está abaixo do mínimo permitido ."+apto);
                    }  if (hemoglobina < 12 || hemoglobina > 16) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. A hemoglobina está fora da faixa permitida.");
                    }  if (hematocrito < 35 || hematocrito > 50) {
                           apto = false;
                        JOptionPane.showMessageDialog(null,
                                "Você não pode doar sangue. O hematócrito está fora da faixa permitida.");
                    } if (apto == true) {
                        dispose(); // Fecha a janela atual
                        InterfaceTriagem interfaceTriagem = new InterfaceTriagem();
                        interfaceTriagem.setVisible(true);
                    }
                } else {
                    // Se não estiver habilitada, exibe uma mensagem
                    JOptionPane.showMessageDialog(null,
                            "Você não está apto para doar. Consulte seu médico para mais informações.");
                }

                if (apto) {
                    try {
                        // Crie uma instância de PreTriagem com os dados coletados
                        PreTriagem preTriagem = new PreTriagem(
                                nomeDoadorTextField.getText(),
                                cpfDoadorTextField.getText(),
                                Integer.parseInt(idadeDoadorTextField.getText()),
                                Double.parseDouble(temperaturaDoadorTextField.getText()),
                                Integer.parseInt(pulsoDoadorTextField.getText()),
                                Double.parseDouble(pressaoDoadorTextField.getText()),
                                Double.parseDouble(pesoDoadorTextField.getText()),
                                Double.parseDouble(hemoglobinaDoadorTextField.getText()),
                                Double.parseDouble(hematocritoDoadorTextField.getText()),
                                apto
                        );
        
                        // Salve os dados no banco de dados
                        ConexaoMysql conexao = new ConexaoMysql();
                        conexao.OpenDatabase();
                        int resultado = conexao.InsereTriagem(preTriagem);
                        conexao.CloseDatabase();
        
                        if (resultado > 0) {
                            dispose(); // Fecha a janela atual
                            InterfaceTriagem interfaceTriagem = new InterfaceTriagem();
                            interfaceTriagem.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no banco de dados.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
                    }
                }
            }
        });
                
            

                
                 

        add(painel);
        setVisible(true);

        }

    }
 
