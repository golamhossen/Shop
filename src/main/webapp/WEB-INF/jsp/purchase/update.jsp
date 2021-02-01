<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#hide").click(function(){
    $("p").hide();
  });
  $("#show").click(function(){
    $("p").show();
  });
});
</script>
</head>
<body>
    //////////////////////////////////////////////
    <div class="row ml-auto">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="section-block" id="basicform">
                                        <h3 class="section-title text-center">Purchase</h3>
                                    </div>
                                    <div class="card">
                                        <div class="card-header">

                                        </div>
                                        <div class="card-body">
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <form action="/purchase/search" method="GET"> 
                                                            <input type="text" name="pId"/>
                                                            <input class="btn-info" type="submit" value="Search"/>
                                                        </form>
                                                    </div>
                                                    <div class="col-md-3"></div>
                                                    <div class="col-md-5 float-right" >
                                                        <img  src="/resources/product/img/${product.pPhoto}" width="250px" height="200px"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <form action="/purchase/save" method="POST">
                                                <div class="form-group">
                                                    <input name="pId" type="hidden" value="${product.pId}" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Name</label>
                                                    <input name="pName" type="text" value="${product.pName}" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Code</label>
                                                    <input name="pCode" type="text" value="${product.pCode}" class="form-control">
                                                </div>
                                                <div class="form-group">
<!--                                                    <label  class="col-form-label"></label>-->
                                                    <input name="cId" type="hidden" value="${product.cId}" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Category</label>
                                                    <input name="cName" type="text" value="${product.cName}" class="form-control">
                                                </div>

                                                <div>
<!--                                                    <label  class="col-form-label"></label>-->
                                                    <input name="pDesc" type="hidden"  value="${product.pDesc}" class="form-control"/>
                                                </div>
                                                <div >
<!--                                                    <label  class="col-form-label"></label>-->
                                                    <input name="pPhoto" type="hidden" value="${product.pPhoto}" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Cost</label>
                                                    <input name="pCost" id="pCost" type="number" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Quantity</label>
                                                    <input name="qty" id="qty" type="number" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Total</label>
                                                    <input name="total" id="total" type="number" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">VAT</label>
                                                    <input name="vat"id="vat" type="number" class="form-control">
                                                </div>
                                                <div class="form-group">
                                                    <label  class="col-form-label">Grand Total</label>
                                                    <input name="grandTotal" id="grandTotal" type="number" class="form-control">
                                                </div>

                                                <div class="form-group">   
                                                    <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                                ///////////////////////////////////
     <h1 class="text-center">Create Purchase</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>

                <div class="col-md-10">
                    <form action="/purchase/save" method="POST">

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


<p>If you click on the "Hide" button, I will disappear.</p>

<button id="hide">Hide</button>
<button id="show">Show</button>

</body>
</html>
