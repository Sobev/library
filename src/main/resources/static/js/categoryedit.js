$("#save").click(function () {
    var adata = {
        "readerCategoryId": $("td[ name='id' ]").attr("value"),
        "num": $("input[ name='num' ]").val(),
        "borrowDate": $("input[ name='borrowDate' ]").val(),
        "keepDate": $("input[ name='keepDate' ]").val(),
        "authority": $("input[ name='authority' ]").val(),
    }
    var data = JSON.stringify(adata);
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/category/update",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            alert(message)
        },
        error: function () {
            alert("fail")
        }
    })
})