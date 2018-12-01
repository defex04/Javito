import React, { Component } from 'react';
import ReactTable from "react-table";
import 'react-table/react-table.css'
import '../../App.css';

class History extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: ""
    }
  }

    componentDidMount() {

        // var options = {
        //     method: 'get',
        //     headers: {
        //         "Access-Control-Request-Headers": "*",
        //         "Access-Control-Request-Method": "*"
        //     },
        // }
        //this.setState({isLoading: true});
        fetch('https://javito2018.herokuapp.com/hello')
            .then(response => response.text())
            .then(dataFromJava => this.setState({data: dataFromJava }));
    }


  render() {
    return (
        <div>
          <h1>{this.state.data}</h1>
        </div>
    )
  }

}

export default History;