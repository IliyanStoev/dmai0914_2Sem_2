package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

import modelLayer.*;
import controlLayer.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalesGui extends JFrame {

	private JPanel contentPane;
	private JTextField saleIdTF;
	private JTextField dateTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField zipCodeTF;
	private JTextField cityTF;
	private JTextField phoneTF;
	private JTextField totalPriceTF;
	private JTextField discountTF;
	private JTextField totalTF;
	private JTextField pidTF;
	private JTextField amountTF;
	private JTextField oidTF;
	private JTextField cidTF;
	private JTextField emailTF;
	private JTable productsTable;
	private JButton btnCancelSale;
	
	private Customer cust;
	private int cid;
	private Product prod;
	private int pid;
	private SalesOrder so;
	private int oid;
	private ArrayList<SalesLine> salesLines;
	private double subtotal;
    private double total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesGui frame = new SalesGui();
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
	public SalesGui() {
		salesLines = new ArrayList<>();
		
		setTitle("Sales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 684);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 13, 740, 563);
		contentPane.add(panel);
		
		JPanel saleInfo = new JPanel();
		saleInfo.setLayout(null);
		saleInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sale Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		saleInfo.setBounds(10, 24, 714, 62);
		panel.add(saleInfo);
		
		JLabel lblSaleId = new JLabel("Sale ID");
		lblSaleId.setBounds(10, 24, 52, 14);
		saleInfo.add(lblSaleId);
		
		saleIdTF = new JTextField();
		saleIdTF.setToolTipText("The order id is assigned automatically when the order is registered");
		saleIdTF.setText("1");
		saleIdTF.setEditable(false);
		saleIdTF.setColumns(10);
		saleIdTF.setBounds(74, 21, 86, 20);
		saleInfo.add(saleIdTF);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setBounds(221, 24, 46, 14);
		saleInfo.add(label_1);
		
		dateTF = new JTextField();
		dateTF.setToolTipText("Current date ");
		dateTF.setText("18/03/2015");
		dateTF.setEditable(false);
		dateTF.setColumns(10);
		dateTF.setBounds(267, 21, 86, 20);
		saleInfo.add(dateTF);
		
		oidTF = new JTextField();
		oidTF.setBounds(472, 21, 86, 20);
		saleInfo.add(oidTF);
		oidTF.setToolTipText("Enter order id");
		oidTF.setColumns(10);
		
		JLabel label = new JLabel("Sale ID");
		label.setBounds(411, 24, 52, 14);
		saleInfo.add(label);
		
		JButton btnFindSale = new JButton("Find Sale by ID");
		btnFindSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findSalesOrder();
			}
		});
		btnFindSale.setToolTipText("Click to find existing order (First enter order's id)");
		btnFindSale.setBounds(569, 19, 133, 30);
		saleInfo.add(btnFindSale);
		
		JPanel customerInfo = new JPanel();
		customerInfo.setLayout(null);
		customerInfo.setBorder(new TitledBorder(null, "Customer information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerInfo.setBounds(10, 88, 714, 97);
		panel.add(customerInfo);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setBounds(10, 35, 46, 14);
		customerInfo.add(label_3);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setBounds(10, 66, 67, 14);
		customerInfo.add(label_4);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(193, 35, 67, 14);
		customerInfo.add(lblZipCode);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(193, 66, 79, 14);
		customerInfo.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(383, 35, 46, 14);
		customerInfo.add(lblPhone);
		
		nameTF = new JTextField();
		nameTF.setToolTipText("Enter name");
		nameTF.setColumns(10);
		nameTF.setBounds(65, 32, 116, 20);
		customerInfo.add(nameTF);
		
		addressTF = new JTextField();
		addressTF.setToolTipText("Enter address");
		addressTF.setColumns(10);
		addressTF.setBounds(65, 63, 116, 20);
		customerInfo.add(addressTF);
		
		zipCodeTF = new JTextField();
		zipCodeTF.setToolTipText("Enter CPR Number");
		zipCodeTF.setColumns(10);
		zipCodeTF.setBounds(255, 32, 116, 20);
		customerInfo.add(zipCodeTF);
		
		cityTF = new JTextField();
		cityTF.setToolTipText("Enter phone number");
		cityTF.setColumns(10);
		cityTF.setBounds(255, 62, 116, 21);
		customerInfo.add(cityTF);
		
		phoneTF = new JTextField();
		phoneTF.setToolTipText("Enter email address");
		phoneTF.setColumns(10);
		phoneTF.setBounds(432, 32, 79, 20);
		customerInfo.add(phoneTF);
		
		JButton btnFindCustomer = new JButton("Find existing customer");
		btnFindCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addCustomer();
			}
		});
		btnFindCustomer.setToolTipText("Click to find existing customer (First enter CPR Number)");
		btnFindCustomer.setBounds(537, 58, 167, 25);
		customerInfo.add(btnFindCustomer);
		
		cidTF = new JTextField();
		cidTF.setToolTipText("Enter email address");
		cidTF.setColumns(10);
		cidTF.setBounds(623, 31, 79, 20);
		customerInfo.add(cidTF);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(537, 35, 90, 14);
		customerInfo.add(lblCustomerId);
		
		emailTF = new JTextField();
		emailTF.setToolTipText("Enter email address");
		emailTF.setColumns(10);
		emailTF.setBounds(432, 63, 79, 20);
		customerInfo.add(emailTF);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(383, 66, 46, 14);
		customerInfo.add(label_5);
		
		JPanel salesLine = new JPanel();
		salesLine.setLayout(null);
		salesLine.setBorder(new TitledBorder(null, "Order lines", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		salesLine.setBounds(10, 271, 714, 189);
		panel.add(salesLine);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 694, 163);
		salesLine.add(scrollPane);
		
		productsTable = new JTable();
		productsTable.setEnabled(false);
		productsTable.setColumnSelectionAllowed(true);
		productsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "Name", "Price", "Quantity", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		productsTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollPane.setViewportView(productsTable);
		
		JButton btnRegisterSale = new JButton("Register Sale");
		btnRegisterSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertSalesOrder();
			}
		});
		btnRegisterSale.setToolTipText("Click to register the order");
		btnRegisterSale.setBounds(10, 485, 154, 48);
		panel.add(btnRegisterSale);
		
		JLabel label_8 = new JLabel("Total");
		label_8.setBounds(498, 468, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Discount");
		label_9.setBounds(498, 502, 75, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Total price");
		label_10.setBounds(498, 533, 75, 14);
		panel.add(label_10);
		
		totalPriceTF = new JTextField();
		totalPriceTF.setToolTipText("Total price with discount");
		totalPriceTF.setEditable(false);
		totalPriceTF.setColumns(10);
		totalPriceTF.setBounds(583, 530, 141, 20);
		panel.add(totalPriceTF);
		
		discountTF = new JTextField();
		discountTF.setToolTipText("Discount ");
		discountTF.setEditable(false);
		discountTF.setColumns(10);
		discountTF.setBounds(583, 499, 141, 20);
		panel.add(discountTF);
		
		totalTF = new JTextField();
		totalTF.setToolTipText("Total price without discount");
		totalTF.setEditable(false);
		totalTF.setColumns(10);
		totalTF.setBounds(583, 465, 141, 20);
		panel.add(totalTF);
		
		JPanel productInfo = new JPanel();
		productInfo.setLayout(null);
		productInfo.setBorder(new TitledBorder(null, "Product information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		productInfo.setBounds(10, 198, 714, 62);
		panel.add(productInfo);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(10, 30, 65, 14);
		productInfo.add(lblProductId);
		
		pidTF = new JTextField();
		pidTF.setToolTipText("Enter barcode");
		pidTF.setColumns(10);
		pidTF.setBounds(74, 27, 127, 20);
		productInfo.add(pidTF);
		
		JLabel label_12 = new JLabel("Amount");
		label_12.setBounds(250, 30, 60, 14);
		productInfo.add(label_12);
		
		amountTF = new JTextField();
		amountTF.setToolTipText("Enter amount ");
		amountTF.setColumns(10);
		amountTF.setBounds(306, 27, 46, 20);
		productInfo.add(amountTF);
		
		JButton btnAddToOrder = new JButton("Add to order");
		btnAddToOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addProduct();
			}
		});
		btnAddToOrder.setToolTipText("Click to add desired product and amount to the order");
		btnAddToOrder.setBounds(554, 25, 150, 25);
		productInfo.add(btnAddToOrder);
		
		btnCancelSale = new JButton("Cancel Sale");
		btnCancelSale.setEnabled(false);
		btnCancelSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelSalesOrder();
			}
		});
		btnCancelSale.setToolTipText("Click to cancel order ");
		btnCancelSale.setBounds(201, 485, 141, 48);
		panel.add(btnCancelSale);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});
		btnBack.setBounds(325, 579, 133, 45);
		contentPane.add(btnBack);
		btnBack.setToolTipText("Click to back to the Main Menu");
	}
	
	private void addCustomer() {
		cid = Integer.parseInt(cidTF.getText());
		SalesOrderCtr soCtr = new SalesOrderCtr();
		cust = (soCtr.findCustomer(cid));
		
		if(cust != null) {
			nameTF.setText(cust.getName());
			addressTF.setText(cust.getAddress());
			zipCodeTF.setText(""+cust.getZipCode());
			cityTF.setText(cust.getCity());
			phoneTF.setText(cust.getPhoneNo());
			//emailTF.setText(cust.getEmail());
		}
		else {
			nameTF.setText("NOT FOUND");
		}
	}
	
	private void addProduct() {
		int i = 0;
		SalesOrderCtr soCtr = new SalesOrderCtr();
		prod = soCtr.findProduct(Integer.parseInt(pidTF.getText()));
		if(prod != null) {
			int quantity = Integer.parseInt(amountTF.getText());
			if (quantity <= prod.getInStock()) {
				SalesLine sl = soCtr.createSalesLine(prod, quantity);
                subtotal = prod.getSalesPrice() * quantity;
                salesLines.add(sl);
                total += subtotal;
                prod.setInStock(prod.getInStock()-quantity);
                
                Object[] row = {i+1, prod.getName(), prod.getSalesPrice(), quantity, subtotal};
                DefaultTableModel model = (DefaultTableModel)productsTable.getModel();
                model.addRow(row);
                pidTF.setText("");
                amountTF.setText("");
                
                totalTF.setText(String.valueOf(total));
                if(total > 1000) {
                	discountTF.setText("10");
                }
                else {
                	discountTF.setText("0");
                }
                if (Integer.parseInt(discountTF.getText()) != 0) {
                	totalPriceTF.setText("" + (total - (total * Integer.parseInt(discountTF.getText())/100)));
                }
                else {
                	totalPriceTF.setText(totalTF.getText());
                }
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "The barcode does not exist. Please enter a new barcode.");
		}
	}
	
	private void insertSalesOrder() {
		String date = dateTF.getText();
		SalesOrderCtr soCtr = new SalesOrderCtr();
		if (cust != null) {
			try{
			soCtr.insertSalesOrder(cust, salesLines, date, total);
			for (SalesLine sl : salesLines) {
				soCtr.updateInStockAmount(sl.getProduct(), -sl.getQuantity());
			}
			}
			catch(Exception e){
	        	System.out.println(e);
	        }
			JOptionPane.showMessageDialog(null, "The order has been successfully registered");
			this.dispose();
			SalesGui.main(null);
		}
		else {
			JOptionPane.showMessageDialog(null, "No customer selected. Please enter the customer information");
		}
	}
	
	private void findSalesOrder() {
		SalesOrderCtr soCtr = new SalesOrderCtr();
		int oid = Integer.parseInt(oidTF.getText());
		so = (soCtr.findSalesOrder(oid));
		
		if (so != null) {
			cust = so.getCustomer();
			JOptionPane.showMessageDialog(null, "\nCustomer : \t" + so.getCustomer().getName() + "\n--------------- \nOrder date  : \t" + so.getDate() + "\nOrder status : \t" + so.getDeliveryStatus() + "\nTotal price : \t" + so.getOrdAmount() );
			btnCancelSale.setEnabled(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "The order id is not registered. Please enter another order id.");
		}
	}
	
	private void cancelSalesOrder() {
		SalesOrderCtr soCtr = new SalesOrderCtr();
		oid = Integer.parseInt(oidTF.getText());
		so = soCtr.findSalesOrder(oid);
		if (so != null) {
			if(!so.getDeliveryStatus().equals("Delivered") || !so.getDeliveryStatus().equals("Cancelled")) {
				so.setDeliveryStatus("Cancelled");
				so.setOid(oid);
				soCtr.changeDeliveryStatus(so);
				// Return products quantities back to inStock attribute
				/*ArrayList<SalesLine> salesLines = so.getSalesLines();
		        for(SalesLine sl : salesLines) {
		            Product prod = sl.getProduct();
		            prod.setInStock(prod.getInStock()+sl.getQuantity());
		            soCtr.updateInStockAmount(sl.getProduct(), sl.getQuantity());
		        }*/
		        JOptionPane.showMessageDialog(null, "The order has been successfully cancelled.");
				}
			else {
				JOptionPane.showMessageDialog(null, "The order has been already delivered or cancelled.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "The order id is not registered. Please enter another order id.");
		}
	}
	
	public void back() {
		this.dispose();
		MainMenuGui.main(null);
	}
}
