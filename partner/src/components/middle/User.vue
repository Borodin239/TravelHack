<template>
  <div class="register form-box">
    <div class="header">Personal account</div>
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
          <span>Баллы компании</span>
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
          <span>Integer.MAX_VALUE</span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "User.vue",
}
</script>

<style scoped>
.left-part {
  display: inline-block;
  position: relative;
  padding-left: -2rem;
  float: left;
}
.right-part {
  display: inline-block;
  position: relative;
  padding-right: 2rem;
  float: right;
}
li {
  list-style-type: none;
}
.left-part li {
  font-weight: bold;
}
</style>