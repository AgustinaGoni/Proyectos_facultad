import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    departamento: [],
}

export const departamentoSlice = createSlice({
    name: "departamento",
    initialState,
    reducers: {
        cargarDepartamento: (state, action) => {
            state.departamento = action.payload.departamentos;
        }
    }
});


export const { cargarDepartamento } = departamentoSlice.actions;

export default departamentoSlice.reducer;