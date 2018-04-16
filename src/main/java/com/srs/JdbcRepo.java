package com.srs;

import java.util.*;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class JdbcRepo {

Connection con=null;
public JdbcRepo(){
	String url="jdbc:mysql://localhost:3306/restdb";
	String username="root";
	String password="jlcindia";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
	} catch (Exception e) {
		System.out.println(e);
	}
}

public List<Alien> getAliens(){
	List<Alien> aliens=new ArrayList<>();
	String sql="select *from alien";
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			Alien a=new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			aliens.add(a);
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return aliens;
}

public Alien getAlien(int id){
	String sql="select *from alien where id="+id;
	Alien a=new Alien();
	try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	return a;
}

public void create(Alien a1) {
	String sql="insert into alien values(?,?,?)";
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, a1.getId());
		pst.setString(2, a1.getName());
		pst.setInt(3, a1.getPoints());
		pst.executeUpdate();
		

	} catch (Exception e) {
		System.out.println(e);
	}	
}
public void update(Alien a1) {
	String sql="update alien set name=?,points=? where id=?";
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, a1.getName());
		pst.setInt(2, a1.getPoints());
		pst.setInt(3, a1.getId());
		pst.executeUpdate();
		

	} catch (Exception e) {
		System.out.println(e);
	}	
}

public void delete(int id) {
	String sql="delete from alien where id=?";
	try {
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}	
}
	
}
