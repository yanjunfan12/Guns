/**
 *
 * 下拉框中有loadData属性的
 * selectOptions封装
 *
 * @author fanyj
 */
(function () {
    var FanSelectOptions = function () {
        this.url = Feng.ctxPath +"/rest/dict/selectOptions";
    };

    FanSelectOptions.prototype = {

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
    	            type : "get",
    	            async : false,
    	            dataType:"json",
    	            data : { "parentName" : sel.attr("loadData")},
    	            success : function(result){
    	            	sel.append("<option value='' selected>未选择</option>");
    	                for (var i=0; i<result.length; i++){
    	                    if(defaultValue && defaultValue == result[i].id){
    	                        sel.append("<option value="+result[i].id+" selected>"+result[i].text+"</option>");
    	                    }else{
    	                        sel.append("<option value="+result[i].id+">"+result[i].text+"</option>");
    	                    }
    	                }
    	            }
    	        });
    	    });

            return this;
        },
    };

    window.FanSelectOptions = FanSelectOptions;

}());