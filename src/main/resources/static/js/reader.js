$("#addNew").click(function () {
    document.body.style.backgroundColor = "#696969"
    document.getElementById("pop").style.display = 'block';
})

$("#cancel").click(function () {
    document.body.style.backgroundColor = "#ffffff"
    document.getElementById("pop").style.display = 'none';
})
$("#confirm").click(function () {
    var adata = {
        "readerCategoryId": $("input[ name='readercategoryid' ]").val(),
        "status": $("input[ name='status' ]").val(),
        "borrowNum": $("input[ name='borrowNum' ]").val(),
        "phone": $("input[ name='phone']").val()
    }
    var data = JSON.stringify(adata);
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/reader/save",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (data) {
            if (data == 'success') alert("保存成功")
        },
        error: function () {
            alert("保存失败")
        }
    })
})