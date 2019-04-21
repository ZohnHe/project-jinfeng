$(function(){
    var listUrl ='/shop/list';
    var orderUrl ='/goods/to_order';
    getList();

    getCustomer()
    
    function getCustomer() {
        $.get("/static/getcustomer",function (data) {
            $("#denglog").empty();
           var html = "Hi~,欢迎登录:"+data.coustomer.cNickname+"\t\t\t\t<a href='/static/ger_zhongx.html' style='color: red'>我的订单</a>"
            $("#denglog").html(html)
            $("#user_name").html(data.coustomer.cNickname)
        })
    }
        function getList() {
            var param= {pageSize:2,pageNum:1};
            $.ajax({
                url: listUrl,
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(param),
                dataType:'json',
                success: function (result) {
                    if(result.code != "200"){
                        alert(result.msg);
                    }else{
                        var dataList = result.data.data;//返回的数据列表
                        $("#goods-image1").attr("src",dataList[0].pMainImage);
                        $("#goods_1_name").text(dataList[0].pName);
                        $("#goods_1_price").text(dataList[0].pPrice);


                        $("#goods-image2").attr("src",dataList[1].pMainImage);
                        $("#goods_2_name").text(dataList[1].pName);
                        $("#goods_2_price").text(dataList[1].pPrice);

                    }
                }
            });


        }


});