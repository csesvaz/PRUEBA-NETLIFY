<script>

import BarraNavegacion from "../components/BarraNavegacion.vue";
import { mapActions } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore.js";

export default {
  components: { BarraNavegacion },
  data() {
    return { id: 0, empresa: null };
  },
  beforeMount() {
    this.id = this.$route.params.id;
    this.empresa = this.getEmpresa(this.id);
  
  },
  methods: {
    ...mapActions(useEmpresaStore, ["updateEmpresa","getEmpresa"]),
    borrarDatos() { 
      this.empresa = {nombre:"",direccion:"",telefono:"",email:""};
     
    },
    modificarEmpresa() {
      this.updateEmpresa(this.empresa);
      this.$router.push('/interfazGestionEmpresa');

  },}
};
</script>
<template>
  <div v-if="empresa" class="container-fluid">
    <div class="d-flex flex-column">
      <BarraNavegacion class="fixed-top" />
    </div>

    <div class="row justify-content inicial">
      <h3 class="formulario inicial">
        Formulario de Modificación de empresa.
      </h3>
      <form @submit.prevent="modificarEmpresa">
        <div class="row inicial">
          <div class="col-md-4">
            <label for="nombre" class="form-label">Nombre</label>
          </div>
          <div class="col-md-2">
            <label for="direccion" class="form-label">Dirección</label>
          </div>
          <div class="col-md-"></div>
        </div>
        <div class="row">
          <div class="col-md-3">
            <input
              type="text"
              class="form-control"
              id="nombre"
              v-model="empresa.nombre"
            />
          </div>
          <div class="col-md-1"></div>

          <div class="col-md-4">
            <input
              type="text"
              class="form-control"
              id="direccion"
              v-model="empresa.direccion"
            />
          </div>
        </div>
        <div class="row inicial">
          <div class="col-md-4">
            <label for="telefono" class="form-label"
              >Teléfono de contacto</label
            >
          </div>
          <div class="col-md-3">
            <label for="email" class="form-label">Dirección E-mail</label>
          </div>
          <div class="col-md-4"></div>
        </div>
        <div class="row">
          <div class="col-md-2">
            <div class="mb-3">
              <input
                type="telephone"
                class="form-control"
                id="telefono"
                v-model="empresa.telefono"
              />
            </div>
          </div>
          <div class="col-md-2"></div>
          <div class="col-md-3">
            <div class="mb-3">
              <input
                type="email"
                class="form-control"
                id="email"
                v-model="empresa.email"
              />
            </div>
          </div>
          <div class="col-md-4"></div>
        </div>

        <br />

        <div class="row inicial">
          <div class="col-md-2">
            <button type="submit" class="btn btn-primary">
              Guardar Cambios
            </button>
          </div>

          <div class="col-md-2">
            <button type="button" class="btn btn-warning" @click="borrarDatos">Borrar Datos</button>
          </div>

          <div class="col-md-6"></div>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
.row {
  margin-left: 0.5em;
}
.inicial {
  margin-top: 1em;
}
</style>
