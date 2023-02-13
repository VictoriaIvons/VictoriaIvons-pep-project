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
    Account accountfromDb=this.accountDAO.getAccountByUserName(account.getUsername());
   if(account.getPassword().length()<4 &&account.username!="")return null;
    if(accountfromDb!=null ||account.getUsername().isBlank())return null;
    return this.accountDAO.createNewUsers(account);
   }
   

public Account retrieveId(int account_id) {
    
    
   return this.accountDAO.retrieveId(account_id);
}
}

