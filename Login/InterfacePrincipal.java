package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfacePrincipal extends JFrame {
    private JButton botaoPreTriagem;
    private JButton botaoAlterarDadosUsuario;
    private JButton botaoSair;

    private Usuario usuarioLogado;

    public InterfacePrincipal(Usuario usuarioLogado) {
        super("Sistema de doação de sangue");
        this.usuarioLogado = usuarioLogado;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;

        botaoAlterarDadosUsuario = new JButton("Alterar Dados do Usuário");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(botaoAlterarDadosUsuario, constraints);

        botaoPreTriagem = new JButton("Pré-Triagem");
        constraints.gridx = 1;
        painel.add(botaoPreTriagem, constraints);

        botaoSair = new JButton("Sair");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painel.add(botaoSair, constraints);

        add(painel);
        setVisible(true);

        botaoPreTriagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InterfacePreTriagem();
            }
        });

        botaoAlterarDadosUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método para alterar os dados do usuário
                alterarDadosUsuario();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona a lógica para voltar à tela de login
                dispose();
                new InterfaceLogin(null);
            }
        });
    }

    private void alterarDadosUsuario() {
        dispose();
        new InterfaceAlterarDadosUsuario(usuarioLogado, null);
    }

    public static void main(String[] args) {
        // Exemplo de uso
        SwingUtilities.invokeLater(() -> {
            // Supondo que você já tenha um usuário autenticado
            Usuario usuarioAutenticado = new Usuario("Exemplo", "123456", "Rua Exemplo", "123456789", "A+", "exemplo@email.com", "senha");
            new InterfacePrincipal(usuarioAutenticado);
        });
    }
}