package UFJF;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controller extends HttpServlet {

    //Valida
    private void validacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("semicPU");
        EntityManager em = emf.createEntityManager();
        PesquisadorJpaController pjc = new PesquisadorJpaController(emf);
        Pesquisador encontrada = pjc.findPesquisador(241944);
        System.out.println(encontrada.getNome());
        */
        
        //daoClasse teste = new daoClasse();
        //classeUsuario u = new classeUsuario();
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemasWeb-1PU");
     //   EntityManager em = emf.createEntityManager();
        usuarioPUJpaController pjc = new usuarioPUJpaController(emf);
        
        try{
            if(request.getParameter("usuario") == null || request.getParameter("senha") == null){
                request.setAttribute("erro_login", "Usuario ou senha inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            usuarioPU u = pjc.findusuarioPU(usuario);
            //u = teste.findByUsuarioSenha(usuario, senha);
            if(u != null){
                if(u.getSenha().equals(senha)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("login", true);
                    session.setAttribute("teste", new Integer(222));
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("erro_login", "Senha errada");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("erro_login", "Usuario ou senha errados");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            //Erros do class.name
            throw new ServletException(e);
        }
    }
    
    //Invalidacao
    private void invalidacao (HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
    
    //Controller
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            int s = Integer.parseInt(request.getParameter("codigo_op"));
            switch (s){
                //Logar
                case -1:{
                    validacao(request,response);
                    break;
                }
                //Sair do sistema
                case 0:{
                    invalidacao(request,response);
                    break;
                }
                //Exibir lista de usuarios
                case 1:{
                    request.getRequestDispatcher("servletLista").forward(request, response);
                    break;
                }
                //Voltar pro menu da lista de usuarios
                case 2:{
                    response.sendRedirect("menu.jsp");
                    break;
                }
                //Opcao invalida
                default:{
                    System.out.println("Opção inválida");
                    break;
                }
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
