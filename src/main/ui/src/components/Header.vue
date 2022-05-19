<template>
    <div style="display: inline-flex" class="header">
        <div style="display: flex;justify-content:flex-start;align-items: center " @click="clicked"  class="custom-checkbox mini-50"> <a href="DisplayBoard">Забронируй.ру</a></div>
        <v-spacer></v-spacer>
        <template>
            <v-row style="justify-content: right; align-content: center">
                <div v-if="lg">
                    <v-btn
                        color="primary"
                        dark
                        v-if="on1"
                        @click="on1=!on1, dialog1=!dialog1"
                >
                    Войти
                </v-btn>
                    <v-dialog
                            v-model="dialog1"
                            style="display: block!important;"
                            persistent
                            max-width="600px"
                            width="600px"
                    >

                        <v-card>
                            <v-card-title>
                                <span class="text-h5">Войти</span>
                            </v-card-title>
                            <v-card-text>
                                <v-container>
                                    <v-form
                                            ref="form"
                                            v-model="valid1"
                                    >
                                        <v-row>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                            >
                                                <v-text-field
                                                        v-model="firstName1"
                                                        :counter="20"
                                                        :rules="nameRules"
                                                        label="username*"
                                                        required
                                                ></v-text-field>
                                            </v-col>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                            >
                                                <v-text-field
                                                        v-model="password1"
                                                        label="Password*"
                                                        :counter="20"
                                                        :rules="passwordRules"
                                                        type="password"
                                                ></v-text-field>
                                            </v-col>
                                            <v-col cols="12">
                                                <v-text-field
                                                        v-model="email1"
                                                        :rules="emailRules"
                                                        label="Email*"
                                                        required
                                                ></v-text-field>
                                            </v-col>
                                        </v-row>
                                    </v-form>
                                </v-container>
                                <small>*Поля которые должны быть заполнены</small>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                        color="blue darken-1"
                                        text
                                        @click="dialog1=!dialog1, on1=!on1"
                                >
                                    Закрыть
                                </v-btn>
                                <v-btn
                                        :disabled="!valid1"
                                        class="mr-4"
                                        color="blue darken-1"
                                        text
                                        @click="dialog1=!dialog1,on1=!on1,loginUser()"
                                >
                                    Отправить
                                </v-btn>
                            </v-card-actions>
                        </v-card>

                    </v-dialog>
                    <v-btn
                            color="primary"
                            dark
                            v-if="on"
                            @click="on=!on, dialog=!dialog"
                    >
                        Регистрация
                    </v-btn>
                    <v-dialog
                            v-model="dialog"
                            style="display: block!important;"
                            persistent
                            max-width="600px"
                            width="600px"
                    >

                        <v-card>
                            <v-card-title>
                                <span class="text-h5">Регистрация</span>
                            </v-card-title>
                            <v-card-text>
                                <v-container>
                                    <v-form
                                            ref="form"
                                            v-model="valid"
                                    >
                                        <v-row>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                            >
                                                <v-text-field
                                                        v-model="firstName"
                                                        :counter="20"
                                                        :rules="nameRules"
                                                        label="username*"
                                                        required
                                                ></v-text-field>
                                            </v-col>
                                            <v-col
                                                    cols="12"
                                                    sm="6"
                                            >
                                                <v-text-field
                                                        v-model="password"
                                                        label="Password*"
                                                        :counter="20"
                                                        :rules="passwordRules"
                                                        type="password"
                                                ></v-text-field>
                                            </v-col>
                                            <v-col cols="12">
                                                <v-text-field
                                                        v-model="email"
                                                        :rules="emailRules"
                                                        label="Email*"
                                                        required
                                                ></v-text-field>
                                            </v-col>
                                        </v-row>
                                    </v-form>
                                </v-container>
                                <small>*Поля которые должны быть заполнены</small>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                        color="blue darken-1"
                                        text
                                        @click="dialog=!dialog, on=!on"
                                >
                                    Закрыть
                                </v-btn>
                                <v-btn
                                        :disabled="!valid"
                                        class="mr-4"
                                        color="blue darken-1"
                                        text
                                        @click="dialog=!dialog,on=!on,createUser()"
                                >
                                    Отправить
                                </v-btn>
                            </v-card-actions>
                        </v-card>

                    </v-dialog>
                </div>
                <div v-if="!lg">
                    <v-btn>Личный кабинет</v-btn>
                </div>

            </v-row>
        </template>
    </div>
</template>

<script>
    export default {
        name: 'Header',

        props: ['visual','currentUser'],
        data(){
            return{
                lg: true,
                valid:true,
                firstName: '',
                password: '',
                email: '',
                on: true,
                valid1:true,
                firstName1: '',
                password1: '',
                email1: '',
                on1: true,
                attrs: false,
                dialog: false,
                dialog1: false,
                curUser: [],
                nameRules: [
                    v => !!v || 'Name is required',
                    v => /[a-zA-Z0-9]+$/.test(v)|| 'Логин состоит из латтаницы и цифр',
                    v => v.length <= 20 || 'Длина должна быть меньше 20',
                    v => v.length >= 4 || 'Длина должна быть больше 3',
                ],
                passwordRules: [
                    v => !!v || 'Name is required',
                    v => /[a-zA-Z0-9]+$/.test(v)|| 'Логин состоит из латтаницы и цифр',
                    v => /[a-zA-Z]/.test(v)|| 'Логин должен содержать хоть одну букву',
                    v => /[0-9]/.test(v)|| 'Логин должен содержать хоть одну цифру',
                    v => v.length <= 20 || 'Длина должна быть меньше 20',
                    v => v.length >= 6 || 'Длина должна быть больше 6',
                ],
                emailRules: [
                    v => !!v || 'E-mail is required',
                    v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                ]
            }
        },
        methods: {
            clicked() {
                this.$emit("update:visual", 1);
            },
            loginUser(){
                this.$emit('getUser', this.firstName1)
                console.log()
            },
            createUser() {
                this.$emit('getUser', this.firstName)
                setTimeout(()=>this.pickUser(),5000)

            },
            clearForm() {
                this.firstName = "";
                this.password = "";
                this.email = "";
            },
            pickUser(){
                //console.log(this.currentUser.firstName)
                if(this.currentUser.firstName===this.firstName){
                    alert('Логин занят')
                    this.clearForm()
                }
                else{
                    const payload = {
                        firstName: this.firstName,
                        password: this.password,
                        email: this.email
                    }
                    this.$emit('createUser', payload)
                    this.clearForm();
                }
            }

            }

    }
</script>
