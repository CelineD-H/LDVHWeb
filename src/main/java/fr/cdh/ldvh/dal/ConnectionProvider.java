package fr.cdh.ldvh.dal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {

	private static DataSource dataSource;

	static {
		Context context;
		try {
			System.out.println("Début ContextProvider");
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");

		} catch (NamingException e) {
			throw new RuntimeException("Impossible d'accéder à la base de donnée");
		}
	}

	public static Connection getConnection() throws SQLException {

		return ConnectionProvider.dataSource.getConnection();

	}

}