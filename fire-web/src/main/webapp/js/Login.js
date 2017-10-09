// Login:
// judge the info if legal: not null
function psdVerify(){
	if($('#password').val() == ''){
		$('#psdResult').html("Password cannot be null!");
		$('#psdResult').css({"color":"#F00"});
	}
}
function usernameVerify(){
	if($('#username').val() == ''){
		$('#usernameResult').html("Username cannot be null");
		$('#usernameResult').css({"color":"#F00"});
	}
}
// send request
function loginTopRequest() {
	if($('#password').val() !='' || $('#username').val() != ''){
		$.ajax({
			type : "POST",
			// url for request.
			// invoke methods in UserController.java
			url : "user/token",
			data : {
				username : $('#username').val(),
				password : $('#password').val(),
				userType : $('input:radio:checked').val()
			},
			// asyncronise, default is true
			async : false,
			dataType : "json",
            error : function(data) {
				var json = data.responseText;
                if (json != null || json!=""){
                	json = $.parseJSON(json);
                    alert(json.error.returnUserMessage);
                }else{
                    alert("Connection error");
                }
            },
            success : function(data) {
                //0-individual 1-organization
				localStorage.setItem("token",data.data.token);
				var select = $('input:radio:checked').val();
                if( select == 1){
                    location.href="/jsp/IndividualUser/individualHome.html";
                }else{
                    location.href="/jsp/OrganizationUser/organizationHome.html";
                }
            }
		});
	}else{
		alert("Invalid username or password.");
	}	
}

// Request Redirect
function loginRedirect(destination,jumpPage) {
	if (destination == "success") {
		var form = $("<form></form>");
		// invoke methods in ViewController.java
		form.attr("action", jumpPage);
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
	if (destination == "failure") {
		var form = $("<form></form>");
		form.attr("action", jumpPage);
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
}

//send request
function logOut() {
	if($('#password').val() !='' || $('#username').val() != ''){
		$.ajax({
			type : "POST",
			// url for request.
			// invoke methods in UserController.java
			url : "user/token",
			data : {
				username : $('#username').val(),
				password : $('#password').val(),
				userType : $('input:radio:checked').val()
			},
			// asyncronise, default is true
			async : false,
			dataType : "text",
			error : function(data) {
                var json = data.responseText;
                if (json != null || json!=""){
                    json = $.parseJSON(json);
                    alert(json.error.returnUserMessage);
                }else{
                    alert("Connection error");
                }

			},
			success : function(data) {
				//0-individual 1-organization
                var json = $.parseJSON(data);
				if( $('input:radio:checked').val() == '0'){
					jumpTo = "individualHome";
                    location.replace="/account/individualHome.html";
				}else{
					jumpTo = "organizationHome";
                    location.replace="/account/organizationHome.html";
				}


			}
		});
	}else{
		alert("Invalid username or password.");
	}	
}

// Request Redirect
function requestLogoutRedirect(destination,jumpPage) {
	if (destination == "success") {
		var form = $("<form></form>");
		// invoke methods in ViewController.java
		form.attr("action", jumpPage);
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
	if (destination == "failure") {
		var form = $("<form></form>");
		form.attr("action",jumpPage );
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
}

