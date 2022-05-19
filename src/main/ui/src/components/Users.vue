<template>
    <div class="container">
        <h2>Users</h2>
        <table per-page="5" class="table table-bordered">
            <b-thead>
            <b-tr>
                <b-th>Логин</b-th>
                <b-th>Почта</b-th>
                <b-th>Роль</b-th>
                <b-th>Блокировка</b-th>
            </b-tr>
            </b-thead>
            <tbody>
              <tr v-for="item in users" :key="item.id">
                  <b-td>{{ item.firstName }}</b-td>
                  <b-td>{{ item.email }}</b-td>
                  <b-td>
                      <div style="display: flex"> {{ item.role}}
                          <v-spacer></v-spacer>
                          <v-btn max-height=30px v-if="item.role==='user'" @click="item.role='moderator', $emit('updateUser',item)">Повысить</v-btn>
                          <v-btn right max-height=30px v-if="item.role==='moderator'" @click="item.role='user', $emit('updateUser',item)">Понизить</v-btn>
                      </div>
                  </b-td>
                  <b-td >
                          <div style="display: flex">
                              {{ item.bloking}}
                              <v-spacer></v-spacer>
                              <v-btn max-height=30px v-if="item.bloking===0" @click="item.bloking=1, $emit('updateUser',item)">Заблокировать</v-btn>
                              <v-btn right max-height=30px v-if="item.bloking===1" @click="item.bloking=0, $emit('updateUser',item)">Разблокировать</v-btn>
                          </div>
                  </b-td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'Users',
        props: ['users'],
        data(){
            return {
                state: "Разблокировать",
        }
        },
        methods:{
        }
     }
</script>
