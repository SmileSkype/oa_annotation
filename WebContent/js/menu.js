var menu = {
	setting:{
		isSimpleData: true,
		treeNodeKey: "mid",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		},
	},
	loadTree:function(){
		$.post("privilegeAction_showMenuitemByUser.action",null,function(data){
			$("#menuTree").zTree(menu.setting,data.privilegeList);
		});
	}
}
$().ready(function(){
	menu.loadTree();
});