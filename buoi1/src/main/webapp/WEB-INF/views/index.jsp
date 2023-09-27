<!doctype html>
<html lang="en">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="get" action="/giang-vien/hien-thi/search">
     <label>search <input  name="ten"/></label>
    <button type="submit">tim kiem</button>
</form>
<button><a href="/giang-vien/hien-thi/add">add</a></button>
        <table>
            <tr>
                <td>ma</td>
                <td>ten</td>
                <td>tuoi</td>
                <td>gioi tinh</td>
                <td>dia chi</td>
                <td>action</td>
            </tr>
            <tbody>
              <c:forEach items="${giangvien}" var="gv">
                 <tr>
                     <td>${gv.ma}</td>
                     <td>${gv.ten}</td>
                     <td>${gv.tuoi}</td>
                     <td>${gv.gioiTinh}</td>
                     <td>${gv.diaChi}</td>
                     <td>
                         <button><a href="/giang-vien/hien-thi/detail/${gv.id}">detail</a></button>
                         <button><a href="/giang-vien/hien-thi/delete/${gv.id}">delete</a></button>
                         <button><a href="/giang-vien/hien-thi/update/${gv.id}">update</a></button>
                     </td>
                 </tr>
              </c:forEach>
            </tbody>
        </table>
</body>
</html>