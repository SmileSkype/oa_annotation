//一次性加载树
//var tree = {
//	setting : {
//			isSimpleData: true,
//			treeNodeKey: "mid",
//			treeNodeParentKey: "pid",
//			showLine: true,
//			root:{ 
//				isRoot:true,
//				nodes:[]
//			}
//	},
//	/**
//	 * 1、回调函数是由服务器端触发的，什么时候执行由服务器决定
//	 * 2、回调函数是由jQuery内核调用的
//	 * 3、客户端存在两个线程
//	 * 4、如果在js代码中，有一些代码要用到回调函数中的数据，那么这些代码必须放在回调函数中
//	 */
//	loadTree:function(){
//		$.post("menuitemJsonAction_getAllMenuitem.action",null,function(data){
//			$("#tree").zTree(tree.setting,data.menuitemList);
//		});
//	},
//	
//};
//$().ready(function(){
//	tree.loadTree();
//});

//点击事件加载树
var tree = {
	pNode:"",
	zTree:"",
	setting : {
			isSimpleData: true,
			treeNodeKey: "mid",
			treeNodeParentKey: "pid",
			showLine: true,
			root:{ 
				isRoot:true,
				nodes:[]
			},
			callback:{
				expand:function(event, treeId, treeNode){
//					alert(treeNode.mid+","+treeNode.name);
					tree.pNode = treeNode;
					tree.loadNodeByPNode();  //加载子节点
				}
			}
	},
	loadNodeByPNode:function(){
		var parameter = {
			 pid:tree.pNode.mid
		}
		if(!tree.zTree.getNodeByParam("pid", tree.pNode.mid)){  //判断当前点击的节点是否有子节点
//			alert("测试使用");
			$.post("menuitemJsonAction_getMenuitemByParentId.action",parameter,function(data){
				/**
				 * 将查询出来的子节点追加到父节点上
				 */
				tree.zTree.addNodes(tree.pNode, data.menuitemList, true);
			});
		}
	},
	//加载树的根节点
	loadRootNode:function(){
		var parameter = {
			pid:0
		};
		$.post("menuitemJsonAction_getMenuitemByParentId.action",parameter,function(data){
			tree.zTree = $("#tree").zTree(tree.setting,data.menuitemList);
		});
	},
	
};
$().ready(function(){
	tree.loadRootNode();
});