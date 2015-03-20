package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import controlLayer.ClothingCtr;

import java.awt.SystemColor;

import modelLayer.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClothingGui extends JFrame{

	private JFrame frmClothing;
	private JTextField textField;
	private JTextField supIdTF;
	private JTextField pidTF;
	private JTextField spriceTF;
	private JTextField ppriceTF;
	private JTextField nameTF;
	private JTextField minStockTF;
	private JTextField inStockTF;
	private JTextField sizeTF;
	private JTextField colorTF;
	
	private Clothing clo;
	private JTextField countryTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothingGui window = new ClothingGui();
					window.frmClothing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClothingGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClothing = new JFrame();
		frmClothing.setTitle("Clothing");
		frmClothing.setBounds(100, 100, 515, 490);
		frmClothing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClothing.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 496, 447);
		frmClothing.getContentPane().add(panel);
		
		JLabel label = new JLabel("Sale Price");
		label.setBounds(183, 162, 75, -4);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(356, 172, 116, 22);
		panel.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});
		btnBack.setBounds(204, 409, 94, 25);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 13, 472, 81);
		panel.add(panel_1);
		
		supIdTF = new JTextField();
		supIdTF.setColumns(10);
		supIdTF.setBounds(344, 27, 116, 22);
		panel_1.add(supIdTF);
		
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
				findClothing();
			}
		});
		btnFind.setBounds(163, 26, 91, 25);
		panel_1.add(btnFind);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 107, 472, 289);
		panel.add(panel_2);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeClothing();
			}
		});
		btnRemove.setBounds(369, 251, 91, 25);
		panel_2.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateClothing();
			}
		});
		btnUpdate.setBounds(197, 251, 91, 25);
		panel_2.add(btnUpdate);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insertClothing();
			}
		});
		btnCreate.setBounds(12, 251, 91, 25);
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
		nameTF.setBounds(52, 12, 152, 22);
		panel_2.add(nameTF);
		
		JLabel label_6 = new JLabel("Name");
		label_6.setBounds(12, 15, 41, 16);
		panel_2.add(label_6);
		
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
		
		sizeTF = new JTextField();
		sizeTF.setColumns(10);
		sizeTF.setBounds(160, 168, 152, 22);
		panel_2.add(sizeTF);
		
		colorTF = new JTextField();
		colorTF.setColumns(10);
		colorTF.setBounds(162, 203, 150, 22);
		panel_2.add(colorTF);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(116, 173, 97, 16);
		panel_2.add(lblSize);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(116, 203, 75, 16);
		panel_2.add(lblColor);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(247, 13, 51, 16);
		panel_2.add(lblCountry);
		
		countryTF = new JTextField();
		countryTF.setColumns(10);
		countryTF.setBounds(308, 10, 152, 22);
		panel_2.add(countryTF);
	}
	
	private void insertClothing() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String color = colorTF.getText();
		String size = sizeTF.getText();
		
		ClothingCtr cloCtr = new ClothingCtr();
		try {
			cloCtr.insertClothing(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, color, size);
		}
		catch(Exception e){
        	System.out.println(e);
        }
	}
	
	private void findClothing() {
		int pid = Integer.parseInt(pidTF.getText());
		ClothingCtr cloCtr = new ClothingCtr();
		clo = cloCtr.findClothing(pid);
		
		nameTF.setText(clo.getName());
		ppriceTF.setText(""+clo.getPurchasePrice());
		spriceTF.setText(""+clo.getSalesPrice());
		countryTF.setText(clo.getCountryOfOrigin());
		inStockTF.setText(""+clo.getInStock());
		minStockTF.setText(""+clo.getMinStock());
		colorTF.setText(clo.getColor());
		sizeTF.setText(clo.getSize());
	}
	
	private void updateClothing() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String color = colorTF.getText();
		String size = sizeTF.getText();
		int pid = Integer.parseInt(pidTF.getText());
		
		ClothingCtr cloCtr = new ClothingCtr();
		cloCtr.updateClothing(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, color, size, pid);
	}
	
	private void removeClothing() {
		ClothingCtr cloCtr = new ClothingCtr();
		clo.setPid(Integer.parseInt(pidTF.getText()));
		cloCtr.removeClothing(clo);
	}
	
	public void back() {
		this.dispose();
		MainMenuGui.main(null);
	}
}
