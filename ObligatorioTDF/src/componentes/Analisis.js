import { useEffect, useState } from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  PointElement,
  LineElement,
} from "chart.js";
import { Bar } from "react-chartjs-2";
import { useDispatch, useSelector } from "react-redux";
import { spinnerCargando } from "../features/spinnerSlice";
import { cargarPersona } from "../features/personaSlice";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import markerIcon from "../img/loc.png";
import Spinner from "../componentes/Spinner";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  PointElement,
  LineElement
);

const Analisis = () => {
  const apiKey = localStorage.getItem("apiKeyUsuario");
  const idUser = localStorage.getItem("id");

  const usuarioCarga = useSelector((state) => state.spinner.loading);
  const listaPersonas = useSelector((state) => state.personas.persona);

  const listaDepartamentos = useSelector(
    (state) => state.departamentos.departamento
  );
  const listaOcupaciones = useSelector((state) => state.ocupaciones.ocupacion);
  const [mensajeError, setMensajeError] = useState(null);
  const [error, setError] = useState(false);

  const dispatch = useDispatch();

  useEffect(() => {
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
        if (data.codigo === 200) {
          dispatch(cargarPersona(data.personas));
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
  }, []);

  //-----------------------------------------------------------------------------------

  const listaDepartamentosFinalPrueba = listaDepartamentos
    .map((dep) => ({
      departamentoName: dep.nombre,
      cantidadPersonas: listaPersonas.filter(
        (per) => per.departamento === dep.id
      ).length,
    }))
    .filter((item) => item.cantidadPersonas > 0);

  const listaOcupacionesFinalPrueba = listaOcupaciones.map((ocu) => ({
    ocupacionName: ocu.ocupacion,
    cantidadPersonas: listaPersonas.filter((per) => per.ocupacion === ocu.id)
      .length,
  }));

  //-------------------------------------------------------------------------

  const customMarkerIcon = L.icon({
    iconUrl: markerIcon,
    iconSize: [25, 41],
    iconAnchor: [12, 41],
    popupAnchor: [1, -34],
    tooltipAnchor: [16, -28],
    shadowSize: [41, 41],
  });

  const markersData = listaDepartamentos.map((dep) => {
    const PersonasTotal = listaPersonas.filter(
      (per) => per.departamento === dep.id
    ).length;
    const cantidad = PersonasTotal ? PersonasTotal : 0;
    return {
      lat: dep.latitud,
      lng: dep.longitud,
      cantidad: cantidad,
      departamento: dep.nombre,
    };
  });

  return (
    <div>
      {usuarioCarga ? <Spinner /> : null}
      <div className="row">
        <div className="col-6">
          <h2>Analisis de personas</h2>
          <Bar
            options={{
              responsive: true,
              plugins: {
                legend: {
                  position: "top",
                },
                title: {
                  display: true,
                  text: "Departamentos",
                },
              },
            }}
            data={{
              labels: listaDepartamentosFinalPrueba.map(
                (item) => item.departamentoName
              ),
              datasets: [
                {
                  label: "Cantidad de personas por departamento",
                  data: listaDepartamentosFinalPrueba.map(
                    (item) => item.cantidadPersonas
                  ),
                  backgroundColor: "rgba(50, 51, 664, 0.5)",
                  barPercentage: 1,
                  barThickness: 15,
                },
              ],
            }}
          />
          ;
        </div>
        <div className="col-6">
          <h2>Analisis de personas</h2>
          <Bar
            options={{
              responsive: true,
              plugins: {
                legend: {
                  position: "top",
                },
                title: {
                  display: true,
                  text: "Ocupaciones",
                },
              },
            }}
            data={{
              labels: listaOcupacionesFinalPrueba.map(
                (item) => item.ocupacionName
              ),
              datasets: [
                {
                  label: "Cantidad de personas por ocupacion",
                  data: listaOcupacionesFinalPrueba.map(
                    (item) => item.cantidadPersonas
                  ),
                  backgroundColor: "rgba(50, 51, 664, 0.5)",
                },
              ],
            }}
          />
          ;
        </div>

        <div className="col-6">
          <MapContainer
            center={[-33.3828, -56.5283]}
            zoom={6}
            style={{ height: "400px", width: "100%" }}
          >
            <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
            {markersData.map((marker) => (
              <Marker
                key={`${marker.lat}-${marker.lng}`}
                position={[marker.lat, marker.lng]}
                icon={customMarkerIcon}
              >
                <Popup>
                  <h3>{marker.departamento}</h3>
                  <p>Cantidad de censados por estado: {marker.cantidad}</p>
                </Popup>
              </Marker>
            ))}
          </MapContainer>
        </div>
      </div>
      <div className="col-12 text-center mt-3 fw-semibold text-success">
        {error ? <p>{mensajeError}</p> : null}
      </div>
    </div>
  );
};

export default Analisis;
