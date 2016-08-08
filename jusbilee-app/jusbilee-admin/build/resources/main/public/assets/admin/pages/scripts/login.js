var Login = function() {
    var handleLogin = function() {

        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                verifyCode: {
                    required: true
                }
            },

            messages: {
                username: {
                    required: "请填写用户登录名"
                },
                password: {
                    required: "请填写密码"
                },
                verifyCode: {
                    required: "请填写验证码"
                }
            },

            invalidHandler: function(event, validator) {
                var err = $('.alert-danger');
                err.show();
                err.find("span").text(validator.errorList[0].message);
            },
            highlight: function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function(element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            errorPlacement: function(error, element) {
            },
            submitHandler: function(form) {
                form.submit(); // form validation success, call ajax form submit
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    $('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
    }
    return {
        //main function to initiate the module
        init: function() {
            handleLogin();
        },
        refresh:function(){
            $("#vimg").attr("src", "captcha?t=" + new Date().getTime());
        }
    };
}();