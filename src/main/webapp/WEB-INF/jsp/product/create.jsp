<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>E Store - eCommerce HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">

        <!-- Favicon -->
        <link href="/resources/home/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="/resources/home/lib/slick/slick.css" rel="stylesheet">
        <link href="/resources/home/lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="/resources/home/css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Top bar Start -->
        <div class="top-bar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <i class="fa fa-envelope"></i>
                        support@email.com
                    </div>
                    <div class="col-sm-6">
                        <i class="fa fa-phone-alt"></i>
                        +012-345-6789
                    </div>
                </div>
            </div>
        </div>
        <!-- Top bar End -->

        <!-- Nav Bar Start -->
        <div class="nav">
            <div class="container-fluid">
                <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="" class="nav-item nav-link active">Home</a>
                            <a href="/productList" class="nav-item nav-link">Products</a>
                            <a href="/productDetails" class="nav-item nav-link">Product Detail</a>
                            <a href="/cart" class="nav-item nav-link">Cart</a>
                            <a href="/checkout" class="nav-item nav-link">Checkout</a>
                            <a href="/myAccount" class="nav-item nav-link">My Account</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                                <div class="dropdown-menu">
                                    <a href="/wishlist" class="dropdown-item">Wishlist</a>
                                    <a href="/login" class="dropdown-item">Login & Register</a>
                                    <a href="/contact" class="dropdown-item">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-nav ml-auto">
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">User Account</a>
                                <div class="dropdown-menu">
                                    <a href="/adminDashboard" class="dropdown-item">Admin DashBoard</a>
                                    <a href="/marchentDashboard" class="dropdown-item">Marchent Dashboard</a>
                                    <a href="/customerDashboard" class="dropdown-item">Customer Dashboard</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->      
        <h1 class="text-center">Create Product</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>
                <div class="col-md-10">

                    <form action="/product/save" method="POST">
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
                            <label  class="col-form-label">Product Brand</label>
                            <input name="brand" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Product Size</label>
                            <input name="size" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Product Color</label>
                            <input name="color" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label  class="col-form-label">Product Description</label>
                            <input name="desc" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label  class="col-form-label">Product Price</label>
                            <input name="price" type="text" class="form-control">
                        </div>
                </div>

                <div class="form-group">   
                    <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                </div>
                </form>

            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

