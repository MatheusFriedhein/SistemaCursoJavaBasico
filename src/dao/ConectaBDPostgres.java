package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectaBDPostgres {
    
    //ABRE CONEXAO
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
		
        Connection conexao = null;
        try {
                Class.forName("org.postgresql.Driver");
                //String url ="jdbc:postgresql://localhost:5432/db_cursoJava";
                String url ="jdbc:postgresql://192.168.90.103:5432/AgendaMotoristasCripto";
                String user="postgres";
                String password = "oimatheus";
                conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) { e.printStackTrace(); }
        return conexao;
    }
    //FECHA CONEXAO
    public void fecharConexao(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            connection.close();
            preparedStatement.close();
            resultSet.close();
         } catch (SQLException e) {e.printStackTrace();}
    }
    
}
