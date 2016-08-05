<%-- 
    Document   : index
    Created on : 04-ago-2016, 19:27:09
    Author     : oscar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.sv.udb.controlador.UnidOrgaCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Guia 1 POO2</title>
        <link rel="stylesheet" href="css/foundation.css">
        <link rel="stylesheet" href="css/app.css">
    </head>
    <body>
        <div class="row">
            <div class="large-12 column">
                <h1>Sistemas de Registro de Visitas</h1>
            </div>
        </div>
        <div class="row">
            <div class="large-12 column">
                <div class="callout">
                    <div class="row collapse">
                        <div class="medium-3 columns">
                            <ul class="tabs vertical" id="contenido" data-tabs>
                                <li class="tabs-title is-active"><a href="#panel3v" aria-selected="true">Tab 3</a></li>
                                <li class="tabs-title"><a href="#panel4v">Tab 4</a></li>
                            </ul>
                        </div>
                        <div class="medium-9 columns">
                            <div class="tabs-content" data-tabs-content="contenido">
                                <div class="tabs-panel" id="panel1v">
                                </div>
                                <div class="tabs-panel" id="panel2v">
                                </div>
                                <div class="tabs-panel is-active" id="panel3v">
                                    <div class="row">
                                        <div class="large-12 column " style="border-top-left-radius: 15px;border-top-right-radius: 15px ;background-color: rgba(235,235,235,1)">
                                            <strong>Administración</strong>
                                        </div>                                        
                                    </div>
                                    <div class="row">
                                        <ul class="tabs" data-tabs id="contenido-tabla">
                                            <li class="tabs-title is-active"><a href="#panel1" aria-selected="true">Visitas Unidades Organizativas</a></li>
                                            <li class="tabs-title"><a href="#panel2">Tab 2</a></li>
                                        </ul>
                                        <div class="tabs-content" data-tabs-content="contenido-tabla">
                                            <div class="tabs-panel is-active" id="panel1">
                                                <div class="row">
                                                    <div class="large-9 column">
                                                        <jsp:useBean id="beanUnidOrgnCtrl" class="com.sv.udb.controlador.UnidOrgaCtrl" scope="page"/>
                                                        <label>Selecciona la unidas organizativa
                                                            <select>
                                                                <c:forEach items="${beanUnidOrgnCtrl.consTodo()}" var="fila">
                                                                    <option value="${fila.codiUnidOrga}">${fila.nombUnidOrga}</option>
                                                                </c:forEach>                                                                
                                                            </select>
                                                        </label>
                                                    </div>
                                                    <div class="large-3 column">
                                                        <label style="color:white">s</label>
                                                        <button type="button" class="success button">Buscar</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tabs-panel" id="panel2">
                                                <p>Suspendisse dictum feugiat nisl ut dapibus.  Vivamus hendrerit arcu sed erat molestie vehicula. Ut in nulla enim. Phasellus molestie magna non est bibendum non venenatis nisl tempor.  Sed auctor neque eu tellus rhoncus ut eleifend nibh porttitor.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tabs-panel" id="panel4v">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                </div>
                                <div class="tabs-panel" id="panel5v">
                                </div>
                                <div class="tabs-panel" id="panel6v">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/vendor/jquery.js"></script>
        <script src="js/vendor/what-input.js"></script>
        <script src="js/vendor/foundation.js"></script>
        <script src="js/app.js"></script>
    </body>
</html>
