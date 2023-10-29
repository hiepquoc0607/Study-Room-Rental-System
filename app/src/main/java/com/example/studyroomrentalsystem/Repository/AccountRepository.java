package com.example.studyroomrentalsystem.Repository;

import com.example.studyroomrentalsystem.Service.Implement.APIService;
import com.example.studyroomrentalsystem.Service.Interface.AccountService;

public interface AccountRepository {
    static AccountService getAccountService(){
        return APIService.getClient().create(AccountService.class);
    }
}
