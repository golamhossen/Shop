<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/home/header.jsp"/> 


<h1>Merchant View</h1>
<div class="col-md-10">
    <table class="table" border="1" width="45" cellspacing="1" id="myTable">
        <thead>
            <tr class="table">
                <th>Id</th>
                <th>Name</th>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Password</th>




            </tr>
        </thead>
        <tbody>
            <c:forEach items="${map.maList}" var="m">
                <tr >
                    <td>${m.id}</td>
                    <td>${m.name}</td>
                    <td>${m.cid}</td>
                    <td>${m.cname}</td>
                    <td>${m.address}</td>
                    <td>${m.email}</td>
                    <td>${m.password}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script>
    $('#myTable').DataTable({
        responsive: true,
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });
    $("#myTable").show();
</script>
<jsp:include page="/WEB-INF/jsp/common/home/footer.jsp"/> 
