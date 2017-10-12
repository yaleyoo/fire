//This script includes the implementation of register/individualRegister/OrganizationRegister/mail.jsp
function findStr(str, n) {
	var temp = 0;
	for (var i = 0; i < str.length; i++) {
		if (str.charAt(i) == n) {
			temp++;
		}
		;
	}
	;
	return temp;
};

/**
 * //individual register:
 * 
 * @returns
 */
function individualRegisterVerification() {
	var psd = document.getElementById("password")
	var psd1 = document.getElementById("confirmPassword");
	var psdInfo = document.getElementsByClassName("psdInfo")[0];
	var psd1Info = document.getElementsByClassName('psd1Info')[0];
	var name_length = 0;
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/g;
	var re_n = /[^\d]/g;
	var re_t = /[^a-zA-Z]/g

	psd.onfocus = function() {
		psdInfo.style.display = "inline-block";
		psdInfo.innerHTML = '<i class="warn"></i> <span style="color:red">The password requires 6 to 16 characters, which should include number and letter</span>';
	}

    $("#firstName").blur(function() {
        if ($(this).val() == '') {
            $("#firstNameInfo").text("First name cannot be null");
            $("#firstNameInfo").css({
                "color" : "#F00"
            });

        } else {
            $("#firstNameInfo").text("");
        }
    });

	// verify family name is not null
	$("#familyName").blur(function() {
		if ($(this).val() == '') {
			$("#familyNameInfo").text("Family name cannot be null");
			$("#familyNameInfo").css({
				"color" : "#F00"
			});

		} else {
			$("#familyNameInfo").text("");
		}
	});

	// verify the format of email
	$("#emailAddr").blur(
			function() {
				if ($("#familyName") != '') {
					if ($(this).val() == '') {
						$("#emaiInfo").html('<b>Email cannot be null.</b>');
						$("#emaiInfo").css({
							"color" : "#F00"
						});

					} else if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
							.test($(this).val()) == false) {
						// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
						$("#emaiInfo").html(
								'<b>The format of email address is not correct.</b>');
						$("#emaiInfo").css({
							"color" : "#F00"
						});

					} else {
                        var email = $(this).val();
                        $.ajax({
                            type : "GET",
                            url : "/user/customer/email/"+email,
                            // asyncronise, default is true
                            async : true,
                            dataType : "json",
                            error : function(data) {
                                if (data.status == 404) {
                                    $("#emaiInfo").text('');
                                    $("#btnMailVerify").removeAttr("disabled");
                                } else{
                                    if (json != null || json!=""){
                                        json = $.parseJSON(json);
                                        alert(json.error.returnUserMessage);
                                    }else{
                                        alert("Connection error");
                                    }
                                }

                            },
                            success : function(data) {
								$("#emaiInfo").css("color","red").html("<b>This email has been used!</b>");
								$("#btnMailVerify").attr("disabled","disabled");
                            }
                        });
					}
				}
			});

	$("#password")
			.blur(
					function() {
						if ($("#emailAddr") != '') {
							var m = findStr(this.value, this.value[0]);
							if (this.value == "") {
								psdInfo.innerHTML = '<i class="cuo"></i> please enter a password';

							} else if (this.value.length < 6
									|| this.value.length > 16) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">The password requires 6 to 16 characters</font>';

							} else if (!re_n.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one letter</font>';

							} else if (!re_t.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one number</font>';

							} else {
								psdInfo.innerHTML = '<i class="right"></i> ';
								psdInfo.innerHTML = '<i class="warn"></i> ';
							}
						}
					});

	$("#confirmPassword")
			.blur(
					function() {
						if (psd.value != "") {
							if (this.value != psd.value) {
								psd1Info.innerHTML = '<i class="cuo"></i> <font color="red">inconsistent</font>';
							} else {
								psd1Info.innerHTML = '';
							}
						} else {
							psd1Info.innerHTML = '<i class="cuo"></i> <font color="red">Please enter password first.</font>';
						}
					});

	$("#contactNum")
			.blur(
					function() {
						if ($('#confirmPassword').val() != '') {
							if ($(this).val() == '') {
								$("#contactInfo").text(
										'The contact number cannont be null.');
								$("#contactInfo").css({
									"color" : "#F00"
								});

							} else if (/^\({0,1}((0|\+61)(2|4|3|7|8)){0,1}\){0,1}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{1}(\ |-){0,1}[0-9]{3}$/
									.test($(this).val()) == false) {
								$("#contactInfo")
										.text(
												'The format of the contact number is wrong.');
								$("#contactInfo").css({
									"color" : "#F00"
								});

							} else {
								$("#contactInfo").text('');
							}
						} else {
							$("#contactInfo")
									.text(
											'Please complete the above information first.');
							$("#contactInfo").css({
								"color" : "#F00"
							});
						}
					});
}

