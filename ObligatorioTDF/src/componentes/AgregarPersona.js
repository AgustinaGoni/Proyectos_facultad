import { useRef, useState, useEffect } from "react";
import { spinnerCargando } from "../features/spinnerSlice";
import { Spinner } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { cargarDepartamento } from "../features/departamentoSlice";
import { cargarOcupacion } from "../features/ocupacionSlice";
import { cargarCiudad } from "../features/ciudadSlice";
import { cargarPersona } from "../features/personaSlice";

const AgregarPersona = () => {
  const nombre = useRef(null);
  const departamento = useRef(null);
  const ciudades = useRef(null);
  const fechaNacimiento = useRef(null);
  const ocupacion = useRef(null);

  const apiKey = localStorage.getItem("apiKeyUsuario");
  const idUser = localStorage.getItem("id");

  const dispatch = useDispatch();

  const usuarioCarga = useSelector((state) => state.spinner.loading);
  const listaDepartamentos = useSelector(
    (state) => state.departamentos.departamento
  );
  const listaCiudades = useSelector((state) => state.ciudades.ciudad);
  const listaOcupaciones = useSelector((state) => state.ocupaciones.ocupacion);

  const [botonAgregar, setBotonAgregar] = useState(false);
  const [listaOcupacionesLocal, setListaOcupacionesLocal] = useState([]);

  const [mensaje, setMensaje] = useState(null);
  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  useEffect(() => {
    dispatch(spinnerCargando(true));
    fetch(`https://censo.develotion.com/departamentos.php`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          dispatch(cargarDepartamento(data));
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        setError(true);
        setMensajeError(error);
        dispatch(spinnerCargando(false));
      });
    //------------------------------------------------------------------------------

    dispatch(spinnerCargando(true));
    fetch(`https://censo.develotion.com/ocupaciones.php`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          dispatch(cargarOcupacion(data));
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        dispatch(spinnerCargando(false));
        setError(true);
        setMensajeError(error);
      });
  }, []);

  const recargarCiudades = () => {
    dispatch(spinnerCargando(true));

    const department = departamento.current.value;

    fetch(
      `https://censo.develotion.com/ciudades.php?idDepartamento=${department}`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          apikey: apiKey,
          iduser: idUser,
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          dispatch(cargarCiudad(data));
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        dispatch(spinnerCargando(false));
        setError(true);
        setMensajeError(error);
        dispatch(spinnerCargando(false));
      });
  };

  const recargarOcupaciones = () => {
    ocupacion.current.value = "";
    const date = fechaNacimiento.current.value;
    let ocupacionesFiltradas = listaOcupaciones;
    const esMenor = esMenorDe18(date);
    if (esMenor) {
      ocupacionesFiltradas = ocupacionesFiltradas.filter((ocu) => ocu.id === 5);
    }
    setListaOcupacionesLocal(ocupacionesFiltradas);
  };

  const datosCompletos = (e) => {
    nombre.current.value &&
    departamento.current.value &&
    ciudades.current.value &&
    fechaNacimiento.current.value &&
    ocupacion.current.value
      ? setBotonAgregar(true)
      : setBotonAgregar(false);
  };

  const esMenorDe18 = (fechaNacimiento) => {
    const fechaNac = new Date(fechaNacimiento);
    const fechaActual = new Date();
    let edad = fechaActual.getFullYear() - fechaNac.getFullYear();
    if (
      fechaNac.getMonth() > fechaActual.getMonth() ||
      (fechaNac.getMonth() === fechaActual.getMonth() &&
        fechaNac.getDate() > fechaActual.getDate())
    ) {
      edad--;
    }
    return edad < 18;
  };

  const agregarNuevaPersona = () => {
    dispatch(spinnerCargando(true));
    const bodyData = {
      idUsuario: idUser,
      nombre: nombre.current.value,
      departamento: Number(departamento.current.value),
      ciudad: Number(ciudades.current.value),
      fechaNacimiento: fechaNacimiento.current.value,
      ocupacion: Number(ocupacion.current.value),
    };
    fetch(`https://censo.develotion.com/personas.php`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
      body: JSON.stringify(bodyData),
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          //agregarPersona(data);
          recargarPersonas();
          nombre.current.value = "";
          departamento.current.value = "";
          ciudades.current.value = "";
          fechaNacimiento.current.value = "";
          ocupacion.current.value = "";
          setBotonAgregar(false);
          setMensaje(data.mensaje);
          setError(false);
        } else {
          setError(true);
          setMensajeError(data.mensaje);
        }
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        setError(true);
        setMensajeError(error);

        dispatch(spinnerCargando(false));
      });
  };

  const recargarPersonas = () => {
    const params = {
      idUsuario: idUser,
    };
    dispatch(spinnerCargando(true));
    fetch(
      `https://censo.develotion.com/personas.php?` +
        new URLSearchParams(params),
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          apikey: apiKey,
          iduser: idUser,
        },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        dispatch(cargarPersona(data.personas));
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        setError(true);
        setMensajeError(error);
        dispatch(spinnerCargando(false));
      });
  };

  return (
    <div className="row flex-nowrap justify-content-center">
      <div className="col py-3">
        <h2 className="text-center pt-5 pb-4 mb-5 titulo-seccion fs-1">
          Agregar Persona
        </h2>
        <div className="row gap-3 justify-content-center contenedor-form m-auto py-5">
          <div className="col-12 col-lg-8 mb-3 px-lg-5">
            <label htmlFor="nombre" className="form-label fw-semibold">
              Nombre:
            </label>
            <input
              type="text"
              className="form-control"
              id="nombre"
              ref={nombre}
              onChange={datosCompletos}
            />
          </div>
          <div className="col-12 col-lg-8 mb-3 px-lg-5">
            <label className="form-label fw-semibold" htmlFor="departamento">
              Departamento:
            </label>
            <select
              name="departamento"
              id="departamento"
              className="form-select"
              ref={departamento}
              onChange={(e) => {
                datosCompletos(e);
                recargarCiudades(e);
              }}
            >
              <option value="">Seleccione un departamento</option>
              {listaDepartamentos.map((dep) => (
                <option key={dep.id} value={dep.id}>
                  {dep.nombre}
                </option>
              ))}
            </select>
          </div>
          <div className="col-12 col-lg-8 mb-3 px-lg-5">
            <label className="form-label fw-semibold" htmlFor="ciudad">
              Ciudad:
            </label>
            <select
              name="ciudad"
              id="ciudad"
              className="form-select"
              ref={ciudades}
              onChange={datosCompletos}
            >
              <option value="">Seleccione una ciudad</option>
              {listaCiudades.map((cdad) => (
                <option key={cdad.id} value={cdad.id}>
                  {cdad.nombre}
                </option>
              ))}
            </select>
          </div>
          <div className="col-12 col-lg-8 mb-3 px-lg-5">
            <label htmlFor="fechaNacimiento" className="form-label fw-semibold">
              Fecha de nacimiento:
            </label>
            <input
              type="date"
              className="form-control"
              id="fechaNacimiento"
              ref={fechaNacimiento}
              onChange={(e) => {
                datosCompletos(e);
                recargarOcupaciones(e);
              }}
              max={new Date().toISOString().split("T")[0]}
            />
          </div>
          <div className="col-12 col-lg-8 mb-3 px-lg-5">
            <label htmlFor="ocupacion" className="form-label fw-semibold">
              Ocupación:
            </label>
            <select
              name="ocupacion"
              id="ocupacion"
              className="form-select"
              ref={ocupacion}
              onChange={datosCompletos}
            >
              <option value="">Selecciona una ocupación</option>
              {listaOcupacionesLocal.map((ocu) => (
                <option key={ocu.id} value={ocu.id}>
                  {ocu.ocupacion}
                </option>
              ))}
            </select>
          </div>
          <div className="col-12 text-center mt-3">
            <button
              type="button"
              className="text-uppercase btn btn-form btn-primary"
              onClick={agregarNuevaPersona}
              disabled={!botonAgregar}
            >
              Agregar
            </button>
            {usuarioCarga ? <Spinner /> : null}
          </div>
          <div className="col-12 text-center mt-3 fw-semibold text-success">
            {error ? <p>{mensajeError}</p> : <p>{mensaje}</p>}
          </div>
        </div>
      </div>
    </div>
  );
};

export default AgregarPersona;
