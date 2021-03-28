<template>
  <div class="register form-box">
    <div class="header">Personal account</div>
    <div class="body">
      <ul class="left-part">
        <li v-for="field in fields" :key="field.id">
          <span>{{field.name}}</span>
        </li>
      </ul>
      <ul class="right-part">
        <li v-for="field in fields" :key="field.id">
          <span>{{field.data}}</span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "User.vue",
  props: ["user", "fields"]
}
</script>

<style scoped>

.header {
  text-align: center;
  font-size: 1.5rem;
  border-color: white;
}
.register {
  border-color: white;
}

</style>