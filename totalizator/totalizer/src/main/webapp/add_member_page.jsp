<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="<c:url value="styles/styles.css" />" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value="styles/form.css" />" />
    <script src="<c:url value="javascript/load_data.js" />"></script>
    <title>Totalizator</title>
</head>
<body>
<div class="container">
    <%@ include file="parts/header.jsp" %>
    <div class="main">
        <%@ include file="parts/left_menu.jsp" %>

        <div class="center-part">
            <div class="form" style="width: 600px;">
                <form class="form" method="post" onsubmit="" action="main?command=addMember" charset="UTF-8">
                    <div class="header-div">
                        <p class="form-header"><fmt:message bundle="${loc}" key="link.addMember"/></p>
                    </div>
                    <c:if test="${!empty success}">
                        <div class="success-div">
                                ${success}
                        </div>
                    </c:if>
                    <c:if test="${!empty error}">
                        <div class="error-div">
                                ${error}
                        </div>
                    </c:if>
                    <div class="input-div">
                        <label><fmt:message bundle="${loc}" key="label.category" /></label>
                        <select id="category-select" name="category-id" onchange="setLeaguesSelect()" required>
                            <option value="0" selected>
                                <fmt:message bundle="${loc}" key="label.select-category" />
                            </option>
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-div">
                        <label><fmt:message bundle="${loc}" key="label.league" /></label>
                        <select id="league-select" name="league-id" required >
                            <option selected><fmt:message bundle="${loc}" key="label.select-league" /></option>
                            <c:forEach var="league" items="${leagues}">
                                <option value="${league.id}">${league.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="input-div">
                        <label><fmt:message bundle="${loc}" key="label.name" /></label>
                        <input type="text" name="name" required />
                    </div>

                    <div class="btn-container">
                        <button class="button" type="submit">
                            <fmt:message bundle="${loc}" key="link.addMember"/>
                        </button>
                    </div>
                </form>
            </div>
        </div>

    </div>
    <%@ include file="parts/footer.jsp" %>
</div>
</body>
</html>
