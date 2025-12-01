package service.impl;

import model.dto.UserCredentils;
import repository.LoadingUIRepository;
import repository.impl.LoadingUIRepositoryImpl;
import service.LoadingUIService;

public class LoadingUIServiceImpl implements LoadingUIService {
    LoadingUIRepository repository  = new LoadingUIRepositoryImpl();

    @Override
    public String userRequest(UserCredentils userCredentils) {
        String firstName = repository.userCredentialCheck(userCredentils);
        return firstName;
    }
}
