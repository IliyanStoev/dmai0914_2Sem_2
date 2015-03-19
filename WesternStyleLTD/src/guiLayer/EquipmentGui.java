package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.EquipmentCtr;
import modelLayer.*;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipmentGui {

	private JFrame frmEquipment;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField pidTF;
	private JTextField spriceTF;
	private JTextField ppriceTF;
	private JTextField nameTF;
	private JTextField minStockTF;
	private JTextField inStockTF;
	private JTextField typeTF;
	private JTextField descriptionTF;
	private JTextField countryTF;
	
	private Equipment eq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentGui window = new EquipmentGui();
					window.frmEquipment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EquipmentGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEquipment = new JFrame();
		frmEquipment.setTitle("Equipment");
		frmEquipment.setBounds(100, 100, 514, 533);
		frmEquipment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEquipment.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 496, 486);
		frmEquipment.getContentPane().add(panel);
		
		JLabel label = new JLabel("Sale Price");
		label.setBounds(183, 162, 75, -4);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(356, 172, 116, 22);
		panel.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(206, 448, 94, 25);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 13, 472, 81);
		panel.add(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(344, 27, 116, 22);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("Supplier ID");
		label_1.setBounds(266, 30, 97, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Product ID");
		label_2.setBounds(12, 30, 75, 16);
		panel_1.add(label_2);
		
		pidTF = new JTextField();
		pidTF.setColumns(10);
		pidTF.setBounds(87, 27, 64, 22);
		panel_1.add(pidTF);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findEquipment();
			}
		});
		btnFind.setBounds(163, 26, 91, 25);
		panel_1.add(btnFind);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 107, 472, 320);
		panel.add(panel_2);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeEquipment();
			}
		});
		btnRemove.setBounds(369, 282, 91, 25);
		panel_2.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateEquipment();
			}
		});
		btnUpdate.setBounds(197, 282, 91, 25);
		panel_2.add(btnUpdate);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertEquipment();
			}
		});
		btnCreate.setBounds(12, 282, 91, 25);
		panel_2.add(btnCreate);
		
		spriceTF = new JTextField();
		spriceTF.setColumns(10);
		spriceTF.setBounds(160, 65, 152, 22);
		panel_2.add(spriceTF);
		
		ppriceTF = new JTextField();
		ppriceTF.setColumns(10);
		ppriceTF.setBounds(12, 65, 116, 22);
		panel_2.add(ppriceTF);
		
		JLabel label_3 = new JLabel("Rent Price");
		label_3.setBounds(369, 45, 81, 16);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Sale Price");
		label_4.setBounds(203, 45, 75, 16);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Purchase Price");
		label_5.setBounds(30, 45, 97, 16);
		panel_2.add(label_5);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(56, 12, 152, 22);
		panel_2.add(nameTF);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 15, 41, 16);
		panel_2.add(lblName);
		
		minStockTF = new JTextField();
		minStockTF.setColumns(10);
		minStockTF.setBounds(344, 138, 116, 22);
		panel_2.add(minStockTF);
		
		JLabel label_7 = new JLabel("Minimum Stock");
		label_7.setBounds(355, 118, 117, 16);
		panel_2.add(label_7);
		
		inStockTF = new JTextField();
		inStockTF.setColumns(10);
		inStockTF.setBounds(12, 138, 116, 22);
		panel_2.add(inStockTF);
		
		JLabel label_8 = new JLabel("In Stock");
		label_8.setBounds(42, 118, 97, 16);
		panel_2.add(label_8);
		
		typeTF = new JTextField();
		typeTF.setColumns(10);
		typeTF.setBounds(160, 168, 152, 22);
		panel_2.add(typeTF);
		
		descriptionTF = new JTextField();
		descriptionTF.setToolTipText("Enter description");
		descriptionTF.setColumns(10);
		descriptionTF.setBounds(137, 203, 200, 54);
		panel_2.add(descriptionTF);
		
		JLabel lblEquipmentType = new JLabel("Equipment Type");
		lblEquipmentType.setBounds(185, 141, 152, 16);
		panel_2.add(lblEquipmentType);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(246, 15, 59, 16);
		panel_2.add(lblCountry);
		
		countryTF = new JTextField();
		countryTF.setColumns(10);
		countryTF.setBounds(308, 12, 152, 22);
		panel_2.add(countryTF);
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
