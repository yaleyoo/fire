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
		psdInfo.innerHTML = '<i class="warn"></i> The password requires 6 to 16 characters, which should include number and letter';
	}
	// verify family name is not null
	$("#familyName").blur(function() {
		if ($(this).val() == '') {
			$("#familyNameInfo").text("Family name cannot be null");
			$("#familyNameInfo").css({
				"color" : "#F00"
			});
			$(this).focus();
		} else {
			$("#familyNameInfo").text("");
		}
	});

	// verify the format of email
	$("#emailAddr").blur(
			function() {
				if ($("#familyName") != '') {
					if ($(this).val() == '') {
						$("#emaiInfo").text('Email cannot be null.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});
						$(this).focus();
					} else if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
							.test($(this).val()) == false) {
						// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
						$("#emaiInfo").text(
								'The format of email address is not correct.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});
						$(this).focus();
					} else {
						$("#emaiInfo").text('');
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
								$(this).focus();
							} else if (this.value.length < 6
									|| this.value.length > 16) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">The password requires 6 to 16 characters</font>';
								$(this).focus();
							} else if (!re_n.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one letter</font>';
								$(this).focus();
							} else if (!re_t.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one number</font>';
								$(this).focus();
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
								$(this).focus();
							} else if (/^\({0,1}((0|\+61)(2|4|3|7|8)){0,1}\){0,1}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{1}(\ |-){0,1}[0-9]{3}$/
									.test($(this).val()) == false) {
								$("#contactInfo")
										.text(
												'The format of the contact number is wrong.');
								$("#contactInfo").css({
									"color" : "#F00"
								});
								$(this).focus();
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
function clickToVerifyCode(obj) {
	if ($("#emailAddr").val() != "") {
		if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
				.test($("#emailAddr").val()) != false) {
			// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
			settime(obj);
			var code = mailVerification(obj);
			$('#userMailCode').blur(function() {
				if (code != $('#userMailCode').val()) {
					$('#emaiInfo').text('The verification code is wrong.');
					$('#emaiInfo').css({
						"color" : "#F00"
					});
					//submit is not allowed
					$("#submit").attr("disabled", true);
				}else{
					$('#emaiInfo').text('The verification code is correct.');
					$('#emaiInfo').css({
						"color" : "#000"
					});
					$("#submit").attr("disabled", false);
				}
			});
		} else {
			$("#emaiInfo").text('The format of email address is not correct.');
			$("#emaiInfo").css({
				"color" : "#F00"
			});
			$("#emailAddr").focus();
		}
	} else {
		$('#emaiInfo').text('Please input the email address first.');
		$('#emaiInfo').css({
			"color" : "#F00"
		});
	}
}
// compare the inputed mail code and the automatically generated code
function mailVerification(obj) {
	var value;
	$("#emaiInfo").text('');
	$.ajax({
		type : "POST",
		url : "user/verifyRegisterEmail",
		data : {
			emailAddr : $("#emailAddr").val()
		},
		async : false,
		dataType : "text",
		error : function(request) {
			alert("Connect error");
		},
		success : function(data) {
			var json = $.parseJSON(data);
			// json.error.returnCode : 1-failure 0-success
			// json.data : data returned
			if (json.error.returnCode == '0') {// success
				value = json.data.mailCode;
			} else {
				$('#btnMailVerify').setAttribute("disabled", false);
				$('#btnMailVerify').val("Get the CAPTCHA");
			}
		}
	});
	return value;
}

// click register: transfer info to controller
function individualRegisterRequest() {
	if ($("#familyName").val() == '' || $("#emailAddre").val() == ''
			|| $("#inputPassword").val() == ''
			|| $("#confirmPassword").val() == ''
			|| $("#contactNum").val() == '' || $("#userMailCode").val() =='') {
		$("#btnInfo").text('Please enter necessary information with * and complete the verification of email address.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		// firstName,familyName,address,gender(radio),emailAddr,password,contactNum
		$.ajax({
			type : "POST",
			url : "user/individualRegister",
			data : $("#individualRegisterForm").serialize(),
			dataType : "text",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				if (json.error.returnCode == '0') {// success
					indivudualRegisterRedirect("success");
				} else {
					indivudualRegisterRedirect("failure");
				}
			}
		});
	}
}

// Request Redirect
function indivudualRegisterRedirect(destination) {
	if (destination == "success") {
		var form = $("<form></form>");
		// invoke methods in ViewController.java
		form.attr("action", "individualHome");
		form.attr("method", "get");
		form.appendTo("body").submit();
		form.remove();
	}
	if (destination == "failure") {
		var form = $("<form></form>");
		form.attr("action", "individualRegister");
		form.attr("method", "get");
		form.appendTo("body").submit();
		form.remove();
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
					$(this).focus();
				} else {
					$("#organizationNameInfo").text("");
				}
			});

	// verify the format of email
	$("#emailAddr").blur(
			function() {
				if ($("#organizationName") != '') {
					if ($(this).val() == '') {
						$("#emaiInfo").text('Email cannot be null.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});
						$(this).focus();
					} else if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
							.test($(this).val()) == false) {
						// "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"
						$("#emaiInfo").text(
								'The format of email address is not correct.');
						$("#emaiInfo").css({
							"color" : "#F00"
						});
						$(this).focus();
					} else {
						$("#emaiInfo").text('');
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
								$(this).focus();
							} else if (this.value.length < 6
									|| this.value.length > 16) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">The password requires 6 to 16 characters</font>';
								$(this).focus();
							} else if (!re_n.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one letter</font>';
								$(this).focus();
							} else if (!re_t.test(this.value)) {
								psdInfo.innerHTML = '<i class="cuo"></i>  <font color="red">password requires at least one number</font>';
								$(this).focus();
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
								$(this).focus();
							} else if (/^\({0,1}((0|\+61)(2|4|3|7|8)){0,1}\){0,1}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{2}(\ |-){0,1}[0-9]{1}(\ |-){0,1}[0-9]{3}$/
									.test($(this).val()) == false) {
								$("#contactInfo")
										.text(
												'The format of the contact number is wrong.');
								$("#contactInfo").css({
									"color" : "#F00"
								});
								$(this).focus();
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

//click register: transfer info to controller
function organizationRegisterRequest() {
	if ($("#organizationName").val() == '' || $("#emailAddre").val() == ''
			|| $("#inputPassword").val() == ''
			|| $("#confirmPassword").val() == ''
			|| $("#contactNum").val() == '' ||  $("#userMailCode").val() =='') {
		$("#btnInfo").text('Please enter necessary information with * and complete the verification of email address.');
		$("#btnInfo").css({
			"color" : "#F00"
		});
	} else {
		$("#btnInfo").text('');
		// firstName,familyName,address,gender(radio),emailAddr,password,contactNum
		$.ajax({
			type : "POST",
			url : "user/organizationRegister",
			data : $("#organizationRegisterForm").serialize(),
			dataType : "text",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				if (json.error.returnCode == '0') {// success
					organizationRegisterRedirect("success");
				} else {
					organizationRegisterRedirect("failure");
				}
			}
		});
	}
}

// Request Redirect
function organizationRegisterRedirect(destination) {
	if (destination == "success") {
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
		var form = $("<form></form>");
		form.attr("action", "organizationRegister");
		form.attr("method", "get");
		// form.append("<input name='username' value='value'></input>"); append
		// value here if its nessesary
		form.appendTo("body").submit();
		form.remove();
	}
}
