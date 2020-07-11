<template>
  <el-main>
    <h1>{{ msg }}</h1>
    <el-row type="flex" justify="center">
      <el-col :span="6">
        <el-input v-model="username" aria-placeholder="请输入用户名"></el-input>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :span="6">
        <el-input v-model="password" aria-placeholder="请输入密码" show-password></el-input>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-button type="info" @click="resetLoginForm">清空</el-button>
        <el-button type="info" @click="submitLoginForm">登录</el-button>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        msg: 'Login Page',
        username: '',
        password: ''
      }
    },
    methods: {
      submitLoginForm() {
        console.log("submitLoginForm : " + this.username + ' | ' + this.password)
        let data = {
          username: this.username,
          password: this.password
        };
        this.$axiosPost('/user/login', data).then(response => {
          console.log(response)
          if (response.code === 0) {
            this.setCookie('login', '123456')
            this.$router.push({path: '/homepage'})
          } else {
            alert('用户名不存在或密码错误！')
          }
        }).catch(error => {
          console.log(error)
        })
      },
      resetLoginForm() {
        console.log("resetLoginForm")
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  li {
    display: inline-block;
    margin: 0 10px;
  }

  .el-row {
    margin-bottom: 20px;
  }
</style>
