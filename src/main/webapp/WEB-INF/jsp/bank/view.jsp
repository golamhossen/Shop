<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>  


<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-10">
            <table class="table" border="1" width="45" cellspacing="1">
                <thead>
                    <tr class="table">
                        <th>Id</th>
                        <th>Product Name</th>
                        <th>Product Code</th>
                        <th>Category Id</th>
                        <th>Category Name</th>
                        <th>Specification</th>
                        <th>Description</th>
                        <th>Price</th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pp" items="${map.pList}">
                        <tr >
                            <td>${pp.id}</td>
                            <td>${pp.name}</td>
                            <td>${pp.code}</td>
                            <td>${pp.cid}</td>
                            <td>${pp.cname}</td>
                            <td>${pp.sp}</td>
                            <td>${pp.des}</td>
                            <td>${pp.price}</td>
                            <td> 
                                <img src="/resources/home/img/${pp.photo}" alt="photo"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>


        <h1 class="text-center">View Bank</h1> <br>
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
