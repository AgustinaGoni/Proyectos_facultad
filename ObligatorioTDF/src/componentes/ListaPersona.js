import React from "react";

import { useEffect, useState, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { cargarPersona } from "../features/personaSlice";
import { spinnerCargando } from "../features/spinnerSlice";

const ListaPersona = () => {
  const idUser = localStorage.getItem("id");
  const apiKey = localStorage.getItem("apiKeyUsuario");
  const [personasFiltradas, setPersonasFiltradas] = useState([]);
  const [ocupacionFiltro, setOcupacionFiltro] = useState("");
  const listaOcupaciones = useSelector((state) => state.ocupaciones.ocupacion);
  const listaPersonas = useSelector((state) => state.personas.persona);
  const dispatch = useDispatch();

  const listaDepartamentos = useSelector(state => state.departamentos.departamento);
  
  const [listaCiudades, setlistaCiudades] = useState([]);

  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  const eliminarPersona = (id) => {
    dispatch(spinnerCargando(true));
    fetch(`https://censo.develotion.com/personas.php?idCenso=${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.codigo === 200) {
          recargarPersonas();
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
    dispatch(spinnerCargando(true));
    fetch(`https://censo.develotion.com/personas.php?idUsuario=${idUser}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        dispatch(cargarPersona(data.personas));
        dispatch(spinnerCargando(false));
      })
      .catch((error) => {
        dispatch(spinnerCargando(false));
      });
  };


  const getDepartamentoNombre = (departamentoId) => {
    const departamento = listaDepartamentos.find(dep => dep.id === departamentoId);
    return departamento ? departamento.nombre : '';
  };

  const getOcupacionNombre = (ocupacionId) => {
    const ocupacion = listaOcupaciones.find(ocu => ocu.id === ocupacionId);
    console.log(ocupacion)
    return ocupacion ? ocupacion.ocupacion : '';
  };

  const getCiudadNombre = (ciudadId) => {
    const ciudad = listaCiudades.find(ciu => ciu.id === ciudadId);
    console.log(ciudad)
    return ciudad ? ciudad.nombre : '';
  };

  useEffect(() => {
    fetch("https://censo.develotion.com/personas.php?idUsuario=" + idUser, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((r) => r.json())
      .then((data) => {
        if (data.codigo === 200) {
          dispatch(cargarPersona(data.personas));
          recargarPersonas();
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
      

      fetch("https://censo.develotion.com/ciudades.php", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        apikey: apiKey,
        iduser: idUser,
      },
    })
      .then((r) => r.json())
      .then((data) => {
        if (data.codigo === 200) {
          setlistaCiudades(data.ciudades)
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



      
  }, []);

  const filtrarOcupacion = (e) => {
    setOcupacionFiltro(Number(e.target.value));
    console.log(ocupacionFiltro);
  };

  useEffect(() => {
    const personasFiltradas = ocupacionFiltro
      ? listaPersonas.filter((persona) => persona.ocupacion === ocupacionFiltro)
      : listaPersonas;
    setPersonasFiltradas(personasFiltradas);

    console.log(listaPersonas);
    console.log(personasFiltradas);
  }, [ocupacionFiltro, listaPersonas]);

  return (
    <div>
      <h1>Lista de Personas</h1>
      <div>
        {/* Filtro por ocupación */}
        <label htmlFor="filtroOcupacion">Filtrar por ocupación:</label>
        <select id="filtroOcupacion" onChange={filtrarOcupacion}>
          <option value="">Todos</option>
          {listaOcupaciones.map((ocupacion) => (
            <option key={ocupacion.id} value={ocupacion.id}>
              {ocupacion.ocupacion}
            </option>
          ))}
        </select>
      </div>

      <div className="lista-personas">
        <table>
          <thead>
            <tr className="tabla-encabezado">
              <th>ID</th>
              <th>Nombre</th>
              <th>Departamento</th>
              <th>Ciudad</th>
              <th>Fecha de Nacimiento</th>
              <th>Ocupación</th>
              <th>Eliminar</th>
            </tr>
          </thead>
          <tbody>
            {personasFiltradas.length > 0 ? (
              personasFiltradas.map((persona) => (
                <tr className="persona" key={persona.id}>
                  <td>{persona.id}</td>
                  <td>{persona.nombre}</td>
                  <td>{getDepartamentoNombre(persona.departamento)}</td>
                  <td>{getCiudadNombre(persona.ciudad)}</td>
                  <td>{persona.fechaNacimiento}</td>
                  <td>{getOcupacionNombre(persona.ocupacion)}</td>
                  <td>
                    <button onClick={() => eliminarPersona(persona.id)}>
                      Eliminar
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="7">
                  No hay personas con la ocupación seleccionada
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
      <div className="col-12 text-center mt-3 fw-semibold text-success">
        {error ? <p>{mensajeError}</p> : null}
      </div>
    </div>
  );
};

export default ListaPersona;
