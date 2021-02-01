<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>     

        <h1 class="text-center">View Customer</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-10">
                    <table class="table" border="1" width="45" cellspacing="1">
                        <thead>
                            <tr class="table">
                                <th>Id</th>
                                <th>Country Id</th>
                                <th>Country</th>
                                <th>City Id</th>
                                <th>City</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>Age</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="c" items="${map.cList}">
                                <tr >
                                    <td>${c.id}</td>
                                    <td>${c.cid}</td>
                                    <td>${c.cname}</td>
                                    <td>${c.cityId}</td>
                                    <td>${c.cityName}</td>
                                    <td>${c.name}</td>
                                    <td>${c.gender}</td>
                                    <td>${c.age}</td>
                                    <td>${c.address}</td>
                                    <td>${c.email}</td>
                                    <td>${c.password}</td>
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

