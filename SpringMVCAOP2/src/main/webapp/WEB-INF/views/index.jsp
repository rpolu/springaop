<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=iso-8859-9" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>
<div class="col-md-4" style="margin: 20px">

    <form role="form" method="post" action="./articleAdd">
        <div class="form-group">
            <label for="exampleInputEmail11">Title</label>
            <input name="title" type="text" class="form-control" id="exampleInputEmail11" placeholder="Title">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail12">Author</label>
            <input name="author" type="text" class="form-control" id="exampleInputEmail12" placeholder="Author">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail13">Category</label>
            <input name="category" type="text" class="form-control" id="exampleInputEmail13" placeholder="category">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail14">Content</label>
            <input name="content" type="text" class="form-control" id="exampleInputEmail14" placeholder="Content">
        </div>

        <button style="float: right" type="submit" class="btn btn-default">Save</button>
    </form>
</div>

<div class="col-md-8">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Content</th>
        </tr>
        </thead>
        <c:forEach items="${articleList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.author}</td>
                <td>${item.category}</td>
                <td>${item.content}</td>
                <td>
                    <a href="getArticleUpdate/${item.id}" class="btn btn-info">Update</a>
                </td>
                <td>
                    <a href="articleDelete/${item.id}" type="button" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

