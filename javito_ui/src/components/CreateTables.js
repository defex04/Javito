import React, { Component } from 'react';
import 'react-table/react-table.css'
import '../App.css';
import History from './CreateTables_sub/History'
import Forecast from './CreateTables_sub/Forecast'
import PropTableHistory from './CreateTables_sub/PropTableHistory'
//import Forecast from './CreateTables_sub/Forecast'


class CreateTables extends Component {
  
  
  render() {
    return (
      <div className="container d-flex mb-5 mt-5">
        <div className="col-md-3">
          <PropTableHistory />
        </div>
        <div className="col-md-5">
          <History />
        </div>
        <div className="col-md-4">
          <Forecast />
        </div>
      </div>
    )
  }
}

export default CreateTables;