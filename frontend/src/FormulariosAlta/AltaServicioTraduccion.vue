<script>

import Calendar from 'primevue/calendar';
import { mapState } from "pinia";
import { useEmpresaStore } from "../stores/EmpresaStore";

import BarraNavegacion from '../components/BarraNavegacion.vue'

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
    }
}

</script><template>
    <div class="container-fluid">
      <div class="d-flex flex-column">
        <BarraNavegacion class="fixed-top" />
      </div>
  
      <div class="row justify-content inicial">
          <h3 class="formulario inicial">Formulario de Alta de un Servicio de Traducción</h3>
          <div class="row inicial">
            <div class="col-md-11">
              <div class="text-left">Introduzca los datos de l servicio de traducción que desea dar de alta:</div>
            </div>
          </div>
          <div class="row inicial">
            <div class="col-md-4">
              <label for="empresa2" class="form-label">Empresa</label>
            </div>
            <div class="col-md-2">
                <label for="idioma1" class="form-label">Idioma</label>
            </div>
            <div class="col-md-2"></div>
          </div>
          <div class="row">
            <div class="col-md-3"> <select
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
          </select></div>   <div class="col-md-1">
   
  </div>

  <div class="col-md-4">
    <select class="form-select form-select-sm" aria-label=".form-select-sm example">
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
                <label for="tipoDocumento" class="form-label">Tipo de Documento</label>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-3">
                <label for="tiempoMaxEntrega" class="form-label">Tiempo máximo de Entrega</label>
            </div>
            
           
          </div>
          <div class="row inicial">
            <div class="col-md-2">
              <input type="text" class="form-control" id="tipoDocumento" placeholder="Carta">
            </div>
            <div class="col-md-1"></div>
    
            <div class="col-md-2">
              <input type="text" class="form-control" id="tiempoMaxEntrega" placeholder="2 horas">
            </div>
            
          </div>
          <div class="row inicial">
        <div class="col-7">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Dispone de traducción Jurada.
                </label>
            </div>
        </div>
          <br>
          
          <div class="row justify-content-center final">
    
            <div class="col-md-2">
              <button type="button" class="btn btn-primary">Guardar Cambios</button>
            </div>
            
            <div class="col-md-2">
              <button type="button" class="btn btn-warning">Borrar Datos</button>
            </div>
           
            <div class="col-md-2">
              <button type="button" class="btn btn-danger">Eliminar Empresa</button>
            </div>
            <div class="col-md-6"></div>
          </div>
        </div>
        
      </div></div>
    
  </template>
  
<style scoped>
.row {
    margin-left: 0.5em;
}
.inicial{
    margin-top: 1em;
}
.final{
  margin-top: 2em;
}
</style>