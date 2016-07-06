$(document).ready(function(){
	loadcus(1);
});
function uppage(){
	var pagecurpage=parseInt($("#pagecurpage").val());
	if(pagecurpage<=1){
		alert("这已经是第一页了");
	}else{
		deltabe();
		loadcus(pagecurpage-1);
	}
}

function nextpage(){
	var pagecurpage=parseInt($("#pagecurpage").val());
	var pages=parseInt($("#pages").val());
	if(pagecurpage>=pages){
		alert("这已经是最后一页了");
	}else{
		deltabe();
		loadcus(pagecurpage+1);
	}
}

function jump(){
	var curp=parseInt($("#selectcur").val());
	var pages=parseInt($("#pages").val());	
	if(curp<=0||curp>pages){
		alert("请输入1~"+pages+"之间的数字！");
		return;
	}
	deltabe();
	loadcus(curp);
}
function loadcus(curpage){
	$.ajax({
		url:"customerListPage.do",
		type:"POST",
		dataType:"json",
		data:{curpage:curpage},
		success:function(jsondata){
		var curpage=jsondata["curpage"];
		$("#pagecurpage").val(curpage);
		$("#selectcur").val(curpage);
		var pages=jsondata["pages"];
		$("#pages").val(pages);
		var customers=jsondata["customers"];
		
		var table=$("middle_tab");
		for(var key in customers){
			var first_name=customers[key]["first_name"];
			var last_name=customers[key]["last_name"];
			var address=customers[key]["address"];
			var email=customers[key]["email"];
			var customerid=customers[key]["customerid"];
			var lastupdate=customers[key]["lastupdate"];
		var newRow="<tr><td><a href='edit1.do?customerId="+customerid+"'>编辑</a>|" +
				"<a href='javascript:delcustomer("+customerid+")'>删除</a></td><td>";
		
		newRow+=first_name+"</td><td>"
		
		newRow+=last_name+"</td><td>"
		
		newRow+=address+"</td><td>"
		
		newRow+=email+"</td><td>"
	
		newRow+=customerid+"</td><td>"
		
		newRow+=lastupdate+"</td><tr>"
		$("#middle_tab tr:last").after(newRow);
		}
		}
	});
}

function deltabe(){
	$("#middle_tab tr:not(:first)").remove();
}
function delcustomer(customerId){
	 if (confirm("确认要删除?")){
		 $.ajax({
			 url:"delcustomer.do",
			 type:"post",
			 dataType:"json",
			 data:{customerId:customerId},
			 success:function(d){
				 if(d){
					 alert("删除成功");
					 location.href="index.jsp";
				 }else{
					 alert("删除失败");
				 }
			 }
		 });
	 }
}