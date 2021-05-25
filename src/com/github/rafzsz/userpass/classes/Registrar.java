package com.github.rafzsz.userpass.classes;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.github.rafzsz.userpass.programa.Programa;


public class Registrar extends Programa {
	
	private String login;
	private String senha;
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void inserirUsuario() throws NoSuchAlgorithmException {
		this.senha = Cripto.criptSenha(this.senha);
		SQLDatabaseConnection.registrar(this);
	}
	
	public void lerUsuario(Scanner leitor) {		
			System.out.println ("Digite um login: ");
			login = leitor.nextLine(); 

			System.out.println ("Senha: ");
			senha = leitor.nextLine();
		}
}
