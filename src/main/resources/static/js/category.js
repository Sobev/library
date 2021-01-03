$("#addNew").click(function () {
    document.getElementById("pop").style.display = 'block';
    document.getElementById("pop").scrollIntoView()
})

$("#cancel").click(function () {
    document.body.style.backgroundColor = "#ffffff"
    document.getElementById("pop").style.display = 'none';
})
$("#confirm").click(function () {
    var adata = {
        "readerCategoryId": $("input[ name='readercategoryid' ]").val(),
        "num": $("input[ name='num' ]").val(),
        "borrowDate": $("input[ name='borrowDate' ]").val(),
        "keepDate": $("input[ name='keepDate' ]").val(),
        "authority": $("input[ name='authority' ]").val(),
    }
    var data = JSON.stringify(adata);
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/category/save",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            alert(message)
        },
        error: function () {
            alert("保存失败")
        }
    })
})