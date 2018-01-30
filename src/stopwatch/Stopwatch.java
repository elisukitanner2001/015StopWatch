package stopwatch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Stopwatch extends JFrame {

	long startTime;
	long stopTime;
	double elapsedTime;
	boolean timeStarted = false;

	JButton startButton = new JButton();
	JLabel startLabel = new JLabel();
	JTextField startTextField = new JTextField();

	JButton stopButton = new JButton();
	JLabel stopLabel = new JLabel();
	JTextField stopTextField = new JTextField();

	JButton exitButton = new JButton();

	JLabel elapsedLabel = new JLabel();
	JTextField elapsedTextField = new JTextField();

	public Stopwatch(String title) {

		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();

		// Create and set up the components
		startButton.setText("Start Timing");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		getContentPane().add(startButton, gridConstraints);

		// Add an Action Listener to detect and respond to clicks
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}

		});

		startLabel.setText("  Start System Time  ");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		getContentPane().add(startLabel, gridConstraints);

		startTextField.setText("");
		startTextField.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		getContentPane().add(startTextField, gridConstraints);

		stopButton.setText("Stop Timing");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		getContentPane().add(stopButton, gridConstraints);

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopButtonActionPerformed(e);
			}

		});

		stopLabel.setText("  Stop System Time  ");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		getContentPane().add(stopLabel, gridConstraints);

		stopTextField.setText("");
		stopTextField.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		getContentPane().add(stopTextField, gridConstraints);

		exitButton.setText("Close ALL Watches");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		getContentPane().add(exitButton, gridConstraints);

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}

			

		});

		elapsedLabel.setText("  Elapsed Time Seconds  ");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedLabel, gridConstraints);

		elapsedTextField.setText("");
		elapsedTextField.setColumns(20);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedTextField, gridConstraints);

		// Make the window visible, and set the size to either a fixed size, or
		// have it packed tight
		setLocationRelativeTo(null);
		// setSize(500, 500);
		pack();
		// setVisible(true);

	} // end of constructor

	private void startButtonActionPerformed(ActionEvent e) {
		startTime = System.currentTimeMillis();

		Date startDate = new Date();
		startTextField.setText(startDate.toString());
		// startTextField.setText(String.valueOf(startTime));
		stopTextField.setText("");
		elapsedTextField.setText("");
		timeStarted = true;

	}

	private void stopButtonActionPerformed(ActionEvent e) {
		if (timeStarted) {
			stopTime = System.currentTimeMillis();
			Date stopDate = new Date();
			stopTextField.setText(stopDate.toString());
			// stopTextField.setText(String.valueOf(stopTime));
			elapsedTime = (stopTime - startTime) / 1000.0;
			elapsedTextField.setText(String.valueOf(elapsedTime));
		} else {
			return;
		}

	}
	
	private void exitButtonActionPerformed(ActionEvent e) {
		System.exit(0);
		
	}

} // end of class

