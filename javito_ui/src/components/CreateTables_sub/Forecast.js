import React, { Component } from 'react';
import ReactTable from "react-table";
import 'react-table/react-table.css'
import '../../App.css';

class History extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data : [{
        course: 'USD',
        value: 2625
      }],
      
      columns : [{
        Header: 'Course',
        accessor: 'course' // String-based value accessors!
      }, {
        Header: 'Value',
        accessor: 'value',
        //Cell: props => <span className='number'>{props.value}</span> // Custom cell components!
      }]
    }
  }
    
  render() {
    const {data, columns, } = this.state;
    return (
      <div className="text-center">
      <h4> Forecast</h4>
       <ReactTable
          data={data}
          columns={columns}
          defaultPageSize={3}
          showPaginationBottom = {false}
        />
      </div>
    )
  }
}

export default History;