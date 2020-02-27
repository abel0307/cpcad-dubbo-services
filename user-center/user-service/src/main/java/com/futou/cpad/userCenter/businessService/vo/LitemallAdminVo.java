package com.futou.cpad.userCenter.businessService.vo;


import com.futou.cpcad.db.domain.LitemallAdmin;

public class LitemallAdminVo extends LitemallAdmin {

    public Integer publicHornOwnerId;

    private String accountType;

    private String accountBank;

    private String accountMode;

    private String accountOwnerName;

    private String account;

    private String roleKey;

    public Integer getPublicHornOwnerId() {
        return publicHornOwnerId;
    }

    public void setPublicHornOwnerId(Integer publicHornOwnerId) {
        this.publicHornOwnerId = publicHornOwnerId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountMode() {
        return accountMode;
    }

    public void setAccountMode(String accountMode) {
        this.accountMode = accountMode;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public void setAccountOwnerName(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

}
