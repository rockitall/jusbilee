var Index = function() {
    var bindEvent = function() {

    };
    return {
        //main function to initiate the module
        init: function() {
            bindEvent();
        },
        menuLink : function(url){
            $.get(url,{}, function(data, xhr){
                $(".page-content-wrapper").html(data);
            }, "text");
        }
    };
}();