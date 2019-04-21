//将表单序列化成json
$.fn.serializeJson=function(){
    var serializeObj={};
    var array=this.serializeArray();
    var str=this.serialize();
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
};

$(function () {
    $("#btnLog").click(function () {
        var paramter={};
        if($("#loginForm").form('validate')){
            var username=$("#cUsername").val();
            var regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            if (regex.test(username)) {
                paramter.cEmail=username;
            }else {
                paramter.cUsername=username;
            }
            var parten = /^[a-zA-Z0-9]{6,10}$/;
            var password = $("#cPassword").val();
            if(parten.test(password)){
                paramter.cPassword=$("#cPassword").val();
            $.ajax({
                type: "post",
                url: "/login",
                contentType:"application/json;charset=utf-8",
                dataType:'json',
                data: JSON.stringify(paramter),
                success : function(data) {
                    if(data.status=='500'){
                        alert(data.msg);
                    }else {
                        alert(data.msg);
                        window.location.href="/static/shoppingindex.html"
                    }
                }
            });
            }else {
            alert("密码格式不正确，请重新输入");
            $("#cPassword").val('');
            }
        }else {
            alert("还有未填写的表单");
        }
    })
})
