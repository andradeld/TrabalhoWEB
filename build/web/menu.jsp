<%@page import="UFJF.listener"%>
<%@ include file="cabecalho.jsp"%>
<jsp:useBean id = "anuncios" scope = "session" class = "UFJF.anuncios"/>
        <title>Menu</title>
        <meta http-equiv="REFRESH" content="15;url=menu.jsp">
        <%-- atualiza anúncio --%>
        <% anuncios.nextAd(); %>
    </head>
    <body>
        <div>
           <div class="container-fluid bg-1 text-center">
            <p>Bem vindo</p>
            <p> Usuários logados: <%= listener.getNumeroUsuarios() %></p>
            <form action="Controller" method="post">
                <button class="btn btn-default" type="submit" name="codigo_op" value="1"> Listar usuários </button>
            </form>
            <br><br>
            <form action="Controller" method="post">
                <button class="btn btn-default" type="submit" name="codigo_op" value="0"> Sair </button>
            </form>
            <br>
            <center>
            <p><a href = "<jsp:getProperty name = "anuncios" property = "link" />" target="_blank">
            <img src = "<jsp:getProperty name = "anuncios" property = "image" />" alt = "advertisement" height="240"/></a></p>
            </center>
<%@ include file="rodape.jsp"%>
</div>