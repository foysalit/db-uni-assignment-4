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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowInfoClient extends JFrame{

	private static final long serialVersionUID = -4660356044131765132L;
	
	private final Dimension dim = getToolkit().getScreenSize();
	
	private JButton info;
	private JTextField cod_client;
	private JTextArea data_client,courses_client;

	public WindowInfoClient(final DB db){
		
		setLayout(new BorderLayout());
		setTitle("Info Client");
		setSize(350,350);
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
		c.gridx = 0;
		c.gridy = 0;		
		center_panel.add(new JLabel("Client Code"),c);
		
		c.gridx = 0;
		c.gridy = 1;
		//padding
		c.insets = new Insets(5,5,0,5);
		cod_client=new JTextField(20);
		center_panel.add(cod_client,c);
		c.gridx = 1;
		c.gridy = 1;
		info=new JButton("Info");
		center_panel.add(info,c);
		
		c.gridx = 0;
		c.gridy = 2;
		center_panel.add(new JLabel("Clients Information"),c);
		c.gridx = 0;
		c.gridy = 3;
		data_client=new JTextArea(5, 20);
		data_client.setEditable(false);
		data_client.setBackground(Color.lightGray);
		data_client.setForeground(Color.blue);
		center_panel.add(new JScrollPane(data_client),c);
		
		c.gridx = 0;
		c.gridy = 4;
		center_panel.add(new JLabel("Enrolled in the following courses"),c);
		c.gridx = 0;
		c.gridy = 5;
		courses_client=new JTextArea(5, 20);
		courses_client.setEditable(false);
		courses_client.setBackground(Color.lightGray);
		courses_client.setForeground(Color.blue);
		center_panel.add(new JScrollPane(courses_client),c);
		
		add(center_panel,BorderLayout.CENTER);
		
		/*
		 * Listener for the Info Button.
		 * obtain the client code and insert in the JtextArea
		 * the client information and courses in which is enrolled.
		 * 
		 */
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				try{
					long code_client=Long.parseLong(cod_client.getText());
					
					
					data_client.setText(db.getDataClient(code_client));
					courses_client.setText("");
					
					for(String s:db.getCourseClient(code_client))
						courses_client.append(s+"\n");
				}catch(Exception er){}	
			}
		});
		
		setVisible(true);	
	}	

}
