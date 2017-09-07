<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>FES</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<link href="css/login.css" type="text/css" rel="stylesheet" />
	<link href="css/index.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery-3.2.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		body{
		background: #00b4ef;
		}
	</style>
	
	<script type="text/javascript">
		function request(){
			$.ajax({
	            type: "POST",
	            //url for request
                url: "user/verifyLogin",
                data: {username: $('#username').val(),
                password: $('#password').val()},
                // asyncronise, default is true
                async: false,
                dataType: "text",
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                	var json = $.parseJSON(data);
                	//json.error.returnCode : 1-failure 0-success
                	//json.data : data returned
                	if(json.error.returnCode=='0'){//success
                			requestRedirect("success");
                	}
                	else{
                			requestRedirect("failure");
                	}
                }
            });
		}
		
		//Request Redirect
		function requestRedirect(destination){
		
			if(destination=="success"){
				var form = $("<form></form>"); 
				form.attr("action","index");
				form.attr("method","get");
				//form.append("<input name='username' value='value'></input>");   append value here if its nessesary
				form.appendTo("body").submit();
				form.remove();
             }
             if(destination=="failure"){
             	var form = $("<form></form>"); 
				form.attr("action","login");
				form.attr("method","get");
				//form.append("<input name='username' value='value'></input>");   append value here if its nessesary
				form.appendTo("body").submit();
				form.remove();
             }
		}
	</script>
	
  </head>
  
  <body>
     <div class="container">
		            <div class="row">
		                <div class="col-md-offset-3 col-md-6">
		                    <form action="user/verifyLogin" method="post" class="form-horizontal">
		                        <span class="heading">login</span>
		                        <div class="form-group">
		                            <input class="form-control" id="username" name="username"  placeholder="username">
		                            <i class="fa fa-user"></i>
		                        </div>
		                        <div class="form-group help">
		                            <input type="password" class="form-control" id="password" name="password" placeholder="password">
		                            <i class="fa fa-lock"></i>
		                            <a href="#" class="fa fa-question-circle"></a>
		                        </div>
		                        <div class="form-group">
		                            <div class="main-checkbox">
		                                <input type="checkbox" value="None" id="checkbox1" name="check"/>
		                                <label for="checkbox1"></label>
		                            </div>
		                            <span class="text">Remember me</span>
		                             <input type="button" value="login" onclick="request()" class="btn btn-default"></button>
		                            </div>
		                    </form>
		                   
		                        
		                </div>
		            </div>
		        </div>
  </body>
</html>
