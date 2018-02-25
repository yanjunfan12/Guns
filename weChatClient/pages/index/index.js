//index.js
//获取应用实例
const app = getApp();

Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    text: '治疗记录',
    weakStatusIndex: -1,
    weakStatusArray: {},
    dietaryStatusIndex: -1,
    dietaryStatusArray: {},
    nauseaStatusIndex: -1,
    nauseaStatusArray: {},
    vomitStatusIndex: -1,
    vomitStatusArray: {},
    diarrheaStatusIndex: -1,
    diarrheaStatusArray: {},
    constipationStatusIndex: -1,
    constipationStatusArray: {},
    muscleJointPainStatusIndex: -1,
    muscleJointPainStatusArray: {},
    nervousSystemStatusIndex: -1,
    nervousSystemStatusArray: {},
    alopeciaStatusIndex: -1,
    alopeciaStatusArray: {},
    feverStatusIndex: -1,
    feverStatusArray: {},
    coughStatusIndex: -1,
    coughStatusArray: {},    
    skinStatusIndex: -1,
    skinStatusArray: {},
    hiccupStatusIndex: -1,
    hiccupStatusArray: {},
    oralMucositisStatusIndex: -1,
    oralMucositisStatusArray: {},
    hoarsenessStatusIndex: -1,
    hoarsenessStatusArray: {},
    hearingStatusIndex: -1,
    hearingStatusArray: {},
    dizzyStatusIndex: -1,
    dizzyStatusArray: {},
    headacheStatusIndex: -1,
    headacheStatusArray: {},
    pneumoniaStatusIndex: -1,
    pneumoniaStatusArray: {},
    esophagitisStatusIndex: -1,
    esophagitisStatusArray: {},

    otherStatusesDesc: null,
    name: null,
    patientNumber: null,
    radiotherapyCount: null,
    chemotherapyCount: null,
    weight: null,

    toast1Hidden: true,
    modalHidden: true,
    modalHidden2: true,
    notice_str: '',
    hints: '',
    formData:{} 
  },  
  toast1Change: function (e) {
    this.setData({ toast1Hidden: true });
  },
  //弹出确认框
  modalTap: function (e) {
    this.setData({
      modalHidden: false
    })
  },
  confirm_one: function (e) {
    console.log(e);
    var formData = this.data.formData;
    console.log('formData为', JSON.stringify(formData));
    var indexUrl = app.globalData.fanUrlHead + '/adverseReaction/add';
    console.log("indexUrl=" + indexUrl);
    var that=this;
    wx.request({
      url: indexUrl,
      data: formData,
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log(JSON.stringify(res));
        
        var obj = res.data;
        var resultCode = obj.code;
        var msg = obj.message;
        if (resultCode != 200) {
          console.warn(indexUrl + "服务器返回结果不为200,为" + JSON.stringify(res));
          that.setData({
            modalHidden: true
          });
          that.modalTap2('提交失败:' + msg);
        } else {
          that.setData({
            modalHidden: true,
            toast1Hidden: false,
            notice_str: '提交成功.',
          });
          that.resetForm();
        }
      },
      fail: function () {
        console.error("submit fail " + JSON.stringify(formData));
        that.setData({
          modalHidden: true
        });
        that.modalTap2('提交失败,请重新提交');
      },
      complete: function () {
      }
    })
  },
  cancel_one: function (e) {
    console.log("取消提交"+e);
    this.setData({
      modalHidden: true,
      toast1Hidden: false,
      notice_str: '取消成功'
    });
  },
  //弹出提示框
  modalTap2: function (msg) {
    this.setData({
      modalHidden2: false,
      hints: msg
    })
  },
  modalChange2: function (e) {
    this.setData({
      modalHidden2: true
    })
  },
  bindPickerChangeDietaryStatusIndex: function (e) {
    console.log('dietaryStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      dietaryStatusIndex: e.detail.value
    })
  },
  bindPickerChangeWeakStatusIndex: function (e) {
    console.log('weakStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      weakStatusIndex: e.detail.value
    })
  },
  bindPickerChangenauseaStatusIndex: function (e) {
    console.log('nauseaStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      nauseaStatusIndex: e.detail.value
    })
  },
  bindPickerChangevomitStatusIndex: function (e) {
    console.log('vomitStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      vomitStatusIndex: e.detail.value
    })
  },
  bindPickerChangediarrheaStatusIndex: function (e) {
    console.log('diarrheaStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      diarrheaStatusIndex: e.detail.value
    })
  },  
  bindPickerChangeconstipationStatusIndex: function (e) {
    console.log('constipationStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      constipationStatusIndex: e.detail.value
    })
  },
  bindPickerChangemuscleJointPainStatusIndex: function (e) {
    console.log('muscleJointPainStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      muscleJointPainStatusIndex: e.detail.value
    })
  },
  bindPickerChangenervousSystemStatusIndex: function (e) {
    console.log('nervousSystemStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      nervousSystemStatusIndex: e.detail.value
    })
  },
  bindPickerChangealopeciaStatusIndex: function (e) {
    console.log('alopeciaStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      alopeciaStatusIndex: e.detail.value
    })
  },
  bindPickerChangefeverStatusIndex: function (e) {
    console.log('feverStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      feverStatusIndex: e.detail.value
    })
  },
  bindPickerChangecoughStatusIndex: function (e) {
    console.log('coughStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      coughStatusIndex: e.detail.value
    })
  },
  bindPickerChangeskinStatusIndex: function (e) {
    console.log('skinStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      skinStatusIndex: e.detail.value
    })
  },
  bindPickerChangehiccupStatusIndex: function (e) {
    console.log('hiccupStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      hiccupStatusIndex: e.detail.value
    })
  },
  bindPickerChangeoralMucositisStatusIndex: function (e) {
    console.log('oralMucositisStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      oralMucositisStatusIndex: e.detail.value
    })
  },  
  bindPickerChangehoarsenessStatusIndex: function (e) {
    console.log('hoarsenessStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      hoarsenessStatusIndex: e.detail.value
    })
  },
  bindPickerChangehearingStatusIndex: function (e) {
    console.log('hearingStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      hearingStatusIndex: e.detail.value
    })
  },
  bindPickerChangedizzyStatusIndex: function (e) {
    console.log('dizzyStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      dizzyStatusIndex: e.detail.value
    })
  },
  bindPickerChangeheadacheStatusIndex: function (e) {
    console.log('headacheStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      headacheStatusIndex: e.detail.value
    })
  }, bindPickerChangepneumoniaStatusIndex: function (e) {
    console.log('pneumoniaStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      pneumoniaStatusIndex: e.detail.value
    })
  },
  bindPickerChangeesophagitisStatusIndex: function (e) {
    console.log('esophagitisStatus picker发送选择改变,携带值为', e.detail.value)
    this.setData({
      esophagitisStatusIndex: e.detail.value
    })
  },  
  refreshSelectOptions: function(){
    this.getUserInfo();
    this.resetSelectOptions();
    this.setData({
      toast1Hidden: false,
      notice_str: '刷新选项完成'
    });
  },
  resetSelectOptions: function(){//重置选项
    var that = this;

    this.getOptions('乏力',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          weakStatusArray: data
        });
      }
    );
    this.getOptions('目前饮食',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          dietaryStatusArray: data
        });
      }
    );
    this.getOptions('恶心',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          nauseaStatusArray: data
        });
      }
    );
    this.getOptions('呕吐',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          vomitStatusArray: data
        });
      }
    );
    this.getOptions('腹泻',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          diarrheaStatusArray: data
        });
      }
    );
    this.getOptions('便秘',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          constipationStatusArray: data
        });
      }
    );
    this.getOptions('肌肉关节痛',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          muscleJointPainStatusArray: data
        });
      }
    );
    this.getOptions('神经系统',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          nervousSystemStatusArray: data
        });
      }
    );
    this.getOptions('脱发',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          alopeciaStatusArray: data
        });
      }
    );
    this.getOptions('发热',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          feverStatusArray: data
        });
      }
    );
    this.getOptions('咳嗽',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          coughStatusArray: data
        });
      }
    );
    this.getOptions('放射性皮肤损伤',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          skinStatusArray: data
        });
      }
    );
    this.getOptions('打嗝',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          hiccupStatusArray: data
        });
      }
    );
    this.getOptions('口腔黏膜炎',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          oralMucositisStatusArray: data
        });
      }
    );
    this.getOptions('声嘶',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          hoarsenessStatusArray: data
        });
      }
    );
    this.getOptions('听力损伤',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          hearingStatusArray: data
        });
      }
    );
    this.getOptions('头晕',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          dizzyStatusArray: data
        });
      }
    );
    this.getOptions('头痛',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          headacheStatusArray: data
        });
      }
    );
    this.getOptions('肺炎',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          pneumoniaStatusArray: data
        });
      }
    );
    this.getOptions('进食痛',
      function (parentName, data) {
        console.log(parentName + " data=" + JSON.stringify(data));
        that.setData({
          esophagitisStatusArray: data
        });
      }
    );
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    this.resetSelectOptions();   

    this.getUserInfo();
  },
  getUserInfo: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {

  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  getOptions: function (parentName, func) {//
    var that = this;
    console.log("parentName=" + parentName);
    wx.request({
      url: app.globalData.fanUrlHead + '/dict/selectOptions',
      data: {
        'parentName': parentName
      },
      method: 'GET',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log(parentName + " getOptions res=" + JSON.stringify(res));
        func(parentName,res.data);
      },
      fail: function () {
        console.error(parentName + " getOptions fail");
        that.setData({
          toast1Hidden: false,
          notice_str: '初始化失败,请确保网络可用,刷新选项后使用'
        });
      },
      complete: function () {
      }
    })      
  },
  formSubmit: function (e) {
    console.log('formSubmit e=', e);
    this.setData({
      formData : e.detail.value
    });
    this.modalTap();
  },
  formReset: function () {
    console.log('form发生了reset事件');
    this.modalTap2('清空成功');
  },
  resetForm: function (){
    this.setData({
      weakStatusIndex: -1,
      dietaryStatusIndex: -1,
      nauseaStatusIndex: -1,
      vomitStatusIndex: -1,
      diarrheaStatusIndex: -1,
      constipationStatusIndex: -1,
      muscleJointPainStatusIndex: -1,
      nervousSystemStatusIndex: -1,
      alopeciaStatusIndex: -1,
      feverStatusIndex: -1,
      coughStatusIndex: -1,
      skinStatusIndex: -1,
      hiccupStatusIndex: -1,
      oralMucositisStatusIndex: -1,
      hoarsenessStatusIndex: -1,
      hearingStatusIndex: -1,
      dizzyStatusIndex: -1,
      headacheStatusIndex: -1,
      pneumoniaStatusIndex: -1,
      esophagitisStatusIndex: -1,
      otherStatusesDesc: null,
      name: null,
      patientNumber: null,
      radiotherapyCount: null,
      chemotherapyCount: null,
      weight: null,
    });
  }
})
