import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ReadFile {

	private JFrame frame;
	protected JTextComponent taContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadFile window = new ReadFile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReadFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
			
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(199, 7, 322, 313);
		frame.getContentPane().add(textArea);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileReader fr=null;
				BufferedReader br=null;
				String s;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						while((s=br.readLine())!=null) {
							textArea.append(s+"\n");
						}
					}
					br.close();
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnOpen.setBounds(26, 341, 89, 23);
		frame.getContentPane().add(btnOpen);
		
		JButton btnSaveas = new JButton("Save as");
		btnSaveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileWriter fw =null;
				BufferedWriter bw=null;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(textArea.getText());
						bw.flush();						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnSaveas.setBounds(146, 341, 89, 23);
		frame.getContentPane().add(btnSaveas);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc;
				try {
					fc = new JFileChooser();
					String chooseFileDel = fc.getSelectedFile().getAbsolutePath(); 
					File delFile = new File(chooseFileDel);
					if(delFile.delete()) {
						JOptionPane.showMessageDialog(null, "Xoá thành công !");
					} else {
						JOptionPane.showMessageDialog(null, "Thất bại !");
					}
				} catch(Exception ex) {
					System.out.print("Không thể xoá File !");
				}
			}		   
		});
		btnDelete.setBounds(404, 341, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileWriter fw =null;
				BufferedWriter bw=null;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(textArea.getText());
						bw.flush();						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}	
		});
		btnSave.setBounds(271, 341, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 179, 307);
		frame.getContentPane().add(tree);
	}
}
