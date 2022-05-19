<template>
    <div class="container">
        <h2>CurUsers</h2>
        <table per-page="5" class="table table-bordered">
            <b-thead>
            <b-tr>
                <b-th>Логин</b-th>
                <b-th>Почта</b-th>
                <b-th>Роль</b-th>
            </b-tr>
            </b-thead>
            <tbody>
              <tr v-for="item in curUsers" :key="item.id">
                  <b-td>{{ item.firstName }}</b-td>
                  <b-td>{{ item.email }}</b-td>
                  <b-td>{{ item.role}}</b-td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'CurUsers',
        props: ['curUsers']
     }
</script>
