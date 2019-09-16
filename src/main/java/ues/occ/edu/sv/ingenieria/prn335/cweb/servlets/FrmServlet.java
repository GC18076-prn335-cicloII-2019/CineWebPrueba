/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ues.occ.edu.sv.ingenieria.prn335.centities.Funcion;
import ues.occ.edu.sv.ingenieria.prn335.centities.Pelicula;
import ues.occ.edu.sv.ingenieria.prn335.centities.Sala;
import ues.occ.edu.sv.ingenieria.prn335.cweb.controller.DirectorFacadeLocal;
import ues.occ.edu.sv.ingenieria.prn335.cweb.controller.Prueba;

/**
 *
 * @author fernando
 */
@WebServlet(name = "FrmServlet", urlPatterns = {"/FrmServlet"})
public class FrmServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Inject
    private Prueba pr;

    @Inject
    private DirectorFacadeLocal dfl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            List<Sala> salasTipoAsiento = pr.tipoAsiento(request.getParameter("caracteristicaAsiento"));
            List<Funcion> funcionDirector = pr.funcionPorDirector(request.getParameter("director"));
            List<Sala> salasFuncion = Collections.emptyList();
            if (!(request.getParameter("fecha").isEmpty())) {
                salasFuncion = pr.salasPorFuncion(Date.valueOf(request.getParameter("fecha")));
            }
            List<Pelicula> tipoPelicula = pr.tipoPelicula(request.getParameter("clasificacion"), request.getParameter("genero"));
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrmServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrmServlet at " + request.getContextPath() + "</h1>");
            if (!(salasTipoAsiento.isEmpty())) {
                out.println("<table border='2'>");
                out.println("<caption>Salas segun tipo de asiento</caption>");
                out.println("<tr><th>Id_Sala</th><th>Sala</th><th>Sucursal</th><th>Direcccion</th><th>Tipo_Asiento</th><th>Descripcion_Asiento</th></tr>");
                for (int i = 0; i < salasTipoAsiento.size(); i++) {
                    out.print("<tr><td>" + String.valueOf(salasTipoAsiento.get(i).getIdSala()) + "</td>"
                            + "<td>" + salasTipoAsiento.get(i).getSala() + "</td>"
                            + "<td>" + salasTipoAsiento.get(i).getIdSucursal().getNombre() + "</td>"
                            + "<td>" + salasTipoAsiento.get(0).getIdSucursal().getDireccion() + "</td>"
                            + "<td>" + salasTipoAsiento.get(i).getAsientoSalaList().get(0).getAsiento().getAtributoAsientoList().get(0).getCaracteristicaAsiento().getCaracteristica() + "</td>"
                            + "<td>" + salasTipoAsiento.get(i).getAsientoSalaList().get(0).getAsiento().getAtributoAsientoList().get(0).getCaracteristicaAsiento().getDescripcion() + "</td></tr>");
                }
                out.println("</table>");
            }
            
            out.print("<br>");
            
            if (!(funcionDirector.isEmpty())) {
                out.println("<table border='2'>");
                out.println("<caption>Funciones segun Director</caption>");
                out.println("<tr><th>Id_Funcion</th><th>Fecha_Funcion</th><th>Pelicula</th><th>Director_Nombre</th><th>Director_Apellido</th></tr>");
                for (int i = 0; i < funcionDirector.size(); i++) {
                    out.print("<tr><td>" + funcionDirector.get(i).getIdFuncion() + "</td>"
                            + "<td>" + funcionDirector.get(i).getFecha() + "</td>"
                            + "<td>" + funcionDirector.get(i).getIdPelicula().getTitulo() + "</td>"
                            + "<td>" + funcionDirector.get(i).getIdPelicula().getIdDirector().getNombre() + "</td>"
                            + "<td>" + funcionDirector.get(i).getIdPelicula().getIdDirector().getApellido() + "</td></tr>");
                }
                out.println("</table>");
            }
            
            out.print("<br>");

            if (!(salasFuncion.isEmpty())) {
                out.println("<table border='2'>");
                out.println("<caption>Salas segun fecha de funcion</caption>");
                out.println("<tr><th>Id_Sala</th><th>Sala</th><th>Sucursal</th><th>Direcccion</th><th>Id_Funcion</th><th>Fecha_Funcion</th></tr>");
                for (int i = 0; i < salasFuncion.size(); i++) {
                    out.print("<tr><td>" + salasFuncion.get(i).getIdSala() + "</td>"
                            + "<td>" + salasFuncion.get(i).getSala() + "</td>"
                            + "<td>" + salasFuncion.get(i).getIdSucursal().getNombre() + "</td>"
                            + "<td>" + salasFuncion.get(i).getIdSucursal().getDireccion() + "</td>"
                            + "<td>" + salasFuncion.get(i).getAsientoSalaList().get(0).getBoletoList().get(0).getIdFuncion().getIdFuncion() + "</td>"
                            + "<td>" + salasFuncion.get(i).getAsientoSalaList().get(0).getBoletoList().get(0).getIdFuncion().getFecha() + "</td></tr>");
                }
                out.println("</table>");
            }
            
            out.print("<br>");

            if (!(tipoPelicula.isEmpty())) {
                out.println("<table border='2'>");
                out.println("<caption>Peliculas segun clasificacion y genero</caption>");
                out.println("<tr><th>Id_Pelicula</th><th>Pelicula</th><th>Clasificacion</th><th>Genero</th><th>Id_Funcion</th><th>Fecha_Funcion</th></tr>");
                for (int i = 0; i < tipoPelicula.size(); i++) {
                    out.print("<tr><td>" + tipoPelicula.get(i).getIdPelicula() + "</td>"
                            + "<td>" + tipoPelicula.get(i).getTitulo() + "</td>"
                            + "<td>" + tipoPelicula.get(i).getIdClasificacion().getClasificacion() + "</td>"
                            + "<td>" + tipoPelicula.get(i).getGeneroList().get(0).getNombre() + "</td></tr>");
                }
                out.println("</table>");
            }

            out.println("</body>");
            out.println("</html>");
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
