<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
<div class="container-fluid">
    <div>

    </div>
    <div class="row">

        <div class="col-md-3"></div>
        <div class="col-md-6">
            <h1>Add Terms and Conditions</h1>
            <form action="/tac/store" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label  class="col-form-label">Title</label>
                    <input name="title" type="text" class="form-control">
                </div>

                <div class="form-group">
                    <label  class="col-form-label">Choose Photo</label>
                    <input name="files" type="file" class="form-control">
                </div>
                <div class="form-group">   
                    <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                </div>
            </form>
        </div>

        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>
