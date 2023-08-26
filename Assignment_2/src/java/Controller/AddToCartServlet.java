/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class AddToCartServlet extends HttpServlet {

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
            String id = request.getParameter("productid");
            int productid = Integer.parseInt(id);
            Product p = ProductDAO.getProductByID(productid);
            HttpSession session = request.getSession();
            HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");
            String msg = "";
            //check cart xem null hay khong
            if (cart == null) { //null thi tao cart, chen product vao cart
                cart = new HashMap<>();
                cart.put(p, 1); //default quantity is 1
                msg = "Add " + p.getProductname() + " - " + 1 +" cai "+p.getPrice();
                request.setAttribute("msg", msg);
            } else {
                // tim product trong cart
                Product findProduct = null;
                boolean flag = false;
                for(Product tmp : cart.keySet()) {
                    if(tmp.getProductid() == productid) {
                        flag = true;
                        findProduct = tmp;
                    }
                }
                
                //neu ton tai product trong cart thi update quantity
                if(flag) {
                    int quantity = cart.get(findProduct);
                    quantity++;
                    cart.put(findProduct, quantity);
                    msg = "Add " + p.getProductname() + " - " + quantity +" cai "+p.getPrice();
                    request.setAttribute("msg", msg);
                //khong co thi add product vao cart 
                } else {
                    cart.put(p, 1);
                    msg = "Add " + p.getProductname() + " - " + 1 +" cai "+p.getPrice();
                    request.setAttribute("msg", msg);
                }
            }
            
            //update cart vao session
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("shopping.jsp").forward(request, response);
        } catch (Exception e) {
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
