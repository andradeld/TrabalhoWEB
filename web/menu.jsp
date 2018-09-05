<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
         <% // inicia scriptlet                                                                                                                                             
         if ( session.getAttribute("login") == null )                                  
         {
             request.setAttribute("erro_login", "Nao logado");
             request.getRequestDispatcher("index.jsp").forward(request, response);
          }
         else {%>
            <p>Bem vindo</p>
            <form action="servletLista" method="post">
                <button type="submit">Listar usuários</button>
            </form>
            <br><br>
            <form action="Invalida" method="post">
                <input type="submit" value="Sair" />
            </form>
         <% } %>
        </div>
    </body>
</html>