function getLength(str) {
	return str.replace(/[^\x00-xff]/g, "xx").length;
}

// click to verify email address
function clickToVerifyCode(obj,usertype) {
	if ($("#emailAddr").val() != "") {
		if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
				.test($("#emailAddr").val()) != false) {
			// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
			settime(obj);

			var code = mailVerification(obj,usertype);
			$('#userMailCode').blur(function() {
				if (code != null && code != ""){
					if (code != $('#userMailCode').val()) {
						$('#emaiInfo').text('The verification code is wrong.');
						$('#emaiInfo').css({
							"color" : "#F00"
						});
						// submit is not allowed
						$("#submit").attr("disabled", true);
					} else {
						$('#emaiInfo').text('The verification code is correct.');
						$('#emaiInfo').css({
							"color" : "#000"
						});
						$("#submit").attr("disabled", false);
					}
                }
			});
		} else {
			$("#emaiInfo").text('The format of email address is not correct.');
			$("#emaiInfo").css({
				"color" : "#F00"
			});

		}
	} else {
		$('#emaiInfo').text('Please input the email address first.');
		$('#emaiInfo').css({
			"color" : "#F00"
		});
	}
}
// compare the inputed mail code and the automatically generated code
function mailVerification(obj, usertype) {
	var value;
	$("#emaiInfo").text('');
	$.ajax({
		type : "POST",
		url : "/user/verifycode",
		data : {
			username : $("#emailAddr").val(),
			usertype : usertype
		},
		async : true,
		dataType : "json",
		error : function(request) {
			alert("Connect error");
		},
		success : function(data) {
			value = data.data.code;
		}
	});
	return value;
}

// click register: transfer info to controller
function individualRegisterRequest() {
	if ($("#familyName").val() == '' || $("#emailAddr").val() == ''
			|| $("#inputPassword").val() == ''
			|| $("#confirmPassword").val() == ''
			|| $("#contactNum").val() == '' || $("#userMailCode").val() == '') {
		$("#btnInfo")
				.text(
						'Please enter necessary information with * and complete the verification of email address.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		// firstName,familyName,address,gender(radio),emailAddr,password,contactNum

        $.ajax({
            type : "POST",
            // url for request.
            // invoke methods in UserController.java
            url : "/user/customer",
            data : $("#individualRegisterForm").serialize(),
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
				alert ("register successful");
                location.href="/index.html?login=false";

            }
        });
	}
}



/**
 * organizational register organizationName; emailAddr;
 * 
 * @returns
 */
function organizationRegisterVerification() {
	var psd = document.getElementById("inputPassword")
	var psd1 = document.getElementById("confirmPassword");
	var psdInfo = document.getElementsByClassName("psdInfo")[0];
	var psd1Info = document.getElementsByClassName('psd1Info')[0];
	var name_length = 0;
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/g;
	var re_n = /[^\d]/g;
	var re_t = /[^a-zA-Z]/g

	psd.onfocus = function() {
		psdInfo.style.display = "inline-block";
		psdInfo.innerHTML = '<i class="warn"></i> The password requires 6 to 16 characters, which should include number and letter';
	}

	// verify family name is not null
	$("#organizationName").blur(
			function() {
				if ($(this).val() == '') {
					$("#organizationNameInfo").text(
							"Organization name cannot be null");
					$("#organizationNameInfo").css({
						"color" : "#F00"
					});

				} else {
					$("#organizationNameInfo").text("");
				}
			});

	// verify the format of email
	$("#emailAddr").blur(
			function() {
				if ($("#organizationName") != '') {
					if ($(this).val() == '') {
						$("#emaiInfo").html('Email cannot be null.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});

					} else if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
							.test($(this).val()) == false) {
						// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
						$("#emaiInfo").text(
								'The format of email address is not correct.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});

					} else {
						var email = $(this).val();
                        $.ajax({
                            type : "GET",
                            url : "/user/organization/email/"+email,
                            // asyncronise, default is true
                            async : true,
                            dataType : "json",
                            error : function(data) {
                                var json = data.responseText;
                                if (data.status == 404){
                                    $("#emaiInfo").css("color","red").text("This email has been used!");

                                } else{
                                    if (json != null || json!=""){
                                        json = $.parseJSON(json);
                                        alert(json.error.returnUserMessage);
                                    }else{
                                        alert("Connection error");
                                    }
                                }
                            },
                            success : function(data) {
                                $("#emaiInfo").text('');
                            }
                        });
					}
				}
			});

	$("#inputPassword")
			.blur(
					function() {
						if ($("#emailAddr") != '') {
							var m = findStr(this.value, this.value[0]);
							if (this.value == "") {
								psdInfo.innerHTML = '<i class="cuo"></i> please enter a password';

							} else if (this.value.length < 6
									|| this.value.length > 16) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">The password requires 6 to 16 characters</font>';

							} else if (!re_n.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one letter</font>';

							} else if (!re_t.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one number</font>';

							} else {
								psdInfo.innerHTML = '<i class="right"></i> ';
								psdInfo.innerHTML = '<i class="warn"></i> ';
							}
						}
					});

	$("#confirmPassword")
			.blur(
					function() {
						if (psd.value != "") {
							if (this.value != psd.value) {
								psd1Info.innerHTML = '<i class="cuo"></i> <font color="red">inconsistent</font>';
							} else {
								psd1Info.innerHTML = '';
							}
						} else {
							psd1Info.innerHTML = '<i class="cuo"></i> <font color="red">Please enter password first.</font>';
						}
					});

	$("#contactNum")
			.blur(
					function() {
						if ($('#confirmPassword').val() != '') {
							if ($(this).val() == '') {
								$("#contactInfo").text(
										'The contact number cannont be null.');
								$("#contactInfo").css({
									"color" : "#F00"
								});

							} else if (/^\({0,1}((0|\+61)(2|4|3|7|8)){0,1}\){0,1}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{1}(\ |-){0,1}[0-9]{3}$/
									.test($(this).val()) == false) {
								$("#contactInfo")
										.text(
												'The format of the contact number is wrong.');
								$("#contactInfo").css({
									"color" : "#F00"
								});

							} else {
								$("#contactInfo").text('');
							}
						} else {
							$("#contactInfo")
									.text(
											'Please complete the above information first.');
							$("#contactInfo").css({
								"color" : "#F00"
							});
						}
					});
}

