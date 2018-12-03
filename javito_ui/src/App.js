import React, { Component } from 'react';
import './App.css';
import Chart from './components/Chart';
import Header from './components/Header';
import Footer from './components/Footer';
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

          <div className="col-lg-7 col-md-7">
            <Forecast /> 
          </div>
        </div>
        
        <Footer />
      </div>
    );  
  }
}

export default App;
