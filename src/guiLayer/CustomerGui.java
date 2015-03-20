package guiLayer;

import java.awt.BorderLayout;

import controlLayer.*;
import modelLayer.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;

public class CustomerGui extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField zipCodeTF;
	private JTextField cityTF;
	private JTextField phoneTF;
	private JTextField cidTF;
	private JTextField emailTF;
	
	private Customer cust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGui frame = new CustomerGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerGui() {
		setTitle("Customer Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setToolTipText("Customer Information\r\n");
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTF = new JTextField();
		nameTF.setBounds(126, 64, 191, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(68, 67, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(68, 101, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCodezip = new JLabel("ZipCode");
		lblCodezip.setBounds(68, 134, 46, 14);
		contentPane.add(lblCodezip);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(68, 161, 46, 26);
		contentPane.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(68, 200, 46, 14);
		contentPane.add(lblPhone);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(126, 98, 191, 20);
		contentPane.add(addressTF);
		
		zipCodeTF = new JTextField();
		zipCodeTF.setColumns(10);
		zipCodeTF.setBounds(126, 131, 191, 20);
		contentPane.add(zipCodeTF);
		
		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(126, 164, 191, 20);
		contentPane.add(cityTF);
		
		phoneTF = new JTextField();
		phoneTF.setColumns(10);
		phoneTF.setBounds(126, 197, 191, 20);
		contentPane.add(phoneTF);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insertCustomer();
			}
		});
		btnCreate.setBounds(12, 310, 102, 26);
		contentPane.add(btnCreate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeCustomer();
			}
		});
		btnRemove.setBounds(318, 310, 102, 26);
		contentPane.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCustomer();
			}
		});
		btnUpdate.setBounds(171, 263, 89, 26);
		contentPane.add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				findCustomerById();
			}
		});
		btnFind.setBounds(226, 28, 89, 23);
		contentPane.add(btnFind);
		
		cidTF = new JTextField();
		cidTF.setColumns(10);
		cidTF.setBounds(126, 29, 88, 20);
		contentPane.add(cidTF);
		
		JLabel lblFindById = new JLabel("Customer ID");
		lblFindById.setBounds(38, 32, 89, 14);
		contentPane.add(lblFindById);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(126, 230, 191, 20);
		contentPane.add(emailTF);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(68, 233, 46, 14);
		contentPane.add(lblEmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});
		btnBack.setBounds(156, 310, 118, 26);
		contentPane.add(btnBack);
	}
	
	private void insertCustomer() {
		CustomerCtr custCtr = new CustomerCtr();
		
		String name = nameTF.getText();
		String address = addressTF.getText();
		int zipCode = Integer.parseInt(zipCodeTF.getText());
		String city = cityTF.getText();
		String phone = phoneTF.getText();
		String email = emailTF.getText();
			
		try {
			custCtr.insertCustomer(name, address, zipCode, city, phone, email);
			JOptionPane.showMessageDialog(null, "The customer has been successfully created");
		}
        catch(Exception e){
        	System.out.println(e);
        	JOptionPane.showMessageDialog(null, "There was a problem while trying to insert the customer into the database. Please try again");
        }
		
	}
		
	private void findCustomerById() {
		int cid = Integer.parseInt(cidTF.getText());
		
		CustomerCtr custCtr = new CustomerCtr();
		cust = custCtr.findByCid(cid);
		if(cust != null) {
			nameTF.setText(cust.getName());
			addressTF.setText(cust.getAddress());
			zipCodeTF.setText(""+cust.getZipCode());
			cityTF.setText(cust.getCity());
			phoneTF.setText(cust.getPhoneNo());
			emailTF.setText(cust.getEmail());
		}
		else {
			System.out.println("Customer empty");
		}
	}
	
	private void updateCustomer() {
		int cid = cust.getCid();
		String name = nameTF.getText();
		String address = addressTF.getText();
		int zipCode = Integer.parseInt(zipCodeTF.getText());
		String city = cityTF.getText();
		String phone = phoneTF.getText();
		String email = emailTF.getText();
		
		CustomerCtr custCtr = new CustomerCtr();
		custCtr.updateCustomer(name, address, zipCode, city, phone, email, cid); 
	}

	private void removeCustomer() {
		CustomerCtr custCtr = new CustomerCtr();
		custCtr.removeCustomer(cust);
	}
	
	public void back() {
		//this.dispose();
		MainMenuGui.main(null);
	}
}
