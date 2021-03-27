<template>
  <div class="middle">
    <main>
      <Index v-if="page === 'Index'"/>
      <Register v-if="page === 'Register'"/>
    </main>
  </div>
</template>

<script>
import Index from "@/components/middle/Index";
import Register from "@/components/middle/Register";

export default {
  name: "Middle",
  needToShowComments: false,
  data: function () {
    return {
      page: "Index",
      post: undefined
    }
  },
  components: {
    Register,
    Index,
  },
}
</script>

<style scoped>

</style>