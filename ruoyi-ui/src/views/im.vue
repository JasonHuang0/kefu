<template>
  <div id="app" class="wrapper">
    <JwChat-index ref="jwChat" :config="config" :taleList="list" @enter="bindEnter" v-model="inputMsg"
                  :showRightBox="true" :scrollType="scrollType" @clickTalk="talkEvent" :toolConfig="tool" :winBarConfig="winBarConfig"
                  :placeholder="placeholder" width1="80vw" height="80vh">
      <!-- <template slot="enter">
        <div>自定义输入框</div>
      </template> -->
      <!-- <template slot="enterBtn">
        <div>自定义按钮</div>
      </template> -->
      <!-- <template slot="winBarBtn">
        <div>删除按钮</div>
      </template> -->
      <!-- <template #downBtn="{ unread }">
        <div>
          未读{{ unread }}
        </div>
      </template> -->
      <template #talkItem="{ data }">
        {{ data }}
      </template>

      <JwChat-rightbox class="rightSlot" :config="rightConfig" @click="rightClick" />
      <!-- <JwChat-talk class="rightSlot" :Talelist="talk" :config="quickConfig" @event="bindTalk" /> -->
      <template slot="tools">
        <div style="width: 20rem; text-align: right" @click="toolEvent(12)" title="自定义">
          <JwChat-icon type="icon-lishi" />
        </div>
      </template>
    </JwChat-index>
  </div>
</template>

