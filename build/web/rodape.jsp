<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
    
    <p> IP: <%= request.getRemoteAddr() %> </p>
    <p> Data: <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>  </p>
    </div>
    </body>
</html>
