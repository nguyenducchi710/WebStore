/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import MyLibrary.DBUtils;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class UserDAO {

    public static User getUser(String username) throws Exception {
        User us = new User();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]\n"
                    + "FROM [dbo].[tbUser]\n"
                    + "WHERE [Username] like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String fullname = rs.getString("CustomerName"),
                            address = rs.getString("Address"),
                            phone = rs.getString("Phone"),
                            email = rs.getString("Email"),
                            password = rs.getString("Password"),
                            role = rs.getString("Role");
                    Date registrationdate = rs.getDate("RegistrationDate");
                    us = new User(id, fullname, address, phone, email, username, password, role, registrationdate);
                }
            }
            cn.close();
        }
        return us;
    }

    public static int registerUser(String fullname, String address, String phone, String email, String username, String password) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "INSERT INTO [dbo].[tbUser]([CustomerName],[Address],[Phone],[Email],[Username],[Password])\n" +
                         "VALUES (?,?,?,?,?,?);";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setNString(1, fullname);
            pst.setNString(2, address);
            pst.setNString(3, phone);
            pst.setNString(4, email);
            pst.setNString(5, username);
            pst.setNString(6, password);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
    
    public static ArrayList<User> searchUser(String keyword) throws Exception{
        ArrayList<User> list = new ArrayList();
        User us = new User();
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]\n"
                    + "FROM [dbo].[tbUser]\n"
                    + "WHERE [CustomerName] like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%"+keyword+"%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String fullname = rs.getString("CustomerName"),
                            address = rs.getString("Address"),
                            phone = rs.getString("Phone"),
                            email = rs.getString("Email"),
                            username = rs.getString("Username"),
                            password = rs.getString("Password"),
                            role = rs.getString("Role");
                    Date registrationdate = rs.getDate("RegistrationDate");
                    us = new User(id, fullname, address, phone, email, username, password, role, registrationdate);
                    list.add(us);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static ArrayList<User> getAllUser() throws Exception{
        ArrayList<User> list = new ArrayList();
        User us = new User();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ID],[CustomerName],[Address],[Phone],[Email],[Username],[Password],[Role],[RegistrationDate]\n"
                        +"FROM [dbo].[tbUser]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String fullname = rs.getString("CustomerName"),
                            address = rs.getString("Address"),
                            phone = rs.getString("Phone"),
                            email = rs.getString("Email"),
                            username = rs.getString("Username"),
                            password = rs.getString("Password"),
                            role = rs.getString("Role");
                    Date registrationdate = rs.getDate("RegistrationDate");
                    us = new User(id, fullname, address, phone, email, username, password, role, registrationdate);
                    list.add(us);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static int deleteUser(int userid) throws Exception{
        int result = 0;
        Connection cn = DBUtils.makeConnection();
        if(cn != null){
            String sql = "DELETE FROM tbUser\n" +
                         "WHERE ID = ?;";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, userid);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}
