/*
 * src\main\java\com\taylor\infosys\restapi\exceptions\ResourceAlreadyExistsException.java
 * Project: Rest-API
 * Created Date: Sunday, February 25th 2024, 6:50:20 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Sunday, 25th February 2024 6:52:28 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Sunday, February 25th 2024	Rui Yu		Initial version
 */

package com.taylor.infosys.restapi.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException() {
        super();
    }

    public ResourceAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public ResourceAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}