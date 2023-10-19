package br.com.iBook.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.iBook.controle.Conexao;

public class AbstractDAO {
	
	protected Connection con;
	protected Conexao conexao;
	
	public AbstractDAO(Connection con){
		 this.con = con;
	}
	
	protected void openConnection(){
		try {
			
			if(con == null || con.isClosed())
				
				con = conexao.recuperarConexao();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
