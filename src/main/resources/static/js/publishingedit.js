$("#save").click(function () {
    var adata = {
        "id": $("td[ name='id' ]").attr("value"),
        "email": $("input[ name='email' ]").val(),
        "name": $("input[ name='name' ]").val(),
        "phone": $("input[ name='phone' ]").val(),
        "location": $("input[ name='location' ]").val(),
        "place": $("input[ name='place' ]").val()
    }
    var data = JSON.stringify(adata)
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/publishing/update",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (data) {
            if (data == 'success') alert("保存成功")
        },
        error: function () {
            alert("保存失败")
        }
    })
})