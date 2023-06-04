package Caculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import exampleApp._tpImplBase;
import exampleApp.tp;
import exampleApp.tpHelper;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator extends JFrame {
	
	int num1,num2,check;
	float xd;
	
	String z, zt;
	
	String[] client;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator frame = new calculator();
					frame.setVisible(true);
					

					try {
						
						ORB orb = ORB.init(args,null);
						ExampleServant servant = new ExampleServant();
						orb.connect((Object) servant);
						org.omg.CORBA.Object object = orb.resolve_initial_references("NameService");
						NamingContext namingContext=NamingContextHelper.narrow(object);
						NameComponent nameComp = new NameComponent("Hello","");
						NameComponent[] path = {nameComp};
						namingContext.rebind(path,servant);
						java.lang.Object syncObj = new java.lang.Object();
						
					}catch(Exception e) {
						e.getMessage();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 430);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("View");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 101, 305, 261);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("MR");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.weighty = 1.0;
		gbc_btnNewButton.weightx = 1.0;
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MC");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.weighty = 1.0;
		gbc_btnNewButton_1.weightx = 1.0;
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MS");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("M+");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("M-");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("<--");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.weighty = 1.0;
		gbc_btnNewButton_5.weightx = 1.0;
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 1;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_10 = new JButton("CE");
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.weighty = 1.0;
		gbc_btnNewButton_10.weightx = 1.0;
		gbc_btnNewButton_10.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 1;
		gbc_btnNewButton_10.gridy = 1;
		panel.add(btnNewButton_10, gbc_btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("C");
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.weighty = 1.0;
		gbc_btnNewButton_11.weightx = 1.0;
		gbc_btnNewButton_11.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 2;
		gbc_btnNewButton_11.gridy = 1;
		panel.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("+-");
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.weighty = 1.0;
		gbc_btnNewButton_12.weightx = 1.0;
		gbc_btnNewButton_12.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 3;
		gbc_btnNewButton_12.gridy = 1;
		panel.add(btnNewButton_12, gbc_btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("SQRT");
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.weighty = 1.0;
		gbc_btnNewButton_13.weightx = 1.0;
		gbc_btnNewButton_13.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_13.gridx = 4;
		gbc_btnNewButton_13.gridy = 1;
		panel.add(btnNewButton_13, gbc_btnNewButton_13);
		
		JButton btnNewButton_6 = new JButton("7");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.weighty = 1.0;
		gbc_btnNewButton_6.weightx = 1.0;
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 2;
		panel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_14 = new JButton("8");
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.weighty = 1.0;
		gbc_btnNewButton_14.weightx = 1.0;
		gbc_btnNewButton_14.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_14.gridx = 1;
		gbc_btnNewButton_14.gridy = 2;
		panel.add(btnNewButton_14, gbc_btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("9");
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.weighty = 1.0;
		gbc_btnNewButton_15.weightx = 1.0;
		gbc_btnNewButton_15.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_15.gridx = 2;
		gbc_btnNewButton_15.gridy = 2;
		panel.add(btnNewButton_15, gbc_btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("/");
		GridBagConstraints gbc_btnNewButton_16 = new GridBagConstraints();
		gbc_btnNewButton_16.weighty = 1.0;
		gbc_btnNewButton_16.weightx = 1.0;
		gbc_btnNewButton_16.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_16.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_16.gridx = 3;
		gbc_btnNewButton_16.gridy = 2;
		panel.add(btnNewButton_16, gbc_btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("%");
		GridBagConstraints gbc_btnNewButton_17 = new GridBagConstraints();
		gbc_btnNewButton_17.weighty = 1.0;
		gbc_btnNewButton_17.weightx = 1.0;
		gbc_btnNewButton_17.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_17.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_17.gridx = 4;
		gbc_btnNewButton_17.gridy = 2;
		panel.add(btnNewButton_17, gbc_btnNewButton_17);
		
		JButton btnNewButton_7 = new JButton("4");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.weighty = 1.0;
		gbc_btnNewButton_7.weightx = 1.0;
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 3;
		panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_18 = new JButton("5");
		GridBagConstraints gbc_btnNewButton_18 = new GridBagConstraints();
		gbc_btnNewButton_18.weighty = 1.0;
		gbc_btnNewButton_18.weightx = 1.0;
		gbc_btnNewButton_18.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_18.gridx = 1;
		gbc_btnNewButton_18.gridy = 3;
		panel.add(btnNewButton_18, gbc_btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_19 = new GridBagConstraints();
		gbc_btnNewButton_19.weighty = 1.0;
		gbc_btnNewButton_19.weightx = 1.0;
		gbc_btnNewButton_19.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_19.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_19.gridx = 2;
		gbc_btnNewButton_19.gridy = 3;
		panel.add(btnNewButton_19, gbc_btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("*");
		GridBagConstraints gbc_btnNewButton_20 = new GridBagConstraints();
		gbc_btnNewButton_20.weighty = 1.0;
		gbc_btnNewButton_20.weightx = 1.0;
		gbc_btnNewButton_20.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_20.gridx = 3;
		gbc_btnNewButton_20.gridy = 3;
		panel.add(btnNewButton_20, gbc_btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("1/x");
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.weighty = 1.0;
		gbc_btnNewButton_21.weightx = 1.0;
		gbc_btnNewButton_21.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_21.gridx = 4;
		gbc_btnNewButton_21.gridy = 3;
		panel.add(btnNewButton_21, gbc_btnNewButton_21);
		
		JButton btnNewButton_8 = new JButton("1");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		            zt = textField.getText();
		            z = zt + "1";
		            textField.setText(z);

		        
			}
		});
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.weighty = 1.0;
		gbc_btnNewButton_8.weightx = 1.0;
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 4;
		panel.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_22 = new JButton("2");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 zt = textField.getText();
		            z = zt + "2";
		            textField.setText(z);
			}
		});
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.weighty = 1.0;
		gbc_btnNewButton_22.weightx = 1.0;
		gbc_btnNewButton_22.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_22.gridx = 1;
		gbc_btnNewButton_22.gridy = 4;
		panel.add(btnNewButton_22, gbc_btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("3");
		GridBagConstraints gbc_btnNewButton_23 = new GridBagConstraints();
		gbc_btnNewButton_23.weighty = 1.0;
		gbc_btnNewButton_23.weightx = 1.0;
		gbc_btnNewButton_23.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_23.gridx = 2;
		gbc_btnNewButton_23.gridy = 4;
		panel.add(btnNewButton_23, gbc_btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("-");
		GridBagConstraints gbc_btnNewButton_24 = new GridBagConstraints();
		gbc_btnNewButton_24.weighty = 1.0;
		gbc_btnNewButton_24.weightx = 1.0;
		gbc_btnNewButton_24.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_24.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_24.gridx = 3;
		gbc_btnNewButton_24.gridy = 4;
		panel.add(btnNewButton_24, gbc_btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("=");
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                num2 = Integer.parseInt(textField.getText());
	            }catch(Exception f)
	            {
	                textField.setText("Enter your number!!");
	                return;
	            }
	            if(check == 1)
	            {
	                try {
	            	ORB orb = ORB.init(client,null);
	    			org.omg.CORBA.Object object = orb.resolve_initial_references("NameService");
	    			NamingContext namingcontext=NamingContextHelper.narrow(object);
	    			NameComponent nameComp = new NameComponent("Hello","");
	    			NameComponent[] path = {nameComp};
	    			object = namingcontext.resolve(path);
	    			tp tpRef = tpHelper.narrow(object);	
	    			xd = tpRef.add(num1, num2);
	    			
	    		}catch(Exception e1) {
	    			System.out.println("Client error ");
	    			e1.printStackTrace();
	    		}

	            }
	            
	            textField.setText(String.valueOf(xd));
			}
		});
		GridBagConstraints gbc_btnNewButton_25 = new GridBagConstraints();
		gbc_btnNewButton_25.gridheight = 2;
		gbc_btnNewButton_25.weighty = 1.0;
		gbc_btnNewButton_25.weightx = 1.0;
		gbc_btnNewButton_25.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_25.gridx = 4;
		gbc_btnNewButton_25.gridy = 4;
		panel.add(btnNewButton_25, gbc_btnNewButton_25);
		
		JButton btnNewButton_9 = new JButton("0");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.gridwidth = 2;
		gbc_btnNewButton_9.weighty = 1.0;
		gbc_btnNewButton_9.weightx = 1.0;
		gbc_btnNewButton_9.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_9.gridx = 0;
		gbc_btnNewButton_9.gridy = 5;
		panel.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton_26 = new JButton(".");
		GridBagConstraints gbc_btnNewButton_26 = new GridBagConstraints();
		gbc_btnNewButton_26.weighty = 1.0;
		gbc_btnNewButton_26.weightx = 1.0;
		gbc_btnNewButton_26.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_26.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_26.gridx = 2;
		gbc_btnNewButton_26.gridy = 5;
		panel.add(btnNewButton_26, gbc_btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("+");
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	            try{
	                num1 = Integer.parseInt(textField.getText());
	            }catch(NumberFormatException f){
	            	textField.setText("Invalid Format");
	                return;
	            }
				
	            z = "";
	            textField.setText(z);
	            check = 1;
			}
		});
		GridBagConstraints gbc_btnNewButton_27 = new GridBagConstraints();
		gbc_btnNewButton_27.weighty = 1.0;
		gbc_btnNewButton_27.weightx = 1.0;
		gbc_btnNewButton_27.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_27.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_27.gridx = 3;
		gbc_btnNewButton_27.gridy = 5;
		panel.add(btnNewButton_27, gbc_btnNewButton_27);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setEnabled(false);
		textField.setBounds(10, 40, 302, 50);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

class ExampleServant extends _tpImplBase{

	
	public float add(float a, float b) {
		return a+b;
	}
	
	
	
}

