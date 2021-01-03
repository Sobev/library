$("#save").click(function () {
    var adata = {
        "cardId": $("td[ name='cardId' ]").attr("value"),
        "status": $("input[ name='status' ]").val(),
        "borrowNum": $("input[ name='borrowNum' ]").val(),
        "phone": $("input[ name='phone' ]").val(),
        "location": $("input[ name='location' ]").val(),
        "pwd": $("input[ name='pwd' ]").val()
    }
    var data = JSON.stringify(adata)
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/reader/update",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            if (message == 'success') alert("保存成功")
        },
        error: function () {
            alert("fail")
        }
    })
})