package com.github.rafzsz.userpass.classes;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Login extends Registrar {

	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login.length() != 0) {
			this.login = login;
		} else {
			System.out.println ("Campo vazio, favor preencher!");
		}
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha.length() != 0) {
			this.senha = senha;			
		} else {
			System.out.println ("Campo vazio, favor preencher!");
		}
	}

	public void lerLogin(Scanner entrada) {
		System.out.println ("Login: ");
		login = entrada.nextLine(); 

		System.out.println ("Senha: ");
		senha = entrada.nextLine(); 
	}
	public boolean Logar(String login, String senha) throws ClassNotFoundException, NoSuchAlgorithmException {

		return SQLDatabaseConnection.login(this.login, Cripto.criptSenha(this.senha));

	}

}