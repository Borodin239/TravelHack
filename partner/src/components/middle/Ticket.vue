<template>
  <div class="buy-ticket">
    <div class="header">
      <span>Required personal data</span>
    </div>
    <div class="body">
      <ul class="left-part">
        <li v-for="field in this.fields" :key="field.id">
          <span>{{field.name}}</span>
        </li>
      </ul>
      <ul class="right-part">
        <li v-for="field in this.fields" :key="field.id">
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
  }, beforeMount() {
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
  },
  props: ["user", "fields", "required"]
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