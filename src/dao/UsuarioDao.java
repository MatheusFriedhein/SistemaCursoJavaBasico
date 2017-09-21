package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDao {
   
    Connection conn;
    PreparedStatement stmt;
    ResultSet rS;
    
    //METODO LOGAR
    public Usuario login(String nome, String senha) throws Exception {
        Usuario usuario = null;
        conn = new ConectaBDPostgres().getConexao();
        String sql = "select * from usuario where nome =? and senha =?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, senha);			
        rS = stmt.executeQuery();
        if (rS.next()) {
            usuario = new Usuario();
            usuario.setIdUsuario(rS.getInt("idusuario"));
            usuario.setSenha(rS.getString("senha"));
            usuario.setNome(rS.getString("nome"));
            usuario.setSobrenome(rS.getString("sobrenome"));
            usuario.setRg(rS.getInt("rg"));
        }
        //FECHA CONEXAO
        new ConectaBDPostgres().fecharConexao(conn,stmt,rS);
        return usuario;
    }
    // FUNCAO INSERE USUARIO 
    public boolean inserirUsuario(Usuario u) throws  SQLException{
        boolean retorno=false;
    	try {
            conn = ConectaBDPostgres.getConexao();
            String sql = "insert into usuario (nome,senha,rg,sobrenome) values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3,u.getRg());
            stmt.setString(4,u.getSobrenome());
            stmt.execute();
            stmt.close();
            retorno=true;
        } catch (ClassNotFoundException e) {e.printStackTrace();}
    	return retorno;
    }
    
     //FUNCAO DELETE USUARIO
    public boolean deletarUsuario(int idUsuario) throws SQLException, Exception {
    	boolean deletar = false;
        conn = ConectaBDPostgres.getConexao();
        String sql=" delete from  usuario where idusuario=?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,idUsuario); 
        stmt.execute();
        stmt.close();
        deletar = true;
        return deletar;
    }
    
    //FUNCAO ATUALIZAR MOTORISTA
    public List<Usuario> getUsuario() throws SQLException, Exception {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        conn = new ConectaBDPostgres().getConexao();
        try {
            stmt = conn.prepareStatement("Select * from usuario");
            rS = stmt.executeQuery();
            while (rS.next()) {
                Usuario u = new Usuario();
                u.setNome(rS.getString("nome"));
                u.setIdUsuario(rS.getInt("idusuario"));
                u.setRg(rS.getInt("rg"));
                u.setSenha(rS.getString("senha"));
                u.setSobrenome(rS.getString("sobrenome"));
                usuarios.add(u);
            }
            new ConectaBDPostgres().fecharConexao(conn, stmt, rS);
        } catch (Exception e) {  e.printStackTrace(); }
        return usuarios;
    }
    
    //PESQUISA USUARIO PELO ID - RETORNA TODOS ATRIBUTOS
    public Usuario PesquisaUsuario(int idUsuario) throws SQLException, Exception {
        Usuario u = null;
        conn = new ConectaBDPostgres().getConexao();
        try {
            stmt = conn.prepareStatement("Select * from usuario where idusuario = '" + idUsuario + "'");
            rS = stmt.executeQuery();
            while (rS.next()) {
                u = new Usuario();
                u.setNome(rS.getString("nome"));
                u.setIdUsuario(rS.getInt("idusuario"));
                u.setRg(rS.getInt("rg"));
                u.setSenha(rS.getString("senha"));
                u.setSobrenome(rS.getString("sobrenome"));
            }
            new ConectaBDPostgres().fecharConexao(conn, stmt, rS);
        } catch (Exception e) { e.printStackTrace();}
        return u;
    }
    
    //ALTERA DADOS NO BANCO
    public boolean alteraUsuario(Usuario u) throws Exception {
        boolean retorno=false;
    	try {
            conn = ConectaBDPostgres.getConexao();//
            String sql = "update  usuario set nome=?,rg=?,senha=?, sobrenome=? where idUsuario=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setInt(2,u.getRg());
            stmt.setString(3,u.getSenha());
            stmt.setString(4,u.getSobrenome());
            stmt.setInt(5,u.getIdUsuario());
            stmt.execute();
            stmt.close();
            retorno=true;
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
    	return retorno;
    }
    
}
