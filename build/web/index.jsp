<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Laborat�rio de programa��o de sistemas web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        </div>
    </body>
</html>
