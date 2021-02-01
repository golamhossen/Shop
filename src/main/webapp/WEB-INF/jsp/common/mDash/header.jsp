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
                            <a href="/marchentDashboard" class="nav-item nav-link active">DashBoard</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Input Data</a>
                                <div class="dropdown-menu">

                                    <a href="/goods/create" class="dropdown-item">Add Product</a>
                                    <a href="/purchase2/create" class="dropdown-item">Add Purchase</a>

                                </div>
                            </div>
                            <a href="/orders2/view" class="nav-item nav-link">Product Request</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Show Data</a>
                                <div class="dropdown-menu">
                                    <a href="/purchase2/view" class="dropdown-item">Purchase Report</a>
                                    <a href="/stock2/view" class="dropdown-item">Stock Report</a>
                                    <a href="/invoice2/view" class="dropdown-item">Invoice Report</a>
                                    <a href="/orders2/view" class="dropdown-item">Order Report</a>
                                    <a href="/orders2/details" class="dropdown-item">Product Report</a>

                                </div>
                            </div>
                            <a href="/" class="nav-item nav-link">Logout</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

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