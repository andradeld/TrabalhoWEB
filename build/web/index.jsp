<%@ include file="cabecalho.jsp"%>
        <title>Laborat�rio de programa��o de sistemas web</title>
    </head>
    <body>
        <%@ page session = "false" %>
        <div>
         <% // inicia scriptlet                                                                                     
         String erro = (String)request.getAttribute( "erro_login" );                                                        
         if ( erro != null )                                  
         {                                                    
         %>
         <h1><%=erro%></h1>
         <% } %>
         <form action="Controller" method="post"><br>
                <label>Usu�rio:</label><br>
                <input type="text" name="usuario" placeholder="Digite o usu�rio" /><br><br>
                <label>Senha:</label><br>
                <input type="password" name="senha" placeholder="Digite a senha" /><br><br>
                <button type="submit" name="codigo_op" value="-1">Envia</button>
          <form>
<%@ include file="rodape.html"%>
