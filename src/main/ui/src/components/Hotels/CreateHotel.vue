<template>
  <div class="container">
    <div class="row">
        <div class="col-md-7 mrgnbtm">
        <h2>Создание карточки отеля</h2>
            <form>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputEmail1">ВВедите название отеля</label>
                        <input type="text" class="form-control" v-model="nameH" name="nameH" id="nameH" aria-describedby="emailHelp" placeholder="Седьмое небо" />
                    </div>
                    <div class="form-group col-md-6">
                        <label htmlFor="exampleInputPassword1">Тип отеля</label>
                        <input type="text" class="form-control" v-model="type" name="type" id="type" placeholder="отель,гостинница,санаторий" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label htmlFor="exampleInputEmail1">Адрес</label>
                        <input type="text" class="form-control" v-model="adress" name="adress" id="adress"  placeholder="Ул. Кутякова, д. 5" />
                    </div>
                </div>
                <v-btn type="button" @click='createHotel()' class="btn btn-danger">Создать</v-btn>
            </form>
            <v-container> <v-container>Посмотерть вид карточки</v-container>
                <v-btn @click="need=!need">Посмотреть</v-btn>
            </v-container>
            <v-card v-if="need" min-height=180px elevation="12" >
                <v-card-title>{{nameH}}</v-card-title>
                <v-rating
                        :value="10.0"
                        color="amber"
                        half-increments
                        readonly
                        length="5"
                        size="20"
                ></v-rating>
                <v-card-text>Тип заведения: {{type}}</v-card-text>
                <v-card-subtitle>Адрес : {{adress}}</v-card-subtitle>
            </v-card>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'CreateHotel',
  data() {
    return {
      nameH: '',
      type: '',
      adress: '',
      need: false
    }
  },
  methods: {
      createHotel() {
          console.log(this.nameH)
          const payload = {
              nameH: this.nameH,
              type: this.type,
              adress: this.adress
          }
          this.$emit('createHotel', payload)
          this.clearForm();
      },
      clearForm() {
          this.nameH = "";
          this.type = "";
          this.adress = "";
      }
  }
}
</script>
