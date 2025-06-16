package com.lbg.ob.eaisp.users.ent.api.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstants {
    /* Error Messages */

    public static final String RECORD_EXISTS_MESSAGE = "Record already exists for that combination";
    public static final String MULTIPLE_DB_RECORDS_EXIST_MESSAGE = "More than 1 record exists in DB for the combination";

}
