package br.com.caelum.test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.caelum.JpaConfigurator;

public class PoolTest {

	public static void main(String[] args) throws PropertyVetoException, SQLException {

		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();

		//Testando a conexão, porem quando não ouver conexões
		//o for para de executar porque chegou no máximo de conexões do pool
		//e o usuário está no aguardo.
		for (int i = 0; i < 10; i++) {
			@SuppressWarnings("unused")
			Connection connection = dataSource.getConnection();

			System.out.println("----------------------------------------");
			System.out.println("------------------- "+i+" ------------------");
			System.out.println("Threads: " + dataSource.getNumHelperThreads());
			System.out.println("Máximo númeno pool: " + dataSource.getMaxPoolSize());
			System.out.println("Mínimo número pool: " + dataSource.getMinPoolSize());
			System.out.println("Total conexões: " + dataSource.getNumConnections());
			
			System.out.println("\nConexões ocupadas: " + dataSource.getNumBusyConnections());
			System.out.println("Conexões ociosas: " + dataSource.getNumIdleConnections());
			System.out.println("\n----------------------------------------");

		}
	}

}
