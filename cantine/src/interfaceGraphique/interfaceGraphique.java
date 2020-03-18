package interfaceGraphique;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

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
		shell.setSize(499, 350);
		shell.setText("cantine");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(209, 224, 75, 25);
		btnNewButton.setText("New Button");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(208, 99, 76, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(208, 162, 76, 21);

	}
}
