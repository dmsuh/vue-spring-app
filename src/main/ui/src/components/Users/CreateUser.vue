<template>
  <div class="container">
    <div class="row">
        <div class="col-md-7 mrgnbtm">
        <h2>Регистрация</h2>
            <form>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputEmail1">ВВедите логин</label>
                        <input type="text" class="form-control" v-model="firstName" name="firstname" id="firstname" aria-describedby="emailHelp" placeholder="user" />
                    </div>
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputPassword1">Введите пароль</label>
                        <input type="text" class="form-control" v-model="password" name="password" id="password" placeholder="***************" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label htmlFor="exampleInputEmail1">Почта</label>
                        <input type="text" class="form-control" v-model="email" name="email" id="email"  placeholder="****@***.**" />
                    </div>
                </div>
                <v-btn type="button" @click='createUser()' class="btn btn-danger">Создать</v-btn>
            </form>
            <v-container> <v-container>Посмотерть вид карточки</v-container>
                <v-btn @click="need=!need">Посмотреть</v-btn>
            </v-container>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'CreateUser',
  data() {
    return {
      firstName: '',
      password: '',
      email: '',
      need: false
    }
  },
  methods: {
      createUser() {
          console.log(this.firstName)
          const payload = {
              firstName: this.firstName,
              password: this.password,
              email: this.email
          }
          this.$emit('createUser', payload)
          this.clearForm();
      },
      clearForm() {
          this.firstName = "";
          this.password = "";
          this.email = "";
      }
  }
}
</script>
