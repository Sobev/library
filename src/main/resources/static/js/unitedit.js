$("#save").click(function () {
    var adata = {
        "unitId": $("td[ name='id' ]").attr("value"),
        "name": $("input[ name='name' ]").val(),
        "nature": $("input[ name='nature' ]").val(),
        "location": $("input[ name='location' ]").val(),
        "remarks": $("input[ name='remarks' ]").val(),
        "phone": $("input[ name='phone' ]").val()
    }
    var data = JSON.stringify(adata);
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/unit/alter",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            alert(message)
        },
        error: function () {
            alert("fail")
        }
    })
})