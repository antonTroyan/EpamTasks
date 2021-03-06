<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/sloganTag.tld" prefix="slogan"%>
<footer>
    <div class="footer">
    <p><slogan:printSlogan/></p>
    </div>
    <div class="locale-div">
        <a href="<c:url value="main?command=changeLocale&locale=en" />">
            <img src="<c:url value="images/flags/united-states.png" />">
        </a>
        <a href="<c:url value="main?command=changeLocale&locale=be" />">
            <img src="<c:url value="images/flags/belarus.png" />">
        </a>
        <a href="<c:url value="main?command=changeLocale&locale=ru" />">
            <img src="<c:url value="images/flags/russia.png" />">
        </a>
    </div>
</footer>
