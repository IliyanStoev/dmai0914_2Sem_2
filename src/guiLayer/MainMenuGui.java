package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuGui extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGui frame = new MainMenuGui();
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
	public MainMenuGui() {
		setTitle("MainMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 432, 360);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerGui.main(null);
				dismiss();
			}
		});
		btnCustomers.setBounds(142, 37, 144, 48);
		panel.add(btnCustomers);
		
		JButton btnSales = new JButton("Sales");
		btnSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SalesGui.main(null);
				dismiss();
			}
		});
		btnSales.setBounds(144, 227, 142, 48);
		panel.add(btnSales);
		
		JButton btnEquipment = new JButton("Equipment");
		btnEquipment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EquipmentGui.main(null);
				dismiss();
			}
		});
		btnEquipment.setBounds(12, 166, 120, 48);
		panel.add(btnEquipment);
		
		JButton btnClothing = new JButton("Clothing");
		btnClothing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClothingGui.main(null);
				dismiss();
			}
		});
		btnClothing.setBounds(144, 166, 144, 48);
		panel.add(btnClothing);
		
		JButton btnGunReplicas = new JButton("Gun Replicas");
		btnGunReplicas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GunReplicasGui.main(null);
				dismiss();
			}
		});
		btnGunReplicas.setBounds(300, 166, 120, 48);
		panel.add(btnGunReplicas);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.setBounds(142, 105, 144, 48);
		panel.add(btnSuppliers);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(144, 314, 142, 33);
		panel.add(btnExit);
	}
	
	private void dismiss() {
		this.dispose();
	}
}
