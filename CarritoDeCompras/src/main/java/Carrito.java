/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beltr
 */
public class Carrito extends HttpServlet {

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
            
            HttpSession Sesion = request.getSession(true);
            Sesion.setAttribute("BasComS", ((Sesion.getAttribute("BasComS")!=null)? (Integer)Sesion.getAttribute("BasComS") : 0 ) + Integer.parseInt(request.getParameter("BasComH")) );
            Sesion.setAttribute("RinComS", ((Sesion.getAttribute("RinComS")!=null)? (Integer)Sesion.getAttribute("RinComS") : 0 ) + Integer.parseInt(request.getParameter("RinComH")) );
            Sesion.setAttribute("CarComS", ((Sesion.getAttribute("CarComS")!=null)? (Integer)Sesion.getAttribute("CarComS") : 0 ) + Integer.parseInt(request.getParameter("CarComH")) );
            Sesion.setAttribute("PagComS", ((Sesion.getAttribute("PagComS")!=null)? (Integer)Sesion.getAttribute("PagComS") : 0 ) + Integer.parseInt(request.getParameter("PagComH")) );
            Sesion.setAttribute("CalComS", ((Sesion.getAttribute("CalComS")!=null)? (Integer)Sesion.getAttribute("CalComS") : 0 ) + Integer.parseInt(request.getParameter("CalComH")) );
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Carrito</title>");            
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Carrito</h1>");
                    out.println("<table border=\"1\">");
                        out.println("<tr align=\"center\">");
                            out.println("<th>Articulo</th>");
                            out.println("<th>Adquiridos en Total</th>");
                            out.println("<th>Precio Unitario</th>");
                            out.println("<th>Total por Articulos</th>");
                        out.println("</tr>");
                        int Tot = 0;
                        if((Integer)Sesion.getAttribute("BasComS") != 0)
                        {
                            out.println("<tr align=\"center\">");
                                out.println("<td>Basura</td>");
                                out.println("<td>"+(Integer)Sesion.getAttribute("BasComS")+"</td>");
                                out.println("<td>1000</td>");
                                int BasTot = (Integer)Sesion.getAttribute("BasComS")*1000;
                                out.println("<td>"+BasTot+"</td>");
                                Tot = Tot + BasTot;
                            out.println("</tr>");
                        }
                        if((Integer)Sesion.getAttribute("RinComS") != 0)
                        {
                            out.println("<tr align=\"center\">");
                                out.println("<td>Riñones (pares)</td>");
                                out.println("<td>"+(Integer)Sesion.getAttribute("RinComS")+"</td>");
                                out.println("<td>20</td>");
                                int RinTot = (Integer)Sesion.getAttribute("RinComS")*20;
                                out.println("<td>"+RinTot+"</td>");
                                Tot = Tot + RinTot;
                            out.println("</tr>");
                        }
                        if((Integer)Sesion.getAttribute("CarComS") != 0)
                        {
                            out.println("<tr align=\"center\">");
                                out.println("<td>Carritos</td>");
                                out.println("<td>"+(Integer)Sesion.getAttribute("CarComS")+"</td>");
                                out.println("<td>150</td>");
                                int CarTot = (Integer)Sesion.getAttribute("CarComS")*150;
                                out.println("<td>"+CarTot+"</td>");
                                Tot = Tot + CarTot;
                            out.println("</tr>");
                        }
                        if((Integer)Sesion.getAttribute("PagComS") != 0)
                        {
                            out.println("<tr align=\"center\">");
                                out.println("<td>Paginas</td>");
                                out.println("<td>"+(Integer)Sesion.getAttribute("PagComS")+"</td>");
                                out.println("<td>1</td>");
                                int PagTot = (Integer)Sesion.getAttribute("PagComS")*1;
                                out.println("<td>"+PagTot+"</td>");
                                Tot = Tot + PagTot;
                            out.println("</tr>");
                        }
                        if((Integer)Sesion.getAttribute("CalComS") != 0)
                        {
                            out.println("<tr align=\"center\">");
                                out.println("<td>Calificacion</td>");
                                out.println("<td>"+(Integer)Sesion.getAttribute("CalComS")+"</td>");
                                out.println("<td>10000</td>");
                                int CalTot = (Integer)Sesion.getAttribute("CalComS")*10000;
                                out.println("<td>"+CalTot+"</td>");
                                Tot = Tot + CalTot;
                            out.println("</tr>");
                        }
                        out.println("<tr align=\"center\">");
                            out.println("<th><a href=\"http://localhost:8082/CarritoDeCompras\">Seguir Comprando</a></th>");
                            out.println("<th></th>");
                            out.println("<th>Precio Total =></th>");
                            out.println("<th>"+Tot+"</th>");
                        out.println("</tr>");
                    out.println("</table>");
                out.println("</body>");
            out.println("</html>");
            out.println("");
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
