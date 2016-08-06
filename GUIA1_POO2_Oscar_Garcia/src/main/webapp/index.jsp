<%-- 
    Document   : index
    Created on : 04-ago-2016, 19:27:09
    Author     : oscar
--%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.lowagie.text.html.HtmlTags"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.sv.udb.controlador.UnidOrgaCtrl"%>
<%@page import="com.sv.udb.controlador.PersCtrl"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
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
                                            <li class="tabs-title"><a href="#panel2">Visitas de Personas</a></li>
                                            <li class="tabs-title"><a href="#panel3">Visitas de unidad organizativa segun fecha</a></li>
                                        </ul>
                                        <div class="tabs-content" data-tabs-content="contenido-tabla">
                                            <div class="tabs-panel is-active" id="panel1">
                                                <div class="row">
                                                    <div class="large-9 column">
                                                        <jsp:useBean id="beanUnidOrgnCtrl" class="com.sv.udb.controlador.UnidOrgaCtrl" scope="page"/>
                                                        <label>Selecciona la unidas organizativa
                                                            <select id="cbb1">
                                                                <c:forEach items="${beanUnidOrgnCtrl.consTodo()}" var="fila">
                                                                    <option value="${fila.codiUnidOrga}">${fila.nombUnidOrga}</option>
                                                                </c:forEach>                                                                
                                                            </select>
                                                        </label>
                                                    </div>
                                                    <div class="large-3 column">
                                                        <label style="color:white">s</label>
                                                        <button id="boton1" type="button" class="success button">Buscar</button>
                                                    </div>
                                                </div>
                                                <div class="row" id="tabla1">

                                                </div>
                                            </div>
                                            <div class="tabs-panel" id="panel2">
                                                <div class="row">
                                                    <div class="large-9 column">
                                                        <jsp:useBean id="beanPersCtrl" class="com.sv.udb.controlador.PersCtrl" scope="page"/>
                                                        <label>Selecciona una Persona
                                                            <select id="cbb2">
                                                                <c:forEach items="${beanPersCtrl.consTodo()}" var="fila2">
                                                                    <option value="${fila2.codiPers}">${fila2.nombPers} ${fila2.apelPers}</option>
                                                                </c:forEach>                                                                
                                                            </select>
                                                        </label>
                                                    </div>
                                                    <div class="large-3 column">
                                                        <label style="color:white">s</label>
                                                        <button id="boton2" type="button" class="success button">Buscar</button>
                                                    </div>
                                                </div>
                                                <div class="row" id="tabla2">

                                                </div>
                                            </div>
                                            <div class="tabs-panel" id="panel3">
                                                <div class="row">
                                                    <div class="large-9 column">
                                                        <label>Selecciona el rango de fechas </label>                                              
                                                            <div class="large-5 column">
                                                                <input type="date" id="fecha1">
                                                            </div>
                                                            <div class="large-5 column">
                                                                <input type="date" id="fecha2">
                                                            </div>                                                        
                                                    </div>
                                                    <div class="large-3 column">
                                                        <label style="color:white">s</label>
                                                        <button id="boton3" type="button" class="success button">Buscar</button>
                                                    </div>
                                                </div>
                                                <div class="row" id="tabla3">

                                                </div>
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
        <script src="js/vendor/jquery-dateFormat.js"></script>
        <script src="js/app.js"></script>
        <script type=text/javascript>
            $('document').ready(function ()
            {
                $("#boton1").click(function () {
                    $id = $("#cbb1").val();
                    $("#tabla1").empty();
                    $("#tabla1").append('<div><object data="reporte1?txt=' + $id + '" type="application/pdf" width="100%" height="100%"></object></div>');
                    $("#tabla1").append('<a href="reporte1?txt=' + $id + '" target="_blank">Ver en pestaña nueva</a>');
                });
                $("#boton2").click(function () {
                    $id = $("#cbb2").val();
                    $("#tabla2").empty();
                    $("#tabla2").append('<div><object data="reporte1?persona=' + $id + '" type="application/pdf" width="100%" height="100%"></object></div>');
                    $("#tabla2").append('<a href="reporte1?persona=' + $id + '" target="_blank">Ver en pestaña nueva</a>');
                });
                $("#boton3").click(function () {
                    $id = $("#cbb2").val();
                    $fechas1 = $.format.date($("#fecha1").val(), "yyyy/MM/dd");
                    $fechas2 = $.format.date($("#fecha2").val(), "yyyy/MM/dd");
                    $("#tabla3").empty();
                    $("#tabla3").append('<div><object data="reporte1?fecha1=' + $fechas1 + '&fecha2='+ $fechas2 +'" type="application/pdf" width="100%" height="100%"></object></div>');
                    $("#tabla3").append('<a href="reporte1?fecha1=' + $fechas1 + '&fecha2='+ $fechas2 +'" target="_blank">Ver en pestaña nueva</a>');
                });
            });
        </script>
    </body>
</html>
