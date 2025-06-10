import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    ciudad: [],
}

export const ciudadSlice = createSlice({
    name: "ciudad",
    initialState,
    reducers: {
        cargarCiudad: (state, action) => {
            state.ciudad = action.payload.ciudades;
        }
    }
});


export const { cargarCiudad } = ciudadSlice.actions;

export default ciudadSlice.reducer;