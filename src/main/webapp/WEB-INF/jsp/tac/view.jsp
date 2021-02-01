<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>     


<h1 class="text-center">View Color</h1> <br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">

        </div>


        <div class="col-md-10">
            <table class="table" border="1" width="45" cellspacing="1">
                <thead>
                    <tr class="table">
                        <th>Id</th>
                        <th>Title</th>
                        <th>Files</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ban" items="${map.banList}">
                        <tr >
                            <td>${ban.id}</td>
                            <td>${ban.title}</td>
                            <td> 

                                <img src="/resources/home/img/${ban.files}" alt="files"/>

                            </td>


                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-4 py-5 container-fluid text-center">
            <c:forEach items="${map.banList}" var="b">
                <h1>${b.title}</h1>
                <iframe src="/resources/home/img/${b.files}" style="width:600px; height:500px;" frameborder="0"></iframe>
<!--                <img src="/resources/home/img/${b.files}" alt="files"/>-->
            </c:forEach>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
