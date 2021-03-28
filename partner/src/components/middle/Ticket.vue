<template>
  <div class="buy-ticket">
    <div class="header">
      <span>Required personal data</span>
    </div>
    <div class="body">
      <ul class="left-part">
        <li v-for="field in this.filtered" :key="field.id">
          <span>{{field.name}}</span>
        </li>
      </ul>
      <ul class="right-part">
        <li v-for="field in this.filtered" :key="field.id">
          <span>{{field.data}}</span>
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
  },
  props: ["user", "fields", "required", "filtered"]
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