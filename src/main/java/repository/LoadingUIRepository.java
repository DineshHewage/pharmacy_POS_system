package repository;

import model.dto.UserCredentils;

public interface LoadingUIRepository {
    boolean userCredentialCheck(UserCredentils userCredentils);
}
