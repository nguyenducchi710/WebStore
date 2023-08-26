/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class MainController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String url = "";
            
            //login page
            if(action == null){
                url = "login.jsp";
            }
            
            //LoginServlet
            else if(action.equals("Login")){
                url = "LoginServlet";
            }
            
            //LogoutSerrvlet
            else if(action.equals("logout")){
               url = "LogoutServlet";
            }
            
            //User--------------------------------------------------------------
            //register.jsp
            else if(action.equals("register")){
                url = "register.jsp";
            }
            
            //RegisterServlet
            else if(action.equals("Register")){
                url = "RegisterServlet";
            }
            
            //SearchServlet
            else if(action.equals("search")){
               url = "SearchServlet";
            }
            
            //AddToCartServlet
            else if(action.equals("Add to cart")){
               url = "AddToCartServlet";
            }
            
            //viewcart.jsp
            else if(action.equals("viewcart")){
               url = "viewcart.jsp";
            }
            
            //UpdateCartServlet, RemoveCartServlet
            else if (action.equals("9")) {// update hoac remove
                String remove = request.getParameter("btnremove");
                if (remove != null && remove.equals("remove")) {
                    url = "RemoveCartServlet";
                } else {
                    url = "UpdateCartServlet";
                }
            }
            
            //SaveOrderServlet
            else if(action.equals("Pay")){
               url = "SaveOrderServlet";
            }
            //User--------------------------------------------------------------
            
            
            //Admin-------------------------------------------------------------
            //-Product Management
            //productmanagement.jsp
            else if(action.equals("productmanagement")){
               url = "productmanagement.jsp";
            }
            
            //SearchProductServlet
            else if(action.equals("searchproduct")){
               url = "SearchProductServlet";
            }
            
            //DeleteProductServlet
            else if(action.equals("Delete Product")){
               url = "DeleteProductServlet";
            }
            
            //edititem.jsp
            else if(action.equals("Edit Product")){
               url = "edititem.jsp";
            }
            
            //UpdateProductServlet
            else if(action.equals("Update")){
               url = "UpdateProductServlet";
            }
            
            //-User Management
            //usermanagement.jsp
            else if(action.equals("usermanagement")){
               url = "usermanagement.jsp";
            }
            
            //SearchUserServlet
            else if(action.equals("searchuser")){
               url = "SearchUserServlet";
            }
            
            //DeleteUserServlet
            else if(action.equals("Delete User")){
               url = "DeleteUserServlet";
            }
            
            //Admin-------------------------------------------------------------
            
            request.getRequestDispatcher(url).forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
