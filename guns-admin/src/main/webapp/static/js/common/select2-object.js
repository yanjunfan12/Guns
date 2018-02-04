/**
 *
 * 下拉框中有loadData属性的
 * select2 的封装
 *
 * @author fanyj
 */
(function () {
    var FanSelect2 = function () {
        this.url = Feng.ctxPath +"/dict/select2";
    };

    FanSelect2.prototype = {

        /**
         * 初始化bootstrap table
         */
        init: function () {
        	var me=this;

       	    //加载下拉菜单 index - 选择器的 index 位置 element - 当前的元素（也可使用 "this" 选择器）
    	    $("select[loadData]").each(function(index,element){
    	        var sel = $(element);
    	        var defaultValue = sel.attr("defaultValue");//默认值
    	        $.ajax({
    	            url : me.url,
    	            type : "post",
    	            async : false,
    	            dataType:"json",
    	            data : { "parentName" : sel.attr("loadData")},
    	            success : function(result){
    	                for (var i=0; i<result.length; i++){
    	                    if(defaultValue && defaultValue == result[i].id){
    	                        sel.append("<option value="+result[i].id+" selected>"+result[i].text);
    	                    }else{
    	                        sel.append("<option value="+result[i].id+">"+result[i].text);
    	                    }
    	                }
    	            }
    	        });
    	    });

            return this;
        },
    };

    window.FanSelect2 = FanSelect2;

}());