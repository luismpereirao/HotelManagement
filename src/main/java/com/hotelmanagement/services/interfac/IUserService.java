package com.hotelmanagement.services.interfac;

import com.hotelmanagement.dto.LoginRequest;
import com.hotelmanagement.dto.Response;
import com.hotelmanagement.entities.User;

public interface IUserService {

    Response register(User loginRequest);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingsHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String userId);
}
