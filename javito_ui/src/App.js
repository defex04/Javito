import React, { Component } from 'react';
import './App.css';
import Header from './components/Header';
import Forecast from './components/Forecast';
import Footer from './components/Footer';
import Request from './components/Request';


class App extends Component {
  render() {
    return (
      <React.Fragment>
        {/* Header File */}
        <Header />
        <div className ="container  d-flex">
          <div className="col-md-8 mb-5 ">
          {/* Modeule that builds a chart */}
            <Request/>
          </div>
          <div className="col-md-4  mt-5">
          {/* Module that builds forecasts */}
            <Forecast /> 
          </div>
        </div>
        <Footer /> 
      </React.Fragment>
    );  
  }
}

export default App;
