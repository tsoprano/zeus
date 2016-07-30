package com.enable.regis.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.enable.regis.dao.CreateFile;
import com.enable.regis.dao.RecipientDetailDao;
import com.enable.regis.dto.RecipientDetailDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ExtraPhotos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JLabel img1Url;
	public JLabel img2Url;
	public JLabel img3Url;
	public JLabel img4Url;
	public JLabel img5Url;
	public File img1=new File("");;
	public File img2=new File("");;
	public File img3=new File("");;
	public File img4=new File("");;
	public File img5=new File("");;
	
	public JLabel idHere;
	public JLabel nameHere;

	/**
	 * Create the frame.
	 */
	public ExtraPhotos() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(38, 70, 70, 15);
		contentPane.add(lblId);
		
		idHere = new JLabel("New label");
		idHere.setBounds(149, 70, 196, 15);
		contentPane.add(idHere);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(38, 97, 70, 15);
		contentPane.add(lblName);
		
		nameHere = new JLabel("New label");
		nameHere.setBounds(149, 97, 196, 15);
		contentPane.add(nameHere);
		
		JLabel lblAddExtraPictures = new JLabel("ADD EXTRA PICTURES");
		lblAddExtraPictures.setForeground(Color.RED);
		lblAddExtraPictures.setBounds(273, 29, 171, 15);
		contentPane.add(lblAddExtraPictures);
		
		JButton btnUpload = new JButton("UPLOAD");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imgStr = null;
				
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(btnUpload)==JFileChooser.APPROVE_OPTION) {
					img1 = imageChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(imageChooser.getSelectedFile().getPath());
					imgStr = ii.toString();
					img1Url.setText(imgStr);
					
				}
				
			}
		});
		btnUpload.setBounds(38, 182, 117, 25);
		contentPane.add(btnUpload);
		
		JButton button = new JButton("UPLOAD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imgStr=null;
				
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(button)==JFileChooser.APPROVE_OPTION) {
					img2 = imageChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(imageChooser.getSelectedFile().getPath());
					imgStr = ii.toString();	
					img2Url.setText(imgStr);
				}
				
				
			}
		});
		
		button.setBounds(38, 216, 117, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPLOAD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imgStr = null;
				
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(button_1)==JFileChooser.APPROVE_OPTION) {
					img3 = imageChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(imageChooser.getSelectedFile().getPath());
					imgStr = ii.toString();
					img3Url.setText(imgStr);
					
				}
				
			}
		});
		button_1.setBounds(38, 250, 117, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("UPLOAD");
		button_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String imgStr = null;
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(button_2)==JFileChooser.APPROVE_OPTION) {
					img4 = imageChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(imageChooser.getSelectedFile().getPath());
					imgStr = ii.toString();
					img4Url.setText(imgStr);
					
				}
			}
		});
		button_2.setBounds(38, 287, 117, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("UPLOAD");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imgStr = null;
				
				JFileChooser imageChooser= new JFileChooser();
				if(imageChooser.showOpenDialog(button_3)==JFileChooser.APPROVE_OPTION) {
					img5 = imageChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(imageChooser.getSelectedFile().getPath());
					imgStr = ii.toString();
					img5Url.setText(imgStr);
					
				}
			}
			
		});
		button_3.setBounds(38, 324, 117, 25);
		contentPane.add(button_3);
		
		img1Url = new JLabel("");
		img1Url.setBounds(210, 187, 430, 15);
		contentPane.add(img1Url);
		
		img2Url = new JLabel("");
		img2Url.setBounds(210, 221, 430, 15);
		contentPane.add(img2Url);
		
		img3Url = new JLabel("");
		img3Url.setBounds(210, 255, 430, 15);
		contentPane.add(img3Url);
		
		img4Url = new JLabel("");
		img4Url.setBounds(210, 292, 430, 15);
		contentPane.add(img4Url);
		
		img5Url = new JLabel("");
		img5Url.setBounds(210, 329, 430, 15);
		contentPane.add(img5Url);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecipientDetailDto rdto = new RecipientDetailDto();
				RecipientDetailDao rdao = new RecipientDetailDao();
				rdto.setId(idHere.getText());
				
				boolean c = rdao.checkExtra(rdto.getId());
				
				//img1
				String filePath = new CreateFile().checkAndCreate(rdto, 0) + img1.getName();
				try {
					BufferedImage bi = ImageIO.read(img1);
					ImageIO.write(bi, "jpg", new File(filePath));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				rdto.setImg1Url(filePath);

				
				//img2
				if(img2.toString().equals("")==false) {
					filePath = new CreateFile().checkAndCreate(rdto, 0) + img2.getName();
					try {
						BufferedImage bi = ImageIO.read(img2);
						ImageIO.write(bi, "jpg", new File(filePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setImg2Url(filePath);
				}
					
				
				
				
				//img3	
				if(img3.toString().equals("")==false) {
					filePath = new CreateFile().checkAndCreate(rdto, 0) + img3.getName();
					try {
						BufferedImage bi = ImageIO.read(img3);
						ImageIO.write(bi, "jpg", new File(filePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setImg3Url(filePath);
				}
				
				
				//img4
				if(img4.toString().equals("")==false) {
					filePath = new CreateFile().checkAndCreate(rdto, 0) + img4.getName();
					try {
						BufferedImage bi = ImageIO.read(img4);
						ImageIO.write(bi, "jpg", new File(filePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setImg4Url(filePath);
				}
				
				
				//img5
				if(img5.toString().equals("")==false) {
					filePath = new CreateFile().checkAndCreate(rdto, 0) + img5.getName();
					try {
						BufferedImage bi = ImageIO.read(img5);
						ImageIO.write(bi, "jpg", new File(filePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rdto.setImg5Url(filePath);
				}
				
				
				
				int done = rdao.uploadExtraPhoto(rdto,c);
				if (done>0) {
					JOptionPane.showMessageDialog(ExtraPhotos.this, "Added Successfully", "Done!", JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(ExtraPhotos.this, "Could not add extra pictures", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSubmit.setBounds(327, 400, 117, 25);
		contentPane.add(btnSubmit);
		
		JButton button_4 = new JButton("<<<BACK");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RecipientList().setVisible(true);
			}
		});
		button_4.setBounds(327, 432, 117, 25);
		contentPane.add(button_4);
	}
}
