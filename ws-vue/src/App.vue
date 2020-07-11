<template>
  <div id="app">
    <el-container v-if="$route.meta.hideMenu == undefined">
      <el-header>
        <NavMenu></NavMenu>
      </el-header>
      <el-main>
        <router-view></router-view> <!--路由出口 -->
      </el-main>
    </el-container>
    <el-container v-if="$route.meta.hideMenu">
      <el-main>
        <router-view></router-view> <!--路由出口 -->
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import NavMenu from "./components/NavMenu";

  export default {
    name: 'App',
    components: {NavMenu}
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    width: 60%;
    margin-top: 60px;
    margin-right: auto;
    margin-left: auto;
  }

</style>
