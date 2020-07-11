<template>
  <div id="NavMenu">
    <el-menu :default-active="activeIndex"
             class="el-menu-demo"
             mode="horizontal"
             @select="handleSelect"
             background-color="#545c64"
             active-text-color="#ffd04b"
             router>
      <template v-for="menu in navMenuData">
        <el-menu-item :index="menu.index">{{menu.name}}</el-menu-item>
      </template>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data() {
      return {
        activeIndex: 'home',
        navMenuData: [
          {index: 'homepage', name: '首页'},
          {index: 'userManagement', name: '用户'}
        ]
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath)
      }
    },
    mounted() {
      console.log(this.activeIndex)
      console.log(this.$route.path)
      this.activeIndex = this.$route.path.substring(1, this.$route.path.length)
      console.log(this.activeIndex)
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
