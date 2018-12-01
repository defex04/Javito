import React, { Component } from 'react';
import 'react-table/react-table.css'
import '../App.css';
/* import History from './CreateTables_sub/History'
 */import Forecast from './CreateTables_sub/Forecast'
//import Forecast from './CreateTables_sub/Forecast'


class Tables extends Component {
  
  
  render() {
    return (
      <div className="container d-flex mb-5 mt-5">
        <div className="col-md-8">
          <Forecast />
        </div>
      </div>
    )
  }
}

export default Tables;