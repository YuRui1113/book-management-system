/**
 * File: src\app\components\shared\base\detail-base.component.ts
 * Project: WebFront
 * Created Date: Monday, February 26th 2024, 3:22:35 pm
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Tuesday, 27th February 2024 12:39:46 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2024 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Monday, February 26th 2024	Rui Yu		Initial version
 */

import { EventEmitter, Injectable, Input, Output } from '@angular/core';

@Injectable()
export class DetailBaseComponent {
    
    hasError: boolean = false;
    errorMessage: string = '';

    @Input() isEdit = false;
    @Input() needCancel = true;
    @Input() title = '';

    @Output() onUpdate: EventEmitter<void> = new EventEmitter();
}