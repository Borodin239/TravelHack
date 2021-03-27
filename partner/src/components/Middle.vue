<template>
  <div class="middle">
    <main>
      <Index v-if="page === 'Index'"/>
      <Register v-if="page === 'Register'"/>
      <User v-if="page === 'User'"/>
    </main>
  </div>
</template>

<script>
import Index from "@/components/middle/Index";
import Register from "@/components/middle/Register";
import User from "@/components/middle/User";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Index",
    }
  },
  components: {
    Register,
    Index,
    User,
  },
  beforeCreate() {
    this.$root.$on("onChangePage", (page) => this.page = page)
  }
}
</script>

<style scoped>

</style>