<jsp:include page="_header.jsp" />

<h1>Cadastrar Estudante!</h1>

<form action="/regescweb/students/new" method="post">
    <div>
        <label>Nome: </label>
        <input type="text" name="name" />
    </div>
    <div>
        <label>Idade: </label>
        <input type="text" name="age" />
    </div>
    <button type="submit">Cadastrar</button>
</form>

<jsp:include page="_footer.jsp" />