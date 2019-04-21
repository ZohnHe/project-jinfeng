$(function () {
            $.ajax({
                type: "POST",
                url: "/getbguser",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if(data.status == "500"){
                        alert(data.msg);
                        return
                    }else {
                        $("#user").html(data.user.uNickname)
                    }
                },
                error: function (message) {
                    $("#request-process-patent").html("提交数据失败！");
                }
            });
  $("#out").click(function () {
      $.get("/delbguser",function (data) {
          if(data.status == "200"){
              alert(data.msg);
          window.location.href="/static/login.html"
          }else {
              return
          }

      })
  })
})