import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    ocupacion: [],
}

export const ocupacionSlice = createSlice({
    name: "ocupacion",
    initialState,
    reducers: {
        cargarOcupacion: (state, action) => {
            state.ocupacion = action.payload.ocupaciones;
        }
    }
});


export const { cargarOcupacion } = ocupacionSlice.actions;

export default ocupacionSlice.reducer;