$(function(menu){
	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	default:
		$('#home').addClass('active');
		break;
	}
	
	
	
	$('.switch input[type = "checkbox"]').on('change',function(){
		 
		 var checkbox = $(this);
		 var checked = checkbox.prop('checked');
		 var dMsg = (checked)?'You want to activate the product?':
			 'You want to deactivate the Product?';
		 var value =  checkbox.prop('value');
		 
		 bootbox.confirm({
			 size : 'medium',
			 title : 'Product activation and deactivation',
			 message : dMsg,
			 callback: function(confirmed){
				 
				 if(confirmed){
					 console.log(value);
					 var activationUrl = window.contextRoot + '/book/'+ value + '/activation';
					 console.log(activationUrl);
					 $.post(activationUrl, function(data){
						 bootbox.alert({
							 size : 'medium',
							 title: 'Information',
							 message: data
						 });
					 });

				 }
				 else{
					 checkbox.prop('checked',!checked);
				 }
			 }
		 })
		 
	 });
	
	

		 
	
//	// list of all products for admin
//		var productsTable = $('#productsTable');
//		
//		
//		if($productsTable.length) {
//			
//			var jsonUrl = window.contextRoot + '/json/admin/all/books';
//			console.log(jsonUrl);
//			
//			$productsTable.DataTable({
//						lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
//						pageLength : 30,
//						ajax : {
//							url : jsonUrl,
//							dataSrc : ''
//						},
//						columns : [		
//						           	{data: 'id'},
//
//
//						           	{data: 'imageUrl',
//						           	 bSortable: false,
//						           		mRender: function(data,type,row) {
//						           			return '<img src="' + window.contextRoot
//											+ '/resources/images/' + data
//											+ '.jpg" class="adminTableImg"/>';					           			
//						           		}
//						           	},
//						           	{
//										data : 'title'
//									},
//									{
//										data : 'author'
//									},
//									{
//										data : 'unitInStock',
//										mRender : function(data, type, row) {
//
//											if (data < 1) {
//												return '<span style="color:red">Out of Stock!</span>';
//											}
//
//											return data;
//
//										}
//									},
//									{
//										data : 'unitPrice',
//										mRender : function(data, type, row) {
//											return '&#8377; ' + data
//										}
//									},
//									{
//										data : 'active',
//										bSortable : false,
//										mRender : function(data, type, row) {
//											var str = '';
//											if(data) {											
//												str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
//												
//											}else {
//												str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
//											}
//											
//											return str;
//										}
//									},
//									{
//										data : 'id',
//										bSortable : false,
//										mRender : function(data, type, row) {
//
//											var str = '';
//											str += '<a href="'
//													+ window.contextRoot
//													+ '/manage/'
//													+ data
//													+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';
//
//											return str;
//										}
//									}					           	
//						],
//						
//						
//						initComplete: function () {
//							var api = this.api();
//							api.	$('.switch input[type = "checkbox"]').on('change',function(){
//								 
//								 var checkbox = $(this);
//								 var checked = checkbox.prop('checked');
//								 var dMsg = (checked)?'You want to activate the product?':
//									 'You want to deactivate the Product?';
//								 var value =  checkbox.prop('value');
//								 
//								 bootbox.confirm({
//									 size : 'medium',
//									 title : 'Product activation and deactivation',
//									 message : dMsg,
//									 callback: function(confirmed){
//										 
//										 if(confirmed){
//											 console.log(value);
//											 var activationUrl = window.contextRoot + '/book/'+ value + '/activation';
//											 console.log(activationUrl);
//											 $.post(activationUrl, function(data){
//												 bootbox.alert({
//													 size : 'medium',
//													 title: 'Information',
//													 message: data
//												 });
//											 });
//
//										 }
//										 else{
//											 checkbox.prop('checked',!checked);
//										 }
//									 }
//								 })
//								 
//							 });
//								
//						}
//					});
//		}
		
		
	
	
	
});