<%@ include file="cabecalho.jsp"%>
        <title>Menu</title>
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
<%@ include file="rodape.html"%>
