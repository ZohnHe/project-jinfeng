$(function () {
    $("#signin").click(
        function () {
            var username = $("#username").val();
            var password = $("#password").val();

            var flag = $("#userLoginFrm").valid();
            if(!flag){
                return;
            }
            $.ajax({
                type: "POST",
                url: "/bcklogin",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({
                    "uUsername": username,
                    "uPassword": password
                }),
                dataType: "json",
                success: function (data) {
                    if(data.status == "500"){
                        alert(data.msg);
                        return
                    }else {
                        alert(data.msg)
                        window.location.href="/static/Coustomer.html";
                    }
                },
                error: function (message) {
                    $("#request-process-patent").html("提交数据失败！");
                }
            });
        }
    );
})