<template>
  <div class="main">
    <div class="message">
      You have successfully bought tickets
    </div>
    <div class="button-field">
      <input type="submit" class="index" value="Back to main page" @click.prevent="changePage('Index')">
    </div>
  </div>
</template>

<script>
export default {
  name: "Success",
  methods: {
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    }
  }
}
</script>

<style scoped>
.message {
  margin: 1rem;
}
.button-field {
  text-align: center;
}
.button-field input {
  width: 20rem;
}
</style>