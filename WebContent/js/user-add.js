$().ready(function(){
	$("input[type='image']").unbind("click");
	$("input[type='image']").bind("click",function(){
		alert("aaaa");
		alert($("select[name='did']"));
		alert($("select[name='did'] option:selected").attr("value"))
		alert($("select[name='pids'] option:selected").attr("value"));
		if($("select[name='did'] option:selected").attr("value") != "" && $("select[name='pids'] option:selected").attr("value")){
			//代表如果部门和岗位都有值的情况下，进行正常提交
			return true;
		}
		//如果部门为空或者岗位unfined的情况下，返回false，选择部门和岗位
		alert("请选择岗位和部门");
		return false;
	});
});