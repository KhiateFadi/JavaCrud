package interfaceGraphique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class visualiser_prof {

	protected Shell shell;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			visualiser_prof window = new visualiser_prof();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("visualiser les professeurs !");

	}
	
	public void affichage() {

	    try {


	         

	      String url = "jdbc:mysql://localhost/cantine";

	String user = "root";

	String password = "";

	         

	      Connection conn = DriverManager.getConnection(url, user, password);

	         

	      //Création d'un objet Statement

	      Statement state = conn.createStatement();

	      //L'objet ResultSet contient le résultat de la requête SQL

	      ResultSet result = state.executeQuery("SELECT * FROM prof");

	      //On récupère les MetaData

	      ResultSetMetaData resultMeta = result.getMetaData();

	         

	      System.out.println("\n**********************************");

	      //On affiche le nom des colonnes

	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)

	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

	         

	      System.out.println("\n**********************************");

	         

	      while(result.next()){         

	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)

	          System.out.print("\t" + result.getObject(i).toString() + "\t |");

	           

	        System.out.println("\n---------------------------------");


	      }


	      result.close();

	      state.close();

	         

	    } catch (Exception e) {

	      e.printStackTrace();

	    }      

	 

	}
}
