<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>      
<h1 class="text-center">Add Merchant</h1> <br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">

            <form action="/marchent/save" method="POST">
                <div class="form-group">
                    <label  class="col-form-label">Name</label>
                    <input name="name" type="text" class="form-control">
                </div>



                <div class="form-group">
                    <label  class="col-form-label">Category</label>
                    <select name="cid" class="form-control">
                        <c:forEach var="c" items="${map.cList}">
                            <option value="${c.id}">${c.name}</option> 
                        </c:forEach> 
                    </select>
                </div>
                <div class="form-group">
                    <label  class="col-form-label">Address</label>
                    <input name="address" type="text" class="form-control">
                </div>

                <div class="form-group">
                    <label  class="col-form-label">Email</label>
                    <input name="email" type="text" class="form-control">
                </div>

                <div class="form-group">
                    <label  class="col-form-label">Password</label>
                    <input name="password" type="text" class="form-control">
                </div>
        

        <div class="form-group">   
            <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
        </div>
   </div>
        <div class="col-md-2">
        </div>
        </form>
    </div>
</div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

