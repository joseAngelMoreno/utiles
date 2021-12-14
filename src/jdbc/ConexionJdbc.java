package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import excepciones.ConnectionException;

public class ConexionJdbc {

	public static Connection con;
	private String driver;
	private String url;
	private String usr;
	private String pwd;
	private String ficheroConfiguracion;

	
	
	//constructor para almacenar todos los datos
	public ConexionJdbc(String driver, String url, String usr, String pwd) {
		
		this.driver = driver;
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
		
	}
	
	

	public ConexionJdbc(String ficheroConfiguracion) {
	
		this.ficheroConfiguracion = ficheroConfiguracion;
	}






	//CONECTAR CON DATASOURCE
	public void conectar(String ficheroConfiguracion) throws ConnectionException {
		
		
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream(ficheroConfiguracion));
			DataSource ds = BasicDataSourceFactory.createDataSource(propiedades);
			con = ds.getConnection();
			//System.out.println("Conexion realizada");
			
		} catch (FileNotFoundException e) {
			System.out.println("fichero "+ficheroConfiguracion+" no encontrado");
			
		} catch (IOException e) {
			System.out.println("error al cargar fichero de configuracion");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("error en sql");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("exception general");
			e.printStackTrace();
		}

	}

	
	

	
	//Conectar con driver, url,usr y pwd
	private void conectar(String driver, String url, String usr, String pwd) throws ConnectionException {
		
		
		try {
			
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(usr);
			ds.setPassword(pwd);
			con = ds.getConnection();
			//System.out.println("Conectado");
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void conectar() {
		if (ficheroConfiguracion!=null) {
			
			conectar(ficheroConfiguracion);
		
		}else {
			conectar(driver, url, usr, pwd);
		}
	}

	
	public  static Connection getConnection() {
		return con;
	}
	
	/**
	* Cierra la conexión almacenada en el atributo con (si no es null y está abierta)
	*/
	public void desconectar(){
		
			try {
				if (con != null && !con.isClosed()) {
					con.close();
					//System.out.println("Desconectado");
				}
				
			} catch (Exception ex) {
				
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "error al cerrar la conexion", ex);
				ex.printStackTrace();
				
			}
			
		
	}
	/**
	* Cierra un ResultSet (si no es null y está abierto)
	*/
	public static void cerrar(ResultSet rs){
		
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
					//System.out.println("resultset cerrado");
				}
				
			} catch (Exception ex) {
				
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "error resultset", ex);
				ex.printStackTrace();
				
			}
			
		
	}
	/**
	* Cierra un Statement(si no es null y está abierto)
	* Este método servirá tanto para cerrar Statemen como para PreparedStatement ya que
	* el segundo es subclase del primero.
	*/
	public static void cerrar(Statement stm){
		
			try {
				if (stm != null && !stm.isClosed()) {
					stm.close();
					//System.out.println("statement cerrado");
				}
				System.out.println();
				
			} catch (Exception ex) {
				
				Logger.getLogger(ConexionJdbc.class.getName()).log(Level.SEVERE, "error al cerrar statement", ex);
				ex.printStackTrace();
				
			}
			
		
	}

}
