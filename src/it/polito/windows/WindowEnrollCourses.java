package it.polito.windows;


import it.polito.db.DB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowEnrollCourses extends JFrame{

	private static final long serialVersionUID = -1387136103507145906L;
	
	private final Dimension dim = getToolkit().getScreenSize();
	
	private JButton enroll;
	private JComboBox cod_course;
	private JTextField cod_client;
	private JTextField msg;
	
	public WindowEnrollCourses(final DB db){
		
		setLayout(new BorderLayout());
		setTitle("Courses enrollment");
		setSize(350,200);
		//position
		setLocation(dim.width / 2 - getWidth() / 2,
				dim.height / 2 - getHeight() / 2);
		//disable resize possibility
		setResizable(false);
		//automatic exit of the program when user presses the X button
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		/*
		 * Panel for the center of the frame.
		 * 
		 */
		JPanel center_panel=new JPanel();
		center_panel.setLayout(new GridBagLayout());
		center_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		GridBagConstraints c = new GridBagConstraints();
		//add a padding
		c.insets = new Insets(5,5,5,5);
		c.gridx = 0;
		c.gridy = 0;		
		center_panel.add(new JLabel("Course Code"),c);
		c.gridx = 2;
		c.gridy = 0;		
		center_panel.add(new JLabel("Client Code"),c);
		
		c.gridx = 0;
		c.gridy = 1;
		cod_course=new JComboBox(db.getCodCourses().toArray(new String[0]));
		center_panel.add(cod_course,c);
		c.gridx = 2;
		c.gridy = 1;
		cod_client=new JTextField(10);
		center_panel.add(cod_client,c);
		
		c.gridx = 0;
		c.gridy = 2;
		enroll=new JButton("Enroll");
		center_panel.add(enroll,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		msg=new JTextField(20);
		msg.setBackground(Color.lightGray);
		msg.setForeground(Color.blue);
	
		msg.setEditable(false);
		center_panel.add(msg,c);
		
		add(center_panel,BorderLayout.CENTER);
		
		/*
		 * Listener for the Enroll Button.
		 * On click, add the enrollment to the database.
		 * If is executed insert in the JTextField a success message,
		 * insuccess otherwise.
		 * 
		 * Moreover, update the elements.
    	 * 
		 */
		enroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				try{
					String [] s1=cod_course.getSelectedItem().toString().replaceAll("\\s","").split("-");
					boolean ok=db.addEnroll(Long.parseLong(""+s1[0]),Long.parseLong(""+cod_client.getText()));
					if(ok==true)
						msg.setText("Enrollment was successful!");
					else 
						msg.setText("Error during the enrollment!");
					
					cod_course.removeAllItems();
					for(String s:db.getCodCourses())
						cod_course.addItem(s);
				}catch(Exception er){
					if(er instanceof NumberFormatException)
						msg.setText("The code must be numeric!");	
				}
				
			}
		});
		
		setVisible(true);
	}

}
