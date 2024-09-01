package com.VisitorsManagement;

import java.sql.DriverManager;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
public class VisitorsDataTable extends JFrame {
	JTable jt;int i=0;int j=0;
	String cols[]= {"VISITOR ID","VISITOR NAME","EMAIL","PHONE","ADDRESS","GENDER","GOVT. ID TYPE","GOVT. ID"};
	JButton v_close;
	Connection con;Statement st;ResultSet rs;
	DefaultTableModel tb=new DefaultTableModel();
	
	public VisitorsDataTable() {
	// TODO Auto-generated constructor stub
		setSize(1400,800);
		setTitle("VISITOR DATA TABLE");
		setVisible(true);
		setLocationRelativeTo(null);
		tb.setColumnIdentifiers(cols);
		jt=new JTable();
		jt.setModel(tb);
		jt.setFont(new Font("Arial",Font.BOLD,14));
		jt.setBackground(new Color(40, 100, 80));
		jt.setForeground(new Color(255,255,255));
		fillData();
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JTableHeader header = jt.getTableHeader();
		header.setBackground(Color.yellow);
		header.setFont(new Font("Arial",Font.BOLD,16));
		JScrollPane jp=new JScrollPane(jt);
		add(jp);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void fillData()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="select * from Visitors";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				tb.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(4),rs.getString(6),rs.getString(7),rs.getString(8)});
			}
		}
		catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VisitorsDataTable();
	}

}
