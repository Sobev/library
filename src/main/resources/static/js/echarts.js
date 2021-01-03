var adata;
$.ajax({
    type: "POST",
    url: "/getCharts",
    headers: {"Content-Type": "application/json;charset=utf-8"},
    dataType: "json",
    success: function (data) {
        adata = data;
        console.log(adata);
        myChart.setOption({
            series: [{
                data: [
                    {value: adata.dutyNum, name: '值班人数'},
                    {value: adata.workerNum, name: '总人数'}
                ]
            }]
        })
    },
    error: function () {
        alert("图形数据加载失败");
    }

})


// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
option = {
    backgroundColor: 'rgba(255, 255, 255, 0.0)',

    title: {
        text: '值班人数表',
        left: 'center',
        top: 20,
        textStyle: {
            color: '#000'
        }
    },

    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
    },

    visualMap: {
        show: false,
        min: 0,
        max: 20,
        inRange: {
            colorLightness: [0, 1]
        }
    },
    series: [
        {
            name: '人数',
            type: 'pie',
            radius: '55%',
            center: ['50%', '50%'],
            data: [
                {value: 1, name: '值班人数'},
                {value: 1, name: '总人数'},
            ].sort(function (a, b) {
                return a.value - b.value;
            }),
            roseType: 'radius',
            label: {
                color: 'rgba(0, 0, 0, 0.5)'
            },
            labelLine: {
                lineStyle: {
                    color: 'rgba(0, 0, 0, 0.5)'
                },
                smooth: 0.2,
                length: 10,
                length2: 20
            },
            itemStyle: {
                color: '#c23531',
                shadowBlur: 200,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            },

            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);