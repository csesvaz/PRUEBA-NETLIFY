<script>
import Calendar from "primevue/calendar";
import { mapState } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";

import BarraNavegacion from "../components/BarraNavegacion.vue";
export default {
  components: { BarraNavegacion, Calendar },
  computed: {
    ...mapState(useEmpresaStore, ["empresas"]),
  },
  data() {
    return {
      tiempoInicio: null,
      tiempoFinal: null,
    };
  },
};
</script>
<template>
  <div class="container-fluid">
    <div class="d-flex flex-column">
      <BarraNavegacion class="fixed-top" />
    </div>

    <div class="row justify-content inicial">
      <h3 class="formulario inicial">
        Formulario de Alta de un Servicio de Interpretación
      </h3>
      <div class="row inicial">
        <div class="col-md-11">
          <div class="text-left">
            Introduzca los datos de l servicio de interpretación que desea dar
            de alta:
          </div>
        </div>
      </div>
      <div class="row inicial">
        <div class="col-md-4">
          <label for="empresa1" class="form-label">Empresa</label>
        </div>
        <div class="col-md-2">
          <label for="idioma1" class="form-label">Idioma</label>
        </div>
        <div class="col-md-2"></div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <select
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option selected="">Seleccione una empresa</option>

            <option
              v-for="empresa in empresas"
              :key="empresa.id"
              :value="empresa.nombre"
            >
              {{ empresa.nombre }}
            </option>
          </select>
        </div>
        <div class="col-md-1"></div>

        <div class="col-md-4">
          <select
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option selected="">Elige Idioma</option>
            <option value="Alemán">Alemán</option>
            <option value="Árabe">Árabe</option>
            <option value="Bengalí">Bengalí</option>
            <option value="Birmano">Birmano</option>
            <option value="Bhojpuri">Bhojpuri</option>
            <option value="Chino mandarín">Chino mandarín</option>
            <option value="Coreano">Coreano</option>
            <option value="Español">Español</option>
            <option value="Francés">Francés</option>
            <option value="Gujarati">Gujarati</option>
            <option value="Hindi">Hindi</option>
            <option value="Indonesio">Indonesio</option>
            <option value="Inglés">Inglés</option>
            <option value="Italiano">Italiano</option>
            <option value="Japonés">Japonés</option>
            <option value="Javanés">Javanés</option>
            <option value="Kannada">Kannada</option>
            <option value="Khmer">Khmer</option>
            <option value="Malayalam">Malayalam</option>
            <option value="Marathi">Marathi</option>
            <option value="Neerlandés">Neerlandés</option>
            <option value="Oriya">Oriya</option>
            <option value="Pastún">Pastún</option>
            <option value="Persa">Persa</option>
            <option value="Polaco">Polaco</option>
            <option value="Portugués">Portugués</option>
            <option value="Punjabi">Punjabi</option>
            <option value="Rumano">Rumano</option>
            <option value="Ruso">Ruso</option>
            <option value="Serbio">Serbio</option>
            <option value="Sundanés">Sundanés</option>
            <option value="Swahili">Swahili</option>
            <option value="Tamil">Tamil</option>
            <option value="Telugu">Telugu</option>
            <option value="Thai">Thai</option>
            <option value="Turco">Turco</option>
            <option value="Ucraniano">Ucraniano</option>
            <option value="Urdu">Urdu</option>
            <option value="Vietnamita">Vietnamita</option>
            <option value="Wu (shanghainés)">Wu (shanghainés)</option>
          </select>
        </div>
      </div>
      <div class="row inicial">
        <div class="col-md-2">
          <label for="tiempoInicio" class="form-label"
            >Horario de Inicio del Servicio</label
          >
        </div>
        <div class="col-md-3">
          <label for="tiempoFinal" class="form-label"
            >Horario de Finalización del Servicio</label
          >
        </div>
        <div class="col-md-3">
          <label for="provincia" class="form-label">Provincia</label>
        </div>
        <div class="col-md-4"></div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <div class="mb-3">
            <Calendar id="calendar-timeonly" v-model="tiempoInicio" timeOnly />
          </div>
        </div>

        <div class="col-md-2">
          <div class="mb-3">
            <Calendar id="calendar-timeonly" v-model="tiempoFinal" timeOnly />
          </div>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-2">
          <select
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option selected="">Elige Provincia</option>
            <option value="Álava/Araba">Álava/Araba</option>
            <option value="Albacete">Albacete</option>
            <option value="Alicante">Alicante</option>
            <option value="Almería">Almería</option>
            <option value="Asturias">Asturias</option>
            <option value="Ávila">Ávila</option>
            <option value="Badajoz">Badajoz</option>
            <option value="Baleares">Baleares</option>
            <option value="Barcelona">Barcelona</option>
            <option value="Burgos">Burgos</option>
            <option value="Cáceres">Cáceres</option>
            <option value="Cádiz">Cádiz</option>
            <option value="Cantabria">Cantabria</option>
            <option value="Castellón">Castellón</option>
            <option value="Ceuta">Ceuta</option>
            <option value="Ciudad Real">Ciudad Real</option>
            <option value="Córdoba">Córdoba</option>
            <option value="Cuenca">Cuenca</option>
            <option value="Gerona/Girona">Gerona/Girona</option>
            <option value="Granada">Granada</option>
            <option value="Guadalajara">Guadalajara</option>
            <option value="Guipúzcoa/Gipuzkoa">Guipúzcoa/Gipuzkoa</option>
            <option value="Huelva">Huelva</option>
            <option value="Huesca">Huesca</option>
            <option value="Jaén">Jaén</option>
            <option value="La Coruña/A Coruña">La Coruña/A Coruña</option>
            <option value="La Rioja">La Rioja</option>
            <option value="Las Palmas">Las Palmas</option>
            <option value="León">León</option>
            <option value="Lérida/Lleida">Lérida/Lleida</option>
            <option value="Lugo">Lugo</option>
            <option value="Madrid">Madrid</option>
            <option value="Málaga">Málaga</option>
            <option value="Melilla">Melilla</option>
            <option value="Murcia">Murcia</option>
            <option value="Navarra">Navarra</option>
            <option value="Orense/Ourense">Orense/Ourense</option>
            <option value="Palencia">Palencia</option>
            <option value="Pontevedra">Pontevedra</option>
            <option value="Salamanca">Salamanca</option>
            <option value="Segovia">Segovia</option>
            <option value="Sevilla">Sevilla</option>
            <option value="Soria">Soria</option>
            <option value="Tarragona">Tarragona</option>
            <option value="Tenerife">Tenerife</option>
            <option value="Teruel">Teruel</option>
            <option value="Toledo">Toledo</option>
            <option value="Valencia">Valencia</option>
            <option value="Valladolid">Valladolid</option>
            <option value="Vizcaya/Bizkaia">Vizcaya/Bizkaia</option>
            <option value="Zamora">Zamora</option>
            <option value="Zaragoza">Zaragoza</option>
          </select>
        </div>
      </div>
      <div class="row inicial">
        <div class="col-7">
          <div class="form-check">
            <input
              class="form-check-input"
              type="checkbox"
              value=""
              id="flexCheckDefault"
            />
            <label class="form-check-label" for="flexCheckDefault">
              Dispone de asistencia Online.
            </label>
          </div>
        </div>
        <br />

        <div class="row justify-content-center final">
          <div class="col-md-2">
            <button type="button" class="btn btn-primary">
              Guardar Cambios
            </button>
          </div>

          <div class="col-md-2">
            <button type="button" class="btn btn-warning">Borrar Datos</button>
          </div>

          <div class="col-md-2">
            <button type="button" class="btn btn-danger">
              Eliminar Empresa
            </button>
          </div>
          <div class="col-md-6"></div>
        </div>
      </div>
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
.final {
  margin-top: 8em;
}
</style>
