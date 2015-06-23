package it.polito.windows;

import it.polito.db.DB;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1868837321666586496L;
	
	private final Dimension dim = getToolkit().getScreenSize();
	
	private JButton info_client, enrollment;
	
	public MainWindow(final DB db){
		
		setLayout(new BorderLayout());
		setTitle("practiceJDBC");
		setSize(250,150);
		//position
		setLocation(dim.width / 2 - getWidth() / 2,
				dim.height / 2 - getHeight() / 2);
		//disable resize possibility
		setResizable(false);
		//automatic exit of the program when user presses the X button
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		/*
		 * Create a panel that contains my elements for the north of the frame.
		 * 
		 * Use the GridBagLayout to positioning the elements.
		 * 
		 */
		JPanel north_panel=new JPanel();
		north_panel.setLayout(new GridBagLayout());
		north_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		north_panel.add(new JLabel("Clients managements and enrollments"),c);
		add(north_panel,BorderLayout.NORTH);
		
		
		/*
		 * Panel for the center of the frame.
		 * 
		 */
		JPanel center_panel=new JPanel();
		center_panel.setLayout(new GridBagLayout());
		center_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		c.gridx = 0;
		c.gridy = 0;
		info_client=new JButton("Client Information");
		center_panel.add(info_client,c);
		
		c.gridx = 0;
		c.gridy = 1;
		//add a padding
		c.insets = new Insets(10,0,0,0);
		enrollment=new JButton("Enrollment");
		center_panel.add(enrollment,c);
		add(center_panel,BorderLayout.CENTER);
		
		/*
		 * Listener for the info_client button.
		 * It opens a new window.
		 * 
		 */
		info_client.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new WindowInfoClient(db);
			}
		});
		
		/*
		 * Listener for the enrollment button.
		 * It opens a new window.
		 * 
		 */
		enrollment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				new WindowEnrollCourses(db);
			}
		});
		
		/*
		 * Listener for the main window.
		 * Whene the user press the X button, the program
		 * close the connection to the database.
		 * 
		 */
		this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                db.CloseConnection();
            }
        });

		setVisible(true);	
	}

}
