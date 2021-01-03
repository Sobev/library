var time = 0;
$(function () {
    $.ajax({
        type: "POST",
        url: "/admin/main/init",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            mydata = []
            var len = 7;
            var curlen = data.length;
            for (i = 0; i < len; i++) {
                if (i < len - curlen) mydata.push(0)
                else mydata.push(data[i - len + curlen].num)
            }
            console.log(mydata)
            myChart.setOption({
                series: [{
                    data: mydata
                }]
            })
        },
        error: function () {
            alert("加载E-charts失败")
        }
    })
    $.ajax({
        type: "POST",
        url: "/admin/main/info",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            console.log(data)
            document.getElementById("arrears").innerText = data[0];
            document.getElementById("out").innerText = data[1];
            document.getElementById("back").innerText = data[2];
        },
        error: function () {
            alert("获取信息失败")
        }
    })
    $.ajax({
        type: "POST",
        url: "/admin/main/active",
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            console.log(data)
            for (var i = 0; i < data.length; i++) {
                appendCard(data[i])
            }
        },
        error: function () {
            alert("管理员状态加载失败")
        }
    })
})


var myChart = echarts.init(document.getElementById('line'));
option = {
    title: {
        text: '近七天借书量',
        subtext: '(本)',
        left: 'center'
    },
    xAxis: {
        type: 'category',
        data: ['', '', '', '', '', '', '']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line'
    }]
};
myChart.setOption(option);

var src = ["https://js2.a.yximgs.com/bs2/emotion/1591240346719third_party_b50790000.png",
    "https://js2.a.yximgs.com/bs2/emotion/1591240346488third_party_b50789998.png",
    "https://js2.a.yximgs.com/bs2/emotion/1591240347525third_party_b50790009.png",
    "https://tx2.a.yximgs.com/bs2/emotion/1591240347601third_party_b50790010.png",
    "https://tx2.a.yximgs.com/bs2/emotion/1595319781913third_party_b93387121.png",
    "https://js2.a.yximgs.com/bs2/emotion/1591240346599third_party_b50789999.png",
]

function appendCard(data) {
    var text = '';
    text += '<div class="card"> <div class="blurring dimmable image"> '
    text += '<img src=' + src[Math.floor(Math.random() * 7)] + '> </div>'
    text += '<div class="content">'
    text += '<a class="header" id="workId">' + data.workId + '</a>'
    text += '<div class="meta">'
    text += '<span class="date" id="email">' + data.email + '</span>'
    text += ' </div> </div> <div class="extra content"> <a> <i class="users icon"></i>'
    text += '<span id="phone">' + data.phone + '</span>'
    text += '</a> </div> </div>'
    $("#append").append(text)
}

$("#icon").click(function () {
    var book = null;
    var id = 1801;
    id = $("input[ id='bookId' ]").val(),
        console.log(id)
    $.ajax({
        type: "POST",
        url: "/admin/book/get?id=" + id,
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            console.log(data)
            if (data == null) alert("查无此书")
            else {
                book = data;
                alert(data.bookName + data.author)
                document.getElementById("pop").style.display = 'block'
            }
        },
        error: function () {
            alert("查询失败或者无此书")
        }
    })

})
$("#cancel").click(function () {
    document.getElementById("pop").style.display = 'none'
})
$("#bookout").click(function () {
    //借出
    var outdata = {
        "cardId": $("input[ name='cardid' ]").val(),
        "adm_adminid": $("input[ name='adminid' ]").val(),
        "bookId": $("input[ name='bookid' ]").val(),
    }
    var tempoutdata = JSON.stringify(outdata);
    $.ajax({
        type: "POST",
        url: "/admin/borrowbook/sbm",
        data: tempoutdata,
        async: true,
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            alert(data.data);
        },
        error: function () {
            alert("out fail")
        }
    })
})
$("#bookback").click(function () {
    //归还/admin/borrow/back
    var adata = {
        "cardId": $("input[ name='cardid' ]").val(),
        "adminId": $("input[ name='adminid' ]").val(),
        "bookId": $("input[ name='bookid' ]").val(),
    }
    var data = JSON.stringify(adata);
    $.ajax({
        type: "POST",
        url: "/admin/borrow/back",
        data: data,
        headers: {"Content-Type": "application/json;charset=utf-8"},
        dataType: "json",
        success: function (data) {
            alert(data.data)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    })
})