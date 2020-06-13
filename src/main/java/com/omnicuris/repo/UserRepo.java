package com.omnicuris.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omnicuris.model.Product;
import com.omnicuris.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
