$(function () {
    $.ajax({
        type: "POST",
        url: "/admin/book/publisher",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            console.log(data)
            for (i = 0; i < data.length; i++)
                setPageOption(data[i]);
        },
        error: function () {
            alert("出版社加载失败")
        }
    })
})

function setPageOption(result) {
    var text = '';
    text += '<option value="' + result.id + '">' + result.name + '</option>';
    $('#option').append(text);
}

$('#save').click(function () {
    var adata = {
        "bookId": $("td[ name='bookId' ]").attr("value"),
        "bookName": $("input[ name='bookName' ]").val(),
        "id": $("select[ name='publisher' ] option:selected").attr("data-value"),
        "author": $("input[ name='author' ]").val(),
        "isbn": $("input[ name='isbn' ]").val(),
        "classifyNum": $("input[ name='classifyNum' ]").val(),
        "price": $("input[ name='price' ]").val(),
    }
    adata = JSON.stringify(adata);
    console.log(adata);
    $.ajax({
        type: "POST",
        url: "/admin/book/edit/sbm",
        data: adata,
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (feedback) {
            if (feedback == 'success') alert("success");
            else alert("fails");
        },
        error: function () {
            location.reload();
        }
    })
})