import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import './ViewProject.css';

class ViewProject extends React.Component{
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
      document.title = "ViewProject";
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
  };1
    render() {

      const { data } = this.state;
     
        return (
            <div class = "ViewProject">
            { data.map((dat) => (
              <div><p><label class = "ViewProjects">Project name : </label>
              {dat.projectname}</p>
              <br/> <p><label class = "ViewProjects">Summary : </label>
              {dat.description} </p>
              <br/><p><label class = "ViewProjects">Manager Email : </label>
              {dat.manager_email}</p>
              <br/><p><label class = "ViewProjects">Release date : </label>
              {dat.release_date}</p>
              <br/><p><label class = "ViewProjects">Progress : </label>
              {dat.progress}</p>
              <br/><br/><br/>
            </div>
          ))}
            </div>
        );
    }
}

export default ViewProject;
