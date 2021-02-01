<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/> 
        <!-- Nav Bar End -->      

        <h1 class="text-center">Create Product</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>
                <div class="col-md-10">

                    <form action="/goods/store" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label  class="col-form-label">Name</label>
                            <input name="name" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Code</label>
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
                            <label  class="col-form-label">Brand</label>
                            <select name="bid" class="form-control">
                                <c:forEach var="b" items="${map.bList}">
                                    <option value="${b.id}">${b.name}</option> 
                                </c:forEach> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Specification</label>
                            <textarea name="sp" class="form-control"></textarea>
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Description</label>
                            <textarea name="des" class="form-control"></textarea>
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Price</label>
                            <input name="price" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Choose Photo</label>
                            <input name="photo" type="file" class="form-control">
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Discount</label>
                            <input name="discount" type="text" class="form-control">
                        </div>
                        <div class="form-group">   
                            <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                        </div>
                    </form>
                    <!--                    <form action="/product/save" method="POST">
                                            Name            : <input type="text" name="name"/> <br/><br/>
                                            Code            : <input type="text" name="code"/> <br/><br/>
                                            Category Id     : <input type="text" name="cId"/> <br/><br/>
                                            Category Name   : <input type="text" name="cName"/><br/><br/> 
                                            Description     : <input type="text" name="descrption"/> <br/><br/>
                                            Cost            : <input type="text" name="cost"/> <br/><br/>
                                            Price           : <input type="text" name="price"/> <br/><br/>
                                            Discount        : <input type="text" name="discount"/> <br/><br/>
                                            Discount Price  : <input type="text" name="disPrice"/> <br/><br/>
                                            Net Price       : <input type="text" name="netPrice"/> <br/><br/>
                    
                                            <input class="btn-info" type="submit" value="save"/>
                                        </form>-->
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
