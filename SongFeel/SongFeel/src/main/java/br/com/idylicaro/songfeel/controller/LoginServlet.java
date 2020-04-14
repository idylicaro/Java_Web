package br.com.idylicaro.songfeel.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina;
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        if (email.equals("idylicaro.se@hotmail.com") && senha.equals("1234")){
            pagina = "/myaccount.jsp";
        }else{
            request.setAttribute("erroSTR","Email / Senha não encontrados!");
            pagina = "/error.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina) ;
        dispatcher.forward(request,response);
    }
}
