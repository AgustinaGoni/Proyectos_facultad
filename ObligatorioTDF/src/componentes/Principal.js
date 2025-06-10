import AgregarPersona from "./AgregarPersona";
import ListaPersona from "./ListaPersona";
import CensoTotal from "./CensoTotal";
import Analisis from "./Analisis";
import Porcentaje from "./Porcentaje";
import TiempoRestante from "./TiempoRestante";

const Principal = () => {
  return (
    <div id="dashboard" className="container">
      <h1 className="text-center mb-4">CENSO</h1>
      <div className="row justify-content-center">
        <div className="col-lg-10">
          <div className="row">
            <div className="col-md-12 mb-4">
              <AgregarPersona />
            </div>
          </div>
          <div className="row">
            <div className="col-md-12 mb-4">
              <ListaPersona />
            </div>
          </div>
          <div className="row">
            <div className="col-md-12 mb-4">
              <CensoTotal />
            </div>
          </div>
          <div className="row">
            <div className="col-md-12 mb-4">
              <Analisis />
            </div>
          </div>
          <div className="row">
            <div className="col-md-12 mb-4">
              <Porcentaje />
            </div>
          </div>
          <div className="row">
            <div className="col-md-12 mb-4">
              <TiempoRestante />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Principal;
