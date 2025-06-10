import React, { useEffect, useState } from "react";

const TiempoRestante = () => {
  const fechaFinalCenso = new Date("2023-08-31");
  const [diasRestantes, setDiasRestantes] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      const fechaActual = new Date();
      const diferencia = fechaFinalCenso - fechaActual;
      const dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
      setDiasRestantes(dias);
    }, 1000); // Actualiza cada segundo

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="tiempo-restante">
      <h2>Dias restantes</h2>
      <div className="cuadro-dias">
        <p>{diasRestantes}</p>
      </div>
    </div>
  );
};

export default TiempoRestante;
