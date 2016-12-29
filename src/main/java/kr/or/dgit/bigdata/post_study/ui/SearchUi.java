package kr.or.dgit.bigdata.post_study.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SearchUi extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SearchUi() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		JPanel searchPanel = new JPanel();
		add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(new GridLayout(0, 5, 10, 0));
		
		JLabel label = new JLabel("시도");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		searchPanel.add(label);
		
		JComboBox comboBox = new JComboBox();
		searchPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("도로명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		searchPanel.add(lblNewLabel);
		
		textField = new JTextField();
		searchPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		searchPanel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
