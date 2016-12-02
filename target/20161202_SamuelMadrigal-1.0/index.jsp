<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/etiquetas" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:set var="contexto" value="${pageContext.request.contextPath}"/>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
        <title>CRUD Inicio</title>
        <link rel="stylesheet" href="${contexto}/css/estilo.css" type="text/css"/>
    </head>
    <body>
        <div id="contPrin">
            <div id="contSecu">
                <table>
                    <tr>
                        <th>Librer&iacute;a</th>
                        <th>Prefijo</th>
                        <th>URI</th>
                    </tr>
                    <tr>
                        <td>Personalizada</td>
                        <td>s</td>
                        <td><c:out value="/WEB-INF/tlds/etiquetas.tld" /></td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <th>Significado</th>
                        <th>Etiqueta</th>
                        <th>Atributos</th>
                        <th>Requerido</th>
                        <th>Formato</th>
                        <th>Salida</th>
                    </tr>

                    <tr>
                        <td>Etiqueta que calcula la letra del DNI</td>
                        <td>letraDNI</td>
                        <td>
                            DIN&Aacute;MICO<br/>
                            <em>numero</em>
                        </td>
                        <td>
                            S&iacute;
                        </td>
                        <td class="formato">
                            <pre>
&lt;c:set var="numero" value="76263285"/>
&lt;s:letraDNI numero="\${numero}"/>
                            </pre>
                        </td>
                        <td>
                            <c:set var="numero" value="76263285"/>
                            <s:letraDNI numero="${numero}"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Etiqueta que obtiene una cabecera simple con logo, nombre y eslogan</td>
                        <td>cabecera</td>
                        <td>
                            <em>logo</em><br/>
                            <em>nombre</em><br/>
                            <em>eslogan</em>
                        </td>
                        <td>
                            S&iacute;<br/>
                            No<br/>
                            No
                        </td>
                        <td class="formato">
                            <pre>
&lt;s:cabecera logo="logo.png" eslogan=""/>
                            </pre>
                        </td>
                        <td>
                            <s:cabecera logo="logo.png" eslogan=""/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Etiqueta que realiza una operaci&oacute;n</td>
                        <td>operacion</td>
                        <td>
                            <em>val1</em><br/>
                            <em>val2</em><br/>
                            <em>operacion</em>
                        </td>
                        <td>
                            S&iacute;<br/>
                            S&iacute;<br/>
                            S&iacute;
                        </td>
                        <td class="formato">
                            <pre>
&lt;s:operacion val1="2" val2="3" operacion="sumar"/>
                            </pre>
                        </td>
                        <td>
                            <s:operacion val1="2" val2="3" operacion="sumar"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Etiqueta que calcula la longitud de un string</td>
                        <td>longitud</td>
                        <td>
                            <em>palabra</em>
                        </td>
                        <td>
                            S&iacute;
                        </td>
                        <td class="formato">
                            <pre>
&lt;s:lonqitud palabra="Hola que tal"/>
                            </pre>
                        </td>
                        <td>
                            <s:lonqitud palabra="Hola que tal"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
