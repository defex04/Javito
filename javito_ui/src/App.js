import React, { Component } from 'react';
import './App.css';
import Chart from './components/Chart';
import Header from './components/Header';
import Tables from './components/Tables';
/* import GETRequest from './components/requests/post/GetRequest'
 */

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <Chart />
        <Tables /> 
        {/*<GETRequest />*/}
      </div>
    );  
  }
}

export default App;
