$().ready(function(){
	$("input[name='allCheck'").unbind("click");
	$("input[name='allCheck'").bind("click",function(){
		$(this).controlCheckBox("userCheckBox");
	});
});