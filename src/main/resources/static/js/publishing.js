$("#addNew").click(function () {
    document.body.style.backgroundColor = "#696969"
    document.getElementById("pop").style.display = 'block';
})

$("#cancel").click(function () {
    document.body.style.backgroundColor = "#ffffff"
    document.getElementById("pop").style.display = 'none';
})
//background-color: rgba(0,0, 0, 0.8);/*设置透明度为0.8，以突出遮罩效果*/
$("#confirm").click(function () {
    var adata = {
        "id": $("input[ name='id' ]").val(),
        "email": $("input[ name='email' ]").val(),
        "name": $("input[ name='name' ]").val(),
        "phone": $("input[ name='phone' ]").val(),
        "location": $("input[ name='location' ]").val(),
        "place": $("input[ name='place' ]").val()
    }
    var data = JSON.stringify(adata);
    console.log(data);
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/publishing/save",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (data) {
            if (data == 'success') alert("保存成功")
        },
        error: function () {
            alert("保存失败")
        }
    })

})
$('.ui.form')
    .form({
        fields: {
            id: 'number',
            email: 'email',
            name: 'email',
            phone: 'empty',
            location: 'empty',
            place: 'empty',
        }
    });