<script>
import BarraNavegacion from "../components/BarraNavegacion.vue";
import ComponentePregunta from "../components/ComponentePregunta.vue";
import { mapState } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";

export default {
  components: { BarraNavegacion, ComponentePregunta },
}
</script>

<template>
  <div class="d-block fixed-top">
    <BarraNavegacion />
  </div>
    <div class="contenedor">
      <br />
      <div class="row mt-3">
        <h3 class="IntroduccionAyuda">
          Preguntas más habituales de la aplicación TRADUCPOL.
        </h3>
      </div>
    </div>
      <ComponentePregunta/>

  
</template>
<style scoped>
.contenedor {
  margin-bottom: 1vh;
  text-align: center;
}

@media (max-width: 768px) {
  
}
</style>
