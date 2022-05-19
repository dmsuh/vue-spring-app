<template>
  <div class="hello">
    <Header @createUser="userCreate($event)" :currentUser="curUser" @getUser="getUser($event)" :visual.sync="vMain" />
      <div v-if="vMain===1">
          <div class="container mrgnbtm">
              <div class="row">
                  <div class="col-md-8">
                      {{curUser}}
                  </div>
                  <div v-if="vMain===4" class="col-md-4">
                      <DisplayBoard :numberOfUsers="numberOfUsers" @getAllUsers="getAllUsers()" />
                  </div>
              </div>
          </div>
          <div v-if="vMain===1" class="row mrgnbtm">
              <Users @updateUser="updateUser($event)"  v-if="users.length > 0" :users="users" />
          </div>
      </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import DisplayBoard from './DisplayBoard.vue'
import Users from './Users.vue'
import {getAllUsers, createUser, getUser, updateUser} from '../services/UserService'

export default {
  name: 'Dashboard',
  components: {
    Header,
    DisplayBoard,
    Users
  },
  data() {
      return {
          curUser:[],
          users: [],
          numberOfUsers: 0,
          vMain: 1,
      }
  },
  methods: {
    getAllUsers() {
      getAllUsers().then(response => {
        console.log(response)
        this.users = response
        this.numberOfUsers = this.users.length
      })
    },
    getUser(int){
        getUser(int).then(response => {
            console.log(response)
            this.curUser = response
        })
    },
    userCreate(data) {
      console.log('data:::', data)
      data.id = this.numberOfUsers + 1
      createUser(data).then(response => {
        console.log(response);
        this.getAllUsers();
      });
    },
    updateUser(data) {
       console.log('data:::', data)
       updateUser(data).then(response => {
       console.log(response);
       });
      }
  },
  mounted () {
    this.getAllUsers();
  }
}
</script>
