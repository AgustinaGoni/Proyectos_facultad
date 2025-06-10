import { useRef, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { NavLink, useNavigate } from "react-router-dom";
import { logearUsuario } from "../features/usuarioSlice";
import { spinnerCargando } from "../features/spinnerSlice";
import Spinner from "./Spinner";

const Login = () => {
  const user = useRef(null);
  const pass = useRef(null);

  const [botonLogin, setBotonLogin] = useState(false);
  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  const dispatch = useDispatch();

  let navigate = useNavigate();

  const usuarioCarga = useSelector((state) => state.spinner.loading);

  const cambioInput = (e) => {
    user.current.value && pass.current.value
      ? setBotonLogin(true)
      : setBotonLogin(false);
  };

  const ingresar = () => {
    dispatch(spinnerCargando(true));
    const bodyData = {
      usuario: user.current.value,
      password: pass.current.value,
    };

    fetch(`https://censo.develotion.com/login.php`, {
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
            usuario: data.usuario,
            password: data.password,
            id: data.id,
            apiKey: data.apiKey,
          };
          dispatch(logearUsuario(usuarioLogeado));
          localStorage.setItem("id", data.id);
          localStorage.setItem("apiKeyUsuario", data.apiKey);
          setMensajeError(null);
          setError(false);
          navigate("dashboard");
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        dispatch(spinnerCargando(false));
        setError(true);
        setMensajeError("Fallo en la conexion con el servidor en login");
      });
  };

  return (
    <div
      id="seccionLogin"
      className="row justify-content-center align-items-center mt-5"
    >
      <h2>Iniciar sesion</h2>

      <label htmlFor="txtUsuarioLogin">Usuario:</label>
      <input
        type="text"
        id="txtUsuarioLogin"
        placeholder="Ingrese su usuario"
        ref={user}
        onChange={cambioInput}
      />
      <br />

      <label htmlFor="txtContrasenaLogin">Contraseña:</label>
      <input
        type="text"
        id="txtContrasenaLogin"
        placeholder="Ingrese su contraseña"
        ref={pass}
        onChange={cambioInput}
      />
      <br />

      <button
        type="button"
        className="btn btn-success"
        onClick={ingresar}
        disabled={!botonLogin}
      >
        Iniciar sesion
      </button>
      <NavLink className="nav-link" to={"registro"}>
        Registrarme
      </NavLink>
      {error ? <p>{mensajeError}</p> : null}
      {usuarioCarga ? <Spinner /> : null}
    </div>
  );
};

export default Login;
