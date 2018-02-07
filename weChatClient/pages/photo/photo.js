// pages/photo/photo.js
const app = getApp();

Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    text: '记录附件',
    id: -1,
    src: [],
    hints: '',
    modalHidden2: true
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
  back: function() {
    wx.navigateBack({
      delta: 1,
    })
  },
  gotoShow: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 最多可以选择的图片张数，默认9
      sizeType: ['original', 'compressed'], // original 原图，compressed 压缩图，默认二者都有
      sourceType: ['album', 'camera'], // album 从相册选图，camera 使用相机，默认二者都有
      success: function (res) {
        // success
        console.log(res);
        that.setData({
          src: res.tempFilePaths
        })
      },
      fail: function () {
        console.log("gotoShow fail");
        that.modalTap2("图片选择失败");
      },
      complete: function () {
        // complete
      }
    })
  },

  uploadPhoto: function () {
    var that = this;
    var theId = this.data.id;
    var theUrl = app.globalData.fanUrlHead+'/adverseReactionPhoto/upload/'+theId;
    console.log("theUrl=" + theUrl);
    var theSrc = that.data.src;
    console.log("theSrc=" + JSON.stringify(theSrc));
    if (theSrc.length<1){
      console.warn("未选择图片" + theUrl);
      that.modalTap2("未选择图片");
      return;
    }

    wx.uploadFile({
      url: theUrl, //仅为示例 
      filePath: theSrc[0],
      name: 'file',
      success: function (res) {        
        console.log("上传成功返回：" + JSON.stringify(res));
        var obj = JSON.parse(res.data);
        var resultCode = obj.code;
        var msg = obj.message;
        if (resultCode != 200) {
          console.warn(theUrl+"服务器返回结果不为200,为" + JSON.stringify(res));
          that.modalTap2('上传失败:' + msg);
        } else {
          wx.showModal({
            title: '上传成功，继续上传？',
            content: '上传成功，确定则继续上传；取消则返回上一页。',
            success: function (res) {
              if (res.confirm) {
                console.log('继续上传？用户点击确定');               
              } else if (res.cancel) {
                console.log('继续上传？用户点击取消');
                wx.navigateBack({
                  delta: 1,
                })
              }
            }
          })
        }
      },
      fail: function () {
        console.error("上传失败 fail " + theUrl);
        that.modalTap2("上传失败,请确保网络可用,重新上传");
      },
      complete:function(){//无论成功失败，清空之前选择的图片
        that.setData({
          src: []
        });
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      id: options.id
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})