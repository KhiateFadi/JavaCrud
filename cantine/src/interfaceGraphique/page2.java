package interfaceGraphique;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class page2 {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			page2 window = new page2();
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
		shell.setSize(502, 344);
		shell.setText("formulaire");
		
		Button btnValider = new Button(shell, SWT.NONE);
		btnValider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				visualiser_eleve window = new visualiser_eleve();
				window.open();
			}
		});
		btnValider.setBounds(121, 55, 75, 25);
		btnValider.setText("valider");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblNewLabel.setBounds(31, 60, 55, 15);
		lblNewLabel.setText("Visualiser");
		
		Label lblPartietudiant = new Label(shell, SWT.NONE);
		lblPartietudiant.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPartietudiant.setBounds(74, 20, 107, 25);
		lblPartietudiant.setText("Partie \u00E9tudiant");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(31, 112, 55, 15);
		lblNewLabel_1.setText("Ajouter");
		
		Button btnValider_1 = new Button(shell, SWT.NONE);
		btnValider_1.setBounds(121, 107, 75, 25);
		btnValider_1.setText("valider");
		btnValider_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				ajouter window = new ajouter();
				window.open();
			}
		});
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(31, 163, 55, 15);
		lblNewLabel_2.setText("Supprimer");
		
		Button btnValider_2 = new Button(shell, SWT.NONE);
		btnValider_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				supprimer window = new supprimer();
				window.open();
			}
		});
		btnValider_2.setBounds(121, 163, 75, 25);
		btnValider_2.setText("valider");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(31, 223, 55, 15);
		lblNewLabel_3.setText("Modifier");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(121, 218, 75, 25);
		btnNewButton.setText("Valider");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				modification window = new modification();
				window.open();
			}
		});
		
		Label lblPartieEnseignant = new Label(shell, SWT.NONE);
		lblPartieEnseignant.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblPartieEnseignant.setBounds(305, 20, 139, 25);
		lblPartieEnseignant.setText("Partie Enseignant");
		
		Label lblVisualiser = new Label(shell, SWT.NONE);
		lblVisualiser.setBounds(287, 60, 55, 15);
		lblVisualiser.setText("Visualiser");
		
		Button btnValider_3 = new Button(shell, SWT.NONE);
		btnValider_3.setBounds(381, 55, 75, 25);
		btnValider_3.setText("valider");

	}
}
