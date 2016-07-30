package com.enable.regis.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllDetail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel idHere;
	
	public JLabel nameHere;
	
	public JLabel ageHere;
	
	public JLabel genderHere;
	
	public JLabel addressHere;
	
	public JLabel fatherHere;
	
	public JLabel motherHere;
	
	public JLabel contactHere;
	
	public JLabel remarksHere;
	
	public JLabel recHere;
	
	public JLabel delHere;
	
	public JLabel guardianHere;
	
	public JLabel dueHere;
	
	public JLabel prostheticHere;
	
	public JLabel retHere;
	
	public JLabel affectedHere;
	
	public JLabel bicepHere;
	
	public JLabel etwHere;
	
	public JLabel wtfHere;
	
	public JLabel reqdHere;
	public JLabel picHere;
	public JLabel sigHere;


	/**
	 * Create the frame.
	 */
	public AllDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 691);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.RED);
		lblName.setBounds(27, 96, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.RED);
		lblAge.setBounds(27, 124, 70, 15);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.RED);
		lblGender.setBounds(27, 151, 70, 15);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.RED);
		lblAddress.setBounds(27, 182, 70, 15);
		contentPane.add(lblAddress);
		
		JLabel lblFathersName = new JLabel("Father's Name:");
		lblFathersName.setForeground(Color.RED);
		lblFathersName.setBounds(27, 209, 108, 15);
		contentPane.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name:");
		lblMothersName.setForeground(Color.RED);
		lblMothersName.setBounds(27, 236, 122, 15);
		contentPane.add(lblMothersName);
		
		JLabel lblGuardiansName = new JLabel("Guardian's Name:");
		lblGuardiansName.setForeground(Color.RED);
		lblGuardiansName.setBounds(27, 263, 137, 15);
		contentPane.add(lblGuardiansName);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setForeground(Color.RED);
		lblContact.setBounds(27, 290, 108, 15);
		contentPane.add(lblContact);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.RED);
		lblId.setBounds(27, 69, 108, 15);
		contentPane.add(lblId);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setForeground(Color.RED);
		lblRemarks.setBounds(27, 317, 108, 15);
		contentPane.add(lblRemarks);
		
		JLabel lblRecievedDate = new JLabel("Recieved Date:");
		lblRecievedDate.setForeground(Color.RED);
		lblRecievedDate.setBounds(27, 344, 108, 15);
		contentPane.add(lblRecievedDate);
		
		JLabel lblDueDate = new JLabel("Due Date:");
		lblDueDate.setForeground(Color.RED);
		lblDueDate.setBounds(27, 371, 108, 15);
		contentPane.add(lblDueDate);
		
		JLabel lblDeliveryStatus = new JLabel("Delivery Status:");
		lblDeliveryStatus.setForeground(Color.RED);
		lblDeliveryStatus.setBounds(27, 398, 122, 15);
		contentPane.add(lblDeliveryStatus);
		
		JLabel lblReturnStatus = new JLabel("Return Status:");
		lblReturnStatus.setForeground(Color.RED);
		lblReturnStatus.setBounds(27, 425, 108, 15);
		contentPane.add(lblReturnStatus);
		
		JLabel lblProstheticType = new JLabel("Prosthetic Type:");
		lblProstheticType.setForeground(Color.RED);
		lblProstheticType.setBounds(27, 452, 137, 15);
		contentPane.add(lblProstheticType);
		
		JLabel lblAffectedSide = new JLabel("Affected Side:");
		lblAffectedSide.setForeground(Color.RED);
		lblAffectedSide.setBounds(175, 485, 108, 15);
		contentPane.add(lblAffectedSide);
		
		JLabel lblBicepmm = new JLabel("Bicep (mm):");
		lblBicepmm.setForeground(Color.RED);
		lblBicepmm.setBounds(175, 512, 96, 15);
		contentPane.add(lblBicepmm);
		
		JLabel lblElbowToWristmm = new JLabel("Elbow to wrist(mm):");
		lblElbowToWristmm.setForeground(Color.RED);
		lblElbowToWristmm.setBounds(175, 539, 152, 15);
		contentPane.add(lblElbowToWristmm);
		
		JLabel lblWristToF = new JLabel("Wrist to F. Tip(mm):");
		lblWristToF.setForeground(Color.RED);
		lblWristToF.setBounds(175, 567, 152, 15);
		contentPane.add(lblWristToF);
		
		JLabel lblRequiredPhotos = new JLabel("4 required photos:");
		lblRequiredPhotos.setForeground(Color.RED);
		lblRequiredPhotos.setBounds(175, 594, 137, 15);
		contentPane.add(lblRequiredPhotos);
		
		idHere = new JLabel("");
		idHere.setBounds(192, 69, 246, 15);
		contentPane.add(idHere);
		
		nameHere = new JLabel("New label");
		nameHere.setBounds(192, 96, 246, 15);
		contentPane.add(nameHere);
		
		ageHere = new JLabel("New label");
		ageHere.setBounds(192, 124, 246, 15);
		contentPane.add(ageHere);
		
		genderHere = new JLabel("New label");
		genderHere.setBounds(192, 151, 246, 15);
		contentPane.add(genderHere);
		
		addressHere = new JLabel("New label");
		addressHere.setBounds(192, 182, 246, 15);
		contentPane.add(addressHere);
		
		fatherHere = new JLabel("New label");
		fatherHere.setBounds(192, 209, 246, 15);
		contentPane.add(fatherHere);
		
		motherHere = new JLabel("New label");
		motherHere.setBounds(192, 236, 246, 15);
		contentPane.add(motherHere);
		
		contactHere = new JLabel("New label");
		contactHere.setBounds(192, 290, 246, 15);
		contentPane.add(contactHere);
		
		remarksHere = new JLabel("New label");
		remarksHere.setBounds(192, 317, 441, 15);
		contentPane.add(remarksHere);
		
		recHere = new JLabel("New label");
		recHere.setBounds(192, 344, 246, 15);
		contentPane.add(recHere);
		
		delHere = new JLabel("New label");
		delHere.setBounds(192, 398, 246, 15);
		contentPane.add(delHere);
		
		guardianHere = new JLabel("New label");
		guardianHere.setBounds(192, 263, 246, 15);
		contentPane.add(guardianHere);
		
		dueHere = new JLabel("New label");
		dueHere.setBounds(192, 371, 246, 15);
		contentPane.add(dueHere);
		
		prostheticHere = new JLabel("New label");
		prostheticHere.setBounds(192, 452, 246, 15);
		contentPane.add(prostheticHere);
		
		retHere = new JLabel("New label");
		retHere.setBounds(192, 425, 246, 15);
		contentPane.add(retHere);
		
		affectedHere = new JLabel("New label");
		affectedHere.setBounds(338, 485, 246, 15);
		contentPane.add(affectedHere);
		
		bicepHere = new JLabel("New label");
		bicepHere.setBounds(338, 512, 246, 15);
		contentPane.add(bicepHere);
		
		etwHere = new JLabel("New label");
		etwHere.setBounds(338, 539, 246, 15);
		contentPane.add(etwHere);
		
		wtfHere = new JLabel("New label");
		wtfHere.setBounds(338, 567, 246, 15);
		contentPane.add(wtfHere);
		
		reqdHere = new JLabel("New label");
		reqdHere.setBounds(338, 594, 246, 15);
		contentPane.add(reqdHere);
		
		JLabel lblPersonalInformation = new JLabel("RECIPIENT INFORMATION");
		lblPersonalInformation.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblPersonalInformation.setForeground(Color.BLUE);
		lblPersonalInformation.setBounds(318, 26, 282, 31);
		contentPane.add(lblPersonalInformation);
		
		JButton button = new JButton("<<<BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new RecipientList().setVisible(true);
				
			}
		});
		button.setBounds(27, 635, 117, 25);
		contentPane.add(button);
		
		picHere = new JLabel("\"");
		picHere.setBounds(628, 124, 152, 161);
		contentPane.add(picHere);
		
		sigHere = new JLabel("k");
		sigHere.setBounds(628, 344, 162, 69);
		contentPane.add(sigHere);
	}
}
