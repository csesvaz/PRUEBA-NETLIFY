<script>

import Calendar from 'primevue/calendar';
export default {
    components: { Calendar },
    data() {
        return {
            date: null,
            time: null
        };
    }
}

</script>
<template>
    
    <h3 class="formulario">Búsqueda de Servicio Lingüístico de Interpretación</h3>
    <br>
    <p>1. Seleccione la fecha en la que necesita el apoyo de Servicio Lingüístico de Interpretación:</p>

    <div class="row">
        <div class="col-1"></div>
        <div class="col-4">
            <div class="text-left">Día*</div>
        </div>
        <div class="col-3">
            <div class="text-left">Hora*</div>
        </div>
        <div class="col-4"></div>
    </div>

    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-4">
            <Calendar v-model="date" dateFormat="dd/mm/yy" showIcon />
        </div>
        <div class="col-3">
            <Calendar id="calendar-timeonly" v-model="time" timeOnly />
        </div>
    </div>
    <br>
    <p>2. Seleccione la localización en la que necesita el apoyo de Servicio Lingüítico.</p>
    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-4">Provincia*
        </div>
    </div>
    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-4">
            <select class="form-select form-select-sm" aria-label=".form-select-sm example">
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
    <br>
    <p>3. Seleccione el idioma y el tipo de servicio que necesita.</p>
    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-4">Idioma*
        </div>
    </div>
    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-4">
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
        <div class="col-7">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                    Selecciona si desea ver únicamente los servicios que tienen asistencia Online.
                </label>
            </div>
        </div>
    </div>
    <br>
    <p>4. Una vez comprobado que tiene todos los campos obligatorios (Marcados con *) rellenos seleccione el botón de
        Búsqueda.</p>
    <div class="row">
        <div class="col-1">
        </div>
        <div class="col-3">
            <button type="button" class="btn btn-primary">Búsqueda</button>
        </div>

    </div>
</template>


<style scoped></style>