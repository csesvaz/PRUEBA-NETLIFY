<script>
import BarraNavegacion from "../components/BarraNavegacion.vue";
import ListadoEmpresas from "../components/ListadoEmpresas.vue";
export default {
  components: { BarraNavegacion, ListadoEmpresas },
};
</script>

<template>
  
  <div class="d-block fixed-top">
    <BarraNavegacion />
      <div class="row mb-12 mt-4 ms-3">
    <div class="col-2">
      <h6>Creación de nueva Empresa</h6>
    </div>
    <div class="col-1">
      <router-link class="btn btn-primary" to="/altaEmpresa">
        EMPRESA</router-link>
    </div>
  </div>
  <div class="row mt-4 ms-4 me-3">
      <br />
      <br />
      <ListadoEmpresas />
    </div>
  </div>
</template>

<style scoped>

</style>
