/**
 * 不良反应记录管理初始化
 */
var AdverseReaction = {
    id: "AdverseReactionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
AdverseReaction.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '住院号', field: 'patientNumber', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '放疗次数', field: 'radiotherapyCount', visible: true, align: 'center', valign: 'middle'},
            {title: '化疗次数', field: 'chemotherapyCount', visible: true, align: 'center', valign: 'middle'},
            {title: '体重', field: 'weight', visible: true, align: 'center', valign: 'middle'},
            {title: '目前饮食', field: 'dietaryStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '乏力', field: 'weakStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '恶心', field: 'nauseaStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '呕吐', field: 'vomitStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '腹泻', field: 'diarrheaStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '便秘', field: 'constipationStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '肌肉关节痛', field: 'muscleJointPainStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '神经系统', field: 'nervousSystemStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '脱发', field: 'alopeciaStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '发热', field: 'feverStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '咳嗽', field: 'coughStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '放射性皮肤损伤', field: 'skinStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '打嗝', field: 'hiccupStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '口腔黏膜炎', field: 'oralMucositisStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '声嘶 ', field: 'hoarsenessStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '听力损伤', field: 'hearingStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '头晕 ', field: 'dizzyStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '头痛  ', field: 'headacheStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '肺炎', field: 'pneumoniaStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '进食痛 （食管炎） ', field: 'esophagitisStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '其他症状', field: 'otherStatusesDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '填表日期', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改日期', field: 'updatetime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
AdverseReaction.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        AdverseReaction.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加不良反应记录
 */
AdverseReaction.openAddAdverseReaction = function () {
    var index = layer.open({
        type: 2,
        title: '添加不良反应记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/adverseReaction/adverseReaction_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看不良反应记录详情
 */
AdverseReaction.openAdverseReactionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '不良反应记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/adverseReaction/adverseReaction_update/' + AdverseReaction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 给某一条不良反应添加附件
 */
AdverseReaction.openAddAdverseReactionPhoto = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '添加不良反应记录附件',
            area: ['460px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/adverseReaction/adverseReaction_upload/' + AdverseReaction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 查询不良反应记录列表
 */
AdverseReaction.search = function () {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['patientNumber'] = $("#patientNumber").val();
    AdverseReaction.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = AdverseReaction.initColumn();
    var table = new BSTable(AdverseReaction.id, "/adverseReaction/list", defaultColunms);
    table.setPaginationType("client");
    AdverseReaction.table = table.init();
});
