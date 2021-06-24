/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhnd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private final static String DELETE_CONTROLLER = "DeleteController";
    private final static String UPDATE_CONTROLLER = "UpdateController";
    private final static String INSERT_CONTROLLER = "InsertController";
    private final static String ADD_CONTROLLER = "AddController";
    private final static String VIEW_CART = "viewCart.jsp";
    private final static String REMOVE_CONTROLLER = "RemoveController";
    private final static String EDIT_CONTROLLER = "EditController";
    
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
        
        try{
            String action = request.getParameter("action");
            if("Login".equals(action)){
                url = LOGIN_CONTROLLER;
            } else if ("Search".equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if ("Logout".equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if ("Delete".equals(action)) {
                url = DELETE_CONTROLLER;
            } else if ("Update".equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if ("Insert".equals(action)) {
                url = INSERT_CONTROLLER;
            } else if ("Add".equals(action)) {
                url = ADD_CONTROLLER;
            } else if ("View".equals(action)) {
                url = VIEW_CART;
            } else if ("Remove".equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if ("Edit".equals(action)) {
                url = EDIT_CONTROLLER;
            } 
        } catch (Exception e){
            log("Error at MainController:" + e.toString());
        } finally{
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
