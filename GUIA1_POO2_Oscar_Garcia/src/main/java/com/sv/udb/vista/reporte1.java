/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.sv.udb.recursos.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sv.udb.controlador.PersCtrl;
import com.sv.udb.modelo.Pers;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
@WebServlet(name = "reporte1", urlPatterns = {"/reporte1"})
public class reporte1 extends HttpServlet {

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
        Connection cn = new Conexion().getConn();
        if (request.getParameter("txt") != null) {
            try {
                File reportfile = new File(this.getClass().getClassLoader().getResource("Visitas.jasper").getPath());

                Map<String, Object> parameters = new HashMap<String, Object>();

                String valor = request.getParameter("txt");
                parameters.put("Codigo_Visita", valor);
//            String ba = JasperRunManager.runReportToHtmlFile(reportfile.getPath(), parameters, cn);
//            File reportHtmlFile = new File(ba);
//            FileInputStream fis = new FileInputStream(reportHtmlFile);
//            byte[] bytes = new byte[(int) reportHtmlFile.length()];
//            fis.read(bytes);
//            response.setHeader("Content-Disposition", "inline; filename=myReport.html");
//            response.setContentType("text/html");
//            response.setContentLength(bytes.length);
//            ServletOutputStream outputstream = response.getOutputStream();
//            outputstream.write(bytes, 0, bytes.length);
//            outputstream.flush();
//            outputstream.close();
                byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameters, cn);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputstream = response.getOutputStream();
                outputstream.write(bytes, 0, bytes.length);

                outputstream.flush();
                outputstream.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (cn != null) {
                    try {
                        if (cn.isClosed()) {
                            cn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (request.getParameter("persona") != null) {
            try {
                File reportfile = new File(this.getClass().getClassLoader().getResource("Personas.jasper").getPath());

                Map<String, Object> parameters = new HashMap<String, Object>();

                String valor = request.getParameter("persona");
                parameters.put("Persona", valor);
//            String ba = JasperRunManager.runReportToHtmlFile(reportfile.getPath(), parameters, cn);
//            File reportHtmlFile = new File(ba);
//            FileInputStream fis = new FileInputStream(reportHtmlFile);
//            byte[] bytes = new byte[(int) reportHtmlFile.length()];
//            fis.read(bytes);
//            response.setHeader("Content-Disposition", "inline; filename=myReport.html");
//            response.setContentType("text/html");
//            response.setContentLength(bytes.length);
//            ServletOutputStream outputstream = response.getOutputStream();
//            outputstream.write(bytes, 0, bytes.length);
//            outputstream.flush();
//            outputstream.close();
                byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameters, cn);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputstream = response.getOutputStream();
                outputstream.write(bytes, 0, bytes.length);

                outputstream.flush();
                outputstream.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (cn != null) {
                    try {
                        if (cn.isClosed()) {
                            cn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (request.getParameter("fecha1") != null && request.getParameter("fecha2") != null) {
            try {
                File reportfile = new File(this.getClass().getClassLoader().getResource("Fechas.jasper").getPath());

                Map<String, Object> parameters = new HashMap<String, Object>();

                String valor = request.getParameter("fecha1");
                String valor2 = request.getParameter("fecha2");
                parameters.put("Fecha1", valor);
                parameters.put("Fecha2", valor2);
//            String ba = JasperRunManager.runReportToHtmlFile(reportfile.getPath(), parameters, cn);
//            File reportHtmlFile = new File(ba);
//            FileInputStream fis = new FileInputStream(reportHtmlFile);
//            byte[] bytes = new byte[(int) reportHtmlFile.length()];
//            fis.read(bytes);
//            response.setHeader("Content-Disposition", "inline; filename=myReport.html");
//            response.setContentType("text/html");
//            response.setContentLength(bytes.length);
//            ServletOutputStream outputstream = response.getOutputStream();
//            outputstream.write(bytes, 0, bytes.length);
//            outputstream.flush();
//            outputstream.close();
                byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameters, cn);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputstream = response.getOutputStream();
                outputstream.write(bytes, 0, bytes.length);

                outputstream.flush();
                outputstream.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (cn != null) {
                    try {
                        if (cn.isClosed()) {
                            cn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            if (request.getParameter("text") != null) {
                try {
                    Document documento = new Document();
                    PdfWriter.getInstance(documento, response.getOutputStream()).setInitialLeading(20);
                    documento.open();

                    documento.add(new Paragraph("Registro de Personas",
                            FontFactory.getFont("arial", // fuente
                                    22, // tamaño
                                    Font.ITALIC, // estilo
                                    BaseColor.BLACK)));             // color
                    documento.add(new Phrase(Chunk.NEWLINE));

                    PdfPTable tabla = new PdfPTable(3);
                    tabla.addCell("Código Persona");
                        tabla.addCell("Nombre");
                        tabla.addCell("Apellido");
                    for (Pers temp : new PersCtrl().consTodo()) {
                        tabla.addCell(String.valueOf(temp.getCodiPers()));
                        tabla.addCell(temp.getNombPers());
                        tabla.addCell(temp.getApelPers());
                    }
                    documento.add(tabla);
                    documento.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    if (cn != null) {
                        try {
                            if (cn.isClosed()) {
                                cn.close();
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
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
