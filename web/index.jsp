<%@ include file="cabecalho.jsp"%>
        <title>Laborat�rio de programa��o de sistemas web</title>
    </head>
    <body>
        <%@ page session = "false" %>
        <div>
        <div class="container-fluid bg-3 text-center">
         <% // inicia scriptlet                                                                                     
         String erro = (String)request.getAttribute( "erro_login" );                                                        
         if ( erro != null )                                  
         {                                                    
         %>
         <h1><%=erro%></h1>
         <% } %>
         <form action="Controller" method="post"><br>
             <h1>Lab Web</h1>
             <div class="form-group">
                <label>Usu�rio</label>
                <input class="form-control" type="text" name="usuario" placeholder="Digite o usu�rio"/><br><br>
             </div>
              <div class="form-group">
                <label>Senha</label>
                <input class="form-control" type="password" name="senha" placeholder="Digite a senha" /><br><br>
              </div>
                <button class="btn btn-primary" type="submit" name="codigo_op" value="-1">Enviar</button>
          <form>
              <br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      