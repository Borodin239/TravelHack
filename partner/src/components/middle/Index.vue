<template>
  <div>
    <div>
      Добро пожаловать на сайт партнёра! Войдите в личный кабинет.
    </div>
    <div class="button-field">
      <input type="submit" class="field" value="Купить билеты" @click.prevent="changePage('Ticket')"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Index',
  methods: {
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    }
  }
}
</script>

<style scoped>
div {
  text-align: center;
  font-size: 2rem;
  padding-top: 4rem;
  padding-bottom: 4rem;
}

input {
  appearance: none;
  width: 18rem;
  font-size: 2rem;
  height: 3rem;
  background-color: #003580;
  outline: none;
}

.button-field input {
  color: white;
}
</style>
