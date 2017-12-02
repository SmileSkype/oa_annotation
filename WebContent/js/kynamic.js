var kynamic = {
	/**
	 * 凡是树的操作
	 */
	kynamicTree:{
		pNode:'',
		zTree:'',
		setting : {
			isSimpleData: true,
			treeNodeKey: "kid",
			treeNodeParentKey: "pid",
			showLine: true,
			root:{ 
				isRoot:true,
				nodes:[]
			},
			callback:{
				rightClick:function(event, treeId, treeNode){
					/**
					 * 在点击右键的时候，将treeNode的值赋值给pNode
					 */
					kynamic.kynamicTree.pNode = treeNode;
					/**
					 * 判断点击的是文件节点还是文件夹节点
					 */
					if(treeNode.isParent){  //文件夹节点
						kynamic.kynamicTree.controlRMenu({
							x:event.clientX,
							y:event.clientY,
							addFile:true,
							addFolder:true,
							deleteNode:true,
							updateNode:true
						});
					}else{  //文件节点
						kynamic.kynamicTree.controlRMenu({
							x:event.clientX,
							y:event.clientY,
							addFile:false,
							addFolder:false,
							deleteNode:true,
							updateNode:true,
						});
					}
					
				}
			}
		},
		
		loadKynamicTree:function(){
			$.post("kynamicAction_showKynamicTree.action",null,function(data){
				kynamic.kynamicTree.zTree = $("#kynamicTree").zTree(kynamic.kynamicTree.setting,data.kynamicList);
			});
		},
		/**
		 * 控制右键菜单的显示
		 * 		div的位置
		 * 		右键菜单的菜单项
		 */
		controlRMenu:function(rMenuJson){
			/**
			 * 菜单项的显示逻辑
			 */
			$("#rMenu").show();
			$("#rMenu").css({"top":rMenuJson.y+"px", "left":rMenuJson.x+"px", "display":"block"});
			
			//是否显示增加文件节点
			if(rMenuJson.addFile){
				$("#addFile").show();
			}else{
				$("#addFile").hide();
			}
			//是否显示增加文件夹节点
			if(rMenuJson.addFolder){
				$("#addFolder").show();
			}else{
				$("#addFolder").hide();
			}
			//是否显示删除节点
			if(rMenuJson.deleteNode){
				$("#deleteNode").show();
			}else{
				$("#deleteNode").hide();
			}
			//是否显示修改节点
			if(rMenuJson.updateNode){
				$("#updateNode").show();
			}else{
				$("#updateNode").hide();
			}
			
		},
		/**
		 * 增加节点
		 */
		addNode:function(addJSON){
			/**
			 * 向kynamic表中插入一条数据
			 * 在zTree树的相应的父节点上增加一个子节点
			 */	
			var fileName = window.prompt(addJSON.fileMessage,"");
			if(fileName != null){
				if(fileName != "" ){  //长度为3的空字符串目前无法在前台进行处理
					 var parameter = {
						name:fileName,
						isParent:addJSON.isParent,
						pid:kynamic.kynamicTree.pNode.kid
					 };
					/**
					 * 判断文件夹的名字是否已经存在
					 */
					$.post("kynamicAction_isExistName.action",{name:fileName},function(data){
						if(data.message == "输入的文件夹的名字不能为空"){
							 alert(data.message);
							 return false;
						}else if(data.message == "2"){  //1,代表文件夹名已存在，2,代表文件夹名可以使用
							$.post("kynamicAction_saveKynamic.action",parameter,function(data2){
								 var kid = data2.kid;
								 var newNodes = {
									kid:kid,
									name:fileName,
									isParent:addJSON.isParent,
									pid:kynamic.kynamicTree.pNode.kid
								 }
								 kynamic.kynamicTree.zTree.addNodes(kynamic.kynamicTree.pNode, newNodes, true);
							 });
						}else{
							alert(addJSON.checkName);
						}
					});
				}else{
					alert(addJSON.errorMessage);
				}
			}
		},
		/**
		 * 增加文件
		 */
		addFile:function(){
			kynamic.kynamicTree.addNode({
				fileMessage:"请输入文件的名字",
				isParent:false,
				checkName:"文件名已存在，请重新输入",
				errorMessage:"输入的文件的名字不能为空"
			})
		},
		/**
		 * 增加文件夹
		 */
		addFolder:function(){
			kynamic.kynamicTree.addNode({
				fileMessage:"请输入文件夹的名字",
				isParent:true,
				checkName:"文件夹名已存在，请重新输入",
				errorMessage:"输入的文件夹的名字不能为空"
			})
		},
		/**
		 * 删除节点
		 */
		deleteNode:function(){
			/**
			 * 判断当前要删除的节点是否是文件节点
			 * 		是
			 * 			直接删除
			 * 		否
			 * 			判断文件夹下是否有子节点
			 * 				如果没有
			 * 					直接删除
			 * 				如果有
			 * 					不能删除
			 */
			if(kynamic.kynamicTree.pNode.isParent){  //文件夹节点
				/**
				 * 如果当前节点是子节点的父节点，则说明当前节点下有子节点，不能直接删除
				 * 获取pid为kid的节点
				 */
				if(kynamic.kynamicTree.zTree.getNodeByParam("pid", kynamic.kynamicTree.pNode.kid)){  
					alert("当前节点下有子节点，不能直接删除");
				}else{   
					var parameter = {
						kid:kynamic.kynamicTree.pNode.kid,	
					};
					/**
					 * 判断当前节点是否有兄弟节点
					 * 		如果有兄弟节点，直接删除
					 * 		如果没有兄弟节点，先获取到父节点，将子节点删除后，将其父节点的isParent置为true
					 */
					$.post("kynamicAction_showSiblingNodes.action",parameter,function(data){
						if(data.kynamicList.length<2){  //说明没有兄弟节点
							/**
							 * 获取当前节点的父节点
							 */
							//获取父节点
							//kynamic.kynamicTree.zTree.pNode.getNodeByParam("kid",kynamic.kynamicTree.pNode.pid);
							$.post("kynamicAction_showParentNode.action",parameter,function(data2){
								var pNode = kynamic.kynamicTree.zTree.getNodeByParam("kid",data2.kynamic.kid);//获取父节点
								//请求从数据库中删除当前节点
								$.post("kynamicAction_deleteNode.action",parameter,function(data3){
									//在页面中删除该节点
									kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
									//更新父节点的isParent
									pNode.isParent = true;
									kynamic.kynamicTree.zTree.refresh();
									alert(data3.message);
								});
							});
						}else{  //说明有兄弟节点
							$.post("kynamicAction_deleteNode",parameter,function(data3){
								kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
								alert(data3.message);
							});
						}
					});
				}
			}else{   //文件节点
				var parameter = {
					kid:kynamic.kynamicTree.pNode.kid	
				};
				$.post("kynamicAction_showSiblingNodes",parameter,function(data){
					if(data.kynamicList.length < 2){  //说明没有兄弟节点
						//获取当前节点的父节点对象
						$.post("kynamicAction_showParentNode.action",parameter,function(data2){
							var pNode = kynamic.kynamicTree.zTree.getNodeByParam("kid",data2.kynamic.kid);
							$.post("kynamicAction_deleteNode.action",parameter,function(data3){
								//删除当前节点
								kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
								//更新父节点的状态
								pNode.isParent = true;
								kynamic.kynamicTree.zTree.refresh();
								alert(data3.message);
							});
						});
					}else{							  //说明有兄弟节点
						$.post("kynamicAction_deleteNode.action",parameter,function(data3){
							//删除当前节点
							kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
							kynamic.kynamicTree.zTree.refresh();
							alert(data3.message);
						});
					}
				});
			}
		},
		/**
		 * 修改节点
		 * 	1，判断修改后的名字是否重名
		 *  2、进行修改
		 */
		updateNode:function(){
			
			var newName = window.prompt("请重新输入名字",kynamic.kynamicTree.pNode.name);
			var parameter = {
				kid:kynamic.kynamicTree.pNode.kid,
				name:newName
			};
			$.post("kynamicAction_isExistName.action",{name:newName},function(data){
				if(data.message == "输入的文件夹的名字不能为空"){
					alert(data.message);
				}else if(data.message == "1"){ //1,代表重名，2,代表正常
					alert("该文件名称已经存在，请重新输入");
				}else{
					$.post("kynamicAction_updateKynamic.action",parameter,function(data){
						kynamic.kynamicTree.pNode.name = newName;
						kynamic.kynamicTree.zTree.refresh();
					});
				}
			});
		},
	},
	
	/**
	 * 版本的维护
	 */
	version:{
		
	}
}
$().ready(function(){
	kynamic.kynamicTree.loadKynamicTree();
	/**
	 * 方法：声明调用
	 * 事件：触发调用
	 * hover在这里仅仅是用于声明事件，事件函数中的内容到底是否执行，根据触发的时候判断
	 */
	$("#rMenu").hover(function(){  //鼠标移入
		/**
		 * 声明增删改事件
		 */
		$("#addFile").unbind("click");
		$("#addFile").bind("click",function(){
			/**
			 * 添加文件节点
			 */
			kynamic.kynamicTree.addFile();
		});
		
		$("#addFolder").unbind("click");
		$("#addFolder").bind("click",function(){
			/**
			 * 添加文件夹节点
			 */
			kynamic.kynamicTree.addFolder();
		});
		
		$("#deleteNode").unbind("click");
		$("#deleteNode").bind("click",function(){
			kynamic.kynamicTree.deleteNode();
		});
		
		$("#updateNode").unbind("click");
		$("#updateNode").bind("click",function(){
			kynamic.kynamicTree.updateNode();
		});
	},function(){
		//当该方法触发的时候，树早已经存在了，右键菜单已经显示了
//		alert("鼠标移出");
		$("#rMenu").hide()              //鼠标移出
	});
});