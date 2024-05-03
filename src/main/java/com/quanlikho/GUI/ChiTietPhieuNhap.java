package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;


import java.awt.Color;

import javax.swing.table.DefaultTableModel;


import java.util.ArrayList;

public class ChiTietPhieuNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabeMaPN;
	private JLabel lblNewLabelNCC;
	private JLabel lblNewLabelNguoiTao;
	private JLabel lblNewLabelNgayTao;
	private JLabel lblNewLabelTongTien;

    private PhieuNhapHangBUS pnhBUS= new PhieuNhapHangBUS();
    private ChiTietPhieuNhapBUS ChitietPnBUS =new ChiTietPhieuNhapBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietPhieuNhap frame = new ChiTietPhieuNhap(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public void layTuBang(String MaPN, String MaNCC, String NguoiTao, String NgayTao, String TongTien){
		lblNewLabeMaPN.setText(MaPN);
		lblNewLabelNCC.setText(MaNCC);
		lblNewLabelNguoiTao.setText(NguoiTao);
		lblNewLabelNgayTao.setText(NgayTao);
		lblNewLabelTongTien.setText(TongTien);
		if (pnhBUS.getList()==null){
            pnhBUS.list();
        }
        if (ChitietPnBUS.getList()==null){
            ChitietPnBUS.list();;
        }
    
		capNhatBang(MaPN);
	}
	
	public ChiTietPhieuNhap(String MaPN) {
		setTitle("Chi tiết phiếu nhập");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 757, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 743, 64);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Chi tiết phiếu nhập");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 78, 743, 95);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu nhập");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 107, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 51, 107, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Người tạo");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(448, 10, 107, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày tạo");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(448, 51, 107, 31);
		panel_1.add(lblNewLabel_1_3);
		
		lblNewLabeMaPN = new JLabel(" ");
		lblNewLabeMaPN.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabeMaPN.setBounds(161, 10, 107, 31);
		panel_1.add(lblNewLabeMaPN);
		
		lblNewLabelNCC = new JLabel("");
		lblNewLabelNCC.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabelNCC.setBounds(161, 51, 107, 31);
		panel_1.add(lblNewLabelNCC);
		
		lblNewLabelNguoiTao = new JLabel("");
		lblNewLabelNguoiTao.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabelNguoiTao.setBounds(554, 10, 107, 31);
		panel_1.add(lblNewLabelNguoiTao);
		
		lblNewLabelNgayTao = new JLabel("");
		lblNewLabelNgayTao.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabelNgayTao.setBounds(554, 51, 107, 31);
		panel_1.add(lblNewLabelNgayTao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 195, 743, 221);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "Số lượng", "Thành tiền"
			}
		));
		panel_2.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 440, 743, 48);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tổng tiền");
		lblNewLabel_1_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(219, 15, 80, 21);
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1_4);
		
		lblNewLabelTongTien = new JLabel("");
		lblNewLabelTongTien.setForeground(new Color(255, 0, 0));
		lblNewLabelTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongTien.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabelTongTien.setBounds(309, 10, 134, 31);
		panel_3.add(lblNewLabelTongTien);
		
		JLabel lblNewLabel_1_6 = new JLabel("VND");
		lblNewLabel_1_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_6.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(453, 10, 107, 31);
		panel_3.add(lblNewLabel_1_6);

	}
	public void capNhatBang(String MaPNH) {
		// Xóa dữ liệu hiện có trong bảng
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		// Lấy danh sách chi tiết phiếu nhập dựa trên mã phiếu nhập
		ArrayList<ChiTietPhieuNhapDTO> dsChiTiet = ChitietPnBUS.getByMaPN(MaPNH);
		
		// Đổ dữ liệu từ danh sách vào bảng
		for (ChiTietPhieuNhapDTO ctpn : dsChiTiet) {
			model.addRow(new Object[]{
				ctpn.getMaSP(),
				ctpn.getSoLuong(),
				ctpn.getDonGiaNhap()
			});
		}
	}
}