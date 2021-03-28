<template>
  <div class="buy-ticket">
    <div class="header">
      <span>Required personal data</span>
    </div>
    <div class="body">
      <ul class="left-part">
        <li>
          <span>Имя</span>
        </li>
        <li>
          <span>Фамилия</span>
        </li>
        <li>
          <span>Отчество</span>
        </li>
        <li>
          <span>Пол</span>
        </li>
        <li>
          <span>Возраст</span>
        </li>
        <li>
          <span>Программа лояльности</span>
        </li>
      </ul>
      <ul class="right-part">
        <li>
          <span>Гоша</span>
        </li>
        <li>
          <span>Корнеев</span>
        </li>
        <li>
          <span>Александрович</span>
        </li>
        <li>
          <span>Муж</span>
        </li>
        <li>
          <span>-</span>
        </li>
        <li>
          <span>-</span>
        </li>
      </ul>
    </div>
    <div class="button-field">
      <input type="submit" class="buy" value="Buy" @click.prevent="changePage('Success')">
    </div>
  </div>
</template>

<script>
export default {
  name: "Ticket",
  methods: {
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    }
  }
}
</script>

<style scoped>
.header {
  font-weight: bold;
  text-align: center;
}
.body {
  margin: auto;
  padding-bottom: 2rem;
  width: 30rem;
}
.button-field {
  text-align: center;
  padding-top: 10rem;
}

</style>