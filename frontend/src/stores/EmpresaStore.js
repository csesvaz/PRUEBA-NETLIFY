import { defineStore } from "pinia";
import DatosEmpresas from "../objetos/Empresa.json";

export const useEmpresaStore = defineStore("empresas", {
  state: () => ({
    empresas: [],
  }),
  actions: {
    fetchEmpresas() {
      this.empresas = DatosEmpresas._embedded.empresa;
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
    convertirBooleano(a) {
      if (a == true) {
        return "Si";
      } else {
        return "No";
      }
    },
    
  },
});
