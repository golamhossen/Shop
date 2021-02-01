<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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



        <link href="https://eviewbd.com/adminlte/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://eviewbd.com/adminlte/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

        <link href="https://eviewbd.com/adminlte/css/AdminLTE.css" rel="stylesheet" type="text/css"/>







    </head>

    <body>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- Nav Bar Start -->
        <!-- Top bar Start -->
        <div class="top-bar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <i class="fa fa-envelope"></i>
                        rtrgolam@gmail.com
                    </div>
                    <div class="col-sm-6">
                        <i class="fa fa-phone-alt"></i>
                        +880-1759-734-048
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
                            <a href="/" class="nav-item nav-link active">Home</a>
                            <a href="/production/view" class="nav-item nav-link active">Products</a>
                            <a href="/production/view2" class="nav-item nav-link active">Product Detail</a>
                            <a href="/cart/view" class="nav-item nav-link active">Cart</a>
                            <a href="/checkout/create" class="nav-item nav-link active">Checkout</a>
                            <a href="/myAccount" class="nav-item nav-link active">My Account</a>
                            <a href="/merchant" class="nav-item nav-link">Merchant Products</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle active" data-toggle="dropdown">More Pages</a>
                                <div class="dropdown-menu">
                                    <a href="/wishlist" class="dropdown-item">Wishlist</a>
                                    <a href="/login2" class="dropdown-item">Login & Register</a>
                                    <a href="/contact/create" class="dropdown-item">Contact Us</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->      


        <!-- Bottom Bar Start -->
        <div class="bottom-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="">
                                <img src="/resources/home/img/logo.png" alt="Logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="search">
                            <input type="text" placeholder="Search">
                            <button><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="user">
                            <a href="/wishlist/view" class="btn wishlist">
                                <i class="fa fa-heart"></i>
                                <span>(${map.wishCount})</span>
                            </a>
                            <a href="/cart/view2" class="btn cart">
                                <i class="fa fa-shopping-cart"></i>
                                <span>(${map.count})</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bottom Bar End -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            $grey: #F5F5F5;
            $dark-grey: #323B40;

            $light-blue: #E0F5FF;
            $blue: #B9E5FE;
            $dark-blue: #00A5FA;

            $green: #B7E0DC;
            $dark-green: #019888;

            $lime: #C7E8C8;
            $dark-lime: #42B045;

            $yellow: #FFEEBA;
            $dark-yellow: #FF9901;

            $pink: #FABAD0;
            $dark-pink: #EF075F;

            $red: #FEC9C6;
            $dark-red: #FD3D08;

            @mixin color-div($color1, $color2){
                background-color: $color1;
                color: $color2;
            }

            .container {
                padding: 2rem 0rem;
            }

            h4 {
                margin: 2rem 0rem;
            }

            .panel {
                border-radius: 4px;
                padding: 1rem;
                margin-top: 0.2rem;

                @include color-div($grey, $dark-grey);

                &.panel-blue {
                    @include color-div($light-blue, $dark-blue);
                }

                &.panel-big-height{
                    min-height: 150px;
                }
            }

            .item {
                border-radius: 4px;
                padding: 0.5rem;
                margin: 0.2rem;

                &.item-blue {
                    @include color-div($blue, $dark-blue);
                }

                &.item-green {
                    @include color-div($green, $dark-green);
                }

                &.item-lime {
                    @include color-div($lime, $dark-lime);
                }

                &.item-yellow {
                    @include color-div($yellow, $dark-yellow);
                }

                &.item-pink {
                    @include color-div($pink, $dark-pink);
                }

                &.item-red {
                    @include color-div($red, $dark-red);
                }

                &.item-big-width{
                    min-width: 380px;
                }
            }
            body {
                font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif; 
            }


        </style>