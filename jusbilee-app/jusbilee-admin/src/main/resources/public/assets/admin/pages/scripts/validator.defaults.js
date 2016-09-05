var AdminValidator = function () {
    return {
        initDefaults: function () {
            $.validator.setDefaults({
                errorElement: 'span',
                errorClass: 'help-block help-block-error',
                highlight: function (element) {
                    $(element).closest('.form-group').addClass('has-error');
                },
                unhighlight: function (element) {
                    $(element).closest('.form-group').removeClass('has-error');
                },
                errorPlacement: function (error, element) {
                    var name = element.attr("name");
                    if (name == "startTime" || name == "endTime") {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.appendTo(element.parent());
                    }
                }
            });
            jQuery.validator.addMethod("requireDependOn", function (value, element, param) {
                if ($(param).is(":checked")) {
                    return !!value;
                }
                return true;
            }, "");
            jQuery.validator.addMethod("requireWhenEnabled", function (value, element, param) {
                if (!$(element).is(":disabled")) {
                    return !!value;
                }
                return true;
            }, "");
        }
    };
}();