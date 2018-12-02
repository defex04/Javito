import React, { Component } from 'react';
import './App.css';
import Chart from './components/Chart';
import Header from './components/Header';
import Forecast from './components/Forecast';


class App extends Component {
  render() {
    return (
      <div>
        <Header />
        
        <div className ="container">
          <div className="mb-5">
            <Chart />
          </div>

        <div className="col-lg-5 col-md-7">
          <Forecast /> 
        </div>
      </div>
    </div>
    );  
  }
}

export default App;
