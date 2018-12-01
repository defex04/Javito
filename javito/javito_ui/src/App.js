import React, { Component } from 'react';
import './App.css';
import CreateGraph from './components/CreateGraph';
import Header from './components/Header';
import PostList from './components/requests/post/PostList';
import CreateTables from './components/CreateTables';


class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <CreateGraph />
        <CreateTables />
        <PostList />

      </div>
    );  
  }
}

export default App;
