import React, { Component } from 'react';
import { Navbar, Container, Nav, NavDropdown } from 'react-bootstrap';
import {  Route, Routes } from 'react-router-dom'; 

import Homepage from './pages/homepage';
import ContactUs from './pages/contacts';

import GetAllPizzasComponent from './components/GetAllPizzasComponent';
import CreatePizzaComponent from './components/CreatePizzaComponent';

import './App.css';

class App extends Component { 
   constructor(props){
       super(props);
       this.state = {}
 }

render() {
  return ( 

      <div className="App">
            
          <header>
              <nav> 
              <ul className="navbar"> 

              <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
               <Container>
                <Navbar.Brand href="/homepage">Pizza Ordering App</Navbar.Brand>
                  <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                   <Navbar.Collapse id="responsive-navbar-nav">
                     <Nav defaultActiveKey="/homepage" as="ul" className="me-auto">  
                <NavDropdown title="Pages" id="collasible-nav-dropdown">
              <NavDropdown.Item href="/homepage">Homepage</NavDropdown.Item>
             <NavDropdown.Item href="/ordertime">Order</NavDropdown.Item>
            <NavDropdown.Item href="/contacts">Contacts</NavDropdown.Item>
           </NavDropdown>
           </Nav>
             </Navbar.Collapse>
              </Container>
                </Navbar>
                </ul>
                    </nav>
          </header>

          <main>
          <Routes>

          <Route path="/homepage" element={<Homepage />} />

          <Route path="/contacts" element={<ContactUs />} />

          <Route path="/ordertime" element={<GetAllPizzasComponent />} />

          <Route path="/add-pizza" element={<CreatePizzaComponent />} />

          <Route path="/edit-pizza/:id" element={<CreatePizzaComponent />} />

          </Routes>
          </main>
 
          <footer className="footer">In collaboration with McGee Enterprises 👍</footer>

      </div>
    )
  }

}


export default App