import React from 'react';
import {Link} from "react-router-dom";

export const Navbar = () => {

    return (
        <nav>
            <h3><Link to={`/`}>Home</Link></h3>
        </nav>
    );

}