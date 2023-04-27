<script>
import BarraNavegacion from "../components/BarraNavegacion.vue";
import ListadoServiciosInterpretacion from "../components/ListadoServiciosInterpretacion.vue"
import ListadoServiciosTraduccion from "../components/ListadoServiciosTraduccion.vue";


export default {
  components: { BarraNavegacion, ListadoServiciosInterpretacion, ListadoServiciosTraduccion },

data() {
    return {
      opcionInicial: true,
    };
  },
  methods: {
    cambioOpcion() {
      this.opcionInicial = !this.opcionInicial;
    },
  },
};
</script>

<template>
  <div class="d-block fixed-top">
    <BarraNavegacion />
         
  <div class="row mb-12 mt-5">
    <div class="col-1"></div>
    <div class="container align-items-start">
      <br />
      <h3 class="listado">
        Listado de todos los servicios lingüisticos disponibles:
      </h3>
      <br />

      <div class="form-check ml-0">
        <input
          class="form-check-input"
          type="radio"
          name="flexRadioDefault"
          id="flexRadioDefault3"
          @click="cambioOpcion"
          :checked="opcionInicial"
          :disabled="opcionInicial"
        />
        <label class="form-check-label" for="flexRadioDefault3">
          Visualizar Servicios de Interpretación.
        </label>
      </div>
      <div class="form-check">
        <input
          class="form-check-input"
          type="radio"
          name="flexRadioDefault"
          id="flexRadioDefault4"
          @click="cambioOpcion"
          :checked="!opcionInicial"
          :disabled="!opcionInicial"
        />
        <label class="form-check-label" for="flexRadioDefault4">
          Visualizar Servicios de Traducción.
        </label>
      </div>
    </div>
    <br />
    <div v-if="this.opcionInicial">
      <ListadoServiciosInterpretacion />
    </div>
    <div v-else>
      <ListadoServiciosTraduccion />
    </div>
  </div>
    </div>
  
</template>

<style scoped>
.container {
  margin-bottom: 1em;
  margin-left: 4em;
}
</style>
