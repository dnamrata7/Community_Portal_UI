import React, { Component } from 'react';


  const divStyle ={
  width: '1000px',
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
const tableStyle ={
  width :"900px",
  borderRadius: '8px',
  float: 'center',
  borderWidth: "1px",
  backgroundColor: 'White',
  paddingTop:"10px",
  paddingBottom: "10px",
  verticalAlign: "center"
}

const cellStyle ={
  borderRadius: '8px',
  float: 'center',
  borderWidth: "1px",
  paddingRight : "5px",
  backgroundColor: 'White',
  borderBottom: '1px solid #ccc',
  borderLeft: '1px solid #ccc',
  borderRight: '1px solid #ccc',
  borderTop: '1px solid #ccc',
  verticalAlign: "center"
}
class RunResults extends Component {

constructor(props){
    super(props);
  this.state = {
    AppName : "",
    platform : "Android",
    createDt : "",
    testCaseTotal:"",
    passed:"",
    failed:"",
    testType: "",
    status:""
  };
}




render(){
  return (
   // <h1> Test Results </h1>
<div style={divStyle}>

<table style={tableStyle}>
<tr>
<th style={cellStyle}> Status </th>
<th style={cellStyle}> Application </th>
<th style={cellStyle}> Test type </th>
<th style={cellStyle}> Total test cases executed </th>
<th style={cellStyle}> Passed </th>
<th style={cellStyle}> Failed </th>
<th style={cellStyle}> Created on </th>
</tr>
<tr>
<td style={cellStyle}>COMPLETED </td>

<td style={cellStyle}>
HelloWorld_v1.0_apkpure.com.apk
</td>
<td style={cellStyle}>
BUILTIN_FUZZ
</td>
<td style={cellStyle}>
15
</td>
<td style={cellStyle}>
15
</td>
<td style={cellStyle}>
0
</td>
<td style={cellStyle}>
11/18/2019
</td>
</tr>
</table>

    </div>
    );
}
    
}

export default RunResults;
