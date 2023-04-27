import {empresaData} from '../data/firebase.js';
import {empresa, onValue, push, remove, update} from 'firebase/database';

class empresaService {
    getAll() {
        return empresaData;
    }

    create(empresa) {
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
