function modifyProfile(){
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
            localStorage.setItem("userType",data.data.userType);
            localStorage.setItem("userId",data.data.userId);
            var select = $('input:radio:checked').val();
            if( select == 1){
                location.href="/jsp/individualUser/individualHome.html";
            }else{
                location.href="/jsp/organizationUser/organizationHome.html";
            }
        }
    });
}