<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>    

    <body>
        <h1 class="text-center">Create Size</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>
                <div class="col-md-10">
                    <form action="/size/save" method="POST">
                        Name : <input type="text" name="name"/> 
                        <input class="btn-info" type="submit" value="save"/>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
