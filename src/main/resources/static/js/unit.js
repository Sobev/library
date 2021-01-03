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
        "unitId": $("input[ name='unitId' ]").val(),
        "name": $("input[ name='name' ]").val(),
        "nature": $("input[ name='nature' ]").val(),
        "location": $("input[ name='location' ]").val(),
        "remarks": $("input[ name='remarks' ]").val(),
        "phone": $("input[ name='phone' ]").val()
    }
    var data = JSON.stringify(adata);
    console.log(data)
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/unit/save",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            alert(message)
        },
        error: function () {
            alert("保存失败")
        }
    })
})