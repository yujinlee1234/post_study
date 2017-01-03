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

public class SearchUi extends JFrame implements ActionListener, MouseListener {
	private MainUi mainUi;

	public void setMainUi(MainUi mainUi) {
		this.mainUi = mainUi;
	}
	
	private JPanel contentPane;
	private JTable sTable;
	private JTextField tfDoro;
	private JButton btnOk;
	private JComboBox<String> cmbSido;
	private String[][] datas;

	public SearchUi() {
		setTitle("우편번호 검색");
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));
		
		JPanel sPanel = new JPanel();
		contentPane.add(sPanel, BorderLayout.NORTH);
		sPanel.setLayout(new GridLayout(0, 5, 10, 0));
		
		JLabel lblSido = new JLabel("시도");
		lblSido.setHorizontalAlignment(SwingConstants.RIGHT);
		sPanel.add(lblSido);
		
		cmbSido = new JComboBox<>();
		setCmbSido();
		sPanel.add(cmbSido);
		
		JLabel lblDoro = new JLabel("도로명");
		lblDoro.setHorizontalAlignment(SwingConstants.RIGHT);
		sPanel.add(lblDoro);
		
		tfDoro = new JTextField();
		sPanel.add(tfDoro);
		tfDoro.setColumns(10);
		
		btnOk = new JButton("검색");
		btnOk.addActionListener(this);
		sPanel.add(btnOk);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		sTable = new JTable();
		sTable.addMouseListener(this);
		sTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(sTable);
		sTable.setRowSelectionAllowed(true);
		
		
		setVisible(true);
		pack();
	}

	private void setCmbSido() {
		// TODO Auto-generated method stub
		List<String> sido = PostService.getInstance().getSido();
		for(int i=0;i<sido.size();i++){
			cmbSido.addItem(sido.get(i));
		}
	}

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

	private void setTableAlignment() {
		// TODO Auto-generated method stub
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
		System.out.println(list.get(0).getZipcode());
		datas = new String[list.size()][];
		for(int i = 0 ; i < list.size() ; i++ ){
			datas[i] = new String[]{list.get(i).getZipcode() , list.get(i).getAddress()};
		}
		return datas;
	}

	private List<Post> getPostList() {
		// TODO Auto-generated method stub
		String sido = cmbSido.getSelectedItem()+"";
		String doro = tfDoro.getText().trim()+"%";
		return PostService.getInstance().selectBySidoro(sido, doro);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == sTable) {
			sTableMouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void sTableMouseClicked(MouseEvent e) {
		
		int index = sTable.getSelectedRow();
		mainUi.setTfZipcode(datas[index][0]);
		mainUi.setTfAddress(datas[index][1]);
		setVisible(false);
	}
}
