<template>
  <div id="app">
    <Header/>
    <Middle :user="user" :fields="fields" :required="required" :filtered="filtered"/>
    <Footer/>
  </div>
</template>

<script>
import Header from "./components/Header";
import Middle from "./components/Middle";
import Footer from "./components/Footer";
import axios from "axios";

export default {
  name: 'App',
  components: {
    Footer,
    Middle,
    Header
  },
  data: function () {
    return {
      user: "Gosha",
      fields: {
        1: {id: 1, name: "First name", data: "Георгий"},
        2: {id: 2, name: "Last name", data: "Корнеев"},
        3: {id: 3, name: "Father name", data: "Александрович"},
        4: {id: 4, name: "Gender", data: "Муж"},
        5: {id: 5, name: "Company points", data: "Inf"}
      },
      required: {
        1: {id: 1, name: "First name"},
        2: {id: 2, name: "Last name"},
        3: {id: 3, name: "Passport number"},
        4: {id: 4, name: "Gender"},
        5: {id: 5, name: "Age"},
      },
      filtered: {
        1: {id: 1, name: "First name", data: "Георгий"},
        2: {id: 2, name: "Last name", data: "Корнеев"},
        3: {id: 3, name: "Passport number", data: "-"},
        4: {id: 4, name: "Gender", data: "Муж"},
        5: {id: 5, name: "Age", data: "-"}
      }
    }
  },
  beforeCreate() {
    this.$root.$on("onEnter", (login, password) => {
      if (password === "") {
        this.$root.$emit("onEnterValidationError", "Password is required");
        return;
      }

      const users = Object.values(this.users).filter(u => u.login === login);
      if (users.length === 0) {
        this.$root.$emit("onEnterValidationError", "No such user");
      } else {
        this.userId = users[0].id;
        this.$root.$emit("onChangePage", "Index");
      }
    });

    this.$root.$on("onRegister", () => {
      let config = {
        headers: {
          "Authorization": "Bearer fff3d794-6d22-4e1b-80cd-4072a1a1a040",
        }
      }
      axios.get("http://localhost:8082/api/user_info", config).then(response => {
        this.token = response.data;
      });
      config = {
        headers: {
          "Authorization": "Bearer " + this.token
        }
      }
      axios.get("http://localhost:8082/api/user_info", config).then(response => {
        this.fields = response.data;
      })
      let arr = {};
      for (let i = 0; i < this.required.length; ++i) {
        let isInInput = false;
        let id = -1;
        for (let j = 0; j < this.fields.length; ++j) {
          if (this.required[i].name === this.fields[j].name) {
            isInInput = true;
            id = j;
          }
        }
        if (isInInput === true) {
          arr[this.required[i].id] = {name: this.required[i].name, data: this.fields[id].data};
        } else {
          arr[this.required[i].id] = {name: this.required[i].name, data: "-"};
        }
      }
      this.fields = arr;
    });

    this.$root.$on("onLogout", () => this.userId = null);
  }
}
</script>

<style>
#app {

}
</style>
