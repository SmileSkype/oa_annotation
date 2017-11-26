var user = {
	formValidate:function(){
		$("input[type='image']").unbind("click");
		$("input[type='image']").bind("click",function(){
			alert("aaaa");
			alert($("select[name='did']"));
			alert($("select[name='did'] option:selected").attr("value"))
			alert($("select[name='pids'] option:selected").attr("value"));
			if($("select[name='did'] option:selected").attr("value") != "" && $("select[name='pids'] option:selected").attr("value")){
				//代表如果部门和岗位都有值的情况下，进行正常提交
				if($("#message").text() == "该用户名可以使用"){
					return true;
				}else{
					return false;
				}
			}
			//如果部门为空或者岗位unfined的情况下，返回false，选择部门和岗位
			alert("请选择岗位和部门");
			return false;
		});
	},
	inintEvent:function(){
		$("input[name='username']").unbind("blur");
		$("input[name='username']").bind("blur",function(){
//			alert("aaa");
			user.checkUser($(this).val());
		});
		
	},
//	checkUser:function(username){
//		alert("bbb");
//		var parameter = {
//				username:username
//		};
//		$.post("userJsonAction_getUserByUsername.action",parameter,function(data){
//			alert(data);
//			$("#message").text(data.message);
//			if(data.message == "该用户名可以使用"){
//				$("#message").css("color", "blue")
//			}else{
//				$("#message").css("color", "red")
//			}
//		});
//	}

	checkUser:function(username){
//		alert(username);
		var parameter = {
			username:username
		}
		$.ajax({
			type:"post",
			url:"userJsonAction_getUserByUsername.action",
			data:parameter,
			success:function(data){
				$("#message").text(data.message);
				if(data.message == "该用户名可以使用"){
					$("#message").css("color", "blue")
				}else{
					$("#message").css("color", "red")
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("bbb");
			}
		});
		
	},
};
$().ready(function(){
	user.formValidate();
	user.inintEvent();
});