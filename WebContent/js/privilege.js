var privilege = {
	/**
	 * 所有的初始化操作
	 */
	init:{
		/**
		 * 初始化所有的事件
		 */
		initEvent:function(){ 
			 /**
			  * 设置权限的click事件
			  */
			$("a").each(function(){
				if($(this).text() == "设置权限"){
					$(this).unbind("click");
					$(this).bind("click",function(){
//						alert("测试使用");
						 /**
						  * 1、显示所有的div
						  * 2、动态的显示用户名
						  * 3、加载权限树
						  */
						//初始化数据
						//var hobj = this;
						//privilege.init.initData(hobj);
						privilege.init.initData.call(this);
						privilege.pFunction.divOption.showDiv();  //显示所有的div
						privilege.pFunction.userOption.showUsername(); //动态的显示用户名
						privilege.pFunction.privilegeTree.loadPrivilegeTree(); //加载权限树
						return false;
					});
				}
			});
			/**
			 * 全选复选框的点击事件
			 */
			$("#allchecked").unbind("click");
			$("#allchecked").bind("click",function(){
//				privilege.pFunction.privilegeTree.checkAll(this);
				privilege.pFunction.privilegeTree.checkAll.call(this);
			});
			/**
			 * 保存事件
			 */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click",function(){
				privilege.pFunction.privilegeTree.savePrivilege();
			});
		},
		/**
		 * 初始化所有的数据
		 */
//		initData:function(hobj){  
//			alert($(hobj).text());
//		}
		initData:function(){  
//			alert("测试使用");
//			alert($(this).parent().siblings("td:first").next().text());
//			alert($(this).parent().siblings("input[type='hidden']").val());
			var username = $(this).parent().siblings("td:first").next().text();
			var uid = $(this).parent().siblings("input[type='hidden']").val();
			privilege.data.user.uid = uid;
			privilege.data.user.username = username;
		}
	},
	/**
	 * 按照功能划分区域
	 */
	pFunction:{
		privilegeTree:{ //所有权限树的操作
			zTree:'',
			/**
			 * 树的配置
			 */
			setting:{
				isSimpleData: true,
				treeNodeKey: "mid",
				treeNodeParentKey: "pid",
				showLine: true,
				checkable : true,
				callback:{
					/**
					 * 在点击树上的复选框之前触发该方法
					 */
					beforeChange:function(treeId, treeNode){
//						alert("测试使用");
						/**
						 * 选中只影响父节点，取消只影响子节点
						 */
						var checkType = {
							"Y":"p",
							"N":"s"
						}
						privilege.pFunction.privilegeTree.controlCheckBox(checkType);
					},
					/**
					 * 如果树上的复选框全部选中后，全选也需要选中状态
					 */
					change:function(event, treeId, treeNode){
						if(privilege.pFunction.privilegeTree.zTree.getCheckedNodes(false) != 0){
							$("#allchecked").attr("checked",false);
						}else{
							$("#allchecked").attr("checked",true);
						}
					}
				}
			},
			/**
			 * 加载权限树
			 */
			loadPrivilegeTree:function(){
				var parameter = {
					uid:privilege.data.user.uid
				};
				$.post("privilegeAction_showPrivilege.action",parameter,function(data){
					privilege.pFunction.privilegeTree.zTree = $("#privilegeTree").zTree(privilege.pFunction.privilegeTree.setting,data.privilegeList);
					/**
					 * 这里是设置全选按钮默认状态的最佳位置
					 * 		默认值必须在点击设置权限的超级链接中设置
					 * 		确保zTree必须有值
					 */
					if(privilege.pFunction.privilegeTree.zTree.getCheckedNodes(false) != 0){
//						alert("测试使用");
						$("#allchecked").attr("checked",false);
					}else{
						$("#allchecked").attr("checked",true);
					}
				});
			},
			/**
			 * 对权限树复选框的控制
			 */
			controlCheckBox:function(checkType){
				var setting = privilege.pFunction.privilegeTree.zTree.getSetting();
				setting.checkType = checkType;
				privilege.pFunction.privilegeTree.zTree.updateSetting(setting);
			},
			/**
			 * 针对某一用户保存权限
			 */
			savePrivilege:function(){
				//获取所有选中的节点
				var checkedNodes = privilege.pFunction.privilegeTree.zTree.getCheckedNodes(true);
				//传输简单格式的json格式更简单，拼接字符串
				var mids = "";
				for(var i=0;i<checkedNodes.length;i++){
					if(i<checkedNodes.length-1){
						mids = mids + checkedNodes[i].mid + ","
					}else{
						mids = mids + checkedNodes[i].mid;
					}
				}
				var parameter = {
					uid:privilege.data.user.uid,
					mids:mids,
				};
//				$.post("privilegeAction_savePrivilege.action",parameter,function(data){
//					
//				});
				$.post("privilegeAction_savePrivilege.action",parameter,function(data){
					alert("已经保存成功");
				});
			},
			/**
			 * 全选复选框的实现
			 */
//			checkAll:function(hobj){
//				alert($(hobj).attr("checked"));
//			}
			checkAll:function(){
				/**
				 * 改变树上的复选框的选中规则
				 * 		在执行该函数的时候，zTree已经存在了
				 */
				
				var checkType = {
					"Y":"ps",
					"N":"ps"
				};
				/**
				 * 改变zTree复选框的规则
				 */
				privilege.pFunction.privilegeTree.controlCheckBox(checkType);
				if($(this).attr("checked")){
					privilege.pFunction.privilegeTree.zTree.checkAllNodes(true);
				}else{
					privilege.pFunction.privilegeTree.zTree.checkAllNodes(false);
				}
			}
		},
		userOption:{    //存放用户的操作
			showUsername:function(){ //把用户名动态的显示到div中
				$("#userImage").text(privilege.data.user.username);
			}
		},
		divOption:{  //显示div的操作
			showDiv:function(){
				$("#userTitle").show();
				$("#privilegeTitle").show();
				$("#privilegeContent").show();
			}
		}
	},
	/**
	 * json对象对数据的封装
	 */
	data:{  //所有数据的封装
		user:{ //存放用户的数据
			uid:'',
			username:''
		}
	}
};
$().ready(function(){
	privilege.init.initEvent();
});
/**
 *全选按钮的状态的设置
 *		在点击完成设置权限的超级链接时，全选按钮的默认状态已经确定了
 *			必须在事件中做这件事情
 *		在全选按钮设置默认值之前，必须保证权限树已经生成了
 */
