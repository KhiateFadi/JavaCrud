package interfaceGraphique;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class interfaceGraphique {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			interfaceGraphique window = new interfaceGraphique();
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
		shell.setSize(475, 345);
		shell.setText("cantine");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(209, 224, 75, 25);
		btnNewButton.setText("Valider");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(208, 99, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(208, 162, 76, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(78, 165, 106, 25);
		lblNewLabel.setText("Mot de passe");
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(86, 99, 55, 15);
		lblLogin.setText("Login");

	}
}
