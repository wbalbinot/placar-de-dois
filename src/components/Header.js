import React from 'react';
import './header.css';

function Header () {
  return (
    <header>
      <div className="red button bigButton" style={{ gridArea: "bt1" }}> + AUMENTAR</div>
      <div className="blue button bigButton" style={{ gridArea: "bt2" }}> + AUMENTAR</div>
    </header >
  );
}

export default Header;