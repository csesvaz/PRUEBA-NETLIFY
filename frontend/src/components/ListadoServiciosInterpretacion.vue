<script>
import { mapActions, mapState } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";
export default {
  computed: {
    ...mapState(useEmpresaStore, ["empresas"]),
    empresasFiltradas() {
      return this.empresas.filter(
        (empresa) =>
          empresa.nombre
            .toLowerCase()
            .includes(this.filtrarServicio.toLowerCase())
        // ||
        // empresa.servicios.some((servicio) =>
        //   servicio.idioma.includes(this.filtrarServicio)
      );
    },
  },
  props: ["filtrarServicio"],
  methods: {
    ...mapActions(useEmpresaStore, ["convertirBooleano"]),
  },
};
</script>
<template>
  <div class="container-fluid mt-4">
    <h3>SERVICIOS DE INTERPRETACIÓN.</h3>
    <div class="row mb-12">
      <span class="col-2 pt-3 pb-3 bg-primary border border-dark"
        >Empresa
      </span>
      <span class="col-2 bg-primary border border-dark">Idioma </span>
      <span class="col-1 bg-primary border border-dark">Hora Inicio </span>
      <span class="col-1 bg-primary border border-dark">Hora Fin </span>
      <span class="col-3 bg-primary border border-dark">Provincia </span>
      <span class="col-2 bg-primary border border-dark">Servicio ONLINE </span>
      <span v-if="$route.path === '/alta'" class="col-1 mt-3 lapiz h5"
        >Editar</span
      >
    </div>
    <!-- Aqui va un v-for de los servicios de Interpretacion-->

    <div v-for="empresa in empresasFiltradas" :key="empresa.id">
      <div v-for="servicio in empresa.servicios" :key="servicio.id">
        <div v-if="servicio.tipo == 'interpretacion'" class="row mb-12">
          <span class="col-2 bg-ligth border border-dark">{{
            empresa.nombre
          }}</span>
          <span class="col-2 bg-ligth border border-dark">{{
            servicio.idioma
          }}</span>
          <span class="col-1 bg-ligth border border-dark">{{
            servicio.horarioInicio
          }}</span>
          <span class="col-1 bg-ligth border border-dark">{{
            servicio.horarioFin
          }}</span>
          <span class="col-3 bg-ligth border border-dark">{{
            servicio.provincia
          }}</span>
          <span class="col-2 bg-ligth border border-dark">{{
            convertirBooleano(servicio.servicioOnline)
          }}</span>
          <span
            v-if="$route.path === '/interfazGestionServicios'"
            class="col-1 mt-2"
          >
            <router-link to="/altaServicioTraduccion">
              <fa class="lapiz" icon="fa-solid fa-pencil" size="2xl" />
            </router-link>
            <fa
              class="bin"
              icon="fa-solid fa-trash-arrow-up"
              size="2xl"
              style="color: #c01c28"
            />
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container-fluid {
  width: 100%;
  margin-left: 2%;
  overflow: hidden;
}
span {
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
}

.col-2 {
  width: 17%;
}

.col-1 {
  width: 10%;
}

.col-3 {
  width: 25%;
}

.lapiz {
  color: rgb(110, 60, 60);
  padding-right: 0.5%;
}
.bin {
  margin-right: 1%;
}
@media (max-width: 768px) {
  .container-fluid {
  width: 100%;
  margin-left: 2%;
  font-size: 0.7rem;
}
}
</style>
