/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Alex
 */
public class SesionCTO extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        
        switch(accion){
            
        case("validar"):
            UsuarioDAO dao = new UsuarioDAO();
            String usuario= request.getParameter("txtUser");
            String clave= CifrarClave(request.getParameter("txtPss")+"Pitufo25.");
            UsuarioDTO dto = new UsuarioDTO(usuario, clave);
            dto = dao.ValidarSesion(dto);
            if(dto != null){
                HttpSession session = request.getSession();
                session.setAttribute("usActual", dto);
                request.getRequestDispatcher("ProductoCTO?accion=listar_datos").forward(request, response);
            }else{
                System.out.println("No valido");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            break;
            
        case("salir"):
            
            break;
        }
    }
    
    private String CifrarClave(String clave){
        String cifrado = "";
        
        try{
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.reset();
            sha256.update(clave.getBytes("utf8"));
            cifrado=Base64.getEncoder().encodeToString(sha256.digest());
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException ex){
            System.out.println("Error en cifrar " + ex.getMessage());
        }
        
        return cifrado;
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
