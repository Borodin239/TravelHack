<template>
  <div class="register form-box">
    <div class="header">Register or Login</div>
    <div class="body">
      <form>
        <div class="field">
          <div class="name">
            <label for="name">Name</label>
          </div>
          <div class="value">
            <input id="name" name="name" v-model="name"/>
          </div>
        </div>
        <div class="field">
          <div class="name">
            <label for="login">Login</label>
          </div>
          <div class="value">
            <input autofocus id="login" name="login" v-model="login"/>
          </div>
        </div>
        <div class="field error">{{ error }}</div>
        <div class="button-field">
          <input type="submit" class="register" value="Register" @click.prevent="changePage('User')">
        </div>
      </form>
      <form>
        <div>
          <img src="../../assets/img/login-russpass.png" alt="russpass" v-on:click="onRegister">
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data: function () {
    return {
      login: "",
      name: "",
      error: ""
    }
  },
  methods: {
    onRegister: function () {
      this.$root.$emit("onRegister");
    },
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    }
  },
  beforeCreate() {
    this.$root.$on("onRegisterValidationError", (error) => this.error = error);
  }
}
</script>

<style scoped>
img {
  width: 20rem;
  padding-left: 5rem;
  padding-bottom: 1rem;
}

.button-field input {
  width: 10rem;
}

.field {
  padding-right: 2rem;
}
</style>