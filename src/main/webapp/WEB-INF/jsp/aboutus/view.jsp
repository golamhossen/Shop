<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>     

        <h1 class="text-center">View About Us</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-10">
                    <table class="table" border="1" width="45" cellspacing="1">
                        <thead>
                            <tr class="table">
                                <th>Id</th>
                                <th>Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ban" items="${map.banList}">
                                <tr >
                                    <td>${ban.id}</td>
                                    <td>${ban.name}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
