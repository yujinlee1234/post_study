package kr.or.dgit.bigdata.post_study.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.post_study.dto.Post;
import kr.or.dgit.bigdata.post_study.service.PostService;
import java.awt.event.MouseListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SearchUi extends JFrame implements ActionListener, MouseListener, FocusListener {
	/* FIELDS*/
	private MainUi mainUi;
	private JPanel contentPane;
	private JTable sTable;
	private JTextField tfDoro;
	private JButton btnOk;
	private JComboBox<String> cmbSido;
	private String[][] datas;
	/* GET/SET */
	public void setMainUi(MainUi mainUi) {
		this.mainUi = mainUi;
	}
	/* CONSTRUCTOR */
	public SearchUi() {
		setTitle("우편번호 검색");
		setBounds(500, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));
		
		JPanel sPanel = new JPanel();
		contentPane.add(sPanel, BorderLayout.NORTH);
		GridBagLayout gbl_sPanel = new GridBagLayout();
		gbl_sPanel.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gbl_sPanel.rowHeights = new int[]{23, 0};
		gbl_sPanel.columnWeights = new double[]{5.0, 11.6, 5.0, 18.0, 11.6, Double.MIN_VALUE};
		gbl_sPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		sPanel.setLayout(gbl_sPanel);
		
		tfDoro = new JTextField();
		tfDoro.addFocusListener(this);
		
		JLabel lblSido = new JLabel("시도");
		lblSido.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblSido = new GridBagConstraints();
		gbc_lblSido.fill = GridBagConstraints.BOTH;
		gbc_lblSido.insets = new Insets(0, 0, 0, 5);
		gbc_lblSido.gridx = 0;
		gbc_lblSido.gridy = 0;
		sPanel.add(lblSido, gbc_lblSido);
		
		cmbSido = new JComboBox<>();
		GridBagConstraints gbc_cmbSido = new GridBagConstraints();
		gbc_cmbSido.fill = GridBagConstraints.BOTH;
		gbc_cmbSido.insets = new Insets(0, 0, 0, 5);
		gbc_cmbSido.gridx = 1;
		gbc_cmbSido.gridy = 0;
		sPanel.add(cmbSido, gbc_cmbSido);
		
		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDoro = new GridBagConstraints();
		gbc_lblDoro.fill = GridBagConstraints.BOTH;
		gbc_lblDoro.insets = new Insets(0, 0, 0, 5);
		gbc_lblDoro.gridx = 2;
		gbc_lblDoro.gridy = 0;
		sPanel.add(lblDoro, gbc_lblDoro);
		tfDoro.setText("예)선기로 or 선기로1길");
		GridBagConstraints gbc_tfDoro = new GridBagConstraints();
		gbc_tfDoro.fill = GridBagConstraints.BOTH;
		gbc_tfDoro.insets = new Insets(0, 0, 0, 5);
		gbc_tfDoro.gridx = 3;
		gbc_tfDoro.gridy = 0;
		sPanel.add(tfDoro, gbc_tfDoro);
		tfDoro.setColumns(10);
		
		btnOk = new JButton("검색");
		btnOk.addActionListener(this);
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.gridx = 4;
		gbc_btnOk.gridy = 0;
		sPanel.add(btnOk, gbc_btnOk);
		setCmbSido();
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		sTable = new JTable();
		sTable.addMouseListener(this);
		sTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(sTable);
		sTable.setRowSelectionAllowed(true);		
		
		setVisible(true);
	}
	/* METHODS */
	private void setCmbSido() {
		// comboBox에 item 삽입
		List<String> sido = PostService.getInstance().getSido();
		for(int i=0;i<sido.size();i++){
			cmbSido.addItem(sido.get(i));
		}
	}
	private void setTableAlignment() {
		// table의 1열만 중앙정렬
		TableColumnModel tcm = sTable.getColumnModel();		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcm.getColumn(0).setCellRenderer(dtcr);
	}
	public void tableSetWidth(int... width) {
		TableColumnModel cModel = sTable.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	private String[] getColumn() {
		return new String[]{"우편번호","주소"};
	}
	private String[][] getData() {		
		List<Post> list = getPostList();
		datas = new String[list.size()][];
		for(int i = 0 ; i < list.size() ; i++ ){
			datas[i] = list.get(i).toArray();
		}
		return datas;
	}
	private List<Post> getPostList() {
		String sido = cmbSido.getSelectedItem()+"";
		String doro = tfDoro.getText().trim()+"%";	
		return PostService.getInstance().selectBySidoro(sido, doro);
	}
	/* EVENT */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			btnNewButtonActionPerformed(arg0);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		sTable.setModel(new DefaultTableModel(getData(), getColumn()));
		setTableAlignment();
		tableSetWidth(200,400);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == sTable) {
			sTableMouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	protected void sTableMouseClicked(MouseEvent e) {		
		int index = sTable.getSelectedRow();
		mainUi.setTfZipcode(datas[index][0]);
		mainUi.setTfAddress(datas[index][1]);
		setVisible(false);
	}
	
	public void focusGained(FocusEvent arg0) {
		if (arg0.getSource() == tfDoro) {
			tfDoroFocusGained(arg0);
		}
	}
	public void focusLost(FocusEvent arg0) {}
	
	protected void tfDoroFocusGained(FocusEvent arg0) {
		tfDoro.setText("");
	}
}
