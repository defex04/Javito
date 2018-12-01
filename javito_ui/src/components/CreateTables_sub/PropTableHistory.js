import React, { Component } from 'react';

class PropTableHistory extends Component {
  constructor (props) {
    super (props);

    this.state = {
      options: ['USD', 'EUR', 'GBP'],
    }
  }
  render() {
    return (
      <div>
        <h4> Currency </h4> 
            <select
              className = " form-control form-control-sm "
              style={{cursor:'pointer'}}
              name="currency"
             // onChange = {this.onChange}
              //value={currency}
            >

            {this.state.options.map((option, idx) =>
              <option
                key={idx}
                value={option}>
              {option} 
              </option>)}
            </select>
      </div>
    );
  }
}

export default PropTableHistory;