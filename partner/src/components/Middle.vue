<template>
  <div class="middle">
    <main>
      <Index v-if="page === 'Index'"/>
      <Register v-if="page === 'Register'"/>
      <User v-if="page === 'User'" :user="user" :fields="fields"/>
      <Ticket v-if="page === 'Ticket'" :user="user" :filtered="filtered"/>
      <Success v-if="page === 'Success'"/>
    </main>
  </div>
</template>

<script>
import Index from "@/components/middle/Index";
import Register from "@/components/middle/Register";
import User from "@/components/middle/User";
import Ticket from "@/components/middle/Ticket";
import Success from "@/components/middle/Success";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Index",
    }
  },
  props: ["user", "fields", "required", "filtered"],
  components: {
    Success,
    Ticket,
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