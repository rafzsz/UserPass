package com.github.rafzsz.userpass.classes;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.rafzsz.userpass.programa.Programa;

public class SQLDatabaseConnection {

	public String conectou;

	public static String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=db_UserPass;"
			+ "integratedSecurity=true;";

//	Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
	public static boolean login(String usuario, String senha) throws ClassNotFoundException {

		ResultSet resultSet = null;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {

			String selectUser = "select * from Pessoa where login ='" + usuario + "' and senha = '" + senha + "'";
			resultSet = statement.executeQuery(selectUser);
			while (resultSet.next()) {
				Programa.eu.setLogin(resultSet.getString(1));
				System.out.println("Login realizado com Sucesso!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Falha ao realizar Login!");
		return false;
	}

	public static String registrar(Registrar usuario) throws NoSuchAlgorithmException {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {

			StringBuilder insert = new StringBuilder();
			insert.append("insert into Pessoa (");
			insert.append("login,");
			insert.append("senha)");
			insert.append(" VALUES (");
			insert.append("'" + usuario.getLogin() + "',");
			insert.append("'" + usuario.getSenha());
			insert.append("')");
			statement.executeUpdate(insert.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
