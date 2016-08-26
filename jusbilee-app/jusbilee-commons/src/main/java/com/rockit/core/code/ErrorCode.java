package com.rockit.core.code;

public interface ErrorCode {
    int SUCCESS = 200;

    int SYS_ERR = 10000;
    int ILLEGAL_PARAMETER = 10001;
    int USER_OPERATION_DENY = 10002;
    int NETWORK_ERROR = 10003;

    int BAD_CREDENTIALS = 20001;
    int SMS_VERIFY_CODE_EXPIRED = 20002;
    int SMS_VERIFY_CODE_INCORRECT = 20003;
    int ACCOUNT_LOCKED = 20004;
    int INVALID_ACCESS_TOKEN = 20005;
    int USER_SIGNATURE_ERROR = 20006;
    int INCORRECT_OLD_PASSWORD = 20007;

    int USER_ALREADY_EXISTS = 20010;
    int UNAUTHORIZED = 20020;
    int USER_NOT_EXISTS = 20030;
    
   
    
    /**
     * admin后面加上来
     */
    int CENSORSHIP_ALREADY_EXISTS = 50010;
}