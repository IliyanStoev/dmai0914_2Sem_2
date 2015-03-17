package guiLayer;

import java.awt.BorderLayout;

import controlLayer.*;
import modelLayer.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerGui extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField codeZipTF;
	private JTextField cityTF;
	private JTextField phoneTF;
	private JTextField cidTF;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTF = new JTextField();
		nameTF.setBounds(109, 30, 173, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 33, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 58, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCodezip = new JLabel("CodeZip");
		lblCodezip.setBounds(10, 86, 46, 14);
		contentPane.add(lblCodezip);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 117, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 149, 46, 14);
		contentPane.add(lblPhone);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(109, 55, 173, 20);
		contentPane.add(addressTF);
		
		codeZipTF = new JTextField();
		codeZipTF.setColumns(10);
		codeZipTF.setBounds(109, 83, 173, 20);
		contentPane.add(codeZipTF);
		
		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(109, 114, 173, 20);
		contentPane.add(cityTF);
		
		phoneTF = new JTextField();
		phoneTF.setColumns(10);
		phoneTF.setBounds(109, 146, 173, 20);
		contentPane.add(phoneTF);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insertCustomer();
			}
		});
		btnCreate.setBounds(20, 200, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(134, 200, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(233, 200, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				findCustomerById();
			}
		});
		btnFind.setBounds(335, 200, 89, 23);
		contentPane.add(btnFind);
		
		cidTF = new JTextField();
		cidTF.setColumns(10);
		cidTF.setBounds(344, 146, 57, 20);
		contentPane.add(cidTF);
		
		JLabel lblFindById = new JLabel("Find by id");
		lblFindById.setBounds(344, 117, 57, 14);
		contentPane.add(lblFindById);
	}
	
	private void insertCustomer() {
		String name = nameTF.getText();
		String address = addressTF.getText();
		String codeZip = codeZipTF.getText();
		String city = cityTF.getText();
		String phone = phoneTF.getText();
		
		CustomerCtr custCtr = new CustomerCtr();
		try {
			custCtr.insertCustomer(name, address, codeZip, city, phone);
		}
        catch(Exception e){
        	System.out.println(e);
        }
	}
		
	private void findCustomerById() {
		int cid = Integer.parseInt(cidTF.getText());
		
		CustomerCtr custCtr = new CustomerCtr();
		Customer cust = custCtr.findById(cid);
		if(cust != null) {
			nameTF.setText(cust.getName());
			addressTF.setText(cust.getAddress());
			codeZipTF.setText(cust.getZipCode());
			cityTF.setText(cust.getCity());
			phoneTF.setText(cust.getPhoneNo());
		}
		else {
			System.out.println("Customer empty");
		}
	}
	
}