<script>
const img = "https://www.baidu.com/img/flexible/logo/pc/result.png";
const listData = [
  {
    date: "2020/04/25 21:19:07",
    text: {
      text: "<i class='el-icon-document-checked' style='font-size:2rem;'/>",
      subLink: {
        text: "a.txt",
        prop: {
          underline: false,
        },
      },
    },
    mine: false,
    name: "留恋人间不羡仙",
    img: "image/one.jpeg",
  },
  {
    date: "2020/04/25 21:19:07",
    text: { text: "全出" },
    mine: false,
    name: "留恋人间不羡仙",
    custom: true,
    img: "image/one.jpeg",
  },
  {
    date: "2020/04/25 21:19:07",
    text: { text: "只出文字" },
    mine: false,
    name: "留恋人间不羡仙",
    // custom: true,
    img: "image/one.jpeg",
  },
  {
    text: "2020/04/25 21:19:07",
    type: "tip",
  },
  {
    date: "2020/04/25 21:19:07",
    text: {
      text: "<audio data-src='https://www.w3school.com.cn/i/horse.mp3'/>",
    },
    mine: false,
    name: "只盼流星不盼雨",
    img: "image/two.jpeg",
  },
  {
    date: "2020/04/25 21:19:07",
    text: { text: "<img data-src='" + img + "'/>" },
    mine: false,
    name: "只盼流星不盼雨",
    img: "image/two.jpeg",
  },
  {
    date: "2020/04/16 21:19:07",
    text: {
      text: "<video data-src='https://www.w3school.com.cn/i/movie.mp4' controls='controls' />",
    },
    mine: true,
    name: "JwChat",
    img: "image/three.jpeg",
  },
  {
    date: "2021/03/02 13:14:21",
    mine: false,
    name: "留恋人间不羡仙",
    img: "image/one.jpeg",
    text: {
      system: {
        title: "在接入人工前，智能助手将为您首次应答。",
        subtitle: "猜您想问:",
        content: [
          {
            id: `system1`,
            text: "组件如何使用",
          },
          {
            id: `system2`,
            text: "组件参数在哪里查看",
          },
          {
            id: "system",
            text: "我可不可把组件用在商业",
          },
        ],
      },
    },
  },
  {
    date: "2020/04/25 21:19:07",
    mine: false,
    name: "留恋人间不羡仙",
    img: "image/one.jpeg",
    text: {
      shop: {
        title: `2022年寒假读一本好书小学生三四五六年级课外读
        物阅读书籍经典儿童文学 回到远古和神仙们聊天 王云超著`,
        describe:
          "购买1-3件时享受单件价￥18.20，超出数量以结算价为准，仅限购买一次:",
        price: "999.99",
        cover: "image/two.jpeg",
        // queue: 'col',
        // queue: 'row',
        tags: [
          { name: "第二件半价" },
          { name: "送50元优惠" },
          { name: "满1件,送50元优惠" },
        ],
      },
    },
  },
];
function getListArr(size) {
  const listSize = listData.length;
  if (!size) {
    size = listSize;
  }
  let result = [];
  for (let i = 0; i < size; i++) {
    const item = listData[i]; //[Math.random()*listSize>>0]
    item.id = Math.random().toString(16).substr(-6);
    result.push(item);
  }
  return result;
}
export default {
  components: {},
  data() {
    return {
      socket: null,
      scrollType: 'noroll', // scroll  noroll 俩种类型
      placeholder: "欢迎使用JwChat...",
      inputMsg: "",
      list: [],
      tool: {
        show: ["file", "history", "img", ["文件1", "", "美图"]],
        // showEmoji: false,
        callback: this.toolEvent,
      },
      rightConfig: {
        listTip: "当前在线",
        notice:
          "【公告】这是一款高度自由的聊天组件，基于AVue、Vue、Element-ui开发。点个赞再走吧 ",
        filterTip: "好友过滤",
        list: [
          {
            name: "JwChat",
            img: "image/three.jpeg",
            id: 1,
          },
          {
            id: 2,
            name: "JwChat",
            img: "image/three.jpeg",
          },
          {
            id: 3,
            name: "JwChat",
            img: "image/three.jpeg",
          },
          {
            id: 4,
            name: "留恋人间不羡仙",
            img: "image/one.jpeg",
          },
          {
            name: "只盼流星不盼雨",
            img: "image/two.jpeg",
          },
        ],
      },
      quickConfig: {
        nav: ["快捷回复", "超级回复"],
        showAdd: true,
        maxlength: 200,
        showHeader: true,
        showDeleteBtn: true,
      },
      talk: [
        "快捷回复1",
        "快捷回复2",
        "快捷回复3",
        "快捷回复4",
        "快捷回复5",
        "快捷回复6",
      ],
      config: {
        img: "image/cover.png",
        name: "JwChat",
        dept: "最简单、最便捷",
        callback: this.bindCover,
        maxlength: 20,
        historyConfig: {
          show: true,
          tip: "加载更多提示框,可以直接使用组件的",
          callback: this.bindLoadHistory,
        },
        quickList: [
          { text: "这里是jwchat，您想了解什么问题。", id: 3 },
          { text: "jwchat是最好的聊天组件", id: 4 },
          { text: "谁将烟焚散，散了纵横的牵绊；听弦断，断那三千痴缠。", id: 5 },
          { text: "长夏逝去。山野间的初秋悄然涉足。", id: 6 },
          { text: "江南风骨，天水成碧，天教心愿与身违。", id: 7 },
          { text: "总在不经意的年生。回首彼岸。纵然发现光景绵长。", id: 8 },
          { text: "外面的烟花奋力的燃着，屋里的人激情的说着情话", id: 10 },
          { text: "假如你是云，我就是雨，一生相伴，风风雨雨；", id: 11 },
          {
            text: "即使泪水在眼中打转，我依旧可以笑的很美，这是你学不来的坚强。",
            id: 12,
          },
          {
            text: " 因为不知来生来世会不会遇到你，所以今生今世我会加倍爱你。",
            id: 13,
          },
        ],
      },
      winBarConfig: {
        active: "win01",
        width: "180px",
        listHeight: "60px",
        list: [
          {
            id: "win00",
            img: "image/cover.png",
            name: "JwChat",
            dept: "最简单、最便捷",
            readNum: 1,
          },
          {
            id: "win01",
            img: "image/three.jpeg",
            name: "阳光明媚爱万物",
            dept: "沙拉黑油",
            readNum: 12,
          },
          {
            id: "win02",
            img: "image/two.jpeg",
            name: "只盼流星不盼雨",
            dept: "最后说的话",
            readNum: 12,
          },
          {
            id: "win03",
            img: "image/one.jpeg",
            name: "留恋人间不羡仙",
            dept: "这里可以放万物",
            readNum: 0,
          },
          {
            id: "win04",
            img: "image/three.jpeg",
            name: "阳光明媚爱万物",
            dept: "官方客服",
          },
        ],
        callback: this.bindWinBar,
      },
    };
  },
  methods: {
    /**
     * @description: 点击加载更多的回调函数
     * @param {*}
     * @return {*}
     */
    async bindLoadHistory(done) {
      const history = new Array(3).fill().map((i, j) => {
        return {
          date: "2020/05/20 23:19:07",
          text: { text: j + new Date() },
          mine: false,
          name: "JwChat",
          img: "image/three.jpeg",
        };
      });
      let list = history.concat(this.list);
      this.list = list;
      console.log("加载历史", list, history);
      //  加载完成后通知组件关闭加载动画
      this.config.historyConfig.tip = "加载完成";

      this.$nextTick(() => {
        // 组件完成加载后需要需要告知组件 下列方法任选一种
        // 1.直接调用 done
        done()
        // 2.直接使用组件方法
        // this.$refs.jwChat.finishPullDown();
      });
    },
    talkEvent(play) {
      console.log(play);
    },
    bindEnter(str) {
      const msg = this.inputMsg;
      console.log(msg, str);
      if (!msg) return;
      const msgObj = {
        date: "2020/05/20 23:19:07",
        text: { text: msg },
        mine: true,
        name: "JwChat",
        img: "image/three.jpeg",
      };
      this.list.push(msgObj);
      const msgObj1 = {
        date: "2020/05/20 23:19:07",
        message: msg,
        mine: true,
        name: "JwChat",
        msgType: "image/three.jpeg",
        type: "image/three.jpeg",
        toUser: "45666",
      };
      this.socket.send(JSON.stringify(msgObj1))
    },
    /**
     * @description:
     * @param {*} type 当前点击的按钮
     * @param {*} plyload 附加文件或者需要处理的数据
     * @return {*}
     */
    toolEvent(type, plyload) {
      console.log("tools", type, plyload);
    },
    bindCover(event) {
      console.log("header", event);
    },
    rightClick(type) {
      console.log("rigth", type);
    },
    bindTalk(play) {
      console.log("talk", play);
      const { key, value } = play;
      if (key === "navIndex")
        this.talk = [1, 1, 1, 1, 1, 1, 1, 1].reduce((p) => {
          p.push("随机修改颜色 #" + Math.random().toString(16).substr(-6));
          return p;
        }, []);
      if (key === "select") {
        this.inputMsg = value;
        this.bindEnter();
      }
      if (key === "delIndex") {
        this.talk.splice(value, 1);
      }
    },
    bindWinBar(play = {}) {
      const { type, data = {} } = play;
      console.log(play);
      if (type === "winBar") {
        const { id, dept, name, img } = data;
        this.config = { ...this.config, id, dept, name, img };
        this.winBarConfig.active = id;
        if (id === "win00") {
          this.list = getListArr();
        } else this.list = getListArr((Math.random() * 4) >> 0);
      }
      if (type === "winBtn") {
        const { target: { id } = {} } = data;
        const { list } = this.winBarConfig;
        this.winBarConfig.list = list.reduce((p, i) => {
          if (id != i.id) p.push(i);
          return p;
        }, []);
      }
    },
    connect(){

      let _this = this;
      /*
      判断浏览器是否支持webSocket
      */
      if (typeof (WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
      } else {
        console.log("您的浏览器支持WebSocket");
        // let socketUrl = "ws://localhost:8080/chat/myServer/" + this.user.username;
        let socketUrl = "ws://localhost:8080/chat/im?appid=123&userid=45666&username=沃尔夫";
        if (this.socket != null) {
          this.socket.close();
          this.socket = null;
        }
        /*
        开启一个websocket服务
         */
        this.socket = new WebSocket(socketUrl);
        this.handleSocket(this.socket, _this);
      }
    },
    handleSocket(socket, _this) {
      /*
      打开事件
       */
      socket.onopen = function () {
        console.log("websocket已打开");
      };

      /*
      浏览器端收消息，获得从服务端发送过来的文本消息
       */
      socket.onmessage = function (msg) {
        console.log("收到数据====" + msg.data)
        // 对收到的json数据进行解析，
        // //类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
        let data = JSON.parse(msg.data)
        console.log(data)
        /*
          如果存在该users字段，说明这时公共消息，则如下处理，
          获取当前连接的所有用户信息，并且使用vue过滤器将本人排除在在线用户展示列表之外，
          使得自己不会出现在自己的聊天列表里
           */
        if (data.users) {
          _this.users = data.users.filter(user => user.username.trim() !== _this.user.username.trim())
        }
        /*
        如果不存在users字段，且不存在text字段时，
        则说明信息为控制类信息，做一下处理
         */
        else if(data.text==null){
          let tip = data.function;
          console.log("function:"+tip);
          let remoteFriend = data.from;
          /*
          当控制信息为leave时，
          说明之前想和自己通信的用户取消了和自己通信的请求
          做以下操作
           */
          if(tip==='leave'){
            _this.handleDisconnect(remoteFriend)
          }
          /*
          当控制信息为link时，
          说明有用户发起了想和自己通信的请求
          做以下操作
           */
          else if(tip==='link'){
            _this.handleRequest(remoteFriend)
          }
        }
        /*
          如果包含text字段，则说明是常规聊天信息
          形如：  {"from": "zhang", "text": "hello"}
        */
        else {
          if (data.from === _this.chatUser) {
            /*
            构建消息内容
             */
            _this.createContent(data.from, null, data.text)
          }
        }
      };

      /*
      关闭事件
       */
      socket.onclose = function () {
        console.log("websocket已关闭");
      };

      /*
      发生了错误事件
       */
      socket.onerror = function () {
        console.log("websocket发生了错误");
      }
    },
  },
  mounted() {
    this.list = getListArr();
    this.connect();
  },
};
</script>
<style scoped>
.rightSlot {
  width: 100%;
  height: 100%;
  overflow: hidden;
  flex-direction: column;
}
</style>
<style>
.active {
  color: red;
}

* {
  padding: 0;
  margin: 0;
}

body {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  background-image: linear-gradient(to bottom right, #7a88ff, #7affaf);
}

#app {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  /* width: 70vw; */
  /* margin: 0 auto; */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
