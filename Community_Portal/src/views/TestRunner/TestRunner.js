import React, { useState } from 'react';
<<<<<<< HEAD
//import { TabContent, TabPane, Nav, NavItem, NavLink, Card,  CardTitle, CardText, Row, Col,Button } from 'reactstrap';
import { Card, CardHeader, CardContent, Grid, Typography, Avatar } from '@material-ui/core';
=======
import { TabContent, TabPane, Nav, NavItem, NavLink, Card,  CardTitle, CardText, Row, Col,Button } from 'reactstrap';
>>>>>>> 11df415d8b5320247c1a75f4aa08b1efa180995b
import {
  Link
} from '@material-ui/core';
import { Link as RouterLink } from 'react-router-dom';
import { MDBContainer, MDBRow, MDBCol } from "mdbreact";

const TestRunner = (props) => {
  const [activeTab, setActiveTab] = useState('1');

  const toggle = tab => {
    if (activeTab !== tab) setActiveTab(tab);
  }



  return (
    <div valign="top" align="center"
    >

      <MDBContainer fluid>
        <MDBRow>
          <MDBCol>
<<<<<<< HEAD
            <Card >
               <Typography
          align="center"
          gutterBottom
          variant="h4">  Automated Testing </Typography>
              <CardContent>Automated testing will allow you to execute built-in
      tests or your own scripts on selected device, generating a detailed report .
			  </CardContent>

              <Link
                component={RouterLink}
                to="/Automated"
                variant="h6"
              >
                Start Execution
=======
            <Card body>
              <CardTitle>Automated Testing</CardTitle>
              <CardText>Automated testing will allow you to execute built-in
      tests or your own scripts on selected device, generating a detailed report .
			  </CardText>
        
              <Link
                    component={RouterLink}
                    to="/Automated"
                    variant="h6"
                  >
                  Start Execution
>>>>>>> 11df415d8b5320247c1a75f4aa08b1efa180995b
                  </Link>
            </Card>
          </MDBCol>
          <MDBCol >
<<<<<<< HEAD
            <Card >
            <Typography
          align="center"
          gutterBottom
          variant="h4"> Interactive Testing</Typography>
              <CardContent>Live or interactive testing allows you to interact with a device through your web browser in real time in order to perform manual testing.
				</CardContent>
              <Link variant="h6" ><a href="https://cloud.geny.io/app/default-devices">Start Session</a></Link>
=======
            <Card body>
              <CardTitle>Interactive Testing</CardTitle>
              <CardText>Live or interactive testing allows you to interact with a device through your web browser in real time in order to perform manual testing.
				</CardText>
              <Button block ><a href="https://cloud.geny.io/app/default-devices">Start Session</a></Button>
>>>>>>> 11df415d8b5320247c1a75f4aa08b1efa180995b
            </Card>
          </MDBCol>
        </MDBRow>
      </MDBContainer >

    </div>
  );
}

export default TestRunner;