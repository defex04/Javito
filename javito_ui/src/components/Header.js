import React, { Component } from 'react';

class Header extends Component {
  render() {
    return (
      <div className="card-header bg-info text-white mb-3 ">
        <div className = "container d-flex">
          <div className="col-md-6 ">
            Javito v.1.0
          </div>
          <div className="col-md-6 text-right">
            email@gmail.com
          </div>
        </div>
      </div>
    )
  }
}

export default Header;