<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>      
<h1 class="text-center">Create Product</h1> <br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">


        </div>
        <div class="col-md-8">

            <form action="/production/store" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label  class="col-form-label">Product Name</label>
                    <input name="name" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label  class="col-form-label">Product Code</label>
                    <input name="code" type="text" class="form-control">
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
                    <label  class="col-form-label">Product Specification</label>
                    <input name="sp" type="text" class="form-control">
                </div>



                <div class="form-group">
                    <label  class="col-form-label">Product Description</label>
                    <input name="des" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label  class="col-form-label">Product Price</label>
                    <input name="price" type="text" class="form-control">
                </div>

                <div class="form-group">
                    <label  class="col-form-label">Choose Photo</label>
                    <input name="photo" type="file" class="form-control">
                </div>
                <div class="form-group">
                    <label  class="col-form-label">Product Discount</label>
                    <input name="discount" type="text" class="form-control">
                </div>
                <div class="form-group">   
                    <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                </div>
        </div>
        </form>

    </div>
    <div class="col-md-2">


    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

