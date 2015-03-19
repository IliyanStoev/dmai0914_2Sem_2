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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

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
	private JTextField sidTF;
	private JTextField cidTF;
	private JTextField emailTF;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sale Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 24, 714, 62);
		panel.add(panel_1);
		
		JLabel lblSaleId = new JLabel("Sale ID");
		lblSaleId.setBounds(10, 24, 52, 14);
		panel_1.add(lblSaleId);
		
		saleIdTF = new JTextField();
		saleIdTF.setToolTipText("The order id is assigned automatically when the order is registered");
		saleIdTF.setText("1");
		saleIdTF.setEditable(false);
		saleIdTF.setColumns(10);
		saleIdTF.setBounds(74, 21, 86, 20);
		panel_1.add(saleIdTF);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setBounds(221, 24, 46, 14);
		panel_1.add(label_1);
		
		dateTF = new JTextField();
		dateTF.setToolTipText("Current date ");
		dateTF.setText("18/03/2015");
		dateTF.setEditable(false);
		dateTF.setColumns(10);
		dateTF.setBounds(267, 21, 86, 20);
		panel_1.add(dateTF);
		
		sidTF = new JTextField();
		sidTF.setBounds(472, 21, 86, 20);
		panel_1.add(sidTF);
		sidTF.setToolTipText("Enter order id");
		sidTF.setColumns(10);
		
		JLabel label = new JLabel("Sale ID");
		label.setBounds(411, 24, 52, 14);
		panel_1.add(label);
		
		JButton btnFindSale = new JButton("Find Sale by ID");
		btnFindSale.setToolTipText("Click to find existing order (First enter order's id)");
		btnFindSale.setBounds(569, 19, 133, 30);
		panel_1.add(btnFindSale);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Customer information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 88, 714, 97);
		panel.add(panel_2);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setBounds(10, 35, 46, 14);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setBounds(10, 66, 67, 14);
		panel_2.add(label_4);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(193, 35, 67, 14);
		panel_2.add(lblZipCode);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(193, 66, 79, 14);
		panel_2.add(lblCity);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(383, 35, 46, 14);
		panel_2.add(lblPhone);
		
		nameTF = new JTextField();
		nameTF.setToolTipText("Enter name");
		nameTF.setColumns(10);
		nameTF.setBounds(65, 32, 116, 20);
		panel_2.add(nameTF);
		
		addressTF = new JTextField();
		addressTF.setToolTipText("Enter address");
		addressTF.setColumns(10);
		addressTF.setBounds(65, 63, 116, 20);
		panel_2.add(addressTF);
		
		zipCodeTF = new JTextField();
		zipCodeTF.setToolTipText("Enter CPR Number");
		zipCodeTF.setColumns(10);
		zipCodeTF.setBounds(255, 32, 116, 20);
		panel_2.add(zipCodeTF);
		
		cityTF = new JTextField();
		cityTF.setToolTipText("Enter phone number");
		cityTF.setColumns(10);
		cityTF.setBounds(255, 62, 116, 21);
		panel_2.add(cityTF);
		
		phoneTF = new JTextField();
		phoneTF.setToolTipText("Enter email address");
		phoneTF.setColumns(10);
		phoneTF.setBounds(432, 32, 79, 20);
		panel_2.add(phoneTF);
		
		JButton btnFindCustomer = new JButton("Find existing customer");
		btnFindCustomer.setToolTipText("Click to find existing customer (First enter CPR Number)");
		btnFindCustomer.setBounds(537, 58, 167, 25);
		panel_2.add(btnFindCustomer);
		
		cidTF = new JTextField();
		cidTF.setToolTipText("Enter email address");
		cidTF.setColumns(10);
		cidTF.setBounds(623, 31, 79, 20);
		panel_2.add(cidTF);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(537, 35, 90, 14);
		panel_2.add(lblCustomerId);
		
		emailTF = new JTextField();
		emailTF.setToolTipText("Enter email address");
		emailTF.setColumns(10);
		emailTF.setBounds(432, 63, 79, 20);
		panel_2.add(emailTF);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(383, 66, 46, 14);
		panel_2.add(label_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Order lines", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 271, 714, 189);
		panel.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 694, 163);
		panel_3.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		scrollPane.setViewportView(lblNewLabel);
		
		JButton btnRegisterSale = new JButton("Register Sale");
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "Product information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 198, 714, 62);
		panel.add(panel_4);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(10, 30, 65, 14);
		panel_4.add(lblProductId);
		
		pidTF = new JTextField();
		pidTF.setToolTipText("Enter barcode");
		pidTF.setColumns(10);
		pidTF.setBounds(74, 27, 127, 20);
		panel_4.add(pidTF);
		
		JLabel label_12 = new JLabel("Amount");
		label_12.setBounds(250, 30, 60, 14);
		panel_4.add(label_12);
		
		amountTF = new JTextField();
		amountTF.setToolTipText("Enter amount ");
		amountTF.setColumns(10);
		amountTF.setBounds(306, 27, 46, 20);
		panel_4.add(amountTF);
		
		JButton btnAddToOrder = new JButton("Add to order");
		btnAddToOrder.setToolTipText("Click to add desired product and amount to the order");
		btnAddToOrder.setBounds(554, 25, 150, 25);
		panel_4.add(btnAddToOrder);
		
		JButton btnCancelSale = new JButton("Cancel Sale");
		btnCancelSale.setToolTipText("Click to cancel order ");
		btnCancelSale.setEnabled(false);
		btnCancelSale.setBounds(201, 485, 141, 48);
		panel.add(btnCancelSale);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(325, 579, 133, 45);
		contentPane.add(btnBack);
		btnBack.setToolTipText("Click to back to the Main Menu");
	}
}
