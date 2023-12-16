package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceAlterarDadosUsuario extends JFrame {
    private JTextField campoNovoNome;
    private JTextField campoNovoTelefone;
    private JTextField campoNovoEndereco;
    private JTextField campoNovoCpf;
    private JTextField campoNovoTipoSanguineo;
    private JTextField campoNovoEmail;
    private JPasswordField campoNovaSenha;
    private JButton botaoSalvar;
    private JButton botaoSair;
    private Usuario usuario;
    private InterfacePrincipal interfacePrincipal; // Adicionando a referência

    private Usuario usuarioLogado;

    public InterfaceAlterarDadosUsuario(Usuario usuarioLogado, InterfacePrincipal interfacePrincipal) {
        super("Alterar Dados do Usuário");
        this.usuarioLogado = usuarioLogado;
        this.interfacePrincipal = interfacePrincipal; // Armazenando a referência
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo("Novo Nome:", campoNovoNome = new JTextField(20), painel, constraints);
        adicionarCampo("Novo Telefone:", campoNovoTelefone = new JTextField(20), painel, constraints);
        adicionarCampo("Novo Endereço:", campoNovoEndereco = new JTextField(20), painel, constraints);
        adicionarCampo("Novo CPF:", campoNovoCpf = new JTextField(20), painel, constraints);
        adicionarCampo("Novo Tipo Sanguíneo:", campoNovoTipoSanguineo = new JTextField(20), painel, constraints);
        adicionarCampo("Novo E-mail:", campoNovoEmail = new JTextField(20), painel, constraints);
        adicionarCampo("Nova Senha:", campoNovaSenha = new JPasswordField(20), painel, constraints);

        botaoSalvar = new JButton("Salvar Alterações");
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        painel.add(botaoSalvar, constraints);

        add(painel);
        setVisible(true);

        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter os dados do usuário
                String novoNome = campoNovoNome.getText();
                String novoTelefone = campoNovoTelefone.getText();
                String novoEndereco = campoNovoEndereco.getText();
                String novoCpf = campoNovoCpf.getText();
                String novoTipoSanguineo = campoNovoTipoSanguineo.getText();
                String novoEmail = campoNovoEmail.getText();
                String novaSenha = new String(campoNovaSenha.getPassword());

                // Lógica para salvar ou atualizar o usuário no sistema
                // ...
                usuario.setNome(novoNome);
                usuario.setTelefone(novoTelefone);
                usuario.setCpf(novoCpf);
                usuario.setEmail(novoEmail);
                usuario.setTipoSanguineo(novoTipoSanguineo);
                usuario.setEndereco(novoEndereco);
                usuario.setSenha(novaSenha);

                JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");
                dispose(); // Fecha a janela após salvar as alterações
                // Redireciona para a InterfacePrincipal após alterar os dados
                interfacePrincipal.setVisible(true);
            }
        });

        botaoSair = new JButton("Sair");
        constraints.gridx = 0;
        constraints.gridy++;
        painel.add(botaoSair, constraints);

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona a lógica para voltar à tela de login
                dispose();
                new InterfaceLogin(InterfaceLogin.usuariosCadastrados);
            }
        });
    }

    private void adicionarCampo(String labelText, JTextField textField, JPanel panel, GridBagConstraints constraints) {
        JLabel label = new JLabel(labelText);
        constraints.gridx = 0;
        constraints.gridy++;
        panel.add(label, constraints);
        constraints.gridx = 1;
        panel.add(textField, constraints);
    }

    public static void main(String[] args) {
        // Exemplo de uso
        SwingUtilities.invokeLater(() -> {
            // Supondo que você já tenha um usuário autenticado
            Usuario usuarioAutenticado = new Usuario("Exemplo", "123456", "Rua Exemplo", "123456789", "A+", "exemplo@email.com", "senha");
            InterfacePrincipal interfacePrincipal = new InterfacePrincipal(usuarioAutenticado);
            new InterfaceAlterarDadosUsuario(usuarioAutenticado, interfacePrincipal);
        });
    }
}