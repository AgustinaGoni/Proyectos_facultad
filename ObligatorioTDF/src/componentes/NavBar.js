import React from "react";
import { NavLink, Outlet } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { logoutUsuario } from "../features/usuarioSlice";

const NavBar = () => {
  const usuario = useSelector((state) => state.usuario.usuarioLogeado);
  const dispatch = useDispatch();

  const salir = () => {
    dispatch(logoutUsuario());
    localStorage.clear();
  };

  return (
    <div>
      <nav
        className="navbar navbar-expand-lg bg-body-tertiary bg-dark border-bottom border-bottom-dark"
        data-bs-theme="dark"
      >
        <div className="container-fluid">
          <NavLink className="navbar-brand" to="/dashboard">
            Censo
          </NavLink>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div className="navbar-nav">
              <NavLink className="nav-link" to="/dashboard">
                Principal
              </NavLink>
              <NavLink className="nav-link" to="/" onClick={salir}>
                Salir
              </NavLink>
            </div>
          </div>
          {usuario ? (
            <span className="navbar-text">Bienvenido</span>
          ) : null}
        </div>
      </nav>
      <br />
      <br />
      <br />
      <Outlet />
    </div>
  );
};

export default NavBar;
