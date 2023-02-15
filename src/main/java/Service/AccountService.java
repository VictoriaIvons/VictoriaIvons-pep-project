package Service;

import java.util.List;

import DAO.AccountDAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

public AccountService(){
    accountDAO=new AccountDAO();
}
public AccountService(AccountDAO accountDAO){
    this.accountDAO=accountDAO;
}
public List<Account>getAllAccounts(){
    return accountDAO.getAllAccounts();
}
public Account CreateNewUsers(Account account){
    
    if(account.password.length()>=4 && account.username!=""){
        return accountDAO.createNewUsers(account);
    }
    
        return null ;
    
}
   

public Account retrieveId(String username, String password) {
    
   return this.accountDAO.retrieveId(username,password);
}
}

