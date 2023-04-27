<script>
import { mapState } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";
export default {
  computed: {
    ...mapState(useEmpresaStore, ["empresas"]),
  },
  methods: {
    eliminarEmpresa(id) {
      useEmpresaStore().deleteEmpresa(id);
    },
  },
};
</script>
<template>
  <h3>Listado de todas las empresas disponibles</h3>
  <div class="row mb-12">
    <span class="col-2 pt-3 pb-3 bg-primary border border-dark"
      >Nombre de la Empresa</span
    >
    <span class="col-3 bg-primary border border-dark">Dirección</span>
    <span class="col-2 bg-primary border border-dark">Teléfono </span>
    <span class="col-3 bg-primary border border-dark">Email </span>
  </div>
  <!-- Aqui va un v-for de llas Empresas-->
  <div v-for="empresa in empresas" :key="empresa.id" class="row mb-12">
    <span class="col-2 bg-ligth border border-dark">{{ empresa.nombre }}</span>
    <span class="col-3 bg-ligth border border-dark">{{
      empresa.direccion
    }}</span>
    <span class="col-2 bg-ligth border border-dark">{{
      empresa.telefono
    }}</span>
    <span class="col-3 bg-ligth border border-dark">{{ empresa.email }}</span>
    <span class="col-1 bg-ligth">
      <router-link :to="{name:'modificacionEmpresa',params:{id:empresa.id}}">
        <fa
          class="lapiz"
          icon="fa-solid fa-pencil"
          size="2xl"
          /></router-link
    ></span>
    <span class="col-1 bg-ligth">
      <fa
        class="bin"
        icon="fa-solid fa-trash-arrow-up"
        size="2xl"
        style="color: #c01c28" @click="eliminarEmpresa(empresa.id)"
    /></span>
  </div>
</template>

<style scoped>
.lapiz {
  color: rgb(110, 60, 60);
  padding-right: 3vw;
  margin-top: 1vh;
}

span {
  display: flex;
  justify-content: center;
  align-items: center;
}
.bin {
  margin-right: 12vw;
  margin-top: 1vh;
  cursor: pointer;
}
.iconoOrdenar {
  padding-left: 0.5em;
}
</style>
