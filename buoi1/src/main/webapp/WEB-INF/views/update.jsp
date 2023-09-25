<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/giang-vien/hien-thi/${gv.id}" method="post">
    <label>ma: <input name="ma" value="${gv.ma}"/></label>
    <label>ten: <input name="ten"  value="${gv.ten}"/></label>
    <label>tuoi: <input name="tuoi" value="${gv.tuoi}"/></label>
    <label>dia Chi: <input name="diaChi" value="${gv.diaChi}"/></label>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1" value="true" >
        <label class="form-check-label" for="flexRadioDefault1">
            nam
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" value="false" checked>
        <label class="form-check-label" for="flexRadioDefault2">
            nu
        </label>
    </div>
    <button type="submit">add</button>
</form>
</body>
</html>