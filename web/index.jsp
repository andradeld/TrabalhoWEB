<%@ include file="cabecalho.jsp"%>
        <title>Laborat�rio de programa��o de sistemas web</title>
    </head>
    <body>
        <div>
         <% // inicia scriptlet                                                                                     
         String erro = (String)request.getAttribute( "erro_login" );                                                        
         if ( erro != null )                                  
         {                                                    
         %>
         <h1><%=erro%></h1>
         <% } %>
            <form action="NewServlet" method="post">
                <label>Usu�rio:</label><br></br>
                <input type="text" name="usuario" placeholder="Digite o usu�rio" /><br>
                <label>Senha:</label><br></br>
                <input type="password" name="senha" placeholder="Digite a senha" /><br>
                <button type="submit">Envia</button>
            <form>
<%@ include file="rodape.html"%>
