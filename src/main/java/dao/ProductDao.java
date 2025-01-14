package dao;

import static utils.ConnectionUtil.getConnection;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Product;

public class ProductDao {
	
	/**
	 * 상품 번호로 상품정보 반환
	 * @param no
	 * @return Product 상품
	 * @throws SQLException
	 */
	public Product selectProductbyNo(int no) throws SQLException{
		Product product = new Product();
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "where product_no = ? ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);	
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return product;
	}
	
	/**
	 * 모든 상품 정보를 반환한다.
	 * @return products 모든상품정보
	 * @throws SQLException
	 */
	public List<Product> selectAllProducts() throws SQLException{
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	/**
	 * 카테고리별 상품정보를 반환한다.
	 * @param categoryName
	 * @return products 카테고리별 상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectProductsByCategory(String category) throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "where product_category = ? ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, category);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	/**
	 * 브랜드별 상품정보를 반환한다.
	 * @param categoryName
	 * @return products 카테고리별 상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectProductsByBrand(String brand) throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "where product_brand = ? ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, brand);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	
	/**
	 * 신상품(최신순서) 상품정보를 반환한다.
	 * @return products 신상품순 상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectNewProducts() throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
		 + "product_disprice, product_brand, product_category, product_created_date, "
		 + "product_gender "
		 + "from (select row_number() over (order by product_created_date desc) rn, "
		 + "		product_no, product_name, product_img, product_price, "
		 + "       product_disprice, product_brand, product_category, product_created_date, "
		 + "		product_gender "
		 + "      from tb_products ) "
		 + "where rn >= 1 and rn <= 10 "
		 + "order by product_created_date desc ";
		
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	/**
	 * 세일상품 상품정보를 반환한다.
	 * @return products 세일상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectProductsOnSale() throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "where product_disprice is not null ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	
	/**
	 * 높은가격순 상품정보를 반환한다.
	 * @return products 세일상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectProductsByPriceDesc() throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "order by product_price desc ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	/**
	 * 낮은가격순 상품정보를 반환한다.
	 * @return products 세일상품정보.
	 * @throws SQLException
	 */
	public List<Product> selectProductsByPriceAsc() throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "order by product_price asc ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}
	
	/**
	 * 성별 상품정보를 반환한다.
	 * @return products 
	 * @throws SQLException
	 */
	public List<Product> selectProductsByGender(String gender) throws SQLException {
		List<Product> products = new ArrayList<>();
		
		String sql = "select product_no, product_name, product_img, product_price, "
				+ "product_disprice, product_brand, "
				+ "product_category, product_created_date, product_gender "
			   + "from tb_products "
			   + "where product_gender = ? ";
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, gender);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPhoto(rs.getString("product_img"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setDisPrice(rs.getInt("product_disprice"));
			product.setBrand(rs.getString("product_brand"));
			product.setCategory(rs.getString("product_category"));
			product.setGender(rs.getString("product_gender"));
			product.setCreatedDate(rs.getDate("product_created_date"));
		
			products.add(product);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return products;
	}

}

