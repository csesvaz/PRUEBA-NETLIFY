<script>
// import ServiciosPrueba from './components/ServiciosPrueba.vue';
import {useEmpresaStore} from './stores/EmpresaStore.js';
export default {
    beforeMount() {
        useEmpresaStore().fetchEmpresas();
        useEmpresaStore().fetchServicios();
    },
    // components: { ServiciosPrueba }
};
</script>

<template>
  <!-- <ServiciosPrueba/> -->
  <router-view></router-view>
</template>

<style scoped>
</style>