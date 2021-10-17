package br.com.masters3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class DataSource {
	
	private String url;
	private String hostname;
	private String username;
	private String password;
	private String database;
	private int port;
	
	private Connection connection;
	
	public DataSource() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			hostname = "oracle.fiap.com.br";
			username = "pf0709";
			password = "fiap21";
			database = "orcl";
			port = 1521;
			
			url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + database;
			
			connection = DriverManager.getConnection(url, username, password);
			
			if(connection != null) {
				System.out.println("BD conectado com sucesso");
			}
			else {
				System.out.println("BD falhou ao conectar");
			}
			
			
		}catch(Exception ex) {
			System.out.println("ERRO AO CONECTAR COM O BD: " + ex.getMessage());
		}
		
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
