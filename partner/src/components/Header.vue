<template>
  <header>
    <a href="#" @click.prevent="changePage('Index')">
      <div class="site-name">
        <p1>Partner</p1><p2>.com</p2>
      </div>
    </a>
    <div class="languages">
      <a href="#"><img src="../assets/img/gb.png" alt="In English" title="In English"/></a>
      <a href="#"><img src="../assets/img/ru.png" alt="In Russian" title="In Russian"/></a>
    </div>
    <div class="enter-or-register-box">
      <template v-if="userId">
        {{ users[userId].name }}
        |
        id: {{ userId }}
        |
        <a href="#" @click.prevent="onLogout">Logout</a>
      </template>
      <template v-else>
        <a class="link" href="#" @click.prevent="changePage('Enter')">Enter</a>
        <p1 class="link">|</p1>
        <a class="link" href="#" @click.prevent="changePage('Register')">Register</a>
      </template>
    </div>
    <nav>
    </nav>
  </header>

</template>

<script>
export default {
  name: "Header",
  props: ["userId", "users"],
  methods: {
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    },
    onLogout: function () {
      this.$root.$emit("onLogout");
      this.changePage("Index");
    }
  }
}
</script>

<style scoped>
header {
  font-size: 1.5rem;
  background: #003580;
}
p1 {
  color: white;
}
p2 {
  color: dodgerblue;
}
.site-name {
  padding-top: 1.8rem;
  padding-left: 1rem;
}
.languages {
  padding-right: 0.5rem;
}
.link {
  color: white;
}
</style>