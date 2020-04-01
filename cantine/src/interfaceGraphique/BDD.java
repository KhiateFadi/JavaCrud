package interfaceGraphique;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

public class BDD {
	 
	
	public static void main(String[] args)
	 {                 
	String url="jdbc:mysql://localhost/cantine";                 
	String user="root";                 
	String password="";                 
	try {                        
	 Connection cnx = DriverManager.getConnection(url, user, password);                         
	System.out.println("Etat de la connexion :");                         
	System.out.println(cnx.isClosed()?"fermée":"ouverte");                 } 
	catch (SQLException e) {                         
	System.out.println("Une erreur est survenue lors de la connexion à la base de données");                        
	e.printStackTrace();                 
	}        
	}
	}


