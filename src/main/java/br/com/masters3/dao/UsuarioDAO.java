package br.com.masters3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.masters3.beans.Usuario;

public class UsuarioDAO implements DAO<Usuario> {
	
	private DataSource dataSource;
	
	public UsuarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}

	@Override
	public void create(Usuario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario read(Usuario object) {
		try {
			
			String sql = "SELECT "
					+ "	tiu.ID, "
					+ "	tiu.NIVEL, "
					+ "	tiu.GENERO, "
					+ "	tiu.EMAIL, "
					+ "	tiu.SENHA, "
					+ "	tiu.DATA_NASCIMENTO, "
					+ "	tiu.ULTIMO_ACESSO  AS ULTIMOACESSO, "
					+ "	tiu.FOTO, "
					+ "	tcid.CIDADE, "
					+ "	tiu.NOME "
					+ "FROM TB_IN_USUARIO tiu  "
					+ "INNER JOIN TB_TIN_CIDADE tcid ON tiu.ID_CIDADE = tcid.ID "
					+ "WHERE tiu.EMAIL  = ? "
					+ "AND tiu.SENHA  = ?";
			
			PreparedStatement stm = this.dataSource.getConnection().prepareStatement(sql);
			stm.setString(1, object.getEmail());
			stm.setString(2, object.getSenha());
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("ID"));
				usuario.setNivel(rs.getString("NIVEL"));
				usuario.setGenero(rs.getString("GENERO"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNascimento(rs.getDate("DATA_NASCIMENTO").toLocalDate());
				usuario.setUltimoAcesso(rs.getDate("ULTIMOACESSO").toLocalDate());
				usuario.setFoto(rs.getString("FOTO"));
				usuario.setCidade(rs.getString("CIDADE"));
				usuario.setNome(rs.getString("NOME"));
				
				return usuario;
				
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERRO AO EFETUAR READ DE USUARIO = " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public void update(Usuario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario object) {
		// TODO Auto-generated method stub
		
	}

}
