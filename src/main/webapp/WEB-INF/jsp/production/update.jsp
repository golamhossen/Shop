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
