package com.coloborador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
public static Connection getConnection() throws SQLException {
	 return DriverManager.getConnection("jdbc:mysql://localhost/JAVA?useTimezone=true&serverTimezone=UTC","root","");
}
}
