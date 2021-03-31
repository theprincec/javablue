package com.techelevator.dao.products.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProductDao implements ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<Product>();
		
		String sql = "SELECT products.id, categories.name AS category, products.name, image_name, description, "
				+ "average_rating, is_top_seller, quantity, price FROM products " 
				+ "JOIN categories ON products.category_id = categories.id;";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		
		while (rows.next()) {
			products.add( mapRowToProduct(rows) );
		}
		
		
		return products;
	}
	
	private Product mapRowToProduct(SqlRowSet row) {
		Product product = new Product();
		
		product.setId(row.getInt("id"));
		product.setCategory(row.getString("category"));
		product.setName(row.getString("name"));
		product.setImage_name(row.getString("image_name"));
		product.setDescription(row.getString("description"));
		product.setRating(row.getDouble("average_rating"));
		product.setIs_top_seller(row.getBoolean("is_top_seller"));
		product.setQuantity(row.getInt("quantity"));
		product.setPrice(row.getDouble("price"));
		
		
		return product;
	}
	
	
	
}
