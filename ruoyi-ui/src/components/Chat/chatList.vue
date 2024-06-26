<template>
  <div class="wrapper" :style="boxSize">
    <div class="scroller" ref="scroller">
      <div class="web__main" ref="main">
        <div class="pulldown-wrapper">
          <div v-html="historyConfig.tip"></div>
        </div>
        <template v-for="(item, k) in list">
          <el-divider v-if="item.type === 'tip'" :key="JSON.stringify(item) + k">{{ item.text }}</el-divider>
          <div v-else class="web__main-item" :key="`${JSON.stringify(item) + k}`"
            :class="{ 'web__main-item--mine': item.mine }">
            <div class="web__main-user">
              <img :src="item.img" @click="$emit('click', { type: 'img', data: item })" />
              <cite @click="$emit('click', { type: 'nickname', data: item })">
                {{ item.name }}
                <i>{{ item.date }}</i>
              </cite>
            </div>
            <div class="web__main-text">
              <div class="web__main-arrow"></div>
              <div v-if="item.custom">
                <slotTalk :data="item" @systemEvent="taskEvent" @loadDone="loadDone">
                  <slot name="talkItem" :data="item" />
                </slotTalk>
              </div>
              <template v-else>
                <itemTalk v-if="item.text.text" :text="item.text.text" @systemEvent="taskEvent" @loadDone="loadDone" />
                <systemTalk v-if="item.text.system" :text="item.text.system" @systemEvent="systemEvent"
                  @loadDone="loadDone" />
                <el-link @click="taskEvent(item.text)" v-if="item.text.subLink" v-bind="item.text.subLink.prop"
                  class="itemChild">
                  {{ item.text.subLink.text }}
                </el-link>
                <shopTalk v-if="item.text.shop" :text="item.text.shop" @systemEvent="taskEvent" @loadDone="loadDone" />
              </template>
            </div>
          </div>
        </template>
      </div>
    </div>
    <div v-if="showDownBtn" class="downBtn-position" @click="scrollBottom">
      <slot v-if="$scopedSlots.downBtn" name="downBtn" :unread="unread" />
      <div v-else class="downBtn">
        <span v-if="unread">{{ unread }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import Scroll from "@/utils/scroll";
// import Remind from '@/utils/remind'
import itemTalk from "./itemTalk";
import systemTalk from "./systemTalk";
import slotTalk from "./slotTalk";
import shopTalk from "./shopTalk";
export default {
  name: "JwChat_list",
  components: { itemTalk, systemTalk, shopTalk, slotTalk },
  props: {
    list: {
      type: Array,
      default: () => [],
    },
    config: {
      type: Object,
      default: () => ({}),
    },
  },
  data() {
    return {
      scroll: null,
      // remind: null, // 消息提示
      stopScroll: false,
    };
  },
  computed: {
    boxSize() {
      let { height = "382px", width = "525px" } = this.config || {};
      if (`${height}`.match(/\d$/)) {
        height += "px";
      }
      if (`${width}`.match(/\d$/)) {
        width += "px";
      }
      return { height, width };
    },
    historyConfig() {
      const { tip = "", show = false } = this.config.historyConfig || {};
      const { tipText } = this.scroll || {};
      return { tip: tip || tipText, show };
    },
    scrollType() {
      const { scrollType = "noroll" } = this.config;
      return scrollType;
    },
    unread() {
      const { unread = 0 } = this.scroll || {};
      return unread;
    },
    showDownBtn() {
      if (this.scroll) return !this.scroll.isBottom;
      return false;
    },
  },
  watch: {
    // unread (newval) {
    //   newval && Remind.showBrowser.call(this)
    //   if(!this.remind) return
    //   if (newval) {
    //     this.remind.changeTitle(newval)
    //   } else {
    //     this.remind.resetTitle()
    //   }
    // },
    boxSize() {
      this.scroll.refresh();
    },
  },
  methods: {
    loadDone() {
      if (this.scrollType == "scroll") {
        this.scrollBottom();
      }
    },
    scrollBottom() {
      if (!this.scroll) return;
      if (this.scroll.isLoding) return;
      this.scroll.refresh();
      this.scroll.scrollBottom();
    },
    createScroll() {
      const { show: pullingDown = false } = this.historyConfig || {};
      this.scroll = new Scroll(this.$refs.scroller, {
        scrollType: this.scrollType,
        pullingDown,
      });
      // 保存数据
      this.scroll.on("refresh", this.childnodeLoad);
      // 刷新
      pullingDown && this.scroll.on("pullingDown", this.pullingDownHandler);
    },
    finishPullDown() {
      this.scroll.finishPullDown();
    },
    childnodeLoad() {
      if (this.scrollType !== "noroll") return;
      const parent = this.$refs.main;
      if (!parent) return;
      const [, ...childs] = parent.children;
      this.scroll.saveNodes({ nodes: childs, dataList: this.list });
    },
    pullingDownHandler() {
      this.$emit("loadHistory", this.finishPullDown);
    },
    systemEvent(itemData) {
      this.$emit("click", { type: "systemItem", data: itemData });
    },
    taskEvent(itemData) {
      this.$emit("click", { type: "taskItem", data: itemData });
    },
  },
  mounted() {
    this.createScroll();
    // this.remind = new Remind()
  },
};
</script>

<style  scoped lang="scss">
::v-deep.iScrollVerticalScrollbar.iScrollLoneScrollbar {
  z-index: 1 !important;
}

.wrapper {
  position: relative;
  width: 525px;
  height: 382px;
  overflow: hidden;
  /* Prevent native touch events on Windows */
  touch-action: none;
  /* Prevent text resize on orientation change, useful for web-apps */
  text-size-adjust: none;

  .downBtn-position {
    position: absolute;
    cursor: pointer;
    right: 1rem;
    width: 2rem;
    height: 2rem;
    bottom: 2rem;
  }

  .downBtn {
    &::before {
      content: "V";
      position: absolute;
      background: rgba(204, 204, 204, 0.2);
      width: 2rem;
      height: 2rem;
      line-height: 2rem;
      text-align: center;
      border-radius: 50%;
      top: 60%;
      left: 50%;
      transform: translateX(-50%);
    }

    span {
      background: #409eff;
      padding: 0.1rem 0.5rem;
      font-size: 0.7rem;
      border-radius: 0.5rem;
      color: #fff;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }
  }

  .scroller {
    height: 100%;
    width: 100%;
  }

  .web__main {
    position: absolute;
    width: calc(100% - 1.5rem);
    padding: 0.5rem;
    padding-right: 1.5rem;

    /* Prevent elements to be highlighted on tap */
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);

    /* Put the scroller into the HW Compositing layer right from the start */
    transform: translateZ(0);

    .web__main-item {
      position: relative;
      font-size: 0;
      margin-bottom: 10px;
      padding-left: 60px;
      min-height: 68px;
      text-align: left;
    }

    .sysTip {
      font-size: 1rem;
      text-align: center;
    }

    .web__main-user,
    .web__main-text {
      display: inline-block;
      vertical-align: top;
      font-size: 14px;
    }

    .web__main-user {
      position: absolute;
      cursor: pointer;
      left: 3px;

      img {
        width: 40px;
        height: 40px;
        border-radius: 100%;
      }

      cite {
        position: absolute;
        left: 60px;
        top: -2px;
        /* width: 500px; */
        line-height: 24px;
        font-size: 12px;
        white-space: nowrap;
        color: #999;
        text-align: left;
        font-style: normal;

        i {
          padding-left: 15px;
          font-style: normal;
        }
      }
    }

    .web__main-text {
      max-width: 75%;
      position: relative;
      line-height: 22px;
      margin-top: 25px;
      padding: 8px 15px;
      background-color: #f3f3f3;
      border-radius: 3px;
      border: 1px solid #f0f0f0;
      color: #000;
      word-break: break-all;
    }

    .web__main-arrow {
      top: 6px;
      left: -8px;
      position: absolute;
      display: block;
      width: 0;
      height: 0;
      border-color: transparent;
      border-style: solid;
      border-width: 8px;
      border-left-width: 0;
      border-right-color: #ebeef5;

      &::after {
        content: " ";
        top: -7px;
        left: 1px;
        position: absolute;
        display: block;
        width: 0;
        height: 0;
        border-color: transparent;
        border-style: solid;
        border-width: 7px;
        border-left-width: 0;
        border-right-color: #ebeef5;
      }
    }

    .web__main-item--mine .web__main-text .web__main-arrow {
      left: auto;
      right: -5px;
      border-color: transparent;
      border-style: solid;
      border-width: 8px;
      border-right-width: 0;
      border-left-color: #409eff;

      &::after {
        left: auto;
        right: -2px;
        border-color: transparent;
        border-style: solid;
        border-width: 7px;
        border-right-width: 0;
        border-left-color: #409eff;
      }
    }

    .web__main-list {
      margin: 10px 0;

      li {
        height: 30px;
        color: #409eff;
        line-height: 30px;
      }
    }

    .web__main-item--mine {
      text-align: right;
      padding-left: 0;
      padding-right: 60px;

      .web__main-user {
        left: auto;
        right: 3px;

        cite {
          left: auto;
          right: 60px;
          text-align: right;

          i {
            padding-left: 0;
            padding-right: 15px;
          }
        }
      }

      .web__main-text {
        margin-left: 0;
        text-align: left;
        background-color: #409eff;
        color: #fff;

        img {
          max-width: 200px;
        }
      }
    }
  }
}

.pulldown-wrapper {
  position: absolute;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
  transform: translateY(-100%) translateZ(0);
  text-align: center;
  color: #999;
}
</style>