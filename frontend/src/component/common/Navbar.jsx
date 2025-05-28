import React from "react";
import { NavLink, useNavigate } from "react-router-dom";
import ApiService from "../../service/ApiService";

function Navbar() {
  const isAuthenticated = ApiService.isAuthenticated();
  const isAdmin = ApiService.isAdmin();
  const isUser = ApiService.isUser();
  const navigate = useNavigate();

  const handleLogout = () => {
    const isLogout = window.confirm("Are you sure you want to logout?");
    if (isLogout) {
      ApiService.logout();
      navigate("/home");
    }
  };

  return (
    <nav className="navbar">
      <div className="navbar-brand">
        <NavLink to="/home">ExtreHotel</NavLink>
      </div>
      <ul className="navbar-ul">
        <li>
          <NavLink to="/home" activeclass="active">
            Home
          </NavLink>
          <NavLink to="/rooms" activeclass="active">
            Rooms
          </NavLink>
          <NavLink to="/find-booking" activeclass="active">
            Find My Bookings
          </NavLink>
          {isUser && (
            <NavLink to="/profile" activeclass="active">
              Profile
            </NavLink>
          )}
          {isAdmin && (
            <NavLink to="/admin" activeclass="active">
              Admin
            </NavLink>
          )}
          {!isAuthenticated && (
            <NavLink to="/login" activeclass="active">
              Login
            </NavLink>
          )}
          {isAuthenticated && (
            <NavLink to="/register" activeclass="active">
              Register
            </NavLink>
          )}
          {isAuthenticated && <li onClick={handleLogout}>Logout</li>}
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;
