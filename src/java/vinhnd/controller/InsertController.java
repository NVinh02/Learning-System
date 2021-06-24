/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vinhnd.daos.UserDAO;
import vinhnd.dtos.UserDTO;
import vinhnd.dtos.UserErrorDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {
    private final static String ERROR = "insert.jsp";
    private final static String SUCCESS = "login.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = false;
        UserErrorDTO error = new UserErrorDTO("", "", "", "", "");
        try {
            String userID = request.getParameter("userID");
            String fullname = request.getParameter("fullname");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            if (userID.length() < 3 || userID.length() >10) {
                check = true;
                error.setUserIDError("User ID must be in 3-10 characters");
            }
            if (fullname.length() < 3 || fullname.length() > 30) {
                check = true;
                error.setFullnameError("Fullname must be in 3-30 characters");
            }
            if (roleID.length() < 2 || roleID.length() > 12) {
                check = true;
                error.setRoleIDError("Role ID must be in 2-12 characters");
            }
            if (password.length() < 5 || password.length() > 16) {
                check = true;
                error.setPasswordError("Password must be in 8-16 characters");
            }
            if (!confirm.equals(password)) {
                check = true;
                error.setConfirmError("Confirm must be same as password");
            }
            if (check) {
                request.setAttribute("ERROR_USER", error);
            } else {
                UserDAO dao = new UserDAO();
//                boolean checkDuplicate = dao.checkDuplicate(userID);
//                if (checkDuplicate) {
//                    error.setUserIDError("User ID is existed");
//                    request.setAttribute("ERROR_USER", error);
//                } else {
//                    UserDTO user = new UserDTO(userID, fullname, roleID, password);
//                    dao.insert(user);
//                    url = SUCCESS;
//                }
                UserDTO user = new UserDTO(userID, fullname, roleID, password);
                boolean result = dao.insert(user);
                if (result)
                url = SUCCESS;
            }
        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                error.setUserIDError("User is existed");
                request.setAttribute("ERROR_USER", error);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
