package com.zensar.spring.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private NamedParameterJdbcTemplate template;

	public ProductRepositoryImpl1() {

	}

	public int insertProduct(Product product) {
		String sql = "INSERT INTO product (productId, productName, productCost) VALUES (:productId, :productName, :productCost)";

		Map<String, String> params = new HashMap<String, String>();

		params.put("productId", "101");
		params.put("productName", "Appleiphone");
		params.put("productCost", "12000");
		return template.update(sql, params);
	}

	public int updateProduct(Product product) {
		String sql = "update product set productName = :productName, productCost = :productCost where productId=:productId";

		Map<String, String> params = new HashMap<String, String>();

		params.put("productId", "103");
		params.put("productName", "Appleiphone");
		params.put("productCost", "12000");
		return template.update(sql, params);
	}

	public boolean deleteProduct(int productId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("productId", productId);
		String sql = "delete from product where productId=:productId";

		return template.update(sql, namedParameters)>0;
	}
	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	/*
	 * private JdbcTemplate template;
	 * 
	 * public ProductRepositoryImpl1() {
	 * 
	 * }
	 * 
	 * public int insertProduct(Product product) { // createTable(); String sql =
	 * "insert into product values(" + product.getProductId() + ",'" +
	 * product.getProductName() + "'," + product.getProductCost() + ");";
	 * template.execute(sql); return 1; }
	 * 
	 * public void createTable() { template.
	 * execute("create table product(productId int ,productName varchar(50),productCost int)"
	 * ); } //for updating the product public int updateProduct(Product product) {
	 * String sql =
	 * "update product set productName = ?, productCost = ? where productId=?";
	 * return template.update(sql, product.getProductName(),
	 * product.getProductCost(), product.getProductId());
	 * 
	 * } //for deleting the product public int deleteProduct(int productId) { String
	 * sql = "delete from product where productId= ?";
	 * 
	 * return template.update(sql, productId); }
	 * 
	 * 
	 * public List<Product> getAllProducts() { String sql = "select * from product";
	 * List<Product> product = template.query(sql, (rs, rowNum) -> new
	 * Product(rs.getInt("productId"), rs.getString("productName"),
	 * rs.getInt("productCost"))); return product; }
	 * 
	 * public void updateProduct(int id, String productName, int productCost) {
	 * template.update("update product set productName = ? where productId = ?",
	 * productName, id); }
	 * 
	 * public void deleteProduct(int id) { String sql =
	 * "DELETE FROM product WHERE productId = ?"; template.update(sql, id); }
	 * 
	 * 
	 * public JdbcTemplate getTemplate() { return template; }
	 * 
	 * public void setTemplate(JdbcTemplate template) { this.template = template; }
	 */
}
