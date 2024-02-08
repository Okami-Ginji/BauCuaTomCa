/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bet;
import model.Roll;
import dao.DBContext;

/**
 *
 * @author Administrator
 */
public class Respone extends HttpServlet {
    protected  List<Integer> moneyDefault = new ArrayList<>();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Respone</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Respone at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        moneyDefault = checkResult(request, response, moneyDefault);
        request.setAttribute("moneyResult", moneyDefault);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private List<Integer> checkResult(HttpServletRequest request, HttpServletResponse response,List<Integer> moneyDefault)
    throws ServletException, IOException{   
        if(moneyDefault.isEmpty()) {
            moneyDefault.add(1000000);
        }  
        Roll list = DBContext.listAll();
//        try{
            String[] choice =  request.getParameterValues("choice");
            String[] money = request.getParameterValues("money");
   
            int result = moneyDefault.get(moneyDefault.size()-1);
            //Bet bet = new Bet(choice, money);
            for(int i=0; i < money.length;i++) {
                int count =0;
                if(choice[i].equalsIgnoreCase(list.getRoll1())){
                    result+= Integer.parseInt(money[i]);
                    count++;
                }
                if(choice[i].equalsIgnoreCase(list.getRoll2())){
                    result+= Integer.parseInt(money[i]);
                    count++;
                }
                if(choice[i].equalsIgnoreCase(list.getRoll3())){
                    result+= Integer.parseInt(money[i]);
                    count++;
                }
                else if(count == 0){
                    result -= Integer.parseInt(money[i]);
                }
            } 
            moneyDefault.add(result);
//        } catch(Exception e){
//            return moneyDefault; 
//        }
//            request.setAttribute("count", count);
//            choice
//            money = 0;
//            count = 0;
            return moneyDefault; 
//        }
//        catch(Exception e){
//            return moneyDefault; 
//        }
        
    }
}
