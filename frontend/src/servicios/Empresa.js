import {empresaData} from '../data/firebase.js';
import {empresa, onValue, push, remove, update} from 'firebase/database';

class empresaService {
    getAll() {
        return empresaData;
    }

    crearEmpresa(empresa) {
        const idsExistentes = empresaData.map(emp => emp.id); // Obtener todos los IDs existentes
        let id = generarIDUnico(); // Generar un nuevo ID aleatorio
      
        // Comprobar si el nuevo ID generado ya está en uso
        while (idsExistentes.includes(id)) {
          id = generarIDUnico();
        }
      
        // Asignar el ID único a la nueva empresa
        empresa.id = id;
      
        // Agregar la empresa a la base de datos
        return push(empresaData, empresa);
      }

    update(key, value) {
        return update(empresa(empresaData, key), value);
    }

    delete(key) {
        return remove(empresa(empresaData, key));
    }

    deleteAll() {
        return remove(empresaData)
    }
    

    subscribeAll(callback) {
        onValue(empresaData, (snapshot) => {
            const empresaren = snapshot.val();
            const empresarenArray = Object.keys(empresaren).map((key) => {
                const empresa = empresaren[key];
                empresa.id = key;
                empresa.nombre = new Date(empresa.nombre)
                return empresa;
            });
            callback(empresarenArray);
        });
    }

    subscribeempresa(id, callback) {
        const empresaRef = empresa(empresaData, id);
        onValue(empresaRef, (snapshot) => {
            const empresa = snapshot.val();
            if (empresa) {
                empresa.id = id;
                empresa.nombre = new Date(empresa.nombre);
                callback(empresa);
            } else {
                callback(null);
            }
        });
    }
 
}

export default new empresaService();
