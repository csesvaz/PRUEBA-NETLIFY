<script>
import ListadoServiciosInterpretacion from "../components/ListadoServiciosInterpretacion.vue";
import ListadoServiciosTraduccion from "../components/ListadoServiciosTraduccion.vue";
export default {
  components: {
    ListadoServiciosInterpretacion,
    ListadoServiciosTraduccion,
  }
};
</script>

<template>
  <br />
  <div class="row mb-12">
    <div class="col-2">
      <h6>Seleccione gestión de Empresas</h6>
    </div>
    <div class="col-1">
      <router-link class="btn btn-primary" to="/interfazGestionEmpresa"
        >EMPRESA</router-link>
    </div>
  </div>
  <br />
  <div class="row mb-12">
    <div class="col-2">
      <h6>Seleccione gestión de Servicios</h6>
    </div>
    <div class="col-1">
      <router-link class="btn btn-primary" to="/interfazGestionServicios"
        >Servicios</router-link
      >
    </div>
  </div>

</template>

<style scoped></style>
