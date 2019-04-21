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


//模块定义
var signupApp = angular.module("signupApp", []);
//控制器定义  目标注入当前域
signupApp.controller("signupCtrl", ["$scope","$http", function($scope,$http) {
    $scope.btnMsg = "发送验证码";
    var active = true; //防止用户多次点击
    var second = 60; //倒计时60秒
    var secondInterval;
    $scope.getCheckCode = function(uEmail) {
        if(active == false) {
            return;
        }
        //发送一个HTTP请求，通知服务器发送邮件给目标用户
        var regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if(regex.test(uEmail)) {
            //校验通过
            $http({

                method: 'POST',
                url: 'customer_sendEmail',
                data:{'cEmail':uEmail}

            }).success(function(data, status, headers, config) {
                // 当响应以正确状态返回时调用
                if (data.status == "500"){
                    alert(data.msg);
                    return ;
                } else {
                    alert(data.msg)
                }
            }).error(function(data, status, headers, config) {
                if (data.status == '500') {

                alert(data.msg);
            }else {
                alert(data.msg);
                $("#customerForm").form('reset');
            }
                // 当响应以错误状态返回时调用
                alert("发送邮件出错，请联系管理员")
            });
        } else {
            //校验失败
            alert("邮箱地址错误，请重新输入");
            return;
        }
        //显示倒计时按钮后，60秒后，允许重新发送
        active = false;
        secondInterval = setInterval(function() {
            if(second < 0) {
                //倒计时结束,允许重新发送
                $scope.btnMsg = "重发送验证码";
                $scope.$digest();
                active = true;
                second = 60;
                //关闭定时器
                clearInterval(secondInterval);
                secondInterval = undefined;
            } else {
                //继续计时
                $scope.btnMsg = second + "秒后重发";
                //强制更新视图
                $scope.$digest();
                second--;
            }
        }, 1000);
    };
    $scope.register=function () {
        if($("#customerForm").form('validate')){
            var cEmail=$scope.uEmail;
            var regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
            if (!regex.test(cEmail)){
                alert("邮箱格式错误，请重新输入")
                $scope.uEmail='';
                return;
            }
            var password=$scope.cPassword;
            var rPassword=$scope.cRPassword;
            if (password != rPassword) {
                alert("两次密码应该相同")
                $scope.cPassword='';
                $scope.cRPassword='';
                return
            }
            var parten = /^[a-zA-Z0-9]{6,10}$/;
            if(parten.test(password)) {
            }else {
                alert("密码应为6-10位数字或英文");
                return
            }
            var params = $("#customerForm").serializeJson();
           /* alert(JSON.stringify(params));*/
            $http({

                method: 'POST',
                url: 'customer_register',
                data:params

            }).success(function(data, status, headers, config) {
                // 当响应以正确状态返回时调用
                if (data.status == '500') {

                    alert(data.msg);
                }else {
                    alert(data.msg);
                    $("#customerForm").form('reset');
                }

            }).error(function(data, status, headers, config) {
                // 当响应以错误状态返回时调用
                alert("注册失败");
            });

        }else{
            alert("还有未填写的表单")
            return;
        }


    }



}]);

