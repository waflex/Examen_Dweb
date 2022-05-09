package cn.dweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		public List<Producto> getAllProducts(){
			List<Producto> productos = new ArrayList<Producto>();
			try {
				query = "select * from products";
				pst = this.con.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					Producto row = new Producto();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setCategory(rs.getString("category"));
					row.setPrice(rs.getString("price"));
					row.setPrice(rs.getString("image"));
					productos.add(row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return productos;
		}
	    
}
