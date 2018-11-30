import React, { Component } from 'react';
import ReactTable from "react-table";
import 'react-table/react-table.css'
import '../../App.css';

class History extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data : [{
        date: ['23.11'],// '24.11', '25.11'],
        trends: ['upImg'],// 'dwnImg', 'upImg'],
        past_forecast: ['win']//, 'win', 'lose']
      }],
      
      columns : [{
        Header: 'Date',
        accessor: 'date', // String-based value accessors!
      }, {
        Header: 'Trends',
        accessor: 'trends'
        //Cell: props => <span className='number'>{props.value}</span> // Custom cell components!
      }, {
        Header: 'Past forecast',
        accessor: 'past_forecast'
      }
    ],

    }
  }
    


  render() {
    const { data, columns } = this.state;
    return (
      <div className=" text-center">
      <h4> History</h4>
      

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