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
import org.eclipse.wb.swt.SWTResourceManager;

public class ajouter {

	protected Shell shell;
	public Text nom;
	public Text prenom;
	public Text age;
	public Text regime;
	public Text cantine;
	private Label lblAjouterUnEleve;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ajouter window = new ajouter();
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
		shell.setSize(513, 361);
		shell.setText("Ajouter des éleves");
       
		nom = new Text(shell, SWT.BORDER);
		nom.setBounds(259, 47, 106, 23);
		
		prenom = new Text(shell, SWT.BORDER);
		prenom.setBounds(259, 89, 106, 23);
		
		age = new Text(shell, SWT.BORDER);
		age.setBounds(259, 132, 106, 23);
		
		regime = new Text(shell, SWT.BORDER);
		regime.setBounds(259, 173, 106, 23);
		
		cantine = new Text(shell, SWT.BORDER);
		cantine.setBounds(259, 217, 106, 23);
		
		Label Nom = new Label(shell, SWT.NONE);
		Nom.setAlignment(SWT.CENTER);
		Nom.setBounds(85, 47, 106, 23);
		Nom.setText("NOM");
		
		Label Prenom = new Label(shell, SWT.NONE);
		Prenom.setAlignment(SWT.CENTER);
		Prenom.setBounds(85, 92, 106, 23);
		Prenom.setText("PRENOM");
		
		Label Age = new Label(shell, SWT.NONE);
		Age.setAlignment(SWT.CENTER);
		Age.setBounds(85, 132, 106, 23);
		Age.setText("AGE");
		
		Label Regime = new Label(shell, SWT.NONE);
		Regime.setAlignment(SWT.CENTER);
		Regime.setBounds(85, 176, 106, 23);
		Regime.setText("REGIME");
		
		Label Cantine = new Label(shell, SWT.NONE);
		Cantine.setAlignment(SWT.CENTER);
		Cantine.setBounds(85, 220, 106, 23);
		Cantine.setText("CANTINE");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(259, 256, 106, 36);
		btnNewButton.setText("Ajouter");
		btnNewButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Add();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });
		
		lblAjouterUnEleve = new Label(shell, SWT.NONE);
		lblAjouterUnEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblAjouterUnEleve.setBounds(246, 10, 132, 31);
		lblAjouterUnEleve.setText("Ajouter un \u00E9leve");
		
	}

public void Add() {
		
		
	    String URL = "jdbc:mysql://localhost/cantine";
	    String User = "root";
	    String Password ="";
	    
	    
	    
	    try {
	    	Connection connection = DriverManager.getConnection(URL, User, Password);
	    	
	    	String sql = "INSERT INTO eleve (nom, prenom, age, regime, cantine)"
	    			+" VALUES (?, ?, ?, ?, ?)";
	    	
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, nom.getText());
	    	statement.setString(2, prenom.getText());
	    	statement.setString(3, age.getText());
	    	statement.setString(4, regime.getText());
	    	statement.setString(5, cantine.getText());
	    	
	    	int rows = statement.executeUpdate();
	    	
	    	if (rows > 0) {
	    		System.out.println("Féliciatation, vous avez ajouté un éleve !");
	    	}
	    		
	    		connection.close();
	    	
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	}
}
