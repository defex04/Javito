import React, { Component } from 'react';
import './App.css';
import CreateGraph from './components/CreateGraph';
import Header from './components/Header';
import CreateTables from './components/CreateTables';
import PostList from './components/requests/post/PostList'


class App extends Component {
  render() {
    return (
      <div className = "container mt-5">
{/*         <Header />
        <CreateGraph />
        <CreateTables /> */}
        <PostList />
      </div>
    );  
  }
}

export default App;
