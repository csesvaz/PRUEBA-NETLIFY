<script>
import Calendar from "primevue/calendar";
import ComponenteIdiomas from "./ComponenteIdiomas.vue";
import ComponenteProvincias from "./ComponenteProvincias.vue";
export default {
  components: { Calendar, ComponenteIdiomas, ComponenteProvincias },
  data() {
    return {
      time: null,
    };
  },
};
</script>
<template>
  <h3 class="formulario">Búsqueda de Servicio Lingüístico de Interpretación</h3>
  <br />
  <p>
    1. Seleccione la hora a la que necesita el apoyo de Servicio Lingüístico de
    Interpretación:
  </p>
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-3 col-md-3">
      <div class="text-left">Hora*</div>
    </div>
    <div class="col-4 col-md-2">
      <Calendar id="calendar-timeonly" v-model="time" timeOnly />
    </div>
    <div class="col-1 col-md-2"></div>
  </div>

  <br />
  <p>
    2. Seleccione la localización en la que necesita el apoyo de Servicio
    Lingüítico.
  </p>
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-2">Provincia*</div>
    <div class="col-1"></div>
    <div class="col-9 col-md-8"><ComponenteProvincias selected="" /></div>
  </div>

  <br />
  <p>3. Seleccione el idioma y el tipo de servicio que necesita.</p>
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-2">Idioma*</div>
  

  <div class="col-1"></div>
  <ComponenteIdiomas selected="" /></div>
  <div class="row">
    <div class="col-12 mt-4">
      <div class="form-check">
        <input
          class="form-check-input"
          type="checkbox"
          value=""
          id="flexCheckDefault"
        />
        <label class="form-check-label" for="flexCheckDefault">
          Selecciona si desea ver únicamente los servicios que tienen asistencia
          Online.
        </label>
      </div>
    </div>
  </div>

  <br />
  <p>
    4. Una vez comprobado que tiene todos los campos obligatorios (Marcados con
    *) rellenos seleccione el botón de Búsqueda.
  </p>
  <div class="row mt-4">
    <div class="col-3"></div>
    <div class="col-3 col-md-4">
      <button type="button" class="btn btn-primary">Búsqueda</button>
    </div>
  </div>
</template>

<style scoped>
h3{
    margin-top: 7vh;
}
@media (max-width: 576px) {
  p {
    text-align: center;
    font-style: oblique;
  }
  h3 {
    text-align: center;
    margin-top: 4vh;

  }
}
</style>
