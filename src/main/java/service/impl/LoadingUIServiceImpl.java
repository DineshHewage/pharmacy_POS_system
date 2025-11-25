package service.impl;

import model.dto.UserCredentils;
import repository.LoadingUIRepository;
import repository.impl.LoadingUIRepositoryImpl;
import service.LoadingUIService;

public class LoadingUIServiceImpl implements LoadingUIService {
    LoadingUIRepository repository  = new LoadingUIRepositoryImpl();

    @Override
    public boolean userRequest(UserCredentils userCredentils) {
        boolean userIsAvilable = repository.userCredentialCheck(userCredentils);
        return userIsAvilable;
    }
}