// click register: transfer info to controller
function organizationRegisterRequest() {
	if ($("#organizationName").val() == '' || $("#emailAddr").val() == ''
			|| $("#inputPassword").val() == ''
			|| $("#confirmPassword").val() == ''
			|| $("#contactNum").val() == '' || $("#userMailCode").val() == '') {
		$("#btnInfo")
				.text(
						'Please enter necessary information with * and complete the verification of email address.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		// firstName,familyName,address,gender(radio),emailAddr,password,contactNum
		$.ajax({
			type : "POST",
			url : "/user/organization",
			data : $("#organizationRegisterForm").serialize(),
			dataType : "json",
			async : false,
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
                alert ("register successful");
                location.href="/index.html?login=false";

            }
		});
	}
}


// modifyProfile
// click to change: transfer info to controller
function organizationProfileModificationRequest() {
	// organizationName, inputPassword, address, contactNum,
	// organizationDescription
	if ($("#organizationName").val() == '' && $("#inputPassword").val() == ''
			&& $("#confirmPassword").val() == ''
			&& $("#contactNum").val() == '' && $("#address").val() == ''
			&& $("#organizationDescription").val() == '') {
		$("#btnInfo").text('Please enter new information to update.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		$.ajax({
			type : "POST",
			url : "user/organizationProfileModification",
			data : $("#organizationProfileForm").serialize(),
			dataType : "text",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				if (json.error.returnCode == '0') {// success
					organizationProfileModificationRedirect("success");
				} else {
					organizationProfileModificationRedirect("failure");
				}
			}
		});
	}
}

// Request Redirect
function organizationProfileModificationRedirect(destination) {
	if (destination == "success") {
		alert("You profile changed successfully!");
		var form = $("<form></form>");
		// invoke methods in ViewController.java
		form.attr("action", "organizationHome");
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
	if (destination == "failure") {
		alert("You profile is not changed!");
		var form = $("<form></form>");
		form.attr("action", "organizationProfile");
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
}

// Add a child for organization
function addNewChildAccountRequest() {
	if ($("#familyName").val() == '' || $("#emailAddr").val() == ''
			|| $("#inputPassword").val() == ''
			|| $("#confirmPassword").val() == ''
			|| $("#contactNum").val() == '' || $("#userMailCode").val() == '') {
		$("#btnInfo")
				.text(
						'Please enter necessary information with * and complete the verification of email address.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		// firstName,familyName,address,gender(radio),emailAddr,password,contactNum
		alert( $("#addNewChildForm").serialize());
		$.ajax({
			type : "POST",
			url : "user/addNewChildAccount",
			data : $("#addNewChildForm").serialize(),
			dataType : "text",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				if (json.error.returnCode == '0') {// success
					addNewChildAccountRedirect("success");
				} else {
					addNewChildAccountRedirect("failure");
				}
			}
		});
	}
}

//Request Redirect
function addNewChildAccountRedirect(destination) {
	if (destination == "success") {
		alert("The child account is added successfully!");
		var form = $("<form></form>");
		// invoke methods in ViewController.java
		form.attr("action", "organizationHome");
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
	if (destination == "failure") {
		alert("Fails to add the child account!");
		var form = $("<form></form>");
		form.attr("action", "organizationChildrenmanagement");
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
}
