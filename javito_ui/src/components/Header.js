import React, { Component } from 'react';

class Header extends Component {
  render() {
    return (
      <div className="card-header bg-info text-white mb-3 pl-0 pr-0">
        <div className = "container d-flex">
          <div className="col-md-6 ">
            Javito v.1.0
          </div>
          <div className="col-md-6 text-right">
            github.com/defex04/Javito
          </div>
        </div>
      </div>
    )
  }
}

export default Header;