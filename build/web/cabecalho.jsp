<%-- 
    Document   : cabecalho
    Created on : Sep 6, 2018, 9:21:13 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
    <p> Data: <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>  </p>
    <p> IP: <%= request.getRemoteAddr() %> </p>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
