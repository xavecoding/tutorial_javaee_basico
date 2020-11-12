<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="_header.jsp" />

<h1>Gerenciamento de Estudantes</h1>

<table>
    <thead>
        <th>ID</th>
        <th>Nome</th>
        <th>Idade</th>
    </thead>
    <tbody>
        <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td> 
                <td>${student.age}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br/><br/>
<a href="students/new.jsp">Cadastrar</a>
        
<jsp:include page="_footer.jsp" />
