<template>
  <el-container>
    <h1>{{ msg }}</h1>
  </el-container>
</template>

<script>
  export default {
    name: 'homepage',
    data() {
      return {
        msg: 'Home Page',
        username: '',
        password: ''
      }
    },
    methods: {}
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  li {
    display: inline-block;
    margin: 0 10px;
  }
</style>
