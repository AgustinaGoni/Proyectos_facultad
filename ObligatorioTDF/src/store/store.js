import { configureStore } from "@reduxjs/toolkit";
import usuarioReducer from "../features/usuarioSlice";
import spinnerReducer from "../features/spinnerSlice";
import departamentoReducer from "../features/departamentoSlice";
import ciudadReducer from "../features/ciudadSlice";
import ocupacionReducer from "../features/ocupacionSlice";
import personaReducer from "../features/personaSlice";

export const store = configureStore({
    reducer:{
        usuario: usuarioReducer,
        spinner: spinnerReducer,
        departamentos: departamentoReducer,
        ciudades: ciudadReducer,
        ocupaciones : ocupacionReducer,
        personas: personaReducer,
    }
})