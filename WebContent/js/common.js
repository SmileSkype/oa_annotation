//var common = {
//	myconfig:function(message){
//		return window.confirm(message);	
//	}
//}
$().ready(function(){
	/**
	 * 当页面加载的时候，给名称删除的超级链接一个事件
	 */
//	$("a").each(function(){
//		if($(this).text() == "删除"){
//			$(this).unbind("click");
//			$(this).bind("click",function(){
////				return common.myconfig("您确定要删除吗？"); 
//				return $(this).confirm("您确认是否要删除");
//			});
//		}
//	});
//	$.confirm("您是否确定要删除吗？",function(){
//		alert("我就是牛");
//	});
	
	$.confirm({
		message:"您是否确定要删除？",
		callback:function(){
			alert("我只是一个弹出框");
		}
	});
});