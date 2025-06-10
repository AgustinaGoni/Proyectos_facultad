import { useRef, useState } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import Spinner from "./Spinner";
import { useDispatch, useSelector } from "react-redux";
import { logearUsuario } from "../features/usuarioSlice";
import { spinnerCargando } from "../features/spinnerSlice";

const Registro = () => {
  const user = useRef(null);
  const pass = useRef(null);

  const [botonRegistro, setBotonRegistro] = useState(false);
  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  const dispatch = useDispatch();
  let navigate = useNavigate();

  const cambioInput = (event) => {
    user.current.value && pass.current.value
      ? setBotonRegistro(true)
      : setBotonRegistro(false);
  };

  const usuarioCarga = useSelector((state) => state.spinner.loading);

  const registrar = () => {
    dispatch(spinnerCargando(true));
    const bodyData = {
      usuario: user.current.value,
      password: pass.current.value,
    };
    fetch(`https://censo.develotion.com/usuarios.php`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(bodyData),
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          const usuarioLogeado = {
            id: data.id,
            apiKey: data.apiKey,
          };
          dispatch(logearUsuario(usuarioLogeado));
          localStorage.setItem("id", data.id);
          localStorage.setItem("apiKeyUsuario", data.apiKey);
          setMensajeError(null);
          setError(false);
          navigate("/dashboard");
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        dispatch(spinnerCargando(false));
        setError(true);
        setMensajeError("Fallo en la conexion con el servidor");
      });
  };

  return (
    <div
      id="seccionRegistro"
      className="row justify-content-center align-items-center mt-5"
    >
      <h2>Registro</h2>

      <label htmlFor="txtUsuarioRegistro">Usuario:</label>
      <input
        type="text"
        id="txtUsuarioRegistro"
        placeholder="Ingrese su usuario"
        ref={user}
        onChange={cambioInput}
      />

      <label htmlFor="txtContrasenaRegistro">Contraseña:</label>
        <input
          type="text"
          id="txtContrasenaRegistro"
          placeholder="Ingrese su contraseña"
          ref={pass}
          onChange={cambioInput}
        />
      
      <br />

      <button
        type="button"
        className="btn btn-danger"
        onClick={registrar}
        disabled={!botonRegistro}
      >
        Registarme e ingresar
      </button>
      <NavLink className="nav-link" to="/">
        Tengo cuenta
      </NavLink>
      {error ? <p>{mensajeError}</p> : null}
      {usuarioCarga ? <Spinner /> : null}
    </div>
  );
};

export default Registro;
