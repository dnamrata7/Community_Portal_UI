import React, {Component} from 'react';
import {
  Link
} from '@material-ui/core';
import { Link as RouterLink } from 'react-router-dom';
import axios from 'axios';

import './MyProjects.css';

class MyProjects extends React.Component{
  state = {
    data: [],
    id: 0,
    message: null,
    intervalIsSet: false,
    idToDelete: null,
    idToUpdate: null,
    objectToUpdate: null,
  };

    componentDidMount() {
      document.title = "My Projects";
      this.getDataFromDb();
      if (!this.state.intervalIsSet) {
        let interval = setInterval(this.getDataFromDb, 1000);
        this.setState({ intervalIsSet: interval });
      }
    }

    // never let a process live forever
    // always kill a process everytime we are done using it
    componentWillUnmount() {
      if (this.state.intervalIsSet) {
        clearInterval(this.state.intervalIsSet);
        this.setState({ intervalIsSet: null });
      }
    }

  getDataFromDb = () => {
    fetch('http://localhost:3001/api/getData')
      .then((data) => data.json())
      .then((res) => this.setState({ data: res.data }));
  };
    render() {
      const { data } = this.state;
        return (
          <div>
            <div class = "NewProject">
            <Link to="/NewProject">Create new Project</Link>
            <br/><br/><br/><br/>
            </div>
            <div class = "MyProjects">
            <p>Active Projects</p>
              <ul class = "MyProjects">
                {data.length <= 0
                  ? <label class = "label"><br/>You don't have any active projects</label>
                  : data.map((dat) => (
                      <li style={{ padding: '10px' }} >
                        <Link
                        component={RouterLink}
                        to={{ pathname: '/ViewProject', state: { id: dat.id, message: dat.message, data : dat } }}>{dat.projectname}</Link>
                      </li>
                    ))}
              </ul>
            </div>
            </div>
        );
    }
}

export default MyProjects;
