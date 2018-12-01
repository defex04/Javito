import React, { Component } from 'react';
import Basic from './CreateGraph_sub/Chart'
/* import PropChart from './CreateGraph_sub/PropChart'
 */import '../App.css';
//import CreateTable from './CreateTables';


class CreateGraph extends Component {
  
  render() {
    return (
      <div>
        <div className="container d-flex flex-wrap content m-auto">
         
      {/*   <div className = "col-md-12">
            <PropChart />
        </div> */}

        <div className = "col-md-12">
          <Basic />
        </div>

          

      </div>
    </div>
    )
  }
}

export default CreateGraph;