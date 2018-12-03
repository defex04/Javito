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
        
        <div className ="container d-flex">
          <div className="mb-5 col-md-8">
            <Chart />
          </div>

          <div className="col-md-4 mt-2 vl">
            <Forecast /> 
          </div>
        </div>
        
        <Footer />
      </div>
    );  
  }
}

export default App;
