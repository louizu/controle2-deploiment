<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Affectation</title>
</head>
<body>
<h2 style="text-align: center;">Employee Affectation</h2>
<div style="text-align: center;">
    <a href="/employees">Employees</a> | <a href="/">Back to Home</a>
</div>
<hr/>
<div style="text-align: center;">
    <form action="assignEmployee" method="post">
        <label for="employeeId">Employee Name:</label>
        <select id="employeeId" name="employeeId">
            <c:forEach var="manager" items="${managers}">
                <option value="${manager.id}">${manager.name}</option>
            </c:forEach>
        </select>
        <br/><br/>
        <label for="projectId">Project Name:</label>
        <select id="projectId" name="projectId">
            <c:forEach var="project" items="${projects}">
                <option value="${project.id}">${project.name}</option>
            </c:forEach>
        </select>
        <br/><br/>
        <label for="implication">Implication (%):</label>
        <input type="number" id="implication" name="implication" step="0.01" min="0" max="100">
        <br/><br/>
        <button type="submit">Affecter Project</button>
    </form>
</div>
</body>
</html>
