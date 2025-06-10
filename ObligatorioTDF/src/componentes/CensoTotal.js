import React from "react";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
const CensoTotal = () => {
  const [censadoTotal, setCensadoTotal] = useState(0);
  const [censadoMontevideo, setCensadoMontevideo] = useState(0);
  const [censadoInterior, setCensadoInterior] = useState(0);

  const listaPersonas = useSelector((state) => state.personas.persona);

  useEffect(() => {
    let montevideoCount = 0;
    let interiorCount = 0;

    listaPersonas.forEach((element) => {
      if (element.departamento === 3218) {
        montevideoCount++;
      } else {
        interiorCount++;
      }
    });

    setCensadoMontevideo(montevideoCount);
    setCensadoInterior(interiorCount);
    setCensadoTotal(listaPersonas.length);
  }, [listaPersonas]);

  return (
    <div className="row flex-nowrap justify-content-center">
      <div className="col py-3">
        <section className="pb-5 px-4 censo">
          <div className="mt-4">
            <h2 className="text-center pt-5 pb-4 mb-5 titulo-seccion fs-1">
              Censados
            </h2>
            <div className="row gap-5 justify-content-center text-center mt-5">
              <div className="col-md-3 card-censo">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{censadoTotal}</h3>
                <p>Censados totales</p>
              </div>
              <div className="col-md-3 card-censo">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{censadoMontevideo}</h3>
                <p>Censados de Montevideo</p>
              </div>
              <div className="col-md-3 card-censo">
                <i className="bi bi-currency-dollar fw-semibold"></i>
                <h3>{censadoInterior}</h3>
                <p>Censados del Interior</p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
};

export default CensoTotal;
