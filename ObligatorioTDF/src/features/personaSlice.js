import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    persona: [],
}

export const personaSlice = createSlice({
    name: "persona",
    initialState,
    reducers: {
        cargarPersona: (state, action) => {
            state.persona = action.payload;
        },
        agregarPersona: (state, action) => {
            state.persona.push(action.payload)
        }
        
    }
});


export const { cargarPersona, agregarPersona } = personaSlice.actions;

export default personaSlice.reducer;