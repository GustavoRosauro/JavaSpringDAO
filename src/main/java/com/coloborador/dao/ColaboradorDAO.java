package com.coloborador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.colaborador.model.Colaborador;

public class ColaboradorDAO {
	public List<Colaborador> retornaColaboradores() throws SQLException{
		Connection con = Conexao.getConnection();
		List<Colaborador> lista = new ArrayList<Colaborador>();
		PreparedStatement stmt = con.prepareStatement("SELECT ID, NOME, SOBRENOME, EMAIL FROM COLABORADOR");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Colaborador colaborador = new Colaborador();
			colaborador.setId(rs.getInt("ID"));
			colaborador.setNome(rs.getString("NOME"));
			colaborador.setSobrenome(rs.getString("SOBRENOME"));
			colaborador.setEmail(rs.getString("EMAIL"));
			lista.add(colaborador);
		}
		con.close();
		rs.close();
		stmt.close();
		return lista;
	}
	public void inserirNovoColaborador(Colaborador colaborador) throws SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = con.prepareStatement(""
				+ "INSERT INTO COLABORADOR (NOME,SOBRENOME,EMAIL)"
				+ "VALUES(?,?,?)");
		stmt.setString(1, colaborador.getNome());
		stmt.setString(2,colaborador.getSobrenome());
		stmt.setString(3,colaborador.getEmail());
		stmt.execute();
		con.close();
		stmt.close();
	}
}
