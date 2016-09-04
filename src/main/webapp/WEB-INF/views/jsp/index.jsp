<%--
  Created by IntelliJ IDEA.
  User: matthew
  Date: 7/25/15
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>${title}</title>
    <meta name="description" content="${description}">
    <spring:url value="resources/css/build/library/normalize.css" var="normalizeCss" />
    <link rel="stylesheet" type="text/css" href="${normalizeCss}" />
    ${headers}
  </head>
  <body>
    ${body}
  </body>
</html>
