package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controlLayer.*;
import modelLayer.*;

public class EquipmentGui extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField ppriceTF;
	private JTextField spriceTF;
	private JTextField countryTF;
	private JTextField inStockTF;
	private JTextField minStockTF;
	private JTextField descriptionTF;
	private JTextField typeTF;
	private JTextField pidTF;
	private Equipment eq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentGui frame = new EquipmentGui();
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
	public EquipmentGui() {
		setTitle("Equipment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 29, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblPurchasePrice = new JLabel("Purchase price");
		lblPurchasePrice.setBounds(10, 54, 76, 14);
		contentPane.add(lblPurchasePrice);
		
		JLabel lblSalePrice = new JLabel("Sale price");
		lblSalePrice.setBounds(10, 81, 76, 14);
		contentPane.add(lblSalePrice);
		
		JLabel lblCountryOfOrigin = new JLabel("Country");
		lblCountryOfOrigin.setBounds(10, 106, 76, 14);
		contentPane.add(lblCountryOfOrigin);
		
		JLabel lblInStock = new JLabel("In stock");
		lblInStock.setBounds(10, 131, 46, 14);
		contentPane.add(lblInStock);
		
		JLabel lblMinStock = new JLabel("Min. stock");
		lblMinStock.setBounds(10, 160, 76, 14);
		contentPane.add(lblMinStock);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(96, 26, 150, 20);
		contentPane.add(nameTF);		
		
		ppriceTF = new JTextField();
		ppriceTF.setColumns(10);
		ppriceTF.setBounds(96, 51, 150, 20);
		contentPane.add(ppriceTF);
		
		spriceTF = new JTextField();
		spriceTF.setColumns(10);
		spriceTF.setBounds(96, 78, 150, 20);
		contentPane.add(spriceTF);
		
		countryTF = new JTextField();
		countryTF.setColumns(10);
		countryTF.setBounds(96, 103, 150, 20);
		contentPane.add(countryTF);
		
		inStockTF = new JTextField();
		inStockTF.setColumns(10);
		inStockTF.setBounds(96, 128, 150, 20);
		contentPane.add(inStockTF);
		
		minStockTF = new JTextField();
		minStockTF.setColumns(10);
		minStockTF.setBounds(96, 157, 150, 20);
		contentPane.add(minStockTF);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insertEquipment();
			}
		});
		btnCreate.setBounds(10, 208, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateEquipment();
			}
		});
		btnUpdate.setBounds(109, 208, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeEquipment();
			}
		});
		btnRemove.setBounds(208, 208, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findEquipment();
			}
		});
		btnFind.setBounds(307, 208, 89, 23);
		contentPane.add(btnFind);
		
		descriptionTF = new JTextField();
		descriptionTF.setBounds(281, 157, 86, 20);
		contentPane.add(descriptionTF);
		descriptionTF.setColumns(10);
		
		JLabel lblSize = new JLabel("Description");
		lblSize.setBounds(281, 131, 70, 14);
		contentPane.add(lblSize);
		
		JLabel lblColor = new JLabel("Type");
		lblColor.setBounds(276, 78, 46, 14);
		contentPane.add(lblColor);
		
		typeTF = new JTextField();
		typeTF.setBounds(276, 104, 86, 20);
		contentPane.add(typeTF);
		
		JLabel lblPid = new JLabel("Pid");
		lblPid.setBounds(276, 22, 46, 14);
		contentPane.add(lblPid);
		
		pidTF = new JTextField();
		pidTF.setBounds(276, 48, 86, 20);
		contentPane.add(pidTF);
	}
	
	private void insertEquipment() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String color = typeTF.getText();
		String size = descriptionTF.getText();
		
		EquipmentCtr eqCtr = new EquipmentCtr();
		try {
			eqCtr.insertEquipment(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, color, size);
		}
		catch(Exception e){
        	System.out.println(e);
        }
	}
	
	private void findEquipment() {
		int pid = Integer.parseInt(pidTF.getText());
		EquipmentCtr eqCtr = new EquipmentCtr();
		eq = eqCtr.findEquipment(pid);
		
		nameTF.setText(eq.getName());
		ppriceTF.setText(""+eq.getPurchasePrice());
		spriceTF.setText(""+eq.getSalesPrice());
		countryTF.setText(eq.getCountryOfOrigin());
		inStockTF.setText(""+eq.getInStock());
		minStockTF.setText(""+eq.getMinStock());
		typeTF.setText(eq.getEtype());
		descriptionTF.setText(eq.getDescription());
	}
	
	private void updateEquipment() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String type = typeTF.getText();
		String description = descriptionTF.getText();
		int pid = Integer.parseInt(pidTF.getText());
		
		EquipmentCtr eqCtr = new EquipmentCtr();
		eqCtr.updateEquipment(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, type, description, pid);
	}
	
	private void removeEquipment() {
		EquipmentCtr eqCtr = new EquipmentCtr();
		eq.setPid(Integer.parseInt(pidTF.getText()));
		eqCtr.removeEquipment(eq);
	}
}
