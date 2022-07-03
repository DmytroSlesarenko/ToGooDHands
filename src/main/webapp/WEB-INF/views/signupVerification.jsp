<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="headerNotSignedIn.jsp"%>


</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <h3 class="error">${error}</h3>
    <form:form action="/signup" method="post" modelAttribute="user">
        <div class="form-group">
            <form:input path="firstName"/>
        </div>
        <div class="form-group">
            <form:input path="lastName"/>
        </div>
        <div class="form-group">
            <form:input path="email"/>
        </div>
        <div class="form-group">
            <form:password path="password"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/toGoodHands/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp"%>