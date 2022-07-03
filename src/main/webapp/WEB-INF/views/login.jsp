<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="headerNotSignedIn.jsp"%>

</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form action="/login" method="post">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email" required/>
        </div>

        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" required/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/signup" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>

</section>

<%@include file="footer.jsp"%>