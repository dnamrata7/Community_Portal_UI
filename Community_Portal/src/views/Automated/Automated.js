import React, { Component, useState } from 'react';
import { Container, Form, Dropdown, FormGroup, Label, Row, Col, Card, Button } from 'reactstrap';
import { FilePond } from 'react-filepond';
import {
  Link
} from '@material-ui/core';
import { Link as RouterLink, withRouter } from 'react-router-dom';
const divStyle = {
  width: '800px',
  borderRadius: '8px',
  float: 'center',
  backgroundColor: 'White',
  paddingBottom: "20px",
  borderBottom: '5px solid Grey',
  borderTop: '5px solid Grey',
  borderLeft: '5px solid Grey',
  borderRight: '5px solid Grey',
  verticalAlign: "center"
}
const head = {
  fontSize: '20px',
  float: 'center',

}
const headDiv = {
  fontSize: '25px',
  float: 'center',
  backgroundColor: '#ccc'
}
class Automated extends Component {
  constructor(props) {
    super(props);
    this.state = {
      AppName: "",
      platform: "",
      createDt: "",
      testCaseTotal: "",
      passed: "",
      fail: ""
    };
  }


  render() {
    return (
      <div style={divStyle}>
        <div style={headDiv} >
          <Label ><b>Create a new session </b></Label>
          <hr>
          </hr>
        </div>
        <table>
          <tr>
            <th style={head} align="middle"> Configure your device </th>
          </tr>
          <tr>
            <td>
              <Label  >Upload application file(.apk)</Label>
            </td>
           <td width="400px">
              <FilePond />
            </td> 
          </tr>
          <tr class="blank_row">
    <td colspan="3"></td>
</tr>
          <tr>
            <td>
              <Label>Select Device </Label>
            </td>
            <td>
              <select multiple>
                <option value="S9+">Samsung Galaxy S9+ (Unlocked)</option>
                <option value="S6">Samsung Galaxy S6 (Verizon)</option>
                <option value="pixel2">Google Pixel 2</option>
                <option value="s6">Samsung Galaxy S6 (T-Mobile)</option>
                <option value="pixel">Google Pixel</option>
                <option value="op6">One Plus 6</option>
              </select>
            </td>
          </tr>
          <hr></hr>
          <tr>
            <th style={head} align="middle"> Configure your test </th>
          </tr>
          <br />
          <tr>
            <td >
              Test Type
</td>
            <td>

              <select id="testTypeList" name="testTypeList">
                <option value="Built in :fuzzy">Built in : Fuzzy</option>
                <option value="Built in :explorer">Built in : Explorer</option>
                <option value="appium">Appium Java JUnit</option>
              </select>
            </td>
          </tr>
          <br />
          <tr>
            <td>
              Upload test script file if applicable
</td>
            <td>
              <FilePond />
            </td>
          </tr>
        </table>
        <Button float="left" type="reset" tag={Link} to="/components/TestRunner1"> Cancel </Button>
        &nbsp;&nbsp;&nbsp;&nbsp;
<Link
          component={RouterLink}
          to="/RunResults"
          variant="h6"
        >
          Next
 </Link>

      </div>
    );
  }

}

export default Automated;