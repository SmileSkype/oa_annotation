(function(jQuery){ //形参
//	$.fn.confirm = function(message){
//		return window.confirm(message);
//	}
	$.confirm = function(confirJson){
		$("a").each(function(){
			if($(this).text() == "删除"){
				$(this).unbind("click");
				$(this).bind("click",function(){
					confirJson.callback();
					return window.confirm(confirJson.message);
				});
			}
		});
	}
})(jQuery);  //实参