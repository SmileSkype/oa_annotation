var tree = {
	setting : {
			isSimpleData: true,
			treeNodeKey: "mid",
			treeNodeParentKey: "pid",
			showLine: true,
			root:{ 
				isRoot:true,
				nodes:[]
			}
	},
	/**
	 * 1、回调函数是由服务器端触发的，什么时候执行由服务器决定
	 * 2、回调函数是由jQuery内核调用的
	 * 3、客户端存在两个线程
	 * 4、如果在js代码中，有一些代码要用到回调函数中的数据，那么这些代码必须放在回调函数中
	 */
	loadTree:function(){
		$.post("menuitemJsonAction_getAllMenuitem.action",null,function(data){
			$("#tree").zTree(tree.setting,data.menuitemList);
		});
	},
	
};
$().ready(function(){
	tree.loadTree();
});