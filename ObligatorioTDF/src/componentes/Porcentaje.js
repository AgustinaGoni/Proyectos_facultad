import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { useRef, useState, useEffect } from "react";
import { spinnerCargando } from "../features/spinnerSlice";
import { Spinner } from "react-bootstrap";

const Porcentaje = () => {
  const apiKey = localStorage.getItem("apiKeyUsuario");
  const idUser = localStorage.getItem("id");

  const totalPersonasUsuario = useSelector(
    (state) => state.personas.persona.length
  );

  const [totalPersonas, setTotalPersonas] = useState(0);
  const porcentaje =
    totalPersonas !== 0 ? (totalPersonasUsuario / totalPersonas) * 100 : 0;
  const dispatch = useDispatch();
  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  useEffect(() => {
    dispatch(spinnerCargando(true));
    fetch(`https://censo.develotion.com/totalCensados.php`, {
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
          setTotalPersonas(data.total);
          dispatch(spinnerCargando(false));
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
  });

  return (
    <div className="row porcentaje">
      <div className="col py-3">
        <section className="pb-5 px-4">
          {/*  <!--PORCENTAJE--> */}
          <div className="mt-4">
            <h2 className=" text-center pt-5 pb-4 mb-5 titulo-seccion fs-1">
              Porcentaje
            </h2>
            <div className="row gap-5 justify-content-center text-center mt-5">
              <div className="col-md-3 card-porcentaje">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{totalPersonas}</h3>
                <p>Total de personas</p>
              </div>
              <div className="col-md-3 card-porcentaje">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{totalPersonasUsuario}</h3>
                <p>Total de personas del usuario</p>
              </div>
              <div className="col-md-3 card-porcentaje">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{porcentaje.toFixed(4)}</h3>
                <p>Porcentaje</p>
              </div>
            </div>
          </div>
        </section>
      </div>
      <div className="col-12 text-center mt-3 fw-semibold text-success">
        {error ? <p>{mensajeError}</p> : null}
      </div>
    </div>
  );
};

export default Porcentaje;
