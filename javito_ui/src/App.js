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
        <Chart />
        <Forecast /> 
      </div>
    );  
  }
}

export default App;
