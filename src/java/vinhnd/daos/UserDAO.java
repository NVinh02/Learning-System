/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import vinhnd.ultils.DBIUltilis;
import vinhnd.dtos.UserDTO;

/**
 *
 * @author PC
 */
public class UserDAO {

    public boolean checkLogin1(String userID, String password) throws SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "Select userID "
                        + "From tblUsers "
                        + "Where userID = ? AND password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();

                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "SELECT fullname, roleID "
                        + "FROM tblUsers "
                        + "WHERE userID=? AND password=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullname");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullname, roleID, "");
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "SELECT userID, fullname, roleID "
                        + " FROM tblUsers "
                        + " WHERE fullname LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullname = rs.getString("fullname");
                    String roleID = rs.getString("roleID");
                    list.add(new UserDTO(userID, fullname, roleID, "********"));
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean delete(String userID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "DELETE tblUsers "
                        + " WHERE userID ='" + userID + "'";
                stm = con.prepareStatement(sql);
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "UPDATE tblUsers SET fullname=?, roleID=?"
                        + " WHERE userID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, user.getFullname());
                stm.setString(2, user.getRoleID());
                stm.setString(3, user.getUserID());
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBIUltilis.getConnection();
            if (con != null) {
                String sql = "SELECT userID FROM tblUsers "
                        + " WHERE userID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    public boolean insert (UserDTO user) throws SQLException,
            ClassNotFoundException,
            NamingException{
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBIUltilis.getConnection();
            if (con != null){
                String sql = "INSERT INTO tblUsers(userID, fullname, password, roleID) "
                        + " VALUES(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullname());
                stm.setString(3, user.getPassword());
                stm.setString(4, user.getRoleID());
                check = stm.executeUpdate() == 0? false : true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
}
