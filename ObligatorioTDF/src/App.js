import './App.css';
import './bootstrap.min.css';
import { store } from './store/store';
import { Provider } from 'react-redux';
import { BrowserRouter, Routes, Route} from "react-router-dom";
import Login from './componentes/Login';
import Registro from './componentes/Registro';
import NavBar from './componentes/NavBar';

import Principal from './componentes/Principal';
import 'leaflet/dist/leaflet.css';
import ListaPersona from './componentes/ListaPersona';

const App = () => {
  return (
    <div className="App">
    <Provider store={store}>

      <BrowserRouter>
        <Routes>

          <Route path='/' element={<Login/>} exact/>
          <Route path='registro' element={<Registro/>}/>


          <Route path='/dashboard' element={<NavBar/>}>
            <Route path='/dashboard' element={<Principal/>}/>
          </Route>
         

        </Routes>

      </BrowserRouter>

</Provider>
    </div>

  );
}

export default App;
