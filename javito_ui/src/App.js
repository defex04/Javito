import React, { Component } from 'react';
import './App.css';
import Chart from './components/Chart';
import Header from './components/Header';
import Forecast from './components/Forecast';
import Footer from './components/Footer';


class App extends Component {
  render() {
    return (
      <React.Fragment>
        <Header />
        <div className ="container  d-flex">
          <div className="col-md-8 mb-5 ">
            <Chart />
          </div>
          <div className="col-md-4  mt-5">
            <Forecast /> 
          </div>
        </div>
        <Footer />
      </React.Fragment>
    );  
  }
}

export default App;
