<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/> 


<h1>Customer Feedback</h1>
<div class="col-md-10">
    <table class="table" border="1" width="45" cellspacing="1">
        <thead>
            <tr class="table">
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Subject</th>
                <th>Message</th>




            </tr>
        </thead>
        <tbody>
            <c:forEach var="pp" items="${map.conList}">
                <tr >
                    <td>${pp.id}</td>
                    <td>${pp.name}</td>
                    <td>${pp.email}</td>
                    <td>${pp.subject}</td>
                    <td>${pp.message}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>