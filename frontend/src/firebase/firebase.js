import { initializeApp } from "firebase/app";
import { getDatabase, ref } from "firebase/database";

const firebaseConfig = {
    databaseURL: "https://camiloprueba-94bd8-default-rtdb.europe-west1.firebasedatabase.app",

    projectId: "camiloprueba-94bd8",

};
const firebaseApp = initializeApp(firebaseConfig);

const db = getDatabase(firebaseApp);
const empresaData = ref(db, "empresa");
export default empresaData;
