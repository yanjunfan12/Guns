// pages/photo/photo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: -1,
    src: ""
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
        wx.showToast({
          title: "图片选择失败",
          icon: 'fail',
          duration: 2000
        })
      },
      complete: function () {
        // complete
      }
    })
  },

  uploadPhoto: function () {
    var that = this;
    var theId = this.data.id;
    var theUrl = 'http://localhost/adverseReactionPhoto/upload/'+theId;
    console.log("theUrl=" + theUrl);
    console.log("that.data.src[0]=" + that.data.src[0]);

    wx.uploadFile({
      url: theUrl, //仅为示例 
      filePath: that.data.src[0],
      name: 'file',
      success: function (res) {        
        console.log(res);
        var obj = JSON.parse(res.data);
        var resule = obj.code;
        var msg = obj.message;
        if (resule != 200) {
          wx.showToast({
            title: '上传失败'+msg,
            icon: 'fail',
            duration: 2000
          })
        } else {
          wx.showModal({
            title: '上传成功，继续上传？',
            content: '上传成功，确定则继续上传；取消则返回上一页。',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定');
                that.setData({
                  src: ""
                });
              } else if (res.cancel) {
                console.log('用户点击取消');
                wx.navigateBack({
                  delta: 1,
                })
              }
            }
          })
        }
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