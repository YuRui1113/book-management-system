/**
 * File: src\app\models\httpOptions.ts
 * Project: WebFront
 * Created Date: Monday, February 26th 2024, 11:07:57 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Monday, 26th February 2024 10:30:30 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Monday, February 26th 2024	Rui Yu		Initial version
 */

import { HttpHeaders, HttpParams } from '@angular/common/http';

export class HttpOptions {
    
    constructor(
        public headers?: HttpHeaders,
        public params?: HttpParams) {
    }
}