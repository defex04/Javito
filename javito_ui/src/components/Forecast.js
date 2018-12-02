import React, { Component } from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

class History extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [], 
      
      columns : [{
        Header: 'Course',
        accessor: 'course' // String-based value accessors!
      }, {
        Header: 'Value',
        accessor: 'value',
        //Cell: props => <span className='number'>{props.value}</span> // Custom cell components!
      }]
    };
  };
  
  componentDidMount() {
    fetch('http://localhost:3000/table')
      .then(response => response.json())
      .then(result => {
        console.log(result);

        let data_mass = result.map((number) => number);

        this.setState (
        {
          data: data_mass
        })
        
        console.log('state: ', this.state);
        
      })      
  }
  
  render() {
    return (
      <div className="container d-flex mb-5 mt-5">
        <div className="col-md-8">
          <BootstrapTable data={this.state.data}>
            <TableHeaderColumn dataField='date' isKey>Date</TableHeaderColumn>
            <TableHeaderColumn dataField='trends'>Trends</TableHeaderColumn>
            <TableHeaderColumn dataField='forecast'>Forecast</TableHeaderColumn>
            <TableHeaderColumn dataField='result'>Results</TableHeaderColumn>
          </BootstrapTable>
        </div>
      </div>
    );
  }
}


export default History;