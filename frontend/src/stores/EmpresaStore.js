import { defineStore } from "pinia";
import DatosEmpresas from "../objetos/Empresa.json";

export const useEmpresaStore = defineStore("empresas", {
  state: () => ({
    empresas: [],
    opcionInicial: true,
    servicios:[]
  }),
  actions: {
    fetchEmpresas() {
      this.empresas = DatosEmpresas._embedded.empresa;
      return this.empresas;
    },
    getEmpresas() {
      if (this.empresas.length === 0) {
        this.fetchEmpresas();
      }
      return this.empresas;
    },
    getEmpresa(id){
      if (this.empresas.length === 0) {
        this.fetchEmpresas();
      }
      return this.empresas.find((empresa) => empresa.id == id);
    },
    addEmpresa(empresa){  
      empresa.id=this.empresas.length+1;
      this.empresas.push(empresa);
      return this.empresas;
    },
    updateEmpresa(empresa) {
      const index = this.empresas.findIndex((emp) => emp.id === empresa.id);
      this.empresas[index] = empresa;
      return this.empresas;
    },
    deleteEmpresa(id){
      const index = this.empresas.findIndex((emp) => emp.id === id);
      this.empresas.splice(index, 1);
      return this.empresas;
    },
    fetchServicios() {
      if (this.empresas.length === 0) {
        this.fetchEmpresas();
      }
      this.servicios = [];
      for (var i = 0; i < this.empresas.length; i++) {
        var empresa = this.empresas[i];
    
        for (var j = 0; j < empresa.servicios.length; j++) {
          var servicio = empresa.servicios[j];
          this.servicios.push(servicio);
        }
      }
      return this.servicios;
    },
    getServicio(id){
      if (this.servicios.length === 0) {
        this.fetchServicios();
      }
      return this.servicios.find((servicio) => servicio.id == id);
    },
    deleteServicio(id){
      if (this.servicios.length === 0) {
        this.fetchServicios();
      }
      const empresaConServicio = this.empresas.find((emp) => emp.servicios.some((ser) => ser.id == id));
      const index = this.servicios.findIndex((emp) => emp.id == id);
      this.servicios.splice(index, 1);
      empresaConServicio.servicios = empresaConServicio.servicios.filter((s) => s.id != id);
    
      return this.servicios;
    },
    updateServicio(servicio) {
      const empresaConServicio = this.empresas.find((emp) => emp.servicios.some((ser) => ser.id == servicio.id));
      const index = this.servicios.findIndex((emp) => emp.id == servicio.id);
       empresaConServicio.servicios[index] = servicio;
      return this.servicios;
    },
    addServicio(servicio, empresaNombre){  
      servicio.id=this.servicios.length+1;
      const empresa = this.empresas.find((emp) => emp.nombre == empresaNombre);
      empresa.servicios.push(servicio);
      this.servicios.push(servicio);
      return this.servicios;
    },
    convertirBooleano(a) {
      if (a == true) {
        return "Si";
      } else {
        return "No";
      }
    },
    cambioOpcion() {
      this.opcionInicial = !this.opcionInicial;
    },
    
  },
});
