package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlLayer.GunReplicasCtr;

import java.awt.SystemColor;

import modelLayer.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GunReplicasGui {

	private JFrame frmGunReplicas;
	private JTextField pidTF;
	private JTextField textField_1;
	private JTextField nameTF;
	private JTextField ppriceTF;
	private JTextField spriceTF;
	private JTextField textField_5;
	private JTextField inStockTF;
	private JTextField minStockTF;
	private JTextField fabricTF;
	private JTextField calibreTF;
	private JTextField countryTF;
	
	private GunReplicas gr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GunReplicasGui window = new GunReplicasGui();
					window.frmGunReplicas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GunReplicasGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGunReplicas = new JFrame();
		frmGunReplicas.setTitle("Gun Replicas");
		frmGunReplicas.setBounds(100, 100, 514, 494);
		frmGunReplicas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGunReplicas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 496, 447);
		frmGunReplicas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_4 = new JLabel("Sale Price");
		label_4.setBounds(183, 162, 75, -4);
		panel.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(356, 172, 116, 22);
		panel.add(textField_5);
		
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
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 13, 472, 81);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(344, 27, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("Supplier ID");
		label_1.setBounds(266, 30, 97, 16);
		panel_1.add(label_1);
		
		JLabel label = new JLabel("Product ID");
		label.setBounds(12, 30, 75, 16);
		panel_1.add(label);
		
		pidTF = new JTextField();
		pidTF.setBounds(87, 27, 64, 22);
		panel_1.add(pidTF);
		pidTF.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findGunReplicas();
			}
		});
		btnFind.setBounds(163, 26, 91, 25);
		panel_1.add(btnFind);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 107, 472, 289);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeGunReplicas();
			}
		});
		btnRemove.setBounds(369, 251, 91, 25);
		panel_2.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateGunReplicas();
			}
		});
		btnUpdate.setBounds(197, 251, 91, 25);
		panel_2.add(btnUpdate);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertGunReplicas();
			}
		});
		btnCreate.setBounds(12, 251, 91, 25);
		panel_2.add(btnCreate);
		
		spriceTF = new JTextField();
		spriceTF.setBounds(160, 65, 152, 22);
		panel_2.add(spriceTF);
		spriceTF.setColumns(10);
		
		ppriceTF = new JTextField();
		ppriceTF.setBounds(12, 65, 116, 22);
		panel_2.add(ppriceTF);
		ppriceTF.setColumns(10);
		
		JLabel label_5 = new JLabel("Rent Price");
		label_5.setBounds(369, 45, 81, 16);
		panel_2.add(label_5);
		
		JLabel label_8 = new JLabel("Sale Price");
		label_8.setBounds(203, 45, 75, 16);
		panel_2.add(label_8);
		
		JLabel label_3 = new JLabel("Purchase Price");
		label_3.setBounds(30, 45, 97, 16);
		panel_2.add(label_3);
		
		nameTF = new JTextField();
		nameTF.setBounds(56, 11, 152, 22);
		panel_2.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setBounds(12, 14, 41, 16);
		panel_2.add(label_2);
		
		minStockTF = new JTextField();
		minStockTF.setBounds(344, 138, 116, 22);
		panel_2.add(minStockTF);
		minStockTF.setColumns(10);
		
		JLabel label_7 = new JLabel("Minimum Stock");
		label_7.setBounds(355, 118, 117, 16);
		panel_2.add(label_7);
		
		inStockTF = new JTextField();
		inStockTF.setBounds(12, 138, 116, 22);
		panel_2.add(inStockTF);
		inStockTF.setColumns(10);
		
		JLabel label_6 = new JLabel("In Stock");
		label_6.setBounds(42, 118, 97, 16);
		panel_2.add(label_6);
		
		fabricTF = new JTextField();
		fabricTF.setBounds(160, 168, 152, 22);
		panel_2.add(fabricTF);
		fabricTF.setColumns(10);
		
		calibreTF = new JTextField();
		calibreTF.setBounds(162, 203, 150, 22);
		panel_2.add(calibreTF);
		calibreTF.setColumns(10);
		
		JLabel lblFabric = new JLabel("Fabric");
		lblFabric.setBounds(116, 173, 97, 16);
		panel_2.add(lblFabric);
		
		JLabel lblCalibre = new JLabel("Calibre");
		lblCalibre.setBounds(116, 203, 75, 16);
		panel_2.add(lblCalibre);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(264, 15, 41, 16);
		panel_2.add(lblCountry);
		
		countryTF = new JTextField();
		countryTF.setColumns(10);
		countryTF.setBounds(308, 12, 152, 22);
		panel_2.add(countryTF);
	}
	
	private void insertGunReplicas() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String fabric = fabricTF.getText();
		double calibre = Double.parseDouble(calibreTF.getText());
		
		GunReplicasCtr grCtr = new GunReplicasCtr();
		try {
			grCtr.insertGunReplicas(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, fabric, calibre);
		}
		catch(Exception e){
        	System.out.println(e);
        }
	}
	
	private void findGunReplicas() {
		int pid = Integer.parseInt(pidTF.getText());
		GunReplicasCtr grCtr = new GunReplicasCtr();
		gr = grCtr.findGunReplicas(pid);
		
		nameTF.setText(gr.getName());
		ppriceTF.setText(""+gr.getPurchasePrice());
		spriceTF.setText(""+gr.getSalesPrice());
		countryTF.setText(gr.getCountryOfOrigin());
		inStockTF.setText(""+gr.getInStock());
		minStockTF.setText(""+gr.getMinStock());
		fabricTF.setText(gr.getFabric());
		calibreTF.setText(""+gr.getCalibre());
	}
	
	private void updateGunReplicas() {
		String name = nameTF.getText();
		double purchasePrice = Double.parseDouble(ppriceTF.getText());
		double salePrice = Double.parseDouble(spriceTF.getText());
		String countryOfOrigin = countryTF.getText();
		int inStock = Integer.parseInt(inStockTF.getText());
		int minStock = Integer.parseInt(minStockTF.getText());
		String fabric = fabricTF.getText();
		double calibre = Double.parseDouble(calibreTF.getText());
		int pid = Integer.parseInt(pidTF.getText());
		
		GunReplicasCtr grCtr = new GunReplicasCtr();
		grCtr.updateGunReplicas(name, purchasePrice, salePrice, countryOfOrigin, inStock, minStock, fabric, calibre, pid);
	}
	
	private void removeGunReplicas() {
		GunReplicasCtr grCtr = new GunReplicasCtr();
		gr.setPid(Integer.parseInt(pidTF.getText()));
		grCtr.removeGunReplicas(gr);
	}
	
	public void back() {
		//this.dispose();
		MainMenuGui.main(null);
	}
}
