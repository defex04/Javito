import React, { Component } from 'react';
import './App.css';
import CreateGraph from './components/CreateGraph';
import Header from './components/Header';
import CreateTables from './components/CreateTables';
/* import GETRequest from './components/requests/post/GetRequest'
 */

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <CreateGraph />
        <CreateTables /> 
        {/*<GETRequest />*/}
      </div>
    );  
  }
}

export default App;
