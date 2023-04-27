<script>
import {useEmpresaStore} from './stores/EmpresaStore.js';
export default { 
 
  beforeMount(){  
   useEmpresaStore().fetchEmpresas() ;
  }
};
</script>

<template>
  <router-view></router-view>
</template>

<style scoped>
</style>