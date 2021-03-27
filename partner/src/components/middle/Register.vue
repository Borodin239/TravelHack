<template>
  <div class="register form-box">
    <div class="header">Register or Login</div>
    <div class="body">
      <form @submit.prevent="onRegister">
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
          <input type="submit" class="register" value="Register">
        </div>
        <div>
          <a href="#"><img src="../../assets/img/login-russpass.png" alt="russpass"></a>
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
      this.$root.$emit("onRegister", this.login, this.name);
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
.field {
  padding-right: 2rem;
}

.button-field input {
  appearance: none;
  width: 8rem;
  height: 2.5rem;
  background-color: #003580;
  outline: none;
}

.button-field:before {
  display: inline-block;
  width: 0.1rem;
  padding-left: 0.1rem;
  content: "";
}

.button-field input:checked {
  appearance: revert;
}

.button-field input {
  color: white;
}
</style>