<template>
  <el-form :model="userForm" :rules="rules" ref="ruleForm">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="userForm.username"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="userForm.password"></el-input>
    </el-form-item>
    <el-form-item label="角色" prop="userRole">
      <el-select v-model="userForm.userRole" placeholder="请选择用户角色">
        <el-option label="管理员" value="admin"></el-option>
        <el-option label="用户" value="user"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    name: "CreateUser",
    data() {
      return {
        userForm: {
          username: '',
          password: '',
          userRole: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, max: 8, message: '长度在6到8之间', trigger: 'blur'}
          ],
          userRole: [
            {required: true, message: '请选择用户角色', trigger: 'change'}
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!')
          } else {
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
