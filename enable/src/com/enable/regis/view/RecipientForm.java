package com.enable.regis.view;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.enable.regis.dao.CreateFile;
import com.enable.regis.dao.RecipientDetailDao;
import com.enable.regis.dto.RecipientDetailDto;
import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;


public class RecipientForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField nameTextfield;
	public JTextField ageTextfield;
	public JTextField cityTextfield;
	public JTextField areaTextfield;
	public JTextField fatherTextfield;
	public JTextField motherTextfield;
	public JTextField guardianTextfield;
	public JTextField IdTextField;
	public JTextField ContactTextField;
	public JTextField RemarksTextField;
	private ButtonGroup genderbutton;
	public JLabel picLabel;
	public JLabel lblConsentSignature;
	public JRadioButton maleRadio;
	public JRadioButton femaleRadio;
	private String imageUploadPath;
	public File file1;
	public File file2;
	public File subFile;
	public File aaFile;
	public File aa_1File;
	public File aa_2File;
	private JLabel lblNewLabel;
	public JTextField bicepField;
	public JTextField etwField;
	public JTextField wtfField;
	private String sub;
	private String aa;
	private String aa_1;
	private String aa_2;
	public JDateChooser dueDate;
	public JDateChooser recDate;
	private ButtonGroup typeButton;
	private ButtonGroup side1Button;
	private ButtonGroup side2Button;
	private ButtonGroup side3Button;
	//private JRadioButton rdbtnArmpalm;
	//private JRadioButton rdbtnPalmOnly;
	//private JRadioButton rdbtnOther;
	public JLabel lblChooseAtLeast;
	public JRadioButton rdbtnArmpalm;
	public JRadioButton rdbtnPalmOnly;
	public JRadioButton rdbtnOther;
	public JRadioButton rdbtnLeft;
	public JRadioButton rdbtnRight;
	public JRadioButton radioButton;
	public JRadioButton radioButton_1;
	public JRadioButton rdbtnLeft_1;
	public JRadioButton rdbtnRight_1;
	
	public JPanel armPanel;
	public JPanel palmPanel;
	public JButton btnRegister;
	public JLabel lblRecipientId;
	public JLabel lblRecipientId1;
	
	public JCheckBox chckbxDeliveryStatus;
	public JCheckBox chckbxReturnStatus;
	
	public JLabel lblAllFilesUploaded;
	

	/**
	 * Create the frame.
	 */
	public RecipientForm() {
        //System.out.println(RecipientForm.class.getClassLoader().getResource("").getPath());
		setTitle("E-Nable Registration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 1014);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblFullName = new JLabel("Full Name*");
		lblFullName.setBounds(41, 59, 98, 15);
		contentPane.add(lblFullName);
		
		JLabel lblAge = new JLabel("Age*");
		lblAge.setBounds(41, 107, 98, 15);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender*");
		lblGender.setBounds(41, 152, 98, 15);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(41, 203, 98, 15);
		contentPane.add(lblAddress);
		
		JLabel lblTowncity = new JLabel("Town/City*");
		lblTowncity.setBounds(142, 203, 98, 15);
		contentPane.add(lblTowncity);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(142, 245, 98, 15);
		contentPane.add(lblArea);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(41, 278, 132, 15);
		contentPane.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setBounds(41, 320, 132, 15);
		contentPane.add(lblMothersName);
		
		JLabel lblGuardiansName = new JLabel("Guardian's Name");
		lblGuardiansName.setBounds(41, 360, 132, 15);
		contentPane.add(lblGuardiansName);
		
		JLabel consentlbl = new JLabel("मेरो छोरा/छोरीको ई-नेबल नेपाललाई उपलब्ध गराएको फोटो कार्यालय तथा प्राविधिक प्रयोजनको निम्ति प्रयोग गर्न मेरो पुर्ण सहमति छ");
		consentlbl.setBounds(41, 473, 602, 44);
		contentPane.add(consentlbl);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(142, 59, 206, 19);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		ageTextfield = new JTextField();
		ageTextfield.setColumns(10);
		ageTextfield.setBounds(142, 105, 70, 19);
		contentPane.add(ageTextfield);
		
		maleRadio = new JRadioButton("Male");
		maleRadio.setBounds(142, 148, 82, 23);
		contentPane.add(maleRadio);
		
		femaleRadio = new JRadioButton("Female");
		femaleRadio.setBounds(228, 148, 82, 23);
		contentPane.add(femaleRadio);
		
		genderbutton = new ButtonGroup();
		genderbutton.add(maleRadio);
		genderbutton.add(femaleRadio);
		
		cityTextfield = new JTextField();
		cityTextfield.setColumns(10);
		cityTextfield.setBounds(247, 201, 206, 19);
		contentPane.add(cityTextfield);
		
		areaTextfield = new JTextField();
		areaTextfield.setColumns(10);
		areaTextfield.setBounds(247, 243, 206, 19);
		contentPane.add(areaTextfield);
		
		fatherTextfield = new JTextField();
		fatherTextfield.setColumns(10);
		fatherTextfield.setBounds(177, 276, 206, 19);
		contentPane.add(fatherTextfield);
		
		motherTextfield = new JTextField();
		motherTextfield.setColumns(10);
		motherTextfield.setBounds(177, 318, 206, 19);
		contentPane.add(motherTextfield);
		
		guardianTextfield = new JTextField();
		guardianTextfield.setColumns(10);
		guardianTextfield.setBounds(177, 358, 206, 19);
		contentPane.add(guardianTextfield);
		
		JLabel lblPersonalDetails = new JLabel("PERSONAL DETAILS");
		lblPersonalDetails.setBounds(313, 32, 148, 15);
		contentPane.add(lblPersonalDetails);
		
		lblRecipientId = new JLabel("ID (date,initials)*");
		lblRecipientId.setBounds(41, 403, 132, 15);
		contentPane.add(lblRecipientId);
		
		IdTextField = new JTextField();
		IdTextField.setColumns(10);
		IdTextField.setBounds(177, 401, 206, 19);
		contentPane.add(IdTextField);
		
		JLabel lblContact = new JLabel("Contact*");
		lblContact.setBounds(41, 444, 132, 15);
		contentPane.add(lblContact);
		
		ContactTextField = new JTextField();
		ContactTextField.setColumns(10);
		ContactTextField.setBounds(177, 442, 206, 19);
		contentPane.add(ContactTextField);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setBounds(437, 426, 132, 15);
		contentPane.add(lblRemarks);
		
		RemarksTextField = new JTextField();
		RemarksTextField.setColumns(10);
		RemarksTextField.setBounds(437, 442, 266, 19);
		contentPane.add(RemarksTextField);
		
		picLabel = new JLabel("  Upload Photo*");
		picLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(picLabel)==JFileChooser.APPROVE_OPTION) {
					file1 = imageChooser.getSelectedFile();
					ImageIcon icon= new ImageIcon(imageChooser.getSelectedFile().getPath());
					Image img=icon.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH);
					icon= new ImageIcon(img);
					picLabel.setIcon(icon);
					
				}
			}
		});
		picLabel.setBackground(Color.BLUE);
		picLabel.setBounds(558, 59, 130, 150);
		contentPane.add(picLabel);
		
		lblConsentSignature = new JLabel("Consent Signature*");
		lblConsentSignature.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(lblConsentSignature)==JFileChooser.APPROVE_OPTION) {
					file2 = imageChooser.getSelectedFile();
					ImageIcon icon= new ImageIcon(imageChooser.getSelectedFile().getPath());
					Image img=icon.getImage().getScaledInstance(155, 44, Image.SCALE_SMOOTH);
					icon= new ImageIcon(img);
					lblConsentSignature.setIcon(icon);
					
				}	
			}
		});
		lblConsentSignature.setBounds(548, 529, 155, 31);
		contentPane.add(lblConsentSignature);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(538, 278, 70, 15);
		contentPane.add(lblNewLabel);
		
		armPanel = new JPanel();
		armPanel.setVisible(false);
		armPanel.setBounds(37, 661, 689, 157);
		contentPane.add(armPanel);
		armPanel.setLayout(null);
		
		palmPanel = new JPanel();
		palmPanel.setVisible(false);
		palmPanel.setBounds(37, 830, 689, 75);
		contentPane.add(palmPanel);
		palmPanel.setLayout(null);
		
		chckbxDeliveryStatus = new JCheckBox("Delivery Status");
		chckbxDeliveryStatus.setBounds(437, 356, 142, 23);
		contentPane.add(chckbxDeliveryStatus);
		
		chckbxReturnStatus = new JCheckBox("Return Status");
		chckbxReturnStatus.setBounds(437, 383, 142, 23);
		contentPane.add(chckbxReturnStatus);
		
		
		JLabel lblProstheticRequired = new JLabel("Prosthetic Required*");
		lblProstheticRequired.setBounds(41, 551, 154, 29);
		contentPane.add(lblProstheticRequired);
		
		rdbtnArmpalm = new JRadioButton("Arm+Palm");
		rdbtnArmpalm.setBounds(209, 554, 117, 23);
		contentPane.add(rdbtnArmpalm);
		
		rdbtnPalmOnly = new JRadioButton("Palm only");
		rdbtnPalmOnly.setBounds(330, 554, 109, 23);
		contentPane.add(rdbtnPalmOnly);
		
		rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(443, 554, 66, 23);
		contentPane.add(rdbtnOther);
		
		typeButton = new ButtonGroup();
		typeButton.add(rdbtnArmpalm);
		typeButton.add(rdbtnPalmOnly);
		typeButton.add(rdbtnOther);
		
		lblChooseAtLeast = new JLabel("Choose at least one!");
		lblChooseAtLeast.setBounds(108, 605, 167, 15);
		contentPane.add(lblChooseAtLeast);
		lblChooseAtLeast.setVisible(false);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnArmpalm.isSelected()) {
					armPanel.setVisible(true);
					palmPanel.setVisible(false);
					lblChooseAtLeast.setVisible(false);
				}
				else if (rdbtnPalmOnly.isSelected()) {
					palmPanel.setVisible(true);
					armPanel.setVisible(false);
					lblChooseAtLeast.setVisible(false);
				}
				else if(rdbtnOther.isSelected()) {
					armPanel.setVisible(false);
					palmPanel.setVisible(false);
					lblChooseAtLeast.setVisible(false);
					//lekhna baki chha!!!
					
				}
				else {
					armPanel.setVisible(false);
					palmPanel.setVisible(false);
					lblChooseAtLeast.setVisible(true);
					//lekhna baki chha yaha pani!!
				}
				
			}
		});
		btnConfirm.setBounds(297, 600, 117, 25);
		contentPane.add(btnConfirm);
		
		
		
		
		JLabel lblAffectedSide = new JLabel("AFFECTED SIDE*");
		lblAffectedSide.setBounds(12, 12, 114, 26);
		armPanel.add(lblAffectedSide);
		
		rdbtnLeft = new JRadioButton("LEFT");
		rdbtnLeft.setBounds(134, 12, 72, 23);
		armPanel.add(rdbtnLeft);
		
		rdbtnRight = new JRadioButton("RIGHT");
		rdbtnRight.setBounds(210, 12, 75, 23);
		armPanel.add(rdbtnRight);
		
		side1Button = new ButtonGroup();
		side1Button.add(rdbtnLeft);
		side1Button.add(rdbtnRight);
		
		JLabel lblBicepCircumference = new JLabel("Bicep Circumference(mm)*");
		lblBicepCircumference.setBounds(330, 12, 177, 20);
		armPanel.add(lblBicepCircumference);
		
		bicepField = new JTextField();
		bicepField.setBounds(551, 12, 114, 19);
		armPanel.add(bicepField);
		bicepField.setColumns(10);
		
		JLabel lblUnaffectedSide = new JLabel("UNAFFECTED SIDE*");
		lblUnaffectedSide.setBounds(12, 53, 133, 15);
		armPanel.add(lblUnaffectedSide);
		
		radioButton = new JRadioButton("LEFT");
		radioButton.setBounds(146, 49, 72, 23);
		armPanel.add(radioButton);
		
		radioButton_1 = new JRadioButton("RIGHT");
		radioButton_1.setBounds(220, 49, 75, 23);
		armPanel.add(radioButton_1);
		
		side2Button = new ButtonGroup();
		side2Button.add(radioButton);
		side2Button.add(radioButton_1);
		
		JLabel lblElbowToWrist = new JLabel("Elbow to Wrist Length(mm)*");
		lblElbowToWrist.setBounds(330, 53, 191, 15);
		armPanel.add(lblElbowToWrist);
		
		etwField = new JTextField();
		etwField.setColumns(10);
		etwField.setBounds(551, 51, 114, 19);
		armPanel.add(etwField);
		
		JLabel lblWristToFtip = new JLabel("Wrist to F.Tip Length(mm)*");
		lblWristToFtip.setBounds(330, 86, 207, 15);
		armPanel.add(lblWristToFtip);
		
		wtfField = new JTextField();
		wtfField.setColumns(10);
		wtfField.setBounds(551, 84, 114, 19);
		armPanel.add(wtfField);
		
		JLabel lblUploaded = new JLabel("Uploaded!");
		lblUploaded.setBounds(58, 33, 79, 15);
		palmPanel.add(lblUploaded);
		lblUploaded.setVisible(false);
		
		JLabel label = new JLabel("Uploaded!");
		label.setBounds(245, 37, 79, 15);
		palmPanel.add(label);
		label.setVisible(false);
		
		JLabel label_1 = new JLabel("Uploaded!");
		label_1.setBounds(398, 37, 79, 15);
		palmPanel.add(label_1);
		label_1.setVisible(false);
		
		JLabel label_2 = new JLabel("Uploaded!");
		label_2.setBounds(574, 37, 79, 15);
		palmPanel.add(label_2);
		label_2.setVisible(false);
		
		
		
		JButton btnStraightUpBoth = new JButton("Straight up both arms*");
		btnStraightUpBoth.setFont(new Font("Dialog", Font.BOLD, 10));
		btnStraightUpBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(btnStraightUpBoth)==JFileChooser.APPROVE_OPTION) {
					subFile = imageChooser.getSelectedFile();
					ImageIcon StraightUpBoth= new ImageIcon(imageChooser.getSelectedFile().getPath());
					sub = StraightUpBoth.toString();
					lblUploaded.setVisible(true);
					
					
				}
				
			}
		});
		btnStraightUpBoth.setBounds(0, 0, 190, 25);
		palmPanel.add(btnStraightUpBoth);
		
		JButton btnAffectedArm = new JButton("Affected Arm 1*");
		btnAffectedArm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(btnAffectedArm)==JFileChooser.APPROVE_OPTION) {
					aaFile = imageChooser.getSelectedFile();
					ImageIcon AffectedArm = new ImageIcon(imageChooser.getSelectedFile().getPath());
					aa = AffectedArm.toString();
					label.setVisible(true);
					
				}
			}
		});
		btnAffectedArm.setBounds(202, 0, 146, 25);
		palmPanel.add(btnAffectedArm);
		
		JButton btnAffectedArm_1 = new JButton("Affected Arm 2*");
		btnAffectedArm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(btnAffectedArm_1)==JFileChooser.APPROVE_OPTION) {
					aa_1File = imageChooser.getSelectedFile();
					ImageIcon AffectedArm_1 = new ImageIcon(imageChooser.getSelectedFile().getPath());
					aa_1 = AffectedArm_1.toString();
					label_1.setVisible(true);
					
				}
			}
		});
		btnAffectedArm_1.setBounds(360, 0, 146, 25);
		palmPanel.add(btnAffectedArm_1);
		
		JButton btnAffectedArm_2 = new JButton("Affected Arm 3*");
		btnAffectedArm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(btnAffectedArm_2)==JFileChooser.APPROVE_OPTION) {
					aa_2File = imageChooser.getSelectedFile();
					ImageIcon AffectedArm_2 = new ImageIcon(imageChooser.getSelectedFile().getPath());
					aa_2 = AffectedArm_2.toString();
					label_2.setVisible(true);
					
				}
			}
		});
		btnAffectedArm_2.setBounds(531, 0, 146, 25);
		palmPanel.add(btnAffectedArm_2);
		
		JLabel lblAffectedSide_1 = new JLabel("AFFECTED SIDE*");
		lblAffectedSide_1.setBounds(0, 60, 137, 15);
		palmPanel.add(lblAffectedSide_1);
		
		rdbtnLeft_1 = new JRadioButton("LEFT");
		rdbtnLeft_1.setBounds(151, 56, 149, 23);
		palmPanel.add(rdbtnLeft_1);
		
		
		rdbtnRight_1 = new JRadioButton("RIGHT");
		rdbtnRight_1.setBounds(317, 56, 88, 23);
		palmPanel.add(rdbtnRight_1);
		
		side3Button = new ButtonGroup();
		side3Button.add(rdbtnLeft_1);
		side3Button.add(rdbtnRight_1);
		
		lblAllFilesUploaded = new JLabel("All files uploaded. Click to change files.");
		lblAllFilesUploaded.setForeground(Color.RED);
		lblAllFilesUploaded.setFont(new Font("Dialog", Font.BOLD, 10));
		lblAllFilesUploaded.setBounds(447, 60, 242, 15);
		lblAllFilesUploaded.setVisible(false);
		palmPanel.add(lblAllFilesUploaded);
		
		
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextfield.setText("");
				ageTextfield.setText("");
				cityTextfield.setText("");
				areaTextfield.setText("");
				fatherTextfield.setText("");
				motherTextfield.setText("");
				guardianTextfield.setText("");
				IdTextField.setText("");
				ContactTextField.setText("");
				RemarksTextField.setText("");
				genderbutton.clearSelection();
				picLabel.setIcon(null);
				lblConsentSignature.setIcon(null);
				bicepField.setText("");
				etwField.setText("");
				wtfField.setText("");
				sub = "";
				aa = "";
				aa_1 = "";
				aa_2 = "";
				dueDate.setDate(null);
				recDate.setDate(null);
				typeButton.clearSelection();
				side2Button.clearSelection();
				side1Button.clearSelection();
				side3Button.clearSelection();
				lblChooseAtLeast.setVisible(false);
				armPanel.setVisible(false);
				palmPanel.setVisible(false);
				
				chckbxDeliveryStatus.setSelected(false);
				chckbxReturnStatus.setSelected(false);
				
				


				
			}
		});
		btnReset.setBounds(190, 977, 117, 25);
		contentPane.add(btnReset);
		
		lblRecipientId1 = new JLabel("");
		lblRecipientId1.setBounds(41, 403, 252, 15);
		contentPane.add(lblRecipientId1);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nameTextfield.getText().isEmpty()||ageTextfield.getText().isEmpty()||cityTextfield.getText().isEmpty()||IdTextField.getText().isEmpty()||
						ContactTextField.getText().isEmpty()||recDate.getDate().toString().isEmpty()||dueDate.getDate().toString().isEmpty()||
						file1.getName().isEmpty()||file2.getName().isEmpty()) {
					JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else if(genderbutton.getSelection()==null) {
					JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else if(typeButton.getSelection()==null) {
					JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					RecipientDetailDto rdto = new RecipientDetailDto();
					RecipientDetailDao rdao = new RecipientDetailDao();
					
					rdto.setName(nameTextfield.getText());
					rdto.setAge(Integer.parseInt(ageTextfield.getText()));
					rdto.setCity(cityTextfield.getText());
					rdto.setArea(areaTextfield.getText());
					rdto.setFather(fatherTextfield.getText());
					rdto.setMother(motherTextfield.getText());
					rdto.setGuardian(guardianTextfield.getText());
					rdto.setId(IdTextField.getText());
					rdto.setRemarks(RemarksTextField.getText());
					rdto.setContact(Long.parseLong(ContactTextField.getText()));
					rdto.setRecDate(recDate.getDate());
					rdto.setDueDate(dueDate.getDate());
					
					if(chckbxDeliveryStatus.isSelected()) {
						rdto.setDeliveryStatus("yes");
					}
					else {
						rdto.setDeliveryStatus("no");
					}
					
					if(chckbxReturnStatus.isSelected()) {
						rdto.setReturnStatus("yes");
					}
					else {
						rdto.setReturnStatus("no");
					}
					
					
					//check id availability
					int u=0;
					if(lblRecipientId1.getText()==null || lblRecipientId1.getText().isEmpty()) { u=1; }
					boolean newid = rdao.checkId(rdto,u);
					if (newid ==true) {
						//create folder
						imageUploadPath = new CreateFile().checkAndCreate(rdto,u);
						if(imageUploadPath.contains("error")) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Cannot create directory!","Error!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(RecipientForm.this, "ID already exists, change ID", "Error!", JOptionPane.ERROR_MESSAGE);
					}
					
					
					//picture
					String filePath = imageUploadPath + file1.getName();
					try {
						BufferedImage bi = ImageIO.read(file1);
						ImageIO.write(bi, "jpg", new File(filePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setPicUrl(filePath);
					
					//consent signature
					String filePath1 = imageUploadPath + file2.getName();
					try {
						BufferedImage bi = ImageIO.read(file2);
						ImageIO.write(bi, "jpg", new File(filePath1));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setSignatureUrl(filePath1);
					
					String gender = "";
					if (maleRadio.isSelected()) {
						rdto.setGender(gender+maleRadio.getText());
					} else {
						rdto.setGender(gender+femaleRadio.getText());
					}
					
					String modelType = "";
					if (rdbtnArmpalm.isSelected()) {
						rdto.setModelType(modelType+rdbtnArmpalm.getText());
						String side="";
						if(side1Button.getSelection()==null) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							if (rdbtnLeft.isSelected()) {
								rdto.setAffectedSideArm(side+rdbtnLeft.getText());
							} else if (rdbtnRight.isSelected()) {
								rdto.setAffectedSideArm(side+rdbtnRight.getText());
							}
						}
						if(side2Button.getSelection()==null) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							if (radioButton.isSelected()) {
								rdto.setUnaffectedSideArm(side+radioButton.getText());
							} else if (radioButton_1.isSelected()) {
								rdto.setUnaffectedSideArm(side+radioButton_1.getText());
							}
							
						}
						if(bicepField.getText().isEmpty()||etwField.getText().isEmpty()||wtfField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							rdto.setBicepField(Integer.parseInt(bicepField.getText()));
							rdto.setEtwField(Integer.parseInt(etwField.getText()));
							rdto.setWtfField(Integer.parseInt(wtfField.getText()));
						}
							
					} 
					else if (rdbtnPalmOnly.isSelected()) {
						rdto.setModelType(modelType+rdbtnPalmOnly.getText());
						String side="";
						if(side3Button.getSelection()==null) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							if (rdbtnLeft_1.isSelected()) {
								rdto.setAffectedSidePalm(side+radioButton.getText());
							} else if (rdbtnRight_1.isSelected()) {
								rdto.setAffectedSidePalm(side+radioButton_1.getText());
							}
						}
						
						if(subFile.getName().isEmpty()||aaFile.getName().isEmpty()||aa_1File.getName().isEmpty()||aa_2File.getName().isEmpty()) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Fill all required fileds!!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						
						else {
							//sub photo
							String filePath3 = imageUploadPath + subFile.getName();
							try {
								BufferedImage bi = ImageIO.read(subFile);
								ImageIO.write(bi, "jpg", new File(filePath3));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							rdto.setSubUrl(filePath3);
							
							//aa photo
							String filePath4 = imageUploadPath + aaFile.getName();
							try {
								BufferedImage bi = ImageIO.read(aaFile);
								ImageIO.write(bi, "jpg", new File(filePath4));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							rdto.setAaUrl(filePath4);
							
							//aa_1 photo
							String filePath5 = imageUploadPath + aa_1File.getName();
							try {
								BufferedImage bi = ImageIO.read(aa_1File);
								ImageIO.write(bi, "jpg", new File(filePath5));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							rdto.setAa_1Url(filePath5);
							
							//aa_2 photo
							String filePath6 = imageUploadPath + aa_2File.getName();
							try {
								BufferedImage bi = ImageIO.read(aa_2File);
								ImageIO.write(bi, "jpg", new File(filePath6));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							rdto.setAa_2Url(filePath6);
							
						}
						
						
					}
					else {
						rdto.setModelType(modelType+rdbtnOther.getText());
						//yaha ni baki chha hare shiva.......
						
					}
					
					if(lblRecipientId1.getText()==null || lblRecipientId1.getText().isEmpty()) {
						
						int success = rdao.saveRecipientInfo(rdto);
						if (success ==2) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Save Successful", "Saved!", JOptionPane.OK_OPTION);
						} else {
							JOptionPane.showMessageDialog(RecipientForm.this, "Check for missing and/or empty fields", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						
						int success = rdao.updateRecipientInfo(rdto);
						if (success ==2) {
							JOptionPane.showMessageDialog(RecipientForm.this, "Update Successful", "Updated!", JOptionPane.OK_OPTION);
						} else {
							JOptionPane.showMessageDialog(RecipientForm.this, "Check for missing and/or empty fields", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
					

					// clear
					nameTextfield.setText("");
					ageTextfield.setText("");
					cityTextfield.setText("");
					areaTextfield.setText("");
					fatherTextfield.setText("");
					motherTextfield.setText("");
					guardianTextfield.setText("");
					IdTextField.setText("");
					ContactTextField.setText("");
					RemarksTextField.setText("");
					genderbutton.clearSelection();
					picLabel.setIcon(null);
					lblConsentSignature.setIcon(null);
					bicepField.setText("");
					etwField.setText("");
					wtfField.setText("");
					sub = "";
					aa = "";
					aa_1 = "";
					aa_2 = "";
					dueDate.setDate(null);
					recDate.setDate(null);
					typeButton.clearSelection();
					side2Button.clearSelection();
					side1Button.clearSelection();
					side3Button.clearSelection();
					lblChooseAtLeast.setVisible(false);
					armPanel.setVisible(false);
					palmPanel.setVisible(false);
					chckbxDeliveryStatus.setSelected(false);
					chckbxReturnStatus.setSelected(false);
					
					dispose();
					new RecipientList().setVisible(true);

					
				}
				
								
				
			}
		});
		btnRegister.setBounds(426, 977, 131, 25);
		contentPane.add(btnRegister);
		
		JLabel lblDateRecieved = new JLabel("Date Recieved*");
		lblDateRecieved.setBounds(12, 940, 109, 15);
		contentPane.add(lblDateRecieved);
		
		recDate = new JDateChooser();
		recDate.setBounds(139, 940, 149, 19);
		contentPane.add(recDate);
		
		JLabel lblDueDate = new JLabel("Due Date*");
		lblDueDate.setBounds(470, 933, 83, 29);
		contentPane.add(lblDueDate);
		
		dueDate = new JDateChooser();
		dueDate.setBounds(569, 940, 157, 19);
		contentPane.add(dueDate);
		
		JButton buttonBack = new JButton("<<<BACK");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RecipientList().setVisible(true);
			}
		});
		buttonBack.setBounds(624, 27, 117, 25);
		contentPane.add(buttonBack);
		
		JLabel lblMeansMustfill = new JLabel("* means must-fill field");
		lblMeansMustfill.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblMeansMustfill.setForeground(Color.RED);
		lblMeansMustfill.setBounds(28, 27, 167, 15);
		contentPane.add(lblMeansMustfill);
		
		
		
	

		
		
	}
}
