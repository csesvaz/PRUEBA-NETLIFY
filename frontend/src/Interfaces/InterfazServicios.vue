<script>
import BarraNavegacion from "../components/BarraNavegacion.vue";
import ListadoServiciosInterpretacion from "../components/ListadoServiciosInterpretacion.vue";
import ListadoServiciosTraduccion from "../components/ListadoServiciosTraduccion.vue";
import { mapState, mapActions } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";
export default {
  components: {
    BarraNavegacion,
    ListadoServiciosInterpretacion,
    ListadoServiciosTraduccion,
  },
  computed: {
    ...mapState(useEmpresaStore, ["opcionInicial"]),
  },
  data() {
    return {
      filtro: "",
    };
  },
  methods: {
    ...mapActions(useEmpresaStore, ["cambioOpcion"]),

    filtrar() {
      this.filtro = this.$refs.busquedaEmpresa.value;
    },
  },
};
</script>

<template>
  <div class="d-block fixed-top w-100">
    <BarraNavegacion />
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
          id="flexRadioDefault1"
          @click="cambioOpcion"
          :checked="opcionInicial"
          :disabled="opcionInicial"
        />
        <label class="form-check-label" for="flexRadioDefault1">
          Visualizar Servicios de Interpretación.
        </label>
      </div>
      <div class="form-check">
        <input
          class="form-check-input"
          type="radio"
          name="flexRadioDefault"
          id="flexRadioDefault2"
          @click="cambioOpcion"
          :checked="!opcionInicial"
          :disabled="!opcionInicial"
        />
        <label class="form-check-label" for="flexRadioDefault2">
          Visualizar Servicios de Traducción.
        </label>
      </div>
    </div>
    <br />
    <div class="row mb-12">
      <div class="col-1"></div>
      <span class="col-4 busqueda"
        ><form class="d-flex" role="search" @submit.prevent="filtrar">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Busqueda por empresa."
            aria-label="search"
            ref="busquedaEmpresa"
          />
          <button
            class="btn btn-outline-info bg-primary btn Busqueda"
            type="submit"
          >
            Buscar
          </button>
        </form>
      </span>
    </div>
    <div v-if="this.opcionInicial">
      <ListadoServiciosInterpretacion :filtrarServicio="filtro" />
    </div>
    <div v-else>
      <ListadoServiciosTraduccion :filtrarServicio="filtro" />
    </div>
  </div>
</template>

<style scoped>
.container {
  margin-bottom: 1vw;
  margin-left: 4vw;
}
.form-check-label {
  justify-content: start;
}
@media (max-width: 768px) {
  .container {
    margin-left: 1vw;
    margin-right: 1vw;
  }
  .busqueda {
    margin-left: 2vw;
  }

  span.col-4 {
    width: 80%;
  }
}
</style>
