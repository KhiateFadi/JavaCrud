package interfaceGraphique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class modification {

	protected Shell shell;
	private Text nom;
	private Text nom1;
	private Text prenom;
	private Text age;
	private Text regime;
	private Text cantine;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			modification window = new modification();
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
		shell.setText("modification d'un éleve");

		nom = new Text(shell, SWT.BORDER);
		nom.setBounds(261, 36, 76, 21);
		
		Label lblNomDeLeleve = new Label(shell, SWT.NONE);
		lblNomDeLeleve.setBounds(135, 36, 89, 15);
		lblNomDeLeleve.setText("Nom de l'eleve");
		
		nom1 = new Text(shell, SWT.BORDER);
		nom1.setBounds(120, 120, 76, 21);
		
		prenom = new Text(shell, SWT.BORDER);
		prenom.setBounds(120, 168, 76, 21);
		
		age = new Text(shell, SWT.BORDER);
		age.setBounds(120, 212, 76, 21);
		
		regime = new Text(shell, SWT.BORDER);
		regime.setBounds(335, 120, 76, 21);
		
		cantine = new Text(shell, SWT.BORDER);
		cantine.setBounds(335, 168, 76, 21);
		
		Label lblNom = new Label(shell, SWT.NONE);
		lblNom.setBounds(26, 126, 55, 15);
		lblNom.setText("nom");
		
		Label lblPrenom = new Label(shell, SWT.NONE);
		lblPrenom.setBounds(26, 168, 55, 15);
		lblPrenom.setText("prenom");
		
		Label lblAge = new Label(shell, SWT.NONE);
		lblAge.setBounds(26, 218, 55, 15);
		lblAge.setText("age");
		
		Label lblRegime = new Label(shell, SWT.NONE);
		lblRegime.setBounds(252, 120, 55, 15);
		lblRegime.setText("regime");
		
		Label lblcantine = new Label(shell, SWT.NONE);
		lblcantine.setBounds(252, 168, 55, 15);
		lblcantine.setText("cantine");
		
		Button btnModifier = new Button(shell, SWT.NONE);
		btnModifier.setBounds(335, 270, 75, 25);
		btnModifier.setText("Modifier");
		btnModifier.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Update();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });


	}
public	void Update() {
		 String jdbcURL = "jdbc:mysql://localhost/cantine";
		    String dbUsername = "root";
		    String dbPassword ="";
		    
		    
		    try {
		    	Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
		    	
		    	String sql = "UPDATE eleve set nom=?, prenom=?, age=?, regime=?, cantine=? WHERE nom=? ";
		    	PreparedStatement statement = connection.prepareStatement(sql);
		    	statement.setString(1, nom1.getText());
		    	statement.setString(2, prenom.getText());
		    	statement.setString(3, age.getText());
		    	statement.setString(4, regime.getText());
		    	statement.setString(5, cantine.getText());
		    	statement.setString(6, nom.getText());
		    	
		    	int rows = statement.executeUpdate();
		    	
		    	if (rows > 0) {
		    		System.out.println("les données de l'éleve ont bien été modifié");
		    	}
		    		
		    		connection.close();
		    	
		    }catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
	}
}
