<script>
import BarraNavegacion from '../components/BarraNavegacion.vue'
import FormularioBusqueda from '../components/FormularioBusqueda.vue';

export default {
    components: { BarraNavegacion, FormularioBusqueda }
}
</script>

<template>
    <div class="d-block fixed-top">
        <BarraNavegacion />

    <div class="container">
        <FormularioBusqueda />
    </div></div>
</template>
<style scoped>
.container {
    margin-left: 3em;
    margin-top: 2em;
}
</style>