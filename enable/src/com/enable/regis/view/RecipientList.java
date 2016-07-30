package com.enable.regis.view;

import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.enable.regis.dao.RecipientDetailDao;
import com.enable.regis.dto.RecipientDetailDto;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JLabel;
import java.awt.Font;

public class RecipientList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable recipientTable;
	RecipientDetailDao rdao = new RecipientDetailDao();
	private JTextField searchTextField;



	/**
	 * Create the frame.
	 */
	public RecipientList() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		recipientTable = new JTable();
		String [] columnNames = {"ID", "Name", "Age", "City", "Contact", "Model", "Recieved Date", "Due Date", "Delivered?", "Returned?"};
		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
		recipientTable.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(recipientTable);
		scrollPane.setBounds(7, 100, 805, 253);
		contentPane.add(scrollPane);
		loadDataInTable();
		
		searchTextField = new JTextField();
		searchTextField.setToolTipText("Search here...");
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String recName = searchTextField.getText();
				if (recName==null||recName.isEmpty()) {
					loadDataInTable();
					
				}
				else {
					searchDataInTable(recName);
				}
				
			}
		});
		searchTextField.setBounds(518, 45, 166, 19);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		

		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new RecipientForm().setVisible(true);
				
			}
		});
		btnNew.setBounds(31, 434, 117, 25);
		contentPane.add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel tableModel1 = (DefaultTableModel) recipientTable.getModel();
				int row = recipientTable.getSelectedRow();
				
				
				if(row>0) {
					Object idObj = tableModel1.getValueAt(row, 0);
					String modelType = tableModel1.getValueAt(row,5).toString();
					List<RecipientDetailDto> recipientList = rdao.editRecipientInfo(idObj.toString(), modelType);
					for (RecipientDetailDto rdto: recipientList) {				
						
						
						RecipientForm rform = new RecipientForm();
						rform.nameTextfield.setText(rdto.getName());
						rform.ageTextfield.setText(String.valueOf(rdto.getAge()));
						rform.cityTextfield.setText(rdto.getCity());
						rform.areaTextfield.setText(rdto.getArea());
						rform.fatherTextfield.setText(rdto.getFather());
						rform.motherTextfield.setText(rdto.getMother());
						rform.guardianTextfield.setText(rdto.getGuardian());
						
						rform.IdTextField.setText(rdto.getId());
						rform.IdTextField.setVisible(false);
						rform.lblRecipientId.setVisible(false);
						rform.lblRecipientId1.setText("ID cannot be updated! ID: "+ rdto.getId());
						rform.lblRecipientId1.setBounds(41, 403, 252, 15);
						rform.contentPane.add(rform.lblRecipientId1);
						
						rform.ContactTextField.setText(String.valueOf(rdto.getContact()));
						rform.RemarksTextField.setText(rdto.getRemarks());
						
						if(rdto.getDeliveryStatus().contains("yes")) {
							rform.chckbxDeliveryStatus.setSelected(true);
						}
						else {
							rform.chckbxDeliveryStatus.setSelected(false);

						}
						
						if(rdto.getReturnStatus().contains("yes")) {
							rform.chckbxReturnStatus.setSelected(true);
						}
						else {
							rform.chckbxReturnStatus.setSelected(false);

						}
						
						
						ImageIcon icon = new ImageIcon(rdto.getPicUrl());
						rform.file1 = new File(rdto.getPicUrl());
						Image img = icon.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH);
						icon= new ImageIcon(img);
						rform.picLabel.setIcon(icon);
						
						ImageIcon iconS = new ImageIcon(rdto.getSignatureUrl());
						rform.file2 = new File(rdto.getSignatureUrl());
						Image imgS = iconS.getImage().getScaledInstance(155, 44, Image.SCALE_SMOOTH);
						icon= new ImageIcon(imgS);
						rform.lblConsentSignature.setIcon(iconS);
						
						if(rdto.getGender().contains("Male")) { rform.maleRadio.setSelected(true); }
						else if(rdto.getGender().contains("Female")) { rform.femaleRadio.setSelected(true); }
						
						if(rdto.getModelType().contains("Arm+Palm")) { 
							rform.rdbtnArmpalm.setSelected(true);
							rform.armPanel.setVisible(true);
							rform.palmPanel.setVisible(false);
							
							if(rdto.getAffectedSideArm().contains("LEFT")) { rform.rdbtnLeft.setSelected(true); }
							else if(rdto.getAffectedSideArm().contains("RIGHT")) { rform.rdbtnRight.setSelected(true); }
							
							if(rdto.getUnaffectedSideArm().contains("LEFT")) { rform.radioButton.setSelected(true); }
							else if(rdto.getUnaffectedSideArm().contains("RIGHT")) { rform.radioButton_1.setSelected(true); }
							
							rform.bicepField.setText(String.valueOf(rdto.getBicepField()));
							rform.etwField.setText(String.valueOf(rdto.getEtwField()));
							rform.wtfField.setText(String.valueOf(rdto.getWtfField()));
							
							
						}
						else if(rdto.getModelType().contains("Palm only")) { 
							rform.rdbtnPalmOnly.setSelected(true);
							rform.armPanel.setVisible(false);
							rform.palmPanel.setVisible(true);
							if(rdto.getAffectedSidePalm().contains("LEFT")) { rform.rdbtnLeft_1.setSelected(true); }
							else if(rdto.getAffectedSidePalm().contains("RIGHT")) { rform.rdbtnRight_1.setSelected(true); }
					
							
							rform.subFile = new File(rdto.getSubUrl());
							rform.aaFile = new File(rdto.getAaUrl());
							rform.aa_1File = new File(rdto.getAa_1Url());
							rform.aa_2File = new File(rdto.getAa_2Url());
							rform.lblAllFilesUploaded.setVisible(true);
							
				
						
						
						}
						else if(rdto.getModelType().contains("Other")) { 
							rform.rdbtnOther.setSelected(true);
							rform.armPanel.setVisible(false);
							rform.palmPanel.setVisible(false);
							
							//lekhna baki chha hai....
							
						
						
						}
						rform.lblChooseAtLeast.setVisible(false);
						rform.recDate.setDate(rdto.getRecDate());
						rform.dueDate.setDate(rdto.getDueDate());
						rform.btnRegister.setText("UPDATE");
						
						
						
						
						
						dispose();
						rform.setVisible(true);
						
						
							
					}
				}
				else {
					JOptionPane.showMessageDialog(RecipientList.this, "Select at least one row!", "Error!", JOptionPane.ERROR_MESSAGE);

					
				}
				
				
				
			}
		});
		btnEdit.setBounds(178, 434, 117, 25);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tableModel1 = (DefaultTableModel) recipientTable.getModel();
				int row = recipientTable.getSelectedRow();
				
				if(row>0) {
					Object idObj = tableModel1.getValueAt(row, 0);
					String modelType = tableModel1.getValueAt(row,5).toString();
					
					int status = JOptionPane.showConfirmDialog(RecipientList.this, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
					if(status==0) {
						rdao.deleteRecipientInfo(idObj.toString(), modelType);
						loadDataInTable();

					}
				}
				else {
					JOptionPane.showMessageDialog(RecipientList.this, "Select at least one row!", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}
		});
		btnDelete.setBounds(329, 434, 117, 25);
		contentPane.add(btnDelete);
		
		JLabel lblSearchHere = new JLabel("Search here...");
		lblSearchHere.setBounds(703, 47, 109, 15);
		contentPane.add(lblSearchHere);
		
		JButton btnViewFullDetail = new JButton("View Full Detail");
		btnViewFullDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel1 = (DefaultTableModel) recipientTable.getModel();
				int row = recipientTable.getSelectedRow();
				if(row>0) {
					Object idObj = tableModel1.getValueAt(row, 0);
					String modelType = tableModel1.getValueAt(row,5).toString();
					
					
					
					List<RecipientDetailDto> recipientList = rdao.editRecipientInfo(idObj.toString(), modelType);
					for (RecipientDetailDto rdto: recipientList) {
						AllDetail ad = new AllDetail();
						
						
						ad.idHere.setText(rdto.getId());
						ad.nameHere.setText(rdto.getName());
						ad.ageHere.setText(String.valueOf(rdto.getAge()));
						ad.genderHere.setText(rdto.getGender());
						ad.addressHere.setText(rdto.getArea()+", "+rdto.getCity());
						ad.fatherHere.setText(rdto.getFather());
						ad.motherHere.setText(rdto.getMother());
						ad.contactHere.setText(String.valueOf(rdto.getContact()));
						ad.remarksHere.setText(rdto.getRemarks());
						ad.recHere.setText(rdto.getRecDate().toString());
						ad.dueHere.setText(rdto.getDueDate().toString());
						ad.delHere.setText(rdto.getDeliveryStatus());
						ad.prostheticHere.setText(rdto.getModelType());
						ad.retHere.setText(rdto.getReturnStatus());
						
						ImageIcon icon = new ImageIcon(rdto.getPicUrl());
						Image img = icon.getImage().getScaledInstance(152, 161, Image.SCALE_SMOOTH);
						icon= new ImageIcon(img);
						ad.picHere.setIcon(icon);
						
						ImageIcon iconS = new ImageIcon(rdto.getSignatureUrl());
						Image imgS = iconS.getImage().getScaledInstance(162, 69, Image.SCALE_SMOOTH);
						icon= new ImageIcon(imgS);
						ad.sigHere.setIcon(iconS);
						
						

						
						if(rdto.getModelType().contains("Arm+Palm")) { 
							
							ad.affectedHere.setText(rdto.getAffectedSideArm());
							
							ad.bicepHere.setText(String.valueOf(rdto.getBicepField()));
							ad.etwHere.setText(String.valueOf(rdto.getEtwField()));
							ad.wtfHere.setText(String.valueOf(rdto.getWtfField()));
							
							
						}
						else if(rdto.getModelType().contains("Palm only")) { 
							ad.affectedHere.setText(rdto.getAffectedSidePalm());
					
							boolean a = rdto.getSubUrl().contains(rdto.getId());
							boolean b = rdto.getAaUrl().contains(rdto.getId());
							boolean c = rdto.getAa_1Url().contains(rdto.getId());
							boolean d = rdto.getAa_2Url().contains(rdto.getId());
							
							
							if(a==true&&b==true&&c==true&&d==true) {
								ad.reqdHere.setText("All files uploaded");
							}
							else {
								ad.reqdHere.setText("Some files missing");
							}
								
							
							ad.bicepHere.setText("-");
							ad.etwHere.setText("-");
							ad.wtfHere.setText("-");
				
						
						
						}
						else if(rdto.getModelType().contains("Other")) { 
							ad.bicepHere.setText("-");
							ad.etwHere.setText("-");
							ad.wtfHere.setText("-");
							ad.reqdHere.setText("-");
					
							//lekhna baki chha hai....
							
						
						
						}
						
						dispose();
						ad.setVisible(true);
					
						
					}

				}
				else {
					JOptionPane.showMessageDialog(RecipientList.this, "Select at least one row!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnViewFullDetail.setBounds(475, 434, 157, 25);
		contentPane.add(btnViewFullDetail);
		
		JButton btnAddMorePhotos = new JButton("Add More Photos");
		btnAddMorePhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel1 = (DefaultTableModel) recipientTable.getModel();
				int row = recipientTable.getSelectedRow();
				if(row>0) {
					Object idObj = tableModel1.getValueAt(row, 0);
					ExtraPhotos ep = new ExtraPhotos();
					if(rdao.checkExtra(idObj.toString())==true) {
						List<RecipientDetailDto> recipientList = rdao.extraPhotoInfo(idObj.toString());
						for (RecipientDetailDto rdto: recipientList) {
							
							ep.idHere.setText(idObj.toString());
							ep.nameHere.setText(tableModel1.getValueAt(row, 1).toString());
							ep.img1Url.setText(rdto.getImg1Url());
							ep.img2Url.setText(rdto.getImg2Url());
							ep.img3Url.setText(rdto.getImg3Url());
							ep.img4Url.setText(rdto.getImg4Url());
							ep.img5Url.setText(rdto.getImg5Url());
							dispose();
							ep.setVisible(true);
						}
					}
					else {
						ep.idHere.setText(idObj.toString());
						ep.nameHere.setText(tableModel1.getValueAt(row, 1).toString());
						ep.img1Url.setText("");
						ep.img2Url.setText("");
						ep.img3Url.setText("");
						ep.img4Url.setText("");
						ep.img5Url.setText("");
						dispose();
						ep.setVisible(true);
					}
						
//						dispose();
//						ep.setVisible(true);
						
					}
					
					
				else {
					JOptionPane.showMessageDialog(RecipientList.this, "Select at least one row!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
		}});
		btnAddMorePhotos.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAddMorePhotos.setBounds(644, 434, 151, 25);
		contentPane.add(btnAddMorePhotos);
		
		
		}	
	
	
	public void loadDataInTable() {
		DefaultTableModel tablemodel = (DefaultTableModel) recipientTable.getModel();
		tablemodel.setRowCount(0);
		List<RecipientDetailDto> recipientList = rdao.getAllRecipientList();
		for (RecipientDetailDto rdto: recipientList) {			
			tablemodel.addRow(new Object[] {rdto.getId(), rdto.getName(), rdto.getAge(), rdto.getCity(), rdto.getContact(), rdto.getModelType(), rdto.getRecDate(), rdto.getDueDate(), rdto.getDeliveryStatus(), rdto.getReturnStatus()});
				
		}	
		
	}
	
	public void searchDataInTable(String recName) {
		DefaultTableModel tablemodel = (DefaultTableModel) recipientTable.getModel();
		tablemodel.setRowCount(0);
		List<RecipientDetailDto> recipientList = rdao.searchRecipientList(recName);
		for (RecipientDetailDto rdto: recipientList) {			
			tablemodel.addRow(new Object[] {rdto.getId(), rdto.getName(), rdto.getAge(), rdto.getCity(), rdto.getContact(), rdto.getModelType(), rdto.getRecDate(), rdto.getDueDate(), rdto.getDeliveryStatus(), rdto.getReturnStatus()});
				
		}	
		
	}
}
