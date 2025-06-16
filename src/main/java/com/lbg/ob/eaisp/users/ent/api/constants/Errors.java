package com.lbg.ob.eaisp.users.ent.api.constants;

import com.ob.eaisp.commons.exception.ErrorData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Errors {

    GET_MULTIPLE_DB_RECORDS_EXIST_MESSAGE("EAISP_USERS_ENT_ERR_DB_409_02", ErrorConstants.MULTIPLE_DB_RECORDS_EXIST_MESSAGE);

    private final String code;
    private final String message;

    public ErrorData.Error toError() {
        return new ErrorData.Error(code, message);
    }

}
