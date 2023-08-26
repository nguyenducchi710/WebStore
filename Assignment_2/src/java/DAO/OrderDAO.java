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
import java.util.HashMap;

/**
 *
 * @author nguye
 */
public class OrderDAO {
    public static int saveOrder(int userid, HashMap<Product, Integer> cart) throws Exception{
        int result = 0;
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            cn.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Orders]([TotalAmount],[Status],[CustomerID])\n" +
                         "VALUES (?,?,?);";
            PreparedStatement pst = cn.prepareStatement(sql);
            double total = 0;
            for (Product p : cart.keySet()) total += p.getPrice() + cart.get(p);
            pst.setDouble(1, total);
            pst.setString(2, "Paid");
            pst.setInt(3, userid);
            result = pst.executeUpdate();
            if(result > 0){
                sql = "SELECT MAX([ID]) as 'orderid'\n" +
                      "FROM [dbo].[Orders]";
                pst = cn.prepareCall(sql);
                ResultSet rs = pst.executeQuery();
                if(rs != null && rs.next()){
                    int orderid = rs.getInt("orderid");
                    for (Product p : cart.keySet()){
                        sql = "INSERT INTO [dbo].[OrderDetails]([OrderID],[ProductID],[Quantity])\n" +
                              "VALUES (?,?,?);";
                        pst = cn.prepareStatement(sql);
                        pst.setInt(1, orderid);
                        pst.setInt(2, p.getProductid());
                        pst.setInt(3, cart.get(p));
                        result = pst.executeUpdate();
                    }
                }
            }
            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
        }        
        return result;
    }
}
