package Login;

import java.sql.*;

import Exames.InterfaceTriagem;

public class ConexaoMysql {
    public static String URL = "jdbc:mysql://localhost:3306/SDS";
    public static String USER = "root";
    public static String SENHA = "";

    private Connection dbconn = null;
    private Statement sqlmgr = null;
    private ResultSet resulsetsql = null;

    public Connection getConnection() {
        return dbconn;
    }

    public void OpenDatabase() {
        try {
            dbconn = DriverManager.getConnection(URL, USER, SENHA);
            System.out.println("Conectado com sucesso: " + URL);
            sqlmgr = dbconn.createStatement();
        } catch (Exception Error) {
            System.out.println("Erro na conexão: " + Error.getMessage());
        }
    }

    public void CloseDatabase() {
        try {
            if (sqlmgr != null) {
                sqlmgr.close();
            }
            if (dbconn != null) {
                dbconn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar o banco de dados: " + e.getMessage());
        }
    }

    public int ExecutaQuery(String sql) {
        try {
            return sqlmgr.executeUpdate(sql);
        } catch (Exception Error) {
            System.out.println("Erro na execução da query: " + Error.getMessage());
        }
        return -1;
    }

    public int InsereUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (Nome, Telefone, Endereco, CPF, TipoSanguineo, Email, Senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = dbconn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getTelefone());
            preparedStatement.setString(3, usuario.getEndereco());
            preparedStatement.setString(4, usuario.getCpf());
            preparedStatement.setString(5, usuario.getTipoSanguineo());
            preparedStatement.setString(6, usuario.getEmail());
            preparedStatement.setString(7, usuario.getSenha());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int InsereTriagem(PreTriagem preTriagem) {
        String sql = "INSERT INTO PreTriagem (Nome, CPF, Idade, Temperatura, Pulso, Pressao, Peso, Hemoglobina, Hematocrito, Habilitado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = dbconn.prepareStatement(sql);
            preparedStatement.setString(1, preTriagem.getNome());
            preparedStatement.setString(2, preTriagem.getCpf());
            preparedStatement.setInt(3, preTriagem.getIdade());
            preparedStatement.setDouble(4, preTriagem.getTemperatura());
            preparedStatement.setInt(5, preTriagem.getPulso());
            preparedStatement.setDouble(6, preTriagem.getPressao());
            preparedStatement.setDouble(7, preTriagem.getPeso());
            preparedStatement.setDouble(8, preTriagem.getHemoglobina());
            preparedStatement.setDouble(9, preTriagem.getHematocrito());
            preparedStatement.setBoolean(10, preTriagem.isHabilitado());
    
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            return -1;
        }
    }
    
}
