/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Product;
import MyLibrary.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class ProductDAO {

    public static ArrayList<Product> getAllProduct() throws Exception {
        ArrayList<Product> list = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT[ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]\n"
                    + "FROM [dbo].[Products]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String productname = rs.getString("ProductName"),
                            description = rs.getString("Description");
                    double price = rs.getDouble("Price");
                    String gender = rs.getString("Gender"),
                            type = rs.getString("ProductType"),
                            size = rs.getString("Size");
                    Product p = new Product(id, productname, description, price, gender, type, size);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static ArrayList<Product> searchProduct(String keyword) throws Exception {
        ArrayList<Product> list = new ArrayList();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]\n" +
                         "FROM Products\n" +
                         "WHERE ProductName LIKE ? OR ProductType LIKE ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%"+keyword+"%");
            pst.setString(2, "%"+keyword+"%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String productname = rs.getString("ProductName"),
                            description = rs.getString("Description");
                    double price = rs.getDouble("Price");
                    String gender = rs.getString("Gender"),
                            type = rs.getString("ProductType"),
                            size = rs.getString("Size");
                    Product p = new Product(id, productname, description, price, gender, type, size);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static Product getProductByID(int productid) throws Exception{
        Product p = new Product();
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "SELECT [ID],[ProductName],[Description],[Price],[Gender],[ProductType],[Size]\n" +
                         "FROM [dbo].[Products]\n" +
                         "WHERE [ID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, productid);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    String productname = rs.getString("ProductName"),
                            description = rs.getString("Description");
                    double price = rs.getDouble("Price");
                    String gender = rs.getString("Gender"),
                            type = rs.getString("ProductType"),
                            size = rs.getString("Size");
                    p = new Product(productid, productname, description, price, gender, type, size);
                }
            }
        }
        return p;
    }
    
    public static int deleteProduct(int productid) throws Exception{
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "DELETE FROM [dbo].[Products]\n" +
                         "WHERE ID = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, productid);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
    
    public static int updateProduct(int productid, String productname, String description, double price, String gender, String type, String size) throws Exception{
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "UPDATE Products\n" +
                         "SET\n" +
                         "    ProductName = ?,\n" +
                         "    Description = ?,\n" +
                         "    Price = ?,\n" +
                         "    Gender = ?,\n" +
                         "    ProductType = ?,\n" +
                         "    Size = ?\n" +
                         "WHERE ID = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setNString(1, productname);
            pst.setNString(2, description);
            pst.setDouble(3, price);
            pst.setNString(4, gender);
            pst.setNString(5, type);
            pst.setNString(6, size);
            pst.setInt(7, productid);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
