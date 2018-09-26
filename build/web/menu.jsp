<%@page import="UFJF.listener"%>
<%@ include file="cabecalho.jsp"%>
<jsp:useBean id = "anuncios" scope = "session" class = "UFJF.anuncios"/>
        <title>Menu</title>
        <meta http-equiv="REFRESH" content="5;url=menu.jsp">
        <style type = "text/css">
         .anuncio { font-family: helvetica, arial, sans-serif;
                font-weight: bold;
                font-size: 2em }
        </style>
        <%-- atualiza anúncio --%>
        <% anuncios.nextAd(); %>
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
            <p> Usuários logados: <%= listener.getNumeroUsuarios() %></p>
            <form action="Controller" method="post">
                <button type="submit" name="codigo_op" value="1"> Listar usuários </button>
            </form>
            <br><br>
            <form action="Controller" method="post">
                <button type="submit" name="codigo_op" value="0"> Sair </button>
            </form>
            <br>
            <p class = "anuncio">Anuncio:</p>
            <p><a href = "<jsp:getProperty name = "anuncios" property = "link" />" target="_blank">
            <img src = "<jsp:getProperty name = "anuncios" property = "image" />" alt = "advertisement" />
         </a>
      </p>
         <% } %>
<%@ include file="rodape.html"%>
