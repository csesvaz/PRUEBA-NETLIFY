<script>
import Calendar from "primevue/calendar";
import ComponenteIdiomas from "./ComponenteIdiomas.vue";
import ComponenteProvincias from "./ComponenteProvincias.vue";
import Button from "primevue/button";
import Dialog from "primevue/dialog";
import { mapState, mapActions } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";
export default {
  components: {
    Calendar,
    ComponenteIdiomas,
    ComponenteProvincias,
    Button,
    Dialog,
  },

  data() {
    return {
      servicio: {
        horaSeleccionada:
          "Tue May 09 2023 23:48:28 GMT+0200 (hora de verano de Europa central)",
        idioma: "",
        provincia: "",
        servicioOnline: false,

      },
      empresasConServicio: [],
      mostrarModal: false,
      visible: false,
    };
  },
  computed: {
    ...mapState(useEmpresaStore, ["empresas"]),
  },
  methods: {
    ...mapActions(useEmpresaStore, ["convertirHora", "convertirBooleano"]),
    provincia(provinciaSeleccionada) {
      this.servicio.provincia = provinciaSeleccionada;
    },
    idioma(idiomaSeleccionado) {
      this.servicio.idioma = idiomaSeleccionado;
    },
    buscarEmpresas(servicio) {
      this.empresasConServicio=[];
      servicio=this.servicio;
      this.visible = true;
      this.empresas.forEach((empresa) => {
    empresa.servicios.forEach((serv) => {
      if (serv.tipo == "interpretacion" &&
          serv.provincia == servicio.provincia &&
          serv.idioma == servicio.idioma &&
          ((servicio.servicioOnline == true) && (serv.servicioOnline == true)||(servicio.servicioOnline == false))) {

        this.empresasConServicio.push(empresa);
      }
    });
  });
  return this.empresasConServicio;
    },
    updateServicioOnline() {
    console.log(this.servicio.servicioOnline);
  },
  },
};
</script>
<template>
  <h3 class="formulario">Búsqueda de Servicio Lingüístico de Interpretación.</h3>
  <form @submit.prevent="buscarEmpresas">
    <p>
      1. Seleccione la hora a la que necesita el apoyo de Servicio Lingüístico
      de Interpretación:
    </p>
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-3 col-md-3">
        <div class="text-left">Hora*</div>
      </div>
      <div class="col-4 col-md-2">
        <Calendar
          id="calendar-timeonly"
          v-model="servicio.horaSeleccionada"
          required
          timeOnly
        />
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
      <div class="col-9 col-md-8">
        <ComponenteProvincias @provinciaSeleccionada="provincia" required />
      </div>
    </div>

    <br />
    <p>3. Seleccione el idioma y el tipo de servicio que necesita.</p>
    <div class="row">
      <div class="col-md-1"></div>
      <ComponenteIdiomas @idiomaSeleccionado="idioma" required />
    </div>
    <div class="row">
      <div class="col-12 mt-4">
        <div class="form-check">
          <input
            class="form-check-input"
            type="checkbox"
            v-model="servicio.servicioOnline"
            id="flexCheckDefault"
            @change="updateServicioOnline"
          />
          <label class="form-check-label" for="flexCheckDefault">
            Selecciona si desea ver únicamente los servicios que tienen
            asistencia Online.
          </label>
        </div>
      </div>
    </div>

    <br />
    <p>
      4. Una vez comprobado que tiene todos los campos obligatorios (Marcados
      con *) rellenos seleccione el botón de Búsqueda.
    </p>
    <div class="row mt-4">
      <div class="col-3"></div>
      <div class="col-3 col-md-4">
        <button
          type="submit"
          class="btn btn-primary"
          :disabled="
            !servicio.provincia ||
            !servicio.idioma ||
            !servicio.horaSeleccionada
          "
        >
          Búsqueda
        </button>
      </div>
    </div>
  </form>
  <Dialog
    v-model:visible="visible"
    modal
    header="Datos de las empresas que tienen ese servicio"
    :style="{ width: '50vw' }"
    :breakpoints="{ '960px': '75vw', '641px': '100vw' }"
  ><div v-if="empresasConServicio.length == 0" class="Not Found">
    <p>No se ha encontrado ninguna empresa que cumpla sus requisitos. Puede contactar con el servicio
        central de interpretes enviando un mensaje a la dirección
        apoyoTraucpol@mmmm.com o llamando al teléfono +34 655-566778 (Horario
        telefónico de 9:00 a 15:00)</p>
  </div>
  <div v-else>
    <p>La hora seleccionada ha sido {{ servicio.horaSeleccionada }}</p>
    <p>La provincia seleccionada ha sido {{ servicio.provincia }}</p>
    <p>El idioma seleccionado ha sido {{ servicio.idioma }}</p>
    <p>Necesidad de Servicio online ({{ convertirBooleano(servicio.servicioOnline) }})</p>
    <p>Las empresas que cumplen sus requisitos son</p>
    <p
      
      v-for="empresa in empresasConServicio"
    >
     - {{ empresa.nombre }} con telefono {{ empresa.telefono }}, con dirección {{ empresa.direccion }}
    </p>
   
  
  </div>
  </Dialog>
</template>

<style scoped>
h3 {
  margin-top: 7vh;
  margin-bottom: 2vh;
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
