package kr.or.dgit.bigdata.post_study.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainUi extends JPanel implements ActionListener {
	/* FIELDS */
	private JTextField tfZipcode;
	private JTextField tfAddress;
	private JTextField tfSubAddress;
	private JButton btnOk;
	private JButton btnZipSearch;
	/* GET/SET */
	public void setTfZipcode(String zipCode) {
		tfZipcode.setText(zipCode);
	}
	public void setTfAddress(String address) {
		tfAddress.setText(address);
	}
	/* CONSTRUCTOR */
	public MainUi() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{3.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblZipcode = new JLabel("우편번호");
		GridBagConstraints gbc_lblZipcode = new GridBagConstraints();
		gbc_lblZipcode.anchor = GridBagConstraints.EAST;
		gbc_lblZipcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipcode.gridx = 0;
		gbc_lblZipcode.gridy = 0;
		add(lblZipcode, gbc_lblZipcode);
		
		tfZipcode = new JTextField();
		GridBagConstraints gbc_tfZipcode = new GridBagConstraints();
		gbc_tfZipcode.insets = new Insets(0, 0, 5, 5);
		gbc_tfZipcode.fill = GridBagConstraints.BOTH;
		gbc_tfZipcode.gridx = 1;
		gbc_tfZipcode.gridy = 0;
		add(tfZipcode, gbc_tfZipcode);
		tfZipcode.setColumns(10);
		
		btnZipSearch = new JButton("우편번호 검색");
		btnZipSearch.addActionListener(this);
		GridBagConstraints gbc_btnZipSearch = new GridBagConstraints();
		gbc_btnZipSearch.fill = GridBagConstraints.BOTH;
		gbc_btnZipSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnZipSearch.gridx = 2;
		gbc_btnZipSearch.gridy = 0;
		add(btnZipSearch, gbc_btnZipSearch);
		
		JLabel lblAddress = new JLabel("주소");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		add(lblAddress, gbc_lblAddress);
		
		tfAddress = new JTextField();
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.gridwidth = 2;
		gbc_tfAddress.insets = new Insets(0, 0, 5, 0);
		gbc_tfAddress.fill = GridBagConstraints.BOTH;
		gbc_tfAddress.gridx = 1;
		gbc_tfAddress.gridy = 1;
		add(tfAddress, gbc_tfAddress);
		tfAddress.setColumns(10);
		
		JLabel lblSubAddress = new JLabel("세부주소");
		GridBagConstraints gbc_lblSubAddress = new GridBagConstraints();
		gbc_lblSubAddress.anchor = GridBagConstraints.EAST;
		gbc_lblSubAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubAddress.gridx = 0;
		gbc_lblSubAddress.gridy = 2;
		add(lblSubAddress, gbc_lblSubAddress);
		
		tfSubAddress = new JTextField();
		GridBagConstraints gbc_tfSubAddress = new GridBagConstraints();
		gbc_tfSubAddress.fill = GridBagConstraints.BOTH;
		gbc_tfSubAddress.insets = new Insets(0, 0, 5, 0);
		gbc_tfSubAddress.gridwidth = 2;
		gbc_tfSubAddress.gridx = 1;
		gbc_tfSubAddress.gridy = 2;
		add(tfSubAddress, gbc_tfSubAddress);
		tfSubAddress.setColumns(10);
		
		btnOk = new JButton("등록");
		btnOk.addActionListener(this);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.gridwidth = 2;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 3;
		add(btnOk, gbc_btnOk);
	}

	/* EVENT */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnZipSearch) {
			btnZipSearchActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	private void btnOkActionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null,tfZipcode.getText()+" "+tfAddress.getText()+", "+tfSubAddress.getText());
	}

	protected void btnZipSearchActionPerformed(ActionEvent e){
		tfSubAddress.setText("");
		SearchUi searchUi = new SearchUi();
		searchUi.setMainUi(this);
	}
}
