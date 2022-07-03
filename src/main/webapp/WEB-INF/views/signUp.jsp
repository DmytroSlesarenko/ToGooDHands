<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="headerNotSignedIn.jsp"%>


</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/signup" method="post" modelAttribute="user">
        <div class="signup">
            <div class="form-group">
                <form:input path="firstName" placeholder="Imię" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="lastName" placeholder="Nazwisko" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="email" placeholder="Email" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="username" placeholder="Nazwa użytkownika" required="true"/>
            </div>
            <div class="form-group">
                <form:password path="password" placeholder="Hasło" required="true"/>
            </div>
            <div class="form-group">
                <input type="password" name="password2" placeholder="Powtórz hasło" required/>
            </div>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/toGoodHands/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp"%>