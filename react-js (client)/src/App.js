import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import Fibonacci from './Component/Fibonacci'


function App() {
  return (
    <div className="App">
      <Router>
        <div>
        <nav class="navbar navbar-dark bg-dark">
          <div className="navbar-nav mr-auto nav">
            <li className="nav-item">
              <Link to={"/"} className="nav-link">
              Fibonacci 
              </Link>
            </li>
          </div>
        </nav>
        </div>
        <div className="container mt-3">
        <Switch>
          <Route exact path='/' component={Fibonacci} />
        </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
