

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>     
        <h1 class="text-center">Create Purchase</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>

                <div class="col-md-10">
                    <form action="/sales/save" method="POST">

                        <div class="form-group">
                            <label  class="col-form-label">Product Name</label>
                            <select name="pid" class="form-control">
                                <c:forEach var="p" items="${map.pList}">
                                    <option value="${p.id}">${p.name}</option> 
                                </c:forEach> 
                            </select>
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Product Code</label>
                            <select name="pid" class="form-control">
                                <c:forEach var="p1" items="${map.pList}">
                                    <option value="${p1.id}">${p1.code}</option> 
                                </c:forEach> 
                            </select>
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Product Price</label>
                            <select name="pid" class="form-control">
                                <c:forEach var="p2" items="${map.pList}">
                                    <option value="${p2.id}">${p2.price}</option> 
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Purchase price</label>
                            <input id="price" name="price" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Quantity</label>
                            <input id="qty" name="qty" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Vat</label>
                            <input id="vat" name="vat" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Total Price</label>
                            <input id="totalPrice" name="totalPrice" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Total Profit</label>
                            <input id="totalPrice" name="profit" type="text" class="form-control">
                        </div>



                        <div class="form-group">   
                            <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                        </div>



                    </form>
                </div>

            </div>
        </div>
        <p>If you click on the "Hide" button, I will disappear.</p>

        <button id="hide">Hide</button>
        <button id="show">Show</button>
        <script>
            $("#vat").focusout(function () {
                var qty = $("#qty").val();
                var price = $("#price").val();
                var vat = $("#vat").val();
                var totalPrice = $("#totalPrice").val();
                var total = parseInt(price) * parseInt(qty);
                var netTotal = (parseInt(total) + (parseInt(vat) / parseInt(100)));
                $("#totalPrice").val("");
                $("#totalPrice").val(qty);
            });

            $(document).ready(function () {
                $("#hide").click(function () {
                    $("p").hide();
                });
                $("#show").click(function () {
                    $("p").show();
                });
            });
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>





<div class="form-group">   
    <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
</div>



</form>
</div>

</div>
</div>
<p>If you click on the "Hide" button, I will disappear.</p>

<button id="hide">Hide</button>
<button id="show">Show</button>
<script>
            $("#vat").focusout(function () {
                var qty = $("#qty").val();
                var price = $("#price").val();
                var vat = $("#vat").val();
                var totalPrice = $("#totalPrice").val();
                var total = parseInt(price) * parseInt(qty);
                var netTotal = (parseInt(total) + (parseInt(vat) / parseInt(100)));
                $("#totalPrice").val("");
                $("#totalPrice").val(qty);
            });

            $(document).ready(function () {
                $("#hide").click(function () {
                    $("p").hide();
                });
                $("#show").click(function () {
                    $("p").show();
                });
            });
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

