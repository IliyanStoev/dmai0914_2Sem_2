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

public class ClothingGui extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField ppriceTF;
	private JTextField spriceTF;
	private JTextField countryTF;
	private JTextField inStockTF;
	private JTextField minStockTF;
	private JTextField sizeTF;
	private JTextField colorTF;
	private Clothing clo;
	private JTextField pidTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothingGui frame = new ClothingGui();
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
	public ClothingGui() {
		setTitle("Clothing");
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
				insertClothing();
			}
		});
		btnCreate.setBounds(10, 208, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateClothing();
			}
		});
		btnUpdate.setBounds(109, 208, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeClothing();
			}
		});
		btnRemove.setBounds(208, 208, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnFind = new JButton("Find");
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findClothing();
			}
		});
		btnFind.setBounds(307, 208, 89, 23);
		contentPane.add(btnFind);
		
		sizeTF = new JTextField();
		sizeTF.setBounds(281, 157, 86, 20);
		contentPane.add(sizeTF);
		sizeTF.setColumns(10);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(281, 131, 46, 14);
		contentPane.add(lblSize);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(276, 78, 46, 14);
		contentPane.add(lblColor);
		
		colorTF = new JTextField();
		colorTF.setBounds(276, 104, 86, 20);
		contentPane.add(colorTF);
		
		JLabel lblPid = new JLabel("Pid");
		lblPid.setBounds(276, 22, 46, 14);
		contentPane.add(lblPid);
		
		pidTF = new JTextField();
		pidTF.setBounds(276, 48, 86, 20);
		contentPane.add(pidTF);
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
}
