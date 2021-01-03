$(function () {
    console.log("yes")
    $.ajax({
        type: "POST",
        url: "/admin/bookECharts",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            console.log(data);
            var mydata = [];
            var mylegend = ['科技', '数学', '文学', '儿童'];
            for (i = 0; i < data.length; i++) {
                mydata.push({
                    name: mylegend[i],
                    value: data[i].classifynum
                });
            }
            console.log(mydata);
            myChart.setOption({
                series: [{
                    data: mydata
                }],
                legend: [{
                    data: mylegend
                }]
            })
        },
        error: function () {
            alert("获取ECharts失败");
        }
    })
});

var myChart = echarts.init(document.getElementById('bookmain'));

option = {
    title: {
        text: '书本类别',
        subtext: 'ORIGINAL',
        left: 'center'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },
    legend: {
        type: 'scroll',
        orient: 'vertical',
        right: 10,
        top: 20,
        bottom: 20,
        data: []
    },
    series: [
        {
            name: '',
            type: 'pie',
            radius: '55%',
            center: ['40%', '50%'],
            data: ['haha'],
            emphasis: {
                itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart.setOption(option);


var count = 1;

function setPageInfo(result) {
    var text = '';
    text += '<tr>'
    text += '<td>' + result.bookId + '</td>'
    text += '<td>' + result.id + '</td> '
    text += '<td>' + result.bookName + '</td> '
    text += '<td>' + result.author + '</td>'
    text += '<td>' + result.isbn + '</td>'
    text += '<td>' + result.classifyNum + '</td>'
    text += '<td>' + result.price + '</td>'
    text += '<td>' + result.introduction + '</td>'
    text += '<td>' + result.publishDate + '</td>'
    text += '<td><a href=' + '"/admin/book/delete/' + result.bookId + '"' + '>删除</a></td>'
    text += '<td><a href=' + '"/admin/book/alter/' + result.bookId + '"' + '>编辑</a></td>'
    text += '</tr>'
    console.log($('#All'))
    $('#table').append(text);
}

$("#submitButton").click(
    function () {
        $.ajax({
            type: "POST",
            url: "/admin/books/clicked?count=" + count,
            headers: {"Content-Type": "application/json;charset=utf-8"},
            dataType: "json",
            success: function (data) {
                console.log(count);
                if (data != null) {
                    count = count + 1;
                    console.log(data)
                    for (var i = 0; i < data.length; i++) {
                        setPageInfo(data[i]);
                    }
                }
            },
            error: function () {
                console.log(adata);
                alert("error")
            }
        })
    })
$("#sbm").click(function () {
    var div = document.getElementById("output");
    var msg = '';
    msg += '<span style="display: block;">' + 'id:' + $("#text").val() + '</span>'
    console.log($("#text").val());
    $("#output").append(msg);
    //div.style.height=parseInt(getStyle(div, "height"))+20+"px"

})

function getStyle(parm1, parm2) {
    return parm1.currentStyle ? parm1.currentStyle[parm2] : getComputedStyle(parm1)[parm2];  //parm1,要改变的元素代替名;parm2,要改变的属性名
}

$('#findByName').click(function () {
    $("#form").submit()
})
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
        "bookId": $("input[ name='bookId' ]").val(),
        "id": $("input[ name='id' ]").val(),
        "bookName": $("input[ name='bookName' ]").val(),
        "author": $("input[ name='author' ]").val(),
        "isbn": $("input[ name='isbn' ]").val(),
        "classifyNum": $("input[ name='classifyNum' ]").val(),
        "price": $("input[ name='price' ]").val(),
        "introduction": $("input[ name='introduction' ]").val(),
        //"publishDate":$("input[ name='publishDate' ]").val()
    }
    var data = JSON.stringify(adata);
    console.log(data)
    $.ajax({
        type: "POST",
        data: data,
        url: "/admin/book/addBook",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        success: function (message) {
            alert("保存成功")
        },
        error: function () {
            alert("保存失败")
        }
    })
})