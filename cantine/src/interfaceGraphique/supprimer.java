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

public class supprimer {

	protected Shell shell;
	private Text delete;
    
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			supprimer window = new supprimer();
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
		shell.setText("Supprimer un éleve");
		
		Button btnSupprimer = new Button(shell, SWT.NONE);
		btnSupprimer.setBounds(176, 188, 104, 42);
		btnSupprimer.setText("Supprimer");
		btnSupprimer.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                Delete();
            }
            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
          });
		
		delete = new Text(shell, SWT.BORDER);
		delete.setBounds(176, 93, 104, 42);
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setAlignment(SWT.CENTER);
		lblId.setBounds(57, 107, 78, 42);
		lblId.setText("ID");
		
		Label lblSupprimerUnEleve = new Label(shell, SWT.NONE);
		lblSupprimerUnEleve.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblSupprimerUnEleve.setBounds(162, 24, 140, 42);
		lblSupprimerUnEleve.setText("Supprimer un eleve");
		

	}

public void Delete() {
		String URL = "jdbc:mysql://localhost/cantine";
	    String Username = "root";
	    String Password ="";
	    
	    
	    
	    try {
	    	Connection connection = DriverManager.getConnection(URL, Username, Password);
	    	
	    	String sql = "DELETE FROM eleve WHERE id=?";
	    	PreparedStatement statement = connection.prepareStatement(sql);
	    	statement.setString(1, delete.getText());
	    	
	    	int rows = statement.executeUpdate();
	    	
	    	if (rows > 0) {
	    		System.out.println("Cette utilisateur est supprimé");
	    	}
	    		
	    		connection.close();
	    	
	    }catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	}
}
