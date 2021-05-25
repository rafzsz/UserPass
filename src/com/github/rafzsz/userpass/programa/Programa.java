package com.github.rafzsz.userpass.programa;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.github.rafzsz.userpass.classes.Login;
import com.github.rafzsz.userpass.classes.Registrar;

public class Programa {

	public static int inicio;
	public static boolean reg = false;
	public static boolean entrou = false;
	public static Registrar eu = new Registrar();

	public static void telainicial() {
		System.out.println("\n=========================");
		System.out.println("|   1 - Registrar	|");
		System.out.println("|   2 - Fazer Login	|");
		System.out.println("=========================\n");
	}
	
	public static Integer selecaoInicial (Scanner entrada) {
		telainicial();
		System.out.println("Opção: ");
		return Integer.parseInt(entrada.nextLine());
	}
	
	public static void casos (Scanner entrada) throws ClassNotFoundException, NoSuchAlgorithmException {
		switch (inicio) {
		case 1:
			eu.lerUsuario(entrada);
			eu.inserirUsuario();
			reg = true;
			break;
		case 2:
			Login eu2 = new Login();
			eu2.lerLogin(entrada);
			entrou = eu2.Logar(eu2.getLogin(), eu2.getSenha());
			break;
		default:
			System.out.println("Opção Inválida!");
		}
	}

	public static void main(String[] args) {
		try (Scanner entrada = new Scanner(System.in)) {
			while (!entrou) {
				inicio = selecaoInicial(entrada);
				casos(entrada);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Usuário Logado!");
	}
}
