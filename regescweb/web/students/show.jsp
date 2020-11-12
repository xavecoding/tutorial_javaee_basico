<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="_header.jsp" />

<h1>Cadastrado com Sucesso!</h1>

Id: ${student.id} <br/>
Nome: ${student.name} <br/>
Idade: ${student.age}

<jsp:include page="_footer.jsp" />