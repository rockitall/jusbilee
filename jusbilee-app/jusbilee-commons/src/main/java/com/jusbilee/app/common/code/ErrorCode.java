package com.jusbilee.app.common.code;

public interface ErrorCode {
    int SUCCESS = 200;

    int SYS_ERR = 10000;
    int ILLEGAL_PARAMETER = 10001;
    int USER_OPERATION_DENY = 11001;

    int BAD_CREDENTIALS = 20001;
    int SMS_VERIFY_CODE_EXPIRED = 20002;
    int SMS_VERIFY_CODE_INCORRECT = 20003;
    int ACCOUNT_LOCKED = 20004;
    int INVALID_ACCESS_TOKEN = 20005;

    int USER_ALREADY_EXISTS = 20010;
    int UNAUTHORIZED = 20020;
    int USER_NOT_EXISTS = 20030;
}