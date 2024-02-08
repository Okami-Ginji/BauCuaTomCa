/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public class TaiXiuServlet extends HttpServlet {
    
   
    public List<String> listRan = new ArrayList<>();   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TaiXiuServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TaiXiuServlet at " + request.getContextPath () + "</h1>");
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
        randomRoll(request, response);
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
  
    }
    
    private void checkResult(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{       
//          if(moneyDefault.isEmpty()) {
//            moneyDefault.add(1000.0);
//        }  
//        String choice = request.getParameter("choice");
//        int money = Integer.parseInt(request.getParameter("money"));
//        int count =0;
//        Bet bet = new Bet(choice, money);
//        for(String x: TaiXiuServlet.) {
//            if(x.equalsIgnoreCase(choice)) {
//                count++;              
//            }
//        }
//        if(count != 0) {
//            moneyDefault.add(moneyDefault.get(moneyDefault.size()-1)+(count*money));
//        }
//        if(count == 0){
//            double moneyCal = (double)moneyDefault.get(moneyDefault.size()-1)- money;
//            moneyDefault.add(moneyCal);
//        }       
//        request.setAttribute("count", count);
//        money = 0;
//        count = 0;
//        return moneyDefault;
    }
    private void randomRoll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listRan.clear();
        Random random = new Random();
        for(int i = 0;i<3;i++) {
            int number = random.nextInt(6)+1;
            listRan.add(ranString(number));
        }
        request.setAttribute("listRan", listRan);
        try{
            if(listRan !=null){
                Roll roll = new Roll(listRan.get(0), listRan.get(1), listRan.get(2));
            DBContext.insert(roll);
            }
            
        } catch(NumberFormatException e){}
    }
    private String ranString(int number){
        switch (number) {
            case 1: {
                return "nai";
            }
            case 2: {
                return "bau";
            }
            case 3: {
                return "ga";
            }
            case 4: {
                return "ca";
            }
            case 5: {
                return "cua";
            }
            case 6: {
                return "tom";
            }
        }
        return "null";
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
