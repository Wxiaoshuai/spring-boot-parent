<template>
  <el-main>
    <el-row class="selectColumn">
      <el-col>
        <el-button type="info" @click="isShowAddUserDialog = true">新增</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column type="index" width="50px">
        </el-table-column>
        <el-table-column prop="username" label="用户名" width="120px">
        </el-table-column>
        <el-table-column prop="userRole" label="角色" width="120px">
        </el-table-column>
        <el-table-column prop="updateTime" label="操作时间" width="180px" :formatter="userDateFormat">
        </el-table-column>
        <el-table-column label="操作" width="180px">
          <template slot-scope="scope">
            <el-button type="info" size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="info" size="small" @click="handleEdit(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>

    <el-dialog title="添加用户" :visible.sync="isShowAddUserDialog">
      <el-form :model="userAddForm" :rules="rules" ref="ruleAddForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="userAddForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="userAddForm.password"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="userRole">
          <el-select v-model="userAddForm.userRole" placeholder="请选择用户角色">
            <el-option label="管理员" value="admin"></el-option>
            <el-option label="用户" value="user"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitAddForm('ruleAddForm')">创建</el-button>
          <el-button @click="resetForm('ruleAddForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="编辑用户" :visible.sync="isShowEditUserDialog">
      <el-form :model="userEditForm" :rules="rules" ref="ruleEditForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="userEditForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="userEditForm.password"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="userRole">
          <el-select v-model="userEditForm.userRole" placeholder="请选择用户角色">
            <el-option label="管理员" value="admin"></el-option>
            <el-option label="用户" value="user"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitEditForm('ruleEditForm')">保存</el-button>
          <el-button @click="resetForm('ruleEditForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </el-main>
</template>

<script>
  export default {
    name: 'UserManagement',
    data() {
      return {
        msg: '',
        tableData: [],
        listQuery: {
          currentPage: 1,
          limit: 10,
          username: undefined,
          role: undefined
        },
        isShowAddUserDialog: false,
        isShowEditUserDialog: false,
        userAddForm: {
          username: '',
          password: '',
          userRole: ''
        },
        userEditForm: {
          id: '',
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
    created() {
      this.queryUserData()
    },
    methods: {
      queryUserData() {
        this.$axiosGet('/user/queryUser', this.listQuery).then(response => {
          console.log(response)
          this.tableData = response.data
        }).catch(error => {
          console.log(error)
        })
      },
      JumpToCreateUser() {
        this.$router.push({path: 'createUser'})
      },
      userDateFormat(user) {
        return this.myDateFormat('YYYY-mm-dd', new Date(user.updateTime))
      },
      handleEdit(index, row) {
        this.userEditForm.id = row.id
        this.userEditForm.username = row.username
        this.userEditForm.password = row.password
        this.userEditForm.userRole = row.userRole
        this.isShowEditUserDialog = true
      },
      submitAddForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!')
            this.$axiosPost('/user/create', this.userAddForm).then(response => {
              console.log(response)
            }).catch(error => {
              console.log(error)
            })
          } else {
            return false
          }
        })
      },
      submitEditForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!')
            this.$axiosPost('/user/edit', this.userEditForm).then(response => {
              console.log(response)
            }).catch(error => {
              console.log(error)
            })
          } else {
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    }
  }
</script>

<style scoped>
  .selectColumn {
    background-color: #72767b;
  }
</style>
