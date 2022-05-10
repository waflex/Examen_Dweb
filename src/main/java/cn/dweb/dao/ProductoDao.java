package cn.dweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import cn.dweb.model.*;

public class ProductoDao {
	 private Connection con;
	    private String query;
	    private PreparedStatement pst;
	    private ResultSet rs;
		public ProductoDao(Connection con) {
			this.con = con;
		}
		
		public List<Producto> getAllProducts() {
	        List<Producto> book = new ArrayList<>();
	        try {

	            query = "select * from products";
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	Producto row = new Producto();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));

	                book.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }
		public Producto getSingleProduct(int id) {
			 Producto row = null;
		        try {
		            query = "select * from products where id=? ";

		            pst = this.con.prepareStatement(query);
		            pst.setInt(1, id);
		            ResultSet rs = pst.executeQuery();

		            while (rs.next()) {
		            	row = new Producto();
		                row.setId(rs.getInt("id"));
		                row.setName(rs.getString("name"));
		                row.setCategory(rs.getString("category"));
		                row.setPrice(rs.getString("price"));
		                row.setImage(rs.getString("image"));
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
		        }

		        return row;
		    }
		
		public double getTotalCartPrice(ArrayList<Cart> cartList) {
	        double sum = 0;
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    query = "select price from products where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        sum+=rs.getDouble("price")*item.getQuantity();
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return sum;
	    }

	    
	    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
	        List<Cart> book = new ArrayList<>();
	        try {
	            if (cartList.size() > 0) {
	                for (Cart item : cartList) {
	                    query = "select * from products where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Cart row = new Cart();
	                        row.setId(rs.getInt("id"));
	                        row.setName(rs.getString("name"));
	                        row.setCategory(rs.getString("category"));
	                        row.setPrice(rs.getDouble("price")*item.getQuantity());
	                        row.setQuantity(item.getQuantity());
	                        book.add(row);
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }
	}