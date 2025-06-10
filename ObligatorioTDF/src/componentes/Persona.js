import React from "react";

const Persona = ({
  id,
  nombre,
  departamento,
  ciudad,
  fechaNacimiento,
  ocupacion,
  onDelete,
}) => {
  const handleEliminar = () => {
    onDelete(id);
  };
  return (
    <tr className="persona">
      <td>{id}</td>
      <td>{nombre}</td>
      <td>{departamento}</td>
      <td>{ciudad}</td>
      <td>{fechaNacimiento}</td>
      <td>{ocupacion}</td>
      <td>
        <button onClick={handleEliminar}>Eliminar</button>
      </td>
    </tr>
  );
};

export default Persona;
